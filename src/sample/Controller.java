package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    public static double pro;
    public static String proText;
    public static String subjectText;
    public static boolean show;
    public static String subjectAssGrade;
    public static boolean addGradeOAss;
    public static String assName;
    public static String pointss;
    public static List<Label> addToGrid;
    public static boolean addDetails;
    String name;
    @FXML
    TableView gradeBookTable;
    @FXML
    TitledPane stats;
    @FXML
    GridPane subjectStats;
    @FXML
    private BorderPane mainWindow;

    @FXML
    Button statsGoBack;
    @FXML
    Button forwardBtn;
    @FXML
    ToggleButton gradeBookBtn;
    @FXML
    ToggleButton calenderBtn;
    @FXML
    ToggleButton attendanceBtn;
    @FXML
    ToggleButton lessonPlansBtn;
    @FXML
    Button backBtn;
    @FXML
    Button All;
    @FXML
    ImageView addGrade;

    @FXML
    ProgressBar titlepaneProgress;


    @FXML
    TableColumn subjectGrades;
    @FXML
    TableColumn communityTime;
    @FXML
    TableColumn languageArts;
    @FXML
    TableColumn expressiveArts;
    @FXML
    TableColumn science;
    @FXML
    TableColumn allSubjects;

    @FXML
    CheckBox communitytime;
    @FXML
    CheckBox languagearts;
    @FXML
    CheckBox expressivearts;
    @FXML
    CheckBox Science;

    private Map<String, Subjects> labels;
    private List<String> labelName;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labels = new HashMap<>();
        labelName = new ArrayList<>();
        labelName.add("Religion");
        labelName.add("Social Studies");
        labelName.add("Oral Reading");

        labelName.add("Comprehension");
        labelName.add("Grammar");
        labelName.add("Spelling");
        labelName.add("Creative Writing");
        labelName.add("Penmanship");
        labelName.add("Phonics");
        labelName.add("Spanish");
        labelName.add("Learning Potential");

        labelName.add("Physical Education");
        labelName.add("Music/Dance/Drama");
        labelName.add("Arts & Craft");

        labelName.add("General Science");
        labelName.add("Health Science");
        labelName.add("Mathematics");
        labelName.add("Computer");
        labelName.add("Math 2");
        labelName.add("Home Economics");

        labels.put(labelName.get(0), new Subjects(labelName.get(0)));
        labels.put(labelName.get(1), new Subjects(labelName.get(1)));
        labels.put(labelName.get(2), new Subjects(labelName.get(2)));

        labels.put(labelName.get(3), new Subjects(labelName.get(3)));
        labels.put(labelName.get(4), new Subjects(labelName.get(4)));
        labels.put(labelName.get(5), new Subjects(labelName.get(5)));
        labels.put(labelName.get(6), new Subjects(labelName.get(6)));
        labels.put(labelName.get(7), new Subjects(labelName.get(7)));
        labels.put(labelName.get(8), new Subjects(labelName.get(8)));
        labels.put(labelName.get(9), new Subjects(labelName.get(9)));
        labels.put(labelName.get(10), new Subjects(labelName.get(10)));

        labels.put(labelName.get(11), new Subjects(labelName.get(11)));
        labels.put(labelName.get(12), new Subjects(labelName.get(12)));
        labels.put(labelName.get(13), new Subjects(labelName.get(13)));

        labels.put(labelName.get(14), new Subjects(labelName.get(14)));
        labels.put(labelName.get(15), new Subjects(labelName.get(15)));
        labels.put(labelName.get(16), new Subjects(labelName.get(16)));
        labels.put(labelName.get(17), new Subjects(labelName.get(17)));
        labels.put(labelName.get(18), new Subjects(labelName.get(18)));
        labels.put(labelName.get(19), new Subjects(labelName.get(19)));


        double j = 0.0;
        for (int i = 0; i < 10; i++) {

            labels.get(labelName.get(i)).changeProgress(j);
            j += 0.1;
        }
        j = 1;
        for (int i = 10; i < 20; i++) {

            labels.get(labelName.get(i)).changeProgress(j);
            j -= 0.1;
        }
        populateColumns();
        updateName();
        selectAll();
        All.setVisible(false);
        setAddGrade();
        setTitiltedPaneBack();
    }

    private void setTitiltedPaneBack() {
        int num = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (num < 20) {
                    subjectStats.add(labels.get(labelName.get(num)).returnsubjectLabel(), i, j);
                }
                num++;
            }
        }
    }

    private void updateGridPane() {
        int num = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (num < addToGrid.size()) {
                    subjectStats.add(addToGrid.get(num), i, j);
                }
                num++;
            }
        }
    }

    @FXML
    public void update() {
        titlepaneProgress.setProgress(pro);
        stats.setText(proText);
        statsGoBack.setDisable(false);
        if (titlepaneProgress.getProgress() <= 0.5d) {
            titlepaneProgress.setStyle("-fx-accent: #ff0000;");
        } else if (titlepaneProgress.getProgress() > .5 && titlepaneProgress.getProgress() <= .6) {
            titlepaneProgress.setStyle("-fx-accent: #f7640e;");
        } else if (titlepaneProgress.getProgress() > .6 && titlepaneProgress.getProgress() <= .7) {
            titlepaneProgress.setStyle("-fx-accent: #f8ba0e;");
        } else if (titlepaneProgress.getProgress() > .7 && titlepaneProgress.getProgress() <= .8) {
            titlepaneProgress.setStyle("-fx-accent: #f4db0e;");
        } else if (titlepaneProgress.getProgress() > .8) {
            titlepaneProgress.setStyle("-fx-accent: #31f20e;");
        }
        if (addDetails) {
            subjectStats.getChildren().clear();
            updateGridPane();
            addDetails = false;
        }
    }

    @FXML
    public void changeCenterView() {
        if (gradeBookBtn.isSelected()) {
            gradeBookTable.setVisible(true);
            calenderBtn.setSelected(false);
            attendanceBtn.setSelected(false);
            lessonPlansBtn.setSelected(false);
        }
        if (calenderBtn.isSelected()) {
            gradeBookTable.setVisible(false);
        }
        if (attendanceBtn.isSelected()) {
            gradeBookTable.setVisible(false);
            calenderBtn.setSelected(false);
            gradeBookBtn.setSelected(false);
            lessonPlansBtn.setSelected(false);
        }
        if (lessonPlansBtn.isSelected()) {
            gradeBookTable.setVisible(false);
            calenderBtn.setSelected(false);
            attendanceBtn.setSelected(false);
            gradeBookBtn.setSelected(false);
        }
    }

    public static void setProText(Double dd, String text) {
        pro = dd;
        proText = text;
    }


    public static void openSubject(String text) {
        subjectText = text;

    }

    @FXML
    public void updateName() {
        if (show) {
            clearColumns();
            subjectGrades.setVisible(true);
            subjectGrades.getColumns().add(labels.get(subjectText).returnColAss());
            labels.get(subjectText).addNames();
            allSubjects.setVisible(false);
            backBtn.setDisable(false);
            All.setDisable(true);
            communitytime.setDisable(true);
            languagearts.setDisable(true);
            expressivearts.setDisable(true);
            Science.setDisable(true);
            communityTime.setVisible(false);
            languageArts.setVisible(false);
            expressiveArts.setVisible(false);
            science.setVisible(false);
            addGrade.setVisible(true);
            show = false;
        }
    }
    @FXML
    public void forwardbtnPressed(){
        show = true;
        updateName();
    }

    public void clearColumns() {
        subjectGrades.getColumns().clear();
        communityTime.getColumns().clear();
        languageArts.getColumns().clear();
        expressiveArts.getColumns().clear();
        science.getColumns().clear();
    }

    public void populateColumns() {
        for (int i = 0; i < 2; i++) {
            communityTime.getColumns().add(labels.get(labelName.get(i)).returnColumn());
        }
        for (int i = 2; i < 11; i++) {
            languageArts.getColumns().add(labels.get(labelName.get(i)).returnColumn());
        }
        for (int i = 11; i < 14; i++) {
            expressiveArts.getColumns().add(labels.get(labelName.get(i)).returnColumn());
        }
        for (int i = 14; i < 20; i++) {
            science.getColumns().add(labels.get(labelName.get(i)).returnColumn());
        }
    }
