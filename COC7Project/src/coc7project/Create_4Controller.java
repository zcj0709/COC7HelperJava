/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coc7project;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author zcj07
 */
public class Create_4Controller implements Initializable {
    private COC7Project project;
    private boolean process = false;
    private Create_3Controller three;
    private String occupationSelected;
    List<String> info = new ArrayList<>();
    
    
    @FXML
    private JFXTextField description;
    @FXML
    private JFXTextField ideology;
    @FXML
    private JFXTextField people;
    @FXML
    private JFXTextField location;
    @FXML
    private JFXTextField possession;
    @FXML
    private JFXTextField trait;
    @FXML
    private JFXTextField connection;
    @FXML
    private JFXTextField detail;
    
    
    /**
     * Initializes the controller class.
     * @param project
     */
    public void setProject(COC7Project project){
        this.project = project;
    }
    
    public void setThree(Create_3Controller three){
        this.three = three;
        info = three.getInfo();
    }
    
    public void setOccupation(String occ){
        occupationSelected = occ;
    }
    
    public List<String> getInfo(){
        return info;
    }
    
    @FXML
    public void changeToEntry(ActionEvent event) throws IOException{
        project.openEntry();
    }
    
    // turn to next page with inputs
    @FXML
    public void changeToCreateFive(ActionEvent event) throws IOException{
        info.add("Personal Description: "+description.getText());
        info.add("Ideology/Beliefs: "+ideology.getText());
        info.add("Significant People: "+people.getText());
        info.add("Meaningful Locations: "+location.getText());
        info.add("Treasured Possessions: "+possession.getText());
        info.add("Traits: "+trait.getText());
        info.add("Key Backstory Connection: "+connection.getText());
        info.add("Additional Details: "+detail.getText());
        project.openCreateFive(this,occupationSelected);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
