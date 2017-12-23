package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Map;

/**
 * Created by ganne on 7/23/2017.
 */
public class Add {
    @FXML
    private TextField newAss;
    @FXML
    private TextField points;
    @FXML
    private ChoiceBox ass;
    @FXML
    private CheckBox gradeChoice;
    private boolean addGrade;
    private String name;
    private String point;
    private String assName;

    public void processResults() {
        name = newAss.getText();
        point = points.getText();
        Controller.updatesubject(addGrade, name,point, assName);
        ass.setItems(Subjects.assessmentNames);
    }

    public void initialize() {
        ass.setItems(Subjects.assessmentNames);
        selectionModel();
        ass.setDisable(true);
        points.setVisible(false);
        addGrade = true;
    }

    private void selectionModel() {
        if (Subjects.assessmentNames.isEmpty()) {
            gradeChoice.setDisable(true);
        } else {
            gradeChoice.setDisable(false);
        }
    }

    @FXML
    private void getCheck() {
        ass.getSelectionModel().clearSelection();
        if (!gradeChoice.isSelected()) {
            addGrade = false;
            ass.setDisable(false);
            points.setVisible(true);
            points.setPromptText("Maximum points");
            newAss.setPromptText("Select category to continue");
            points.setDisable(true);
            newAss.setDisable(true);
        } else {
            ass.setDisable(true);
            points.setVisible(false);
            points.setDisable(false);
            newAss.setDisable(false);
            newAss.setPromptText("New Assessment field");
            addGrade = true;
        }
    }
    @FXML
    private void updateAss(){
        if(gradeChoice.isSelected() && ass.getSelectionModel().getSelectedItem() != null){
            newAss.setPromptText("New " +ass.getSelectionModel().getSelectedItem()+ " name");
            newAss.setTooltip(new Tooltip("New " +ass.getSelectionModel().getSelectedItem()+ " name"));
            newAss.setDisable(false);
        }
    }
    @FXML
    private void updatePoints(){
        if(gradeChoice.isSelected() && ass.getSelectionModel().getSelectedItem() != null) {
            points.setTooltip(new Tooltip("Maximum points for: " + newAss.getText()));
            points.setDisable(false);
        }
    }

    @FXML
    public void updatefields(){
            updateAss();
            updatePoints();
            assName = (String) ass.getSelectionModel().getSelectedItem();

    }
}
