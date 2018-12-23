/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coc7project;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 *
 * @author zcj07
 */
public class EntryController implements Initializable {
    private COC7Project project;
    
    @FXML
    private JFXButton exitButton;
    @FXML
    private JFXButton coc7;
    
    public void setProject(COC7Project project){
        this.project = project;
    }
    
    // open Investigator page
    @FXML
    public void changeToInvestigator(ActionEvent event) throws IOException{
        project.openInvestigator();
    }
    
    // open Introduction page
    @FXML
    public void changeToIntroduction(ActionEvent event) throws IOException{
        project.openIntroduction();
    }
    
    // open Dice Page
    @FXML
    public void changeToDice(ActionEvent event) throws IOException{
        project.openDice();
    }
    
    // exit button
    public void exitButtonOnMouseClicked() {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
