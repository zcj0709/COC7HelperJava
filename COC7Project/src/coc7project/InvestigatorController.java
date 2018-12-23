/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coc7project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author zcj07
 */
public class InvestigatorController implements Initializable {
    private COC7Project project;
    
    
    /**
     * Initializes the controller class.
     * @param project
     */
    public void setProject(COC7Project project){
        this.project = project;
    }
    
    @FXML
    public void changeToEntry(ActionEvent event) throws IOException{
        project.openEntry();
    }
    
    // To open Create_1 scene
    @FXML
    public void changeToNew(ActionEvent event) throws IOException{
        project.openCreateOne();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
