package br.edu.estaciofcat.smiliapp;

import android.database.SQLException;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Dark on 29/04/2016.
 */
public class db {
    private Connection con;
    public void testDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Log.w("Conectou", "ao banco");
            con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/smili", "smili", "ads2016");
            Statement st = con.createStatement();
            /*
           st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Matriculas");
            ResultSetMetaData rsmd = rs.getMetaData();*/

        }
        catch(SQLException e) {
            Log.w("Deu","Erro nessa merda "+e);
        } catch (ClassNotFoundException e) {
            Log.w("Deu", "Erro nessa merda " + e);
        } catch (java.sql.SQLException e) {
            Log.w("Deu", "Erro nessa merda " + e);
        }


    }
}
