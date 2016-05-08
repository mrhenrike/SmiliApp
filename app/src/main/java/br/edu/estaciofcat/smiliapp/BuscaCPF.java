package br.edu.estaciofcat.smiliapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class BuscaCPF extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_buscacpf);
    }

    public void voltar(View view) {
        onBackPressed();
    }
}
