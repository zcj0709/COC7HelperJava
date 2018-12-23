/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coc7project;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author zcj07
 */
public class COC7Project extends Application {
    private Stage stage;
     
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        openEntry();
        stage.show();
        
    }
    // open first scene - entry
    public void openEntry() throws IOException{
        try {  
            EntryController entry = (EntryController) replaceSceneContent("Entry.fxml");  
            entry.setProject(this);  
        } catch (Exception ex) {  
            Logger.getLogger(COC7Project.class.getName()).log(Level.SEVERE, null, ex);  
        }  
    }
    // open investigator scene
    public void openInvestigator() throws IOException{
        try {  
            InvestigatorController investigator = (InvestigatorController) replaceSceneContent("Investigator.fxml");  
            investigator.setProject(this);  
        } catch (Exception ex) {  
            Logger.getLogger(COC7Project.class.getName()).log(Level.SEVERE, null, ex);  
        } 
    }
    
    public void openDice() throws IOException{
        try {  
            DiceController dice = (DiceController) replaceSceneContent("Dice.fxml");  
            dice.setProject(this);  
        } catch (Exception ex) {  
            Logger.getLogger(COC7Project.class.getName()).log(Level.SEVERE, null, ex);  
        } 
    }
    
    public void openIntroduction() throws IOException{
        try {  
            IntroductionController introduction = (IntroductionController) replaceSceneContent("Introduction.fxml");  
            introduction.setProject(this);  
        } catch (Exception ex) {  
            Logger.getLogger(COC7Project.class.getName()).log(Level.SEVERE, null, ex);  
        } 
    }
    
    public void openCreateOne() throws IOException{
        try {  
            Create_1Controller create = (Create_1Controller) replaceSceneContent("Create_1.fxml");  
            create.setProject(this);  
        } catch (Exception ex) {  
            Logger.getLogger(COC7Project.class.getName()).log(Level.SEVERE, null, ex);  
        } 
    }
        
    public void openCreateTwo(Create_1Controller One) throws IOException{
        try {  
            Create_2Controller create = (Create_2Controller) replaceSceneContent("Create_2.fxml");
            create.setOne(One);
            create.setProject(this);  
        } catch (Exception ex) {  
            Logger.getLogger(COC7Project.class.getName()).log(Level.SEVERE, null, ex);  
        } 
    }
    
    public void openCreateThree(Create_2Controller Two) throws IOException{
        try {  
            Create_3Controller create = (Create_3Controller) replaceSceneContent("Create_3.fxml");
            create.setTwo(Two);
            create.setProject(this);  
        } catch (Exception ex) {  
            Logger.getLogger(COC7Project.class.getName()).log(Level.SEVERE, null, ex);  
        } 
    }
    
    public void openCreateFour(Create_3Controller Three, String occ) throws IOException{
        try {  
            Create_4Controller create = (Create_4Controller) replaceSceneContent("Create_4.fxml");
            create.setThree(Three);
            create.setOccupation(occ);
            create.setProject(this);  
        } catch (Exception ex) {  
            Logger.getLogger(COC7Project.class.getName()).log(Level.SEVERE, null, ex);  
        } 
    }
    
     public void openCreateFive(Create_4Controller Four, String occ) throws IOException{
        try {  
            Create_5Controller create = (Create_5Controller) replaceSceneContent("Create_5.fxml");
            create.setFour(Four);
            create.setOccupation(occ);
            create.setProject(this);  
        } catch (Exception ex) {  
            Logger.getLogger(COC7Project.class.getName()).log(Level.SEVERE, null, ex);  
        } 
    }

    
    // the function to change scene in one stage
    private Initializable replaceSceneContent(String fxml) throws Exception {  
        FXMLLoader loader = new FXMLLoader();  
        InputStream in = COC7Project.class.getResourceAsStream(fxml);  
        loader.setBuilderFactory(new JavaFXBuilderFactory());  
        loader.setLocation(COC7Project.class.getResource(fxml));  
        AnchorPane page;  
        try {  
            page = (AnchorPane) loader.load(in);  
        } finally {  
            in.close();  
        }   
        Scene scene = new Scene(page);  
        stage.setScene(scene);  
        stage.sizeToScene();  
        return (Initializable) loader.getController();  
    }  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    
}
