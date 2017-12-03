package hpcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hp-calculator.fxml"));
        primaryStage.setTitle("HP-Calculator");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
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
