package acc.br.projetoDOIS.repository.entities;

import org.springframework.data.annotation.Id;

public class Score {

    @Id
    private Integer id;

    private int vitorias;
    private int derrotas;
    private int empates;

    public Score(int vitorias, int derrotas, int empates) {
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
    }

    public void addVitoria(){
        this.vitorias++;
    }

    public void addDerrota(){
        this.derrotas++;
    }

    public void addEmpate(){
        this.empates++;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public void zerar() {
        setVitorias(0);
        setDerrotas(0);
        setEmpates(0);
    }
}
