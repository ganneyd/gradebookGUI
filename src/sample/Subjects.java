package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by ganne on 7/22/2017.
 */
public class Subjects {
    private label subjectLabel;
    public TableColumn subjectColumn;
    private Label header;
    private Map<String, Assessment> assessmentMap;
    public static ObservableList<String> assessmentNames;
    private List<String> names;

    public Subjects(String subjectName) {
        header = new Label(subjectName);
        subjectLabel = new label(subjectName);
        subjectColumn = new TableColumn();
        subjectColumn.setPrefWidth(120.0);
        assessmentMap = new HashMap<>();
        assessmentNames = FXCollections.observableArrayList();
        names = new ArrayList<>();
    }

    public TableColumn returnColumn() {
        subjectColumn.getColumns().clear();
        subjectColumn.setText("");
        header.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> Controller.openSubject(header.getText()));
        header.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> Controller.show = true);
        header.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> this.header.setStyle("-fx-font: 12px TimesNewRoman;"));
        header.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> this.header.setStyle("-fx-font: 15px TimesNewRoman;"));
        header.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> this.header.setTextFill(Color.CADETBLUE));
        header.addEventHandler(MouseEvent.MOUSE_EXITED, event -> this.header.setStyle("-fx-font: 12px TimesNewRoman;"));
        header.addEventHandler(MouseEvent.MOUSE_EXITED, event -> this.header.setTextFill(Color.BLACK));
        header.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> this.header.setStyle("-fx-font: 15px TimesNewRoman;"));
        subjectColumn.setGraphic(header);
        return this.subjectColumn;
    }

    public Label returnsubjectLabel() {
        subjectLabel.returnNode().addEventHandler(MouseEvent.MOUSE_PRESSED, event -> Controller.addToGrid = addToGridPane());
        subjectLabel.returnNode().addEventHandler(MouseEvent.MOUSE_PRESSED, event -> Controller.addDetails = true);
        return this.subjectLabel.returnNode();
    }

    public TableColumn returnColAss() {
        subjectColumn.setGraphic(null);
        subjectColumn.getColumns().clear();
        subjectColumn.setText(header.getText());
        subjectColumn.setMaxWidth(120.0);
        //subjectColumn.setResizable(false);
        for (int i = 0; i < assessmentMap.size(); i++) {
            subjectColumn.getColumns().add(assessmentMap.get(names.get(i)).returnAssCol());
        }

        return this.subjectColumn;
    }

    public void changeProgress(double newProgress) {
        this.subjectLabel.changeProgress(newProgress);
    }

    public void addASS(String assName) {
        assessmentMap.put(assName, new Assessment(assName));
        names.add(assName);
    }

    public void addGrade(String assName, String name, String points) {
        assessmentMap.get(assName).addGrade(name,points);
    }

    private List<Label> addToGridPane() {
        List<Label> addToGridPane = new ArrayList<>();
        for (int i = 0; i < assessmentMap.size(); i++) {
            addToGridPane.add(assessmentMap.get(names.get(i)).returnassLabel());
        }
        return addToGridPane;
    }

    public void addNames() {
        assessmentNames.clear();
        assessmentNames.addAll(names);

    }
}