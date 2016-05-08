package br.edu.estaciofcat.smiliapp;

import android.app.Activity;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class db extends Activity {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://"+"db4free.net:3306/smili";
    private String user = "smili";
    private String password = "ads2016";

    //-- CRIANDO CONEXOES
    public static Connection conn = null;
    public static Statement stmt;
    public static ResultSet rs;
    Integer i = 0;

    public void fechaBD() throws Exception {
        conn.close();
    }
    public boolean conectaBD() throws Exception {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName(driver).newInstance();
            Log.w("BLOQUEIO","TUDO OK COM CLASS.FORNAME");
        } catch (Exception e) {
            Log.w("BLOQUEIO","NAO FUNCIONOU O CLASS.FORNAME");
        }

        try {
            conn = DriverManager.getConnection(url,user,password);
            Log.w("BLOQUEIO","TUDO OK COM O DRIVER.MANAGER ");
        } catch (Exception e) {
           i = 1;
            Log.w("BLOQUEIO","NAO FUNCIONOU O DRIVER.MANAGER ERRO "+e);


        }

        try {
            stmt = conn.createStatement();
            Log.w("BLOQUEIO","TUDO OK COM O CREATESTATEMENT");
        } catch (Exception e) {
            Log.w("BLOQUEIO","NAO FUNCIONOU O CREATESTATEMENT");
        }
        return true;
    }

}