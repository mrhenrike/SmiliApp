package br.edu.estaciofcat.smiliapp;

import java.io.Serializable;

/**
 * Created by Dark on 04/05/2016.
 */
public class Matriculas implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer Matricula;
    private String Nome;
    public int getMatricula(){
        return Matricula;
    }
    public int setMatricula(){
        return Matricula;
    }
    public String getNome(){
        return Nome;
    }
    public String setNome(){
        return Nome;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public void setNome(Integer Matricula) {
        this.Matricula = Matricula;
    }
}
