package sample;

import javafx.scene.control.TableColumn;



/**
 * Created by ganne on 7/24/2017.
 */
public class Tests {
    private final String name;
    private String points;
    private TableColumn header;

    public Tests(String name, String points) {
        this.name = name;
        this.points = points;
        header = new TableColumn(name);
    }
    public TableColumn returnCol(){
        return this.header;
    }
}
