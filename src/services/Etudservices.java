/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author ahmed
 *
 */
import entities.Etud;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import controller.EtudController;
import static java.sql.DriverManager.println;
import java.sql.PreparedStatement;
import javafx.scene.control.Alert;
import utils.MyDB;

public class Etudservices {

    Connection cnx;
    Statement ste;
    ResultSet rs;

    public Etudservices() {
        try {
            cnx = MyDB.getInstance().getCnx();
            ste = (Statement) cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Etudservices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertAct(Etud u) {
        String req = "insert etudiant  (EtudID,Name,Surname,Password,Login,ArticleID,StatutArticle) values ('" + u.getId_etud() + "','" + u.getName() + "','" + u.getSurname() + "','" + u.getPassword() + "','" + u.getLogin()+ u.getArticle_ID()+ u.getArticle_stat() + "','" + "','" + "')";
        try {
            ste.executeUpdate(req);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Added");
            alert.show();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failed to add actuality");
            alert.show();
        }

    }
       public List<String> listmemeve() throws SQLException {
        List<Etud> eventsList = FXCollections.observableArrayList();
        List<String> idmem = new ArrayList<>();
        Statement stm = cnx.createStatement();
        String query = "select distinct EtudID from etudiant";
        //ResultSet rs;
        rs = stm.executeQuery(query);
        
        while (rs.next()) {
            idmem.add(rs.getString("EtudID"));
            //System.out.println(idmem);
            
            

        }
        return idmem;
     }

    public ObservableList<Etud> getActuList() throws SQLException {
        String req = "select  EtudID,Name, Surname, Password , Login , ArticleID from actualities";
        ObservableList<Etud> list = FXCollections.observableArrayList();

        try {
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Etud p = new Etud();
                p.setId_etud(rs.getInt("EtudID"));
                p.setName(rs.getString("Name"));
                p.setSurname(rs.getString("Surname"));
                p.setPassword(rs.getString("Password"));
                p.setLogin(rs.getString("Login"));
                p.setArticle_id(rs.getInt("ArticleID"));
                list.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Etudservices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public void DelAct(int u) {
        try {
            Statement stm = cnx.createStatement();
            String query = "delete  from etudiant where EtudID = '" + u + "'";
            println(query);
            stm.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(Etudservices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Etud> displayAllLista() {
        String req = "select   EtudID,Name, Surname, Password , Login , ArticleID  from actualities";
        List<Etud> list = new ArrayList<>();

        try {
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Etud p = new Etud();
                p.setId_etud(rs.getInt("EtudID"));
                p.setName(rs.getString("Name"));
                p.setSurname(rs.getString("Surname"));
                p.setPassword(rs.getString("Password"));
                p.setLogin(rs.getString("Login"));
                p.setArticle_id(rs.getInt("ArticleID"));
               
                list.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Etudservices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void updateAct(Integer id, String name, String surname, String Login, int article_id) {
        String requete = "UPDATE etudiant SET Name='" + name + "',  Surname='" + surname + "',Login='" + Login + "', article_id='" + article_id + "'  WHERE EtudID='" + id + "'";

        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            System.out.println("actualite modifié");
        } catch (SQLException ex) {
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
