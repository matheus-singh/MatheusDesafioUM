package acc.br.projetoDOIS.controller;

import acc.br.projetoDOIS.repository.entities.Score;
import acc.br.projetoDOIS.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/index")
    public String index(Model model){
        scoreService.getScore(model);
        return "index";
    }

    @GetMapping("/teste")
    public String teste(@RequestParam(name = "escolha") String aEscolha, Model model){
        scoreService.jogar(aEscolha, model);
        return "resultado";
    }

    @ResponseBody
    @GetMapping("/score")
    public Score getScore(){
        return scoreService.getScore();
    }

    @GetMapping("/zerar")
    public String zerarScore(Model model){
        scoreService.zerarScore(model);
        return "index";
    }
}
