package com.connection;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author pelz
 */
public class Connexion {
    
    private static Connection conex;
    private String url= "jdbc:postgresql://localhost:5432/saloon";
    private String user = "pelz";
    private String pwd = "123456";
    private Connexion(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.out.println("Erreur d'ouverture du driver:"+ e.getMessage());
        }
        try {
            conex = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println("Erreur d'entree a la DB:"+ e.getMessage());
        }
    }
    public static Connection seconnecter(){
        if (conex==null){
            Connexion connexion = new Connexion();
        }
        return conex;
    }

    
}
