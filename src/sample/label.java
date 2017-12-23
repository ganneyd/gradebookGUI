package sample;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * Created by ganne on 7/22/2017.
 */
public class label extends Label {
    private  Label progressBarLabel;
    private  progressBar progress;

    public label(String text){
        progress = new progressBar(0.0);
        progressBarLabel = new Label(text,progress.returnNode());
        progressBarLabel.setStyle("-fx-font: 12px TimesNewRoman; -fx-fill: #000000;");
        progressBarLabel.setContentDisplay(ContentDisplay.RIGHT);
        progressBarLabel.addEventHandler(MouseEvent.MOUSE_PRESSED,event -> Controller.setProText(this.getProgress(),text));
        progressBarLabel.addEventHandler(MouseEvent.MOUSE_PRESSED,event -> this.progressBarLabel.setStyle("-fx-font: 12px TimesNewRoman;"));
        progressBarLabel.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> this.progressBarLabel.setStyle("-fx-font: 15px TimesNewRoman;"));
        progressBarLabel.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> this.progressBarLabel.setTextFill(Color.CADETBLUE));
        progressBarLabel.addEventHandler(MouseEvent.MOUSE_EXITED,event ->  this.progressBarLabel.setStyle("-fx-font: 12px TimesNewRoman;"));
        progressBarLabel.addEventHandler(MouseEvent.MOUSE_EXITED,event -> this.progressBarLabel.setTextFill(Color.BLACK));
        progressBarLabel.addEventHandler(MouseEvent.MOUSE_RELEASED,event -> this.progressBarLabel.setStyle("-fx-font: 15px TimesNewRoman;"));
       progressBarLabel.addEventHandler(MouseEvent.MOUSE_ENTERED,event ->progressBarLabel.setCursor(Cursor.HAND));
        progressBarLabel.getGraphic().addEventHandler(MouseEvent.MOUSE_ENTERED,event ->progressBarLabel.getGraphic().setCursor(Cursor.DEFAULT));
    }

    public void changeProgress(double newProgress){
    progress.change(newProgress);
    progress.updateColor();
   }
   public Label returnNode(){
        return this.progressBarLabel;
   }
   public double getProgress(){
       return progress.getP();
   }
}
