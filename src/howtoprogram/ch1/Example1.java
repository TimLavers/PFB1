package howtoprogram.ch1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class Example1 extends Application {

    int[][] getTileColors() {
        return new int[][]{
                {0, 255},
                {255, 0 }
        };
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Tiler tiler = new Tiler(getTileColors());
        Canvas canvas = tiler.setUpPicture();
        Group root = new Group(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}