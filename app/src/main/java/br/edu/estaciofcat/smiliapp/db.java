package br.edu.estaciofcat.smiliapp;

import android.app.Activity;
import android.database.SQLException;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dark on 29/04/2016.
 */
public class db extends Activity {
    private String driver;
    private String url;
    private String user;
    private String password;

    //-- CRIANDO CONEXOES
    public static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;

        public  db() {
            driver   = "com.mysql.jdbc.Driver";
            url      = "jdbc:mysql://localhost:3306/test";
            user     = "root";
            password = "";
        }

        public void fechaBD() throws Exception {
            conn.close();
        }


        public boolean conectaBD() throws Exception {
            try {
                Class.forName(driver);
                Log.w("BLOQUEIO","TUDO OK COM CLASS.FORNAME");
            } catch (Exception e) {
                Log.w("BLOQUEIO","NAO FUNCIONOU O CLASS.FORNAME");
            }

            try {
                conn = DriverManager.getConnection(url,user,password);
                Log.w("BLOQUEIO","TUDO OK COM O DRIVER.MANAGER ");
            } catch (Exception e) {
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


        public List<String> listaBloqueada() {
            List<String> lista = new ArrayList<String>();
            try{
                Log.w("BLOQUEIO","INICIANDO... stmt.executeQuery");
                rs = stmt.executeQuery("select * from bloqueio order by nm_cli");
                Log.w("BLOQUEIO","INICIANDO... while");
                while (rs.next()) {
                    lista.add(rs.getString("nm_cli"));
                    Log.w("BLOQUEIO",rs.getString("nm_cli"));
                    //+ " " +rs.getString("nm_cli") + " " + rs.getString("dt_bloqueio"));
                }
                Log.w("BLOQUEIO","ACABOU...");
                rs.close();
                stmt.close();
                return lista;
            } catch (Exception erro){
                Log.w("BLOQUEIO","NAO FUNCIONOU...");
            }
            return lista;
        }

    }

