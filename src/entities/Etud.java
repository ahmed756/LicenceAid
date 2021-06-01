/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ahmed
 */
public class Etud {

    public Etud(int id_etud, String name, String surname, String password, String login, int article_id, String article_stat) {
        this.id_etud = id_etud;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.login = login;
        this.article_id = article_id;
        this.article_stat=article_stat;
    }
    private int id_etud;
    private String name;

    public void setId_etud(int id_act) {
        this.id_etud = id_etud;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }
public void setArticle_stat(String article_stat) {
        this.article_stat = article_stat;
    }
    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }
    private String surname;
    private String password;
    private String login;
    private int article_id;
    private String article_stat;


    public Etud() {
    }

    @Override
    public String toString() {
        return "Etud{" +"id_etud=" + id_etud+ "name=" + name + ", surname=" + surname + ", password=" + password + ", login=" + login + ", article_id=" + article_id + ", article_stat=" + article_stat+ '}';
    }

    public int getId_etud() {
        return this.id_etud;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPassword() {
        return this.password;
    }

    public String getLogin() {
        return this.login;
    }

    public int getArticle_ID() {
        return this.article_id;
    }
     public String getArticle_stat() {
        return this.article_stat;
    }
    
}
