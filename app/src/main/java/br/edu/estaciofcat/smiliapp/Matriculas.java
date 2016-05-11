package br.edu.estaciofcat.smiliapp;

public class Matriculas{
    private static final long serialVersionUID = 1L;
    private String Matricula;
    private String Nome;
    public String getMatricula(){
        return Matricula;
    }
    public String setMatricula(){
        return Matricula;
    }
    public String getNome(String lucas){
        return Nome;
    }
    public String setNome(){
        return Nome;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public void setMatricula (String Matricula) {
        this.Matricula = Matricula;
    }


}
