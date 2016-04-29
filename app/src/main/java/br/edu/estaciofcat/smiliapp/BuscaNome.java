package br.edu.estaciofcat.smiliapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class BuscaNome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_buscanome);
    }

    public void voltar(View view) {
        onBackPressed();
    }
}