//
//    public void populateColumns() {
//
//        communityTime.getColumns().setAll(labels.get(labelName.get(0)).returnColumn(), labels.get(labelName.get(1)).returnColumn());
//        languageArts.getColumns().setAll(labels.get(labelName.get(2)).returnColumn(), labels.get(labelName.get(3)).returnColumn(), labels.get(labelName.get(4)).returnColumn(), labels.get(labelName.get(5)).returnColumn(), labels.get(labelName.get(6)).returnColumn(), labels.get(labelName.get(7)).returnColumn(), labels.get(labelName.get(8)).returnColumn(), labels.get(labelName.get(9)).returnColumn(), labels.get(labelName.get(10)).returnColumn());
//        expressiveArts.getColumns().setAll(labels.get(labelName.get(11)).returnColumn(), labels.get(labelName.get(12)).returnColumn(), labels.get(labelName.get(13)).returnColumn());
//        science.getColumns().setAll(labels.get(labelName.get(14)).returnColumn(), labels.get(labelName.get(15)).returnColumn(), labels.get(labelName.get(16)).returnColumn(), labels.get(labelName.get(17)).returnColumn(), labels.get(labelName.get(18)).returnColumn(), labels.get(labelName.get(19)).returnColumn());
//
//    }

    @FXML
    public void goBack() {
        populateColumns();
        subjectGrades.setVisible(false);
        backBtn.setDisable(true);
        allSubjects.setVisible(true);
        communitytime.setDisable(false);
        languagearts.setDisable(false);
        expressivearts.setDisable(false);
        Science.setDisable(false);
        addGrade.setVisible(false);
        subjectView();
    }

    @FXML
    public void statsGoBack() {
        subjectStats.getChildren().clear();
        titlepaneProgress.setProgress(0.0);
        stats.setText("Class Stats");
        statsGoBack.setDisable(true);
        setTitiltedPaneBack();
    }

    @FXML
    public void subjectView() {
        communityTime.setVisible(communitytime.isSelected());
        languageArts.setVisible(languagearts.isSelected());
        expressiveArts.setVisible(expressivearts.isSelected());
        science.setVisible(Science.isSelected());
        if (!Science.isSelected() || !expressivearts.isSelected() || !languagearts.isSelected() || !communitytime.isSelected()) {
            All.setVisible(true);
        } else {
            All.setVisible(false);
        }
    }

    @FXML
    public void selectAll() {
        communitytime.setSelected(true);
        languagearts.setSelected(true);
        expressivearts.setSelected(true);
        Science.setSelected(true);
        subjectView();
    }

    @FXML
    public void addgrade() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainWindow.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("add.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Fail");
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            Add controller = fxmlLoader.getController();
            controller.processResults();
            addAss();
        }


    }

    private void setAddGrade() {
        addGrade.setVisible(false);
        addGrade.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> addGrade.setScaleX(-1.0));
        addGrade.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> addGrade.setScaleX(1.0));
        addGrade.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> addGrade.setScaleY(-1.0));
        addGrade.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> addGrade.setScaleY(1.0));
        addGrade.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> addGrade.setCursor(Cursor.HAND));
        addGrade.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> addGrade.setScaleY(1.15));
        addGrade.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> addGrade.setScaleX(1.15));
        addGrade.addEventHandler(MouseEvent.MOUSE_EXITED, event -> addGrade.setScaleY(1.0));
        addGrade.addEventHandler(MouseEvent.MOUSE_EXITED, event -> addGrade.setScaleX(1.0));

    }

    public static void updatesubject(Boolean ass, String name,String point,String assname) {
        subjectAssGrade = name;
        addGradeOAss = ass;
        pointss = point;
        assName = assname;
    }

    private void addAss() {
        subjectGrades.getColumns().clear();
        if (addGradeOAss) {
            labels.get(subjectText).addASS(subjectAssGrade);
        } else if(!addGradeOAss){
            labels.get(subjectText).addGrade(assName, subjectAssGrade,pointss);
        }
        subjectGrades.getColumns().add(labels.get(subjectText).returnColAss());
        goBack();
        show = true;
        updateName();
    }
}

