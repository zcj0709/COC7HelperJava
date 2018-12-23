/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coc7project;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.IntegerTextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.function.Function;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

 

/**
 * FXML Controller class
 *
 * @author zcj07
 */
public class Create_5Controller implements Initializable {
    private COC7Project project;
    private final boolean process = false;
    private int occpoint = 0;
    private int intpoint = 0;
    private String selectedDirectory = "";
    private Create_4Controller four;
    private String occupationSelected;
    List<String> info = new ArrayList<>();
    
    @FXML
    private JFXTreeTableView<Skill> skillTable;
    @FXML
    private Text directoryShow;
    @FXML
    private JFXButton finish;
    @FXML
    private JFXButton directory;
    
    @FXML
    private JFXTreeTableColumn<Skill, String> skillColumn;
    @FXML
    private JFXTreeTableColumn<Skill, Integer> initialColumn;
    @FXML
    private JFXTreeTableColumn<Skill, Integer> occupationColumn;
    @FXML
    private JFXTreeTableColumn<Skill, Integer> interestColumn;
    @FXML
    private JFXTreeTableColumn<Skill, Integer> totalColumn;
    
    @FXML
    private Text occPoint;
    @FXML
    private Text intPoint;
    @FXML
    private Text occ;
    
    // set up the cell value
    private <T> void setupCellValueFactory(JFXTreeTableColumn<Skill, T> column, Function<Skill, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<Skill, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    // set up the editable cell - occupation and interest point
    private void setupEditableTableView() {
        setupCellValueFactory(skillColumn, Skill::nameProperty);
        setupCellValueFactory(initialColumn,  p -> p.initial.asObject());
        setupCellValueFactory(occupationColumn, p -> p.occupation.asObject());
        setupCellValueFactory(interestColumn,  p -> p.interest.asObject());
        setupCellValueFactory(totalColumn, p -> p.total.asObject());

        // add editors
        occupationColumn.setCellFactory((TreeTableColumn<Skill, Integer> param) -> {
            return new GenericEditableTreeTableCell<>(
                new IntegerTextFieldEditorBuilder());
        });
        occupationColumn.setOnEditCommit((CellEditEvent<Skill, Integer> t) -> {
                Skill item = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue();
                // total occupation point change
                occpoint -= t.getOldValue();
                occpoint += t.getNewValue();
                occPoint.setText(String.valueOf(occpoint));
                // table data change: occupation & total point
                item.occupation.set(t.getNewValue());
                item.total.set(item.initial.getValue()+item.occupation.getValue()+item.interest.getValue());
        });
        
        // add editors
        interestColumn.setCellFactory((TreeTableColumn<Skill, Integer> param) -> {
            return new GenericEditableTreeTableCell<>(
                new IntegerTextFieldEditorBuilder());
        });
        interestColumn.setOnEditCommit((CellEditEvent<Skill, Integer> t) -> {
                Skill item = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue();
                // total interest point change
                intpoint -= t.getOldValue();
                intpoint += t.getNewValue();
                intPoint.setText(String.valueOf(intpoint));
                // table data change: interest & total point
                item.interest.set(t.getNewValue());
                item.total.set(item.initial.getValue()+item.occupation.getValue()+item.interest.getValue());
            
        });

        final ObservableList<Skill> dummyData = generateSkill();
        skillTable.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
        skillTable.setShowRoot(false);
        skillTable.setEditable(true);
    }
    
    // to add skills
    private ObservableList<Skill> generateSkill() {
        final ObservableList<Skill> skilldata = FXCollections.observableArrayList();
        skilldata.add(new Skill("Accounting",5,0,0,5));
        skilldata.add(new Skill("Anthropology",1,0,0,1));
        skilldata.add(new Skill("Appraise",1,0,0,1));
        skilldata.add(new Skill("Archaeology",1,0,0,1));
        skilldata.add(new Skill("Art and Craft",5,0,0,5));
        skilldata.add(new Skill("Charm",15,0,0,15));
        skilldata.add(new Skill("Climb",20,0,0,20));
        skilldata.add(new Skill("Computer Use",5,0,0,5));
        skilldata.add(new Skill("Credit Rating",0,0,0,0));
        skilldata.add(new Skill("Cthulhu Mythos",0,0,0,0));
        skilldata.add(new Skill("Disguise",5,0,0,5));
        skilldata.add(new Skill("Dodge",0,0,0,0));
        skilldata.add(new Skill("Drive Auto",20,0,0,20));
        skilldata.add(new Skill("Electrical Repair",10,0,0,10));
        skilldata.add(new Skill("Electronics",1,0,0,1));
        skilldata.add(new Skill("Fast Talk",5,0,0,5));  
        skilldata.add(new Skill("Fighting",25,0,0,25));
        skilldata.add(new Skill("Firearms",20,0,0,20));
        skilldata.add(new Skill("First Aid",30,0,0,30));
        skilldata.add(new Skill("History",5,0,0,5));
        skilldata.add(new Skill("Intimidate",5,0,0,5));
        skilldata.add(new Skill("Jump",20,0,0,20));
        skilldata.add(new Skill("Language",1,0,0,1));
        skilldata.add(new Skill("Law",5,0,0,5));
        skilldata.add(new Skill("Library Use",20,0,0,20));
        skilldata.add(new Skill("Listen",20,0,0,20));
        skilldata.add(new Skill("Locksmith",1,0,0,1));
        skilldata.add(new Skill("Mechanical Repair",10,0,0,10));
        skilldata.add(new Skill("Medicine",1,0,0,1));
        skilldata.add(new Skill("Natural World",10,0,0,10));
        skilldata.add(new Skill("Navigate",10,0,0,10));
        skilldata.add(new Skill("Occult",5,0,0,5));
        skilldata.add(new Skill("Operate Heavy Machinery",1,0,0,1));
        skilldata.add(new Skill("Persuade",10,0,0,10));
        skilldata.add(new Skill("Pilot",1,0,0,1));
        skilldata.add(new Skill("Psychoanalysis",1,0,0,1));
        skilldata.add(new Skill("Psychology",10,0,0,10));
        skilldata.add(new Skill("Ride",5,0,0,5));
        skilldata.add(new Skill("Science",1,0,0,1));
        skilldata.add(new Skill("Sleight of Hand",10,0,0,10));
        skilldata.add(new Skill("Spot Hidden",25,0,0,25));
        skilldata.add(new Skill("Stealth",20,0,0,20));
        skilldata.add(new Skill("Survival",10,0,0,10));
        skilldata.add(new Skill("Swim",20,0,0,20));
        skilldata.add(new Skill("Throw",20,0,0,20));
        skilldata.add(new Skill("Track",10,0,0,10));
        skilldata.add(new Skill("Beast Trainning*",5,0,0,5));
        skilldata.add(new Skill("Diving*",1,0,0,1));
        skilldata.add(new Skill("Demolitions*",1,0,0,1));
        skilldata.add(new Skill("Read Lips",1,0,0,1));
        skilldata.add(new Skill("Hypnosis*",1,0,0,1));
        skilldata.add(new Skill("Artillery*",1,0,0,1));
        skilldata.add(new Skill("Knowledge*",0,0,0,0));
        
        return skilldata;
    }
    
    /**
     * Initializes the controller class.
     * @param project
     */
    public void setProject(COC7Project project){
        this.project = project;
    }
    
    public void setFour(Create_4Controller four){
        this.four = four;
        info = four.getInfo();
    }

    public void setOccupation(String occu){
        occupationSelected = occu;
        occ.setText("CHOSEN: "+occu);
        
    }
    
    @FXML
    public void changeToEntry(ActionEvent event) throws IOException{
        project.openEntry();
    }
    
    @FXML
    public void output(ActionEvent event) throws IOException{
        // if user has selected directory → output
        if (!"".equals(selectedDirectory)){
            JFXAlert alert = new JFXAlert((Stage) finish.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setOverlayClose(false);
            JFXDialogLayout layout = new JFXDialogLayout();
            String name = info.get(0).split(" ")[1];
            String dic = selectedDirectory+"\\"+name+".csv";
            layout.setHeading(new Label("Output Data Alert"));
            layout.setBody(new Label("Please find the excel file in "+dic+"\n"));
            JFXButton closeButton = new JFXButton("Accept");
            closeButton.getStyleClass().add("dialog-accept");
            closeButton.setOnAction(e -> {
                try {
                    writeExcel();
                } catch (Exception ex) {
                    Logger.getLogger(Create_5Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                alert.hideWithAnimation();
            });
            layout.setActions(closeButton);
            alert.setContent(layout);
            alert.show();
        // if directory not select → alert    
        } else{
            JFXAlert alert = new JFXAlert((Stage) finish.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setOverlayClose(false);
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Label("Directory Error Alert"));
            layout.setBody(new Label("Please choose the directory use the directory choose button\n"));
            JFXButton closeButton = new JFXButton("Accept");
            closeButton.getStyleClass().add("dialog-accept");
            closeButton.setOnAction(e -> {
                alert.hideWithAnimation();
            });
            layout.setActions(closeButton);
            alert.setContent(layout);
            alert.show();
        }
    }
    
    
    @FXML
    public void selectDirectory(ActionEvent event){
        DirectoryChooser  directoryChooser  = new DirectoryChooser ();
        Window primaryStage = directory.getScene().getWindow();
        File f=  directoryChooser.showDialog(primaryStage);
        if (f != null){
            selectedDirectory =f.getAbsolutePath();
            directoryShow.setText("The directory you choose is:\n"+selectedDirectory);
        }
    }
    @FXML
    public void openDirectory(ActionEvent event) throws IOException{
        if (!"".equals(selectedDirectory))
            Desktop.getDesktop().open(new File(selectedDirectory));
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupEditableTableView();
        
    }    
    /*
     * data class
     */
    static final class Skill extends RecursiveTreeObject<Skill> {
        final StringProperty name;
        final SimpleIntegerProperty initial;
        final SimpleIntegerProperty occupation;
        final SimpleIntegerProperty interest;
        final SimpleIntegerProperty total;

        Skill(String name, int inital, int occupation, int interest, int total) {
            this.name = new SimpleStringProperty(name);
            this.initial = new SimpleIntegerProperty(inital);
            this.occupation = new SimpleIntegerProperty(occupation);
            this.interest = new SimpleIntegerProperty(interest);
            this.total = new SimpleIntegerProperty(total);
        }

        StringProperty nameProperty() {
            return name;
        }

    }
    
    public void writeExcel() throws Exception {
    Writer writer = null;
    String name = info.get(0).split(" ")[1];
    String dic = selectedDirectory+"\\"+name+".csv";
    try {
        // export the data user iuputed before
        File file = new File(dic);
        writer = new BufferedWriter(new FileWriter(file));
        writer.write("Investigator Info Table\n");
        for (int i = 0; i < info.size();i++){
            String[] line = info.get(i).split(": ");
            String text = "";
            if (line.length == 1) text = line[0] +"\n";
            else text = line[0] + ",," + line[1] +"\n";
            writer.write(text);
            
        }
        // export the skill data
        writer.write("\n");
        writer.write("Skill,Initial Point,Occupation Point,Interest Point,Total Point\n");
        for (int i = 0; i < skillTable.getCurrentItemsCount();i++){
            Skill item = skillTable.getTreeItem(i).getValue();
            String text = item.name.getValue() + "," + item.initial.getValue() + "," + item.occupation.getValue() +","+ item.interest.getValue() +","+ item.total.getValue() +"\n";
            writer.write(text);
        
        }
    } catch (IOException ex) {
        Logger.getLogger(Create_5Controller.class.getName()).log(Level.SEVERE, null, ex);
    }
    finally {

        writer.flush();
        writer.close();
    } 
}
}
