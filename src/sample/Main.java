package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class Main extends Application {

    public static final String FILE_NAME = "D:\\Computers\\Qa Experts\\MyCode\\CurrencyConvertor\\results.txt";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        Group root = new Group();
        TextArea textArea = new TextArea(getListString());
        textArea.setPrefSize(300,275);
        textArea.setEditable(false);
        root.getChildren().add(textArea);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private String getListString(){
        StringBuilder listBuilder = new StringBuilder();

        try {
            List<Result> resultList = FileManager.read(FILE_NAME);
            for (Result result: resultList) {
                listBuilder.append(result.toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listBuilder.toString();
    }
}