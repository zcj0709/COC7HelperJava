/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coc7project;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
public class Create_2Controller implements Initializable {
    private COC7Project project;
    private String[] data;
    private Create_1Controller one;
    List<String> info = new ArrayList<>();
    @FXML
    private JFXButton nextPage;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField gender;
    @FXML
    private JFXTextField age;
    @FXML
    private JFXTextField location;
    @FXML
    private JFXTextField hometown;
    @FXML
    private JFXTextField era;
    @FXML
    private Text str;
    @FXML
    private Text con;
    @FXML
    private Text app;
    @FXML
    private Text dex;
    @FXML
    private Text pow;
    @FXML
    private Text edu;
    @FXML
    private Text siz;
    @FXML
    private Text intll;
    @FXML
    private Text luck;
    @FXML
    private Text total;
 
    /**
     * Initializes the controller class.
     * @param project
     */
    public void setProject(COC7Project project){
        this.project = project;
    }
    // set data value
    public void setOne(Create_1Controller one){
        this.one = one;
        data = one.getString().split(" ");
        str.setText("Strength: "+ data[1]);
        con.setText("Constitution: "+ data[3]);
        siz.setText("Size: "+ data[5]);
        dex.setText("Dexterity: "+ data[7]);
        app.setText("Appearance: "+ data[9]);
        intll.setText("Intelligence: "+ data[11]);
        pow.setText("Power: "+ data[13]);
        edu.setText("Education: "+ data[15]);
        luck.setText("Luck: "+ data[17]);
        total.setText("Total: "+ data[19]);
    }
    
    public List<String> getInfo(){
        return info;
    }

    
    @FXML
    public void changeToEntry(ActionEvent event) throws IOException{
        project.openEntry();
    }
    
    // pass the input data to next scene
    @FXML
    public void changeToCreateThree(ActionEvent event) throws IOException{
        if (!"".equals(name.getText()) && !"".equals(gender.getText())&&!"".equals(age.getText())){
            
            info.add("Name: "+name.getText());
            info.add("Gender: "+gender.getText());
            info.add("Age: "+age.getText());
            info.add("Location: "+location.getText());
            info.add("Hometown: "+hometown.getText());
            info.add("Era: "+era.getText());
            info.add(str.getText());
            info.add(con.getText());
            info.add(siz.getText());
            info.add(dex.getText());
            info.add(app.getText());
            info.add(intll.getText());
            info.add(pow.getText());
            info.add(edu.getText());
            info.add(luck.getText());
            info.add(total.getText());
            
            project.openCreateThree(this);
        }
        else {
            JFXAlert alert = new JFXAlert((Stage) nextPage.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setOverlayClose(false);
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Label("Fill Form Alert"));
            layout.setBody(new Label("You have to fill the name, age and gender part\n"
                                    + "Warning: you can not go back to edit."));
            JFXButton closeButton = new JFXButton("Accept");
            closeButton.getStyleClass().add("dialog-accept");
            closeButton.setOnAction(e -> alert.hideWithAnimation());
            layout.setActions(closeButton);
            alert.setContent(layout);
            alert.show();
        }
    }
    
    
    public Create_1Controller getOne(){
        return this.one;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        name.focusedProperty().addListener((o, oldVal, newVal) -> { 
            if (!newVal) {
                name.validate();
            }
        });
        gender.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                gender.validate();
            }
        });
        age.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal){
                age.validate();
            }
        });
    }    
    
}
