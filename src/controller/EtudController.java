package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Etud;
import javafx.scene.image.Image;
import entities.Etud;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import services.Etudservices;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import static java.sql.DriverManager.println;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;

import java.io.FileOutputStream;

import java.io.OutputStream;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

/**
 *
 * @author ahmed
 */
public class EtudController implements Initializable {

    String name = "";
    @FXML
    private Label surname;
    @FXML
    private TextField login;
    private TextField etudid;
    @FXML
    private DatePicker date;
    @FXML
    private TextField description;

   
    private TextField pickUpPathField;

 
    private TableView<Etud> tableau;
    @FXML
    private Button add_etud;
    @FXML
    private Button update_etud;
    @FXML
    private Button delete_etud;
    @FXML
    private TextField surnamee;
    @FXML
    private TableView<Etud> tableauAct;
    @FXML
    private ComboBox<String> select;
    // private ComboBox<String> select2;
    @FXML
    private Button pdfevent;
private TableColumn<Etud, String> password;
    @FXML
    private ObservableList<Etud> list;
    @FXML
    private TableColumn<Etud, String> namee;
    @FXML
    private TableColumn<Etud, String> surnameee;
    @FXML
    private TableColumn<Etud, Integer>article_ID ;
    @FXML
    private TableColumn<Etud, String> loginn;
    @FXML
    private TableColumn<Etud, Integer> etud_id;
    @FXML
    private Button ExitBackEvent;
    @FXML
    private ComboBox<String> select1;

    public EtudController() throws SQLException {

    }
 
    Integer id, iddd;
    Etudservices see = new Etudservices();

    // DatePicker datePicker = (DatePicker) getPrimaryStage().getScene().getRoot().lookup(".date-picker");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            
            
            select1.setItems(FXCollections.observableArrayList(see.listmemeve()));
            System.out.println(select);
        } catch (SQLException ex) {
            Logger.getLogger(EtudController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tableau.setOnMouseClicked((MouseEvent event) -> {

          

        tableauAct.setOnMouseClicked((MouseEvent event) -> {
            iddd = see.displayAllLista()
                    .get(tableauAct.getSelectionModel().getSelectedIndex())
                    .getId_etud();
            //System.out.println(iddd);
            surname.setText(see.displayAllLista()
                    .get(tableauAct.getSelectionModel().getSelectedIndex())
                    .getName());

            description_Act.setText(see.displayAllLista()
                    .get(tableauAct.getSelectionModel()
                            .getSelectedIndex())
                    .getSurname());
            String imagesource =  see.displayAllLista()
                    .get(tableauAct.getSelectionModel().getSelectedIndex())
                    .getLogin();
            System.out.println(imagesource);
            Image img = new Image(imagesource);
            imageActu.setImage(img);
        });

      

        ObservableList<Etud> listA;
        try {
            listA = see.getActuList();

            name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            surname.setCellValueFactory(new PropertyValueFactory<>("Surname"));
            etud_id.setCellValueFactory(new PropertyValueFactory<>("Login"));
            login.setCellValueFactory(new PropertyValueFactory<>("Article_ID"));
            article_ID.setCellValueFactory(new PropertyValueFactory<>("Statut_Article"));

            tableauAct.setItems(listA);

        } catch (SQLException ex) {
            Logger.getLogger(EtudController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   

  

    @FXML
    private void ExitbackEvent(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
}
