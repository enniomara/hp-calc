package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 500));
        primaryStage.show();
        /*HPCalculator hpCalculator = new HPCalculator();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                Double[] e = hpCalculator.processInput(scanner.next());
                for (Double g : e) {
                    System.out.println(g);
                }
            }catch (Error e){
                System.out.println(e.getMessage());
            }
        }*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
