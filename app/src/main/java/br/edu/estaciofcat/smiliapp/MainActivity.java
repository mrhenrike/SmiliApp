package br.edu.estaciofcat.smiliapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.ArrayRes;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.sql.*;
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db teste = new db();
        teste.testDB();
    }

    /*//Função Voltar para Home
    public void btn_voltarHome(View view) {
        setContentView(R.layout.activity_main);
    }*/

    //Método Entrar Layout Home
    public void acao_acessarLayoutHome(View view) {
        setContentView(R.layout.activity_main);
    }

    //Método Entrar Layout Pesquisa
    public  void acao_acessarLayoutBusca(View view){
        setContentView(R.layout.layout_buscamenu);
    }

    //Método Buscar Layout Nome

    public void acao_BuscarNome(View view){

        setContentView(R.layout.layout_buscanome);

    }

    //Método Buscar Layout Matrícula
    public void acao_BuscarMatr(View view){
        setContentView(R.layout.layout_buscamatr);
            }

    // Métodos para busca do banco de dados
    public void matribanco(View view){

    }

    //Screen Help
    public void screenHelp(View view){
        setContentView(R.layout.layout_ajuda);
    }
}