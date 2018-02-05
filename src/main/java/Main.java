import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.sikuli.script.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

        Screen screen = new Screen();
        try {
            screen.wait("img/chrome_back.jpg", 3.0);
            screen.getLastMatch().highlight(3.0f);
            screen.getLastMatch().click();
        }
        catch(FindFailed findFailedException) {
            findFailedException.printStackTrace();
        }
    }
}
