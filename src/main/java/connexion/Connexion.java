/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connexion;

/**
 *
 * @author hp
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static Connexion instance = null;

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    private Connection cn = null;
    
    private final String url = "jdbc:mysql://localhost:3306/transport_universitaire";
    private final String login = "root";
    private final String password = "";

    private Connexion() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        cn = DriverManager.getConnection(url, login, password);
        System.out.println("Connexion réussie");
    } catch (ClassNotFoundException ex) {
        System.out.println("Driver introuvable : " + ex.getMessage());
    } catch (SQLException ex) {
        System.out.println("Erreur SQL : " + ex.getMessage());
    }
}


    public static synchronized Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }

    public Connection getCn() {
        return cn;
    }
}