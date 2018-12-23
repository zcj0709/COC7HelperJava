/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coc7project;


import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zcj07
 */
public class Create_3Controller implements Initializable {
    private COC7Project project;
    private boolean process = false;
    private Create_2Controller two;
    @FXML
    private JFXButton nextPage;
    @FXML
    private Text occupation;
    @FXML
    private JFXButton antiqueDealer;  
    @FXML
    private JFXButton artist;
    @FXML
    private JFXButton athlete;  
    @FXML
    private JFXButton author;
    @FXML
    private JFXButton clergy;  
    @FXML
    private JFXButton criminal;
    @FXML
    private JFXButton dilettante;  
    @FXML
    private JFXButton doctor;
    @FXML
    private JFXButton drifter;  
    @FXML
    private JFXButton engineer;
    @FXML
    private JFXButton entertainer;  
    @FXML
    private JFXButton farmer;
    @FXML
    private JFXButton hacker;  
    @FXML
    private JFXButton journalist;
    @FXML
    private JFXButton lawyer;  
    @FXML
    private JFXButton militaryOfficer;
    @FXML
    private JFXButton missionary;  
    @FXML
    private JFXButton musician;
    @FXML
    private JFXButton pilot;  
    @FXML
    private JFXButton police;
    @FXML
    private JFXButton psychologist;  
    @FXML
    private JFXButton privateInvestigator;
    @FXML
    private JFXButton professor;  
    @FXML
    private JFXButton soldier;
    @FXML
    private JFXButton tribeMember;
    @FXML
    private JFXButton zealot;
    
    
    
    @FXML
    private void handleButtonClick(ActionEvent event) {
        process = true;
        if (event.getSource() == antiqueDealer) {
            occupation.setText("Occupation: Antique Dealer");
        } else if (event.getSource() == artist) {
            occupation.setText("Occupation: Artist");
        } else if (event.getSource() == athlete) {
            occupation.setText("Occupation: Athlete");
        } else if (event.getSource() == author) {
            occupation.setText("Occupation: Author");
        } else if (event.getSource() == clergy) {
            occupation.setText("Occupation: Clergy");
        } else if (event.getSource() == criminal) {
            occupation.setText("Occupation: Criminal");
        } else if (event.getSource() == dilettante) {
            occupation.setText("Occupation: Dilettante");
        } else if (event.getSource() == doctor) {
            occupation.setText("Occupation: Doctor");
        } else if (event.getSource() == drifter) {
            occupation.setText("Occupation: Drifter");
        } else if (event.getSource() == engineer) {
            occupation.setText("Occupation: Engineer");
        } else if (event.getSource() == entertainer) {
            occupation.setText("Occupation: Entertainer");
        } else if (event.getSource() == farmer) {
            occupation.setText("Occupation: Farmer");
        } else if (event.getSource() == hacker) {
            occupation.setText("Occupation: Hacker");
        } else if (event.getSource() == journalist) {
            occupation.setText("Occupation: Journalist");
        } else if (event.getSource() == lawyer) {
            occupation.setText("Occupation: Lawyer");
        } else if (event.getSource() == militaryOfficer) {
            occupation.setText("Occupation: Military Officer");
        } else if (event.getSource() == missionary) {
            occupation.setText("Occupation: Missionary");
        } else if (event.getSource() == musician) {
            occupation.setText("Occupation: Musician");
        } else if (event.getSource() == pilot) {
            occupation.setText("Occupation: Pilot");
        } else if (event.getSource() == police) {
            occupation.setText("Occupation: Police");
        } else if (event.getSource() == psychologist) {
            occupation.setText("Occupation: Psychologist");
        } else if (event.getSource() == privateInvestigator) {
            occupation.setText("Occupation: Private Investigator");
        } else if (event.getSource() == professor) {
            occupation.setText("Occupation: Professor");
        } else if (event.getSource() == soldier) {
            occupation.setText("Occupation: Soldier");
        } else if (event.getSource() == tribeMember) {
            occupation.setText("Occupation: Tribe Member");
        } else if (event.getSource() == zealot) {
            occupation.setText("Occupation: Zealot");
        }  
    }
    
    /**
     * Initializes the controller class.
     * @param project
     */
    public void setProject(COC7Project project){
        this.project = project;
    }
    
    public void setTwo(Create_2Controller two){
        this.two = two;
    }

    @FXML
    public void changeToEntry(ActionEvent event) throws IOException{
        project.openEntry();
    }
    
    @FXML
    public void changeToCreateFour(ActionEvent event) throws IOException{
        if (process){
            // get the occupation
            String[] occ = occupation.getText().split(" ");
            project.openCreateFour(this,occ[1]);
        }
        else{
            JFXAlert alert = new JFXAlert((Stage) nextPage.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setOverlayClose(false);
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Label("Occupation Selection Alert"));
            layout.setBody(new Label("You have to select one occupation.\n"
                                    + "Warning: you can not go back to edit."));
            JFXButton closeButton = new JFXButton("Accept");
            closeButton.getStyleClass().add("dialog-accept");
            closeButton.setOnAction(e -> alert.hideWithAnimation());
            layout.setActions(closeButton);
            alert.setContent(layout);
            alert.show();
        }
    }
    public List<String> getInfo(){
        return two.getInfo();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    
    
}
