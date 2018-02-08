import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.sikuli.basics.Debug;
import org.sikuli.basics.FileManager;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

import java.io.File;
import java.net.URL;
import java.security.CodeSource;

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

        Screen s = new Screen();
//        ImagePath.setBundlePath("D:\\IdeaProjects\\godshelper\\target\\classes\\images\\");
//        ImagePath.add("Main/images");
        ImagePath.addJar("godshelper.jar", "images");

        String[] strings = ImagePath.get();
        for (String p : strings) {
            System.out.println(p);
        }
        s.highlight(1);
        Settings.MinSimilarity = 0.5;
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ImagePath.find("back.png"));
        try {
            s.findAll("back.jpg");
            s.getLastMatches().hasNext();
            while (s.getLastMatches().hasNext()) {
                s.getLastMatches().next().highlight(1);
                Debug.info("Score: %s", s.getLastMatches().next().getScore());
                s.getLastMatches().remove();
            }
            Match m = s.find("back.jpg");
            Pattern p = new Pattern("back.jpg");
            if (m.exists(p.exact()) != null) {
                Debug.info("Score: %f", s.getLastMatch().getScore());
                s.getLastMatch().highlight(3.0f);
            }
        } catch(FindFailed e) {
            e.printStackTrace();
        }

        primaryStage.close();
    }
}
