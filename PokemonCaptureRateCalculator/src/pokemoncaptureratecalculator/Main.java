package pokemoncaptureratecalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Main extends Application {

    private TextField level, maxhp, currhp, evolutions, pokeball, misc;
    private Label total;
    private Button calculate;

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        ConditionsPane conditions = new ConditionsPane();
        pane.setLeft(conditions);
        GridPane mainpane = new GridPane();

        mainpane.getChildren().clear();

        Label title = new Label("Default Characteristics");
        mainpane.setConstraints(title, 0, 0);

        Label lvl = new Label("Level: ");
        mainpane.setConstraints(lvl, 0, 1);

        this.level = new TextField();
        mainpane.setConstraints(this.level, 1, 1);

        Label maxhp = new Label("Max HP: ");
        mainpane.setConstraints(maxhp, 0, 2);

        this.maxhp = new TextField();
        mainpane.setConstraints(this.maxhp, 1, 2);

        Label currhp = new Label("Current HP: ");
        mainpane.setConstraints(currhp, 0, 3);

        this.currhp = new TextField();
        mainpane.setConstraints(this.currhp, 1, 3);

        Label evolutions = new Label("Evolutions Left: ");
        mainpane.setConstraints(evolutions, 0, 4);

        this.evolutions = new TextField();
        mainpane.setConstraints(this.evolutions, 1, 4);

        Label misc = new Label("Any Misc mods:");
        mainpane.setConstraints(misc, 0, 5);

        this.misc = new TextField("0");
        mainpane.setConstraints(this.misc, 1, 5);

        this.calculate = new Button("Calculate");
        mainpane.setConstraints(this.calculate, 2, 5);

        Label total = new Label("Total:");
        mainpane.setConstraints(total, 0, 6);

        this.total = new Label("100");
        mainpane.setConstraints(this.total, 1, 6);

        mainpane.getChildren().add(title);
        mainpane.getChildren().add(lvl);
        mainpane.getChildren().add(this.level);
        mainpane.getChildren().add(maxhp);
        mainpane.getChildren().add(this.maxhp);
        mainpane.getChildren().add(currhp);
        mainpane.getChildren().add(this.currhp);
        mainpane.getChildren().add(evolutions);
        mainpane.getChildren().add(this.evolutions);
        mainpane.getChildren().add(misc);
        mainpane.getChildren().add(this.misc);
        mainpane.getChildren().add(this.calculate);
        mainpane.getChildren().add(total);
        mainpane.getChildren().add(this.total);

        Label blank = new Label("");
        mainpane.setConstraints(blank, 0, 7);
        
        Label reminder = new Label("Reminder: Pokeball thro-\nws are a struggle attack\nwith AC base 6," +
                "\nwith range of 4\n + trainer's atheltics. " +
                "Also,\ncapture roll is\n1d100-trainer's\nlevel+pokeball_mod");
        mainpane.setConstraints(reminder, 0, 8);
        
        mainpane.getChildren().add(blank);
        mainpane.getChildren().add(reminder);
        
        this.calculate.setOnAction(e -> {
            try {
                int rate = 100 + conditions.getRate();
                rate -= Integer.valueOf(this.level.getText()) * 2;

                int percentage = (int) (Double.parseDouble(this.currhp.getText()) / Double.parseDouble(this.maxhp.getText()) * 100.0);
                if (Integer.valueOf(this.currhp.getText()) == 1) {
                    rate += 30;
                } else if (percentage <= 25) {
                    rate += 15;
                } else if (percentage <= 50) {
                    rate += 0;
                } else if (percentage <= 75) {
                    rate -= 15;
                } else if (percentage >= 75) {
                    rate -= 30;
                }

                if (Integer.valueOf(this.evolutions.getText()) == 2) {
                    rate += 10;
                } else if (Integer.valueOf(this.evolutions.getText()) == 0) {
                    rate -= 10;
                }

                rate += Integer.valueOf(this.misc.getText());
                
                this.total.setText(Integer.toString(rate));
            } catch (Exception ex) {
                this.total.setText("Invalid input");
            }
        });

        pane.setCenter(mainpane);

        Scene scene = new Scene(pane, 624, 450);
        primaryStage.setTitle("PTU Capture Rate Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
