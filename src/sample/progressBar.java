package sample;

import com.sun.scenario.effect.Effect;
import javafx.scene.Cursor;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseEvent;

/**
 * Created by ganne on 7/21/2017.
 */
public class progressBar extends ProgressBar {
    private  ProgressBar dor;

    public progressBar(double progress) {
        dor = new ProgressBar(progress);
        dor.setPrefWidth(200.0);
        dor.setBlendMode(BlendMode.DARKEN);
        updateColor();
    }


    public void updateColor(){
        if(dor.getProgress() <=0.5d){
            dor.setStyle("-fx-accent: #ff0000;");
        }else if(dor.getProgress() >.5 && dor.getProgress() <=.6){
            dor.setStyle("-fx-accent: #f7640e;");
        }else if(dor.getProgress() >.6 && dor.getProgress()<=.7){
            dor.setStyle("-fx-accent: #f8ba0e;");
        }else if(dor.getProgress() >.7 && dor.getProgress() <=.8){
            dor.setStyle("-fx-accent: #f4db0e;");
        }else if(dor.getProgress() >.8){
            dor.setStyle("-fx-accent: #31f20e;");
        }
    }
    public ProgressBar returnNode(){
        return this.dor;
    }
    public void change(double newProgress){
        dor.setProgress(newProgress);
    }
    public double getP(){
        return this.dor.getProgress();
    }

}
