package sample;

import javafx.scene.control.TableColumn;

/**
 * Created by ganne on 7/24/2017.
 */
public class Grades {
    private TableColumn gradeCol;
    private double maxPoints;

    public  Grades(String gradename, String points){
        this.gradeCol = new TableColumn(gradename + points);
        //this.maxPoints = points;
    }
    public TableColumn returnGradeCol(){
        return this.gradeCol;
    }
}
