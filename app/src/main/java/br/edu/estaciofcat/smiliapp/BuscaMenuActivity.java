package br.edu.estaciofcat.smiliapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BuscaMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_buscamenu);
    }

    public void abreBuscaNome(View view) {
        Intent intent = new Intent(this, BuscaNome.class);
        startActivity(intent);
    }

    public void abreBuscaMatr(View view) {
        Intent intent = new Intent(this, BuscaMatricula.class);
        startActivity(intent);
    }

    public void abreBuscaCurso(View view) {
        Intent intent = new Intent(this, BuscaCurso.class);
        startActivity(intent);
    }

    public void voltar(View view) {
        onBackPressed();
    }
}
