package br.edu.estaciofcat.smiliapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    db banco = new db();
/*
Tentando Metodo para Reconectar
    if (banco.i.intValue() == 1) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sem Conexão");
        builder.setMessage("Tentar Reconectar");
        builder.setCancelable(false);
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    banco.conectaBD();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        builder.create().show();
    }
   */

    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            banco.conectaBD();
        } catch (Exception e) {
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public void about (View view){
        setContentView(R.layout.layout_sobre);
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

    //Método Buscar Layout CPF
    public void acao_Buscarcpf(View view){
        setContentView(R.layout.layout_buscacpf);

    }

    //Método Buscar Layout Matrícula
    public void acao_BuscarMatr(View view){
        setContentView(R.layout.layout_buscamatr);
            }

    // Métodos para busca Matriculas no banco de dados
    public void matribanco(View view){
        EditText editTextMatricula = (EditText)findViewById(R.id.editTextMatricula);
        String sala;
        String bloco;
        String andar;
        String Matricula;
        Integer i = 0;
        if (editTextMatricula.getText().length() == 0 ) {
          Toast.makeText(this,"Preencha o Campo MATRICULA",Toast.LENGTH_LONG).show();
            Log.w("BLOQUEIO", "CAMPO MATRICULA VAZIO");
        }else{
        try{
            db.stmt = db.conn.createStatement();
            String SQL="SELECT * FROM Matriculas";
            db.rs = db.stmt.executeQuery(SQL);
            while (db.rs.next()) {
                if (editTextMatricula.getText().toString().equals(db.rs.getString("Matricula"))) {
                    i = 1;
                    Matricula = editTextMatricula.toString();
                    setContentView(R.layout.layout_resultmatric);
                    //Metodo para setar Sala na tela ResultMatric
                    sala = db.rs.getString("Sala");
                    ((EditText) findViewById(R.id.sala)).setText(sala);
                    Log.w("BLOQUEIO", sala);
                    //Metodo para setar Bloco na tela ResultMatric
                    bloco = db.rs.getString("Bloco");
                    Log.w("BLOQUEIO", bloco);
                    ((EditText) findViewById(R.id.bloco)).setText(bloco);
                    //Metodo para setar Andar na tela ResultMatric
                    andar = db.rs.getString("Andar");
                    Log.w("BLOQUEIO", andar);
                    ((EditText) findViewById(R.id.andar)).setText(andar);

                } else if (i == 0) {
                    Toast.makeText(this, "MATRICULA INVALIDO", Toast.LENGTH_LONG).show();
                    Log.w("BLOQUEIO", "USUARIO INVALIDO");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }


    public void voltar(View view) {
        onBackPressed();
    }

    //Screen Help
    public void screenHelp(View view){
        setContentView(R.layout.layout_ajuda);
    }

    //Método para buscar CPF no Banco
    public void cpfbanco(View view) {
        EditText editTextCPF = (EditText) findViewById(R.id.editTextCPF);
        String sala;
        String bloco;
        String andar;
        int i = 0;
        if (editTextCPF.getText().length() == 0) {
            Toast.makeText(this, "Preencha o Campo CPF", Toast.LENGTH_LONG).show();
            Log.w("BLOQUEIO", "CAMPO CPF VAZIO");
        } else if (editTextCPF.getText().length() <11) {
            Toast.makeText(this, "Preencha o Campo CPF Corretamente", Toast.LENGTH_LONG).show();
            Log.w("BLOQUEIO", "CAMPO CPF FALTA DIGITOS");
        }else {
            try {
                db.stmt = db.conn.createStatement();
                String SQL = "SELECT * FROM Matriculas";
                db.rs = db.stmt.executeQuery(SQL);
                while (db.rs.next()) {
                    if (editTextCPF.getText().toString().equals(db.rs.getString("CPF"))) {
                        i = 1;
                        String CPF = editTextCPF.toString();
                        Log.w("BLOQUEIO", "PROXIMA TELA");
                        setContentView(R.layout.layout_resultmatric);
                        //Metodo para setar Sala na tela ResultMatric
                        sala = db.rs.getString("Sala");
                        ((EditText) findViewById(R.id.sala)).setText(sala);
                        Log.w("BLOQUEIO", sala);
                        //Metodo para setar Bloco na tela ResultMatric
                        bloco = db.rs.getString("Bloco");
                        Log.w("BLOQUEIO", bloco);
                        ((EditText) findViewById(R.id.bloco)).setText(bloco);
                        //Metodo para setar Andar na tela ResultMatric
                        andar = db.rs.getString("Andar");
                        Log.w("BLOQUEIO", andar);
                        ((EditText) findViewById(R.id.andar)).setText(andar);

                    } else if (i == 0)  {
                        Toast.makeText(this, "CPF INVALIDO", Toast.LENGTH_LONG).show();
                        Log.w("BLOQUEIO", "USUARIO INVALIDO");
                    }
                }



            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}