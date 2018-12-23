/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coc7project;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
public class Create_1Controller implements Initializable {
    private COC7Project project;
    private boolean process = false;
    private String select = null;
    
    @FXML
    private JFXListView<Label> listView;
    @FXML
    private JFXButton nextPage;
    
    /**
     * Initializes the controller class.
     * @param project
     */
    public void setProject(COC7Project project){
        this.project = project;
    }
    
    // Roll 3D6 and Multiply by 5
    public static int generateDiceOne(){
        Random r = new Random();
        int one = r.nextInt(6)+1;
        int two = r.nextInt(6)+1;
        int three = r.nextInt(6)+1;
        return (one+two+three)*5;
    }
    
    // Roll 2D6+6 and Multiply by 5
    public static int generateDiceTwo(){
        Random r = new Random();
        int one = r.nextInt(6)+1;
        int two = r.nextInt(6)+1;
        return (one+two+6)*5;
    }
    
    public static String generateOne(){
        int total = 0;
        String output = "";
        // for SIZ INT LUCK, use 2D6+6
        String[] character = {"STR","CON","SIZ","DEX","APP","INT","POW","EDU","LUCK"};
        for (String cha: character){
            if( "SIZ".equals(cha) || "INT".equals(cha) || "LUCK".equals(cha)){
                int newOne = generateDiceTwo();
                total += newOne;
                output += cha + ": "+ String.valueOf(newOne)+" ";
            }else{
                int newOne = generateDiceOne();
                total += newOne;
                output += cha + ": "+ String.valueOf(newOne)+" ";
            }
        }
        output += "TOTAL: "+ total;
        return output;
        
    }
    
    @FXML
    public void generate(ActionEvent event) throws IOException{
        process = true;
        listView.getItems().clear();
        for (int i = 0; i < 10; i++){
            String k = generateOne();
            listView.getItems().add(new Label(k));
        }
    }
    
    public String getString(){
        return select;
    }
    
    
    @FXML
    public void changeToEntry(ActionEvent event) throws IOException{
        project.openEntry();
    }
    
    @FXML
    public void changeToCreateTwo(ActionEvent e) throws IOException{
        if (process && select != null){
            project.openCreateTwo(this);
        }
        else{
            JFXAlert alert = new JFXAlert((Stage) nextPage.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setOverlayClose(false);
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Label("Selection Alert"));
            layout.setBody(new Label("You have to hit Generate button,\n"
                                    + "then select one line data.\n"
                                    + "Warning: you can not go back to reselect."));
            JFXButton closeButton = new JFXButton("Accept");
            closeButton.getStyleClass().add("dialog-accept");
            closeButton.setOnAction(event -> alert.hideWithAnimation());
            layout.setActions(closeButton);
            alert.setContent(layout);
            alert.show();
        }
    }
    
    @FXML
    public void changeToNew(ActionEvent event) throws IOException{
        project.openCreateOne();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listView.getItems().add(new Label(" Please Hit the Generate Button!"));
        listView.getSelectionModel().selectedItemProperty()
        .addListener((ObservableValue<? extends Label> observable, Label oldValue, Label newValue) -> {
            select = newValue.getText();
        });

    }    
    
}
