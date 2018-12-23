/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coc7project;


import com.jfoenix.controls.JFXListView;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.Random;


/**
 * FXML Controller class
 *
 * @author zcj07
 */
public class DiceController implements Initializable {
    private COC7Project project;
    
    @FXML
    private JFXListView<Label> listView;
    
    /**
     * Initializes the controller class.
     * @param project
     */
    public void setProject(COC7Project project){
        this.project = project;
    }
    
    public static int randomNumber(int num){
         Random r = new Random();
         return r.nextInt(num);
    }
    
    // D100
    @FXML
    public void dice100(ActionEvent event) throws IOException{
        int rand = randomNumber(100)+1;
        String dice = "You throw D100: "+ String.valueOf(rand);
        listView.getItems().add(new Label(dice));
    }
    // D4
    @FXML
    public void dice4(ActionEvent event) throws IOException{
        int rand = randomNumber(4)+1;
        String dice = "You throw D4: "+ String.valueOf(rand);
        listView.getItems().add(new Label(dice));
    }
    // D6
    @FXML
    public void dice6(ActionEvent event) throws IOException{
        int rand = randomNumber(6)+1;
        String dice = "You throw D6: "+ String.valueOf(rand);
        listView.getItems().add(new Label(dice));
    }
    // D8
    @FXML
    public void dice8(ActionEvent event) throws IOException{
        int rand = randomNumber(8)+1;
        String dice = "You throw D8: "+ String.valueOf(rand);
        listView.getItems().add(new Label(dice));
    }
    // D20
    @FXML
    public void dice20(ActionEvent event) throws IOException{
        int rand = randomNumber(20)+1;
        String dice = "You throw D20: "+ String.valueOf(rand);
        listView.getItems().add(new Label(dice));
    }
    
    
    @FXML
    public void changeToEntry(ActionEvent event) throws IOException{
        project.openEntry();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.getItems().add(new Label("Please choose the DICE!"));
        
    }    
    
}
