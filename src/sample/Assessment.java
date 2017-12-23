package sample;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ganne on 7/24/2017.
 */
public class Assessment {
private  TableColumn assessment;
private Map<String,Grades> grades;
private label label;

public Assessment(String assessmentName){
    assessment=new TableColumn<>(assessmentName);
    grades = new HashMap<>();
    label = new label(assessmentName);
}
 public void addGrade(String name, String points){
    this.grades.put(assessment.getText(),new Grades(name,points));
    this.assessment.getColumns().add(grades.get(assessment.getText()).returnGradeCol());
 }
 public Map<String,Grades> returnGrades(){
     return this.grades;
 }
 public TableColumn returnAssCol(){
     return this.assessment;
 }

 public Label returnassLabel(){
     return this.label.returnNode();
 }

    @Override
    public String toString() {
        return this.assessment.getText();
    }

}
