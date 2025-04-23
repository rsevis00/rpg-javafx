package rpg;

import javafx.application.Application;
import javafx.stage.Stage;
import rpg.view.MainMenuView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RPG de Texto");
        MainMenuView menu = new MainMenuView(primaryStage);
        primaryStage.setScene(menu.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
