package acc.br.projetoDOIS.service;

import acc.br.projetoDOIS.repository.ScoreRepository;
import acc.br.projetoDOIS.repository.entities.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepo;

    //Sobrecarga adicionando o score no model
    public Score getScore(Model model){
        Score score;
        try {
            score = scoreRepo.findById(Integer.valueOf(1)).get();
        }
        catch (Exception e){
            score = new Score(0,0,0);
            scoreRepo.save(score);
        }
        model.addAttribute(score);
        return score;
    }

    //Sobrecarga sem adicionar o score no model
    public Score getScore(){
        Score score;
        try {
            score = scoreRepo.findById(Integer.valueOf(1)).get();
        }
        catch (Exception e){
            score = new Score(0,0,0);
            scoreRepo.save(score);
        }
        return score;
    }

    public void save(Score score) {
        scoreRepo.save(score);
    }

    public void jogar(String aEscolha, Model model) {
        Score score = getScore();
        String saida = "empate";
        if (aEscolha.equalsIgnoreCase("papel")){
            saida = "ganhou";
            score.addVitoria();
        } else if (aEscolha.equalsIgnoreCase("tesoura")){
            saida = "perdeu";
            score.addDerrota();
        } else {
            score.addEmpate();
        }
        model.addAttribute("saida", saida);
        model.addAttribute("aEscolha", aEscolha);
        model.addAttribute(score);
        scoreRepo.save(score);
    }

    public void zerarScore(Model model) {
        Score score = getScore();
        score.zerar();
        scoreRepo.save(score);
        model.addAttribute(score);
    }
}
