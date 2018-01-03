package pokemoncaptureratecalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PokemonCaptureRateCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        Label instructions = new Label("Level:");
        GridPane.setConstraints(instructions, 0, 0);

        TextField level = new TextField();
        GridPane.setConstraints(level, 1, 0);

        Label instructions2 = new Label("Max HP:");
        GridPane.setConstraints(instructions2, 0, 1);

        TextField maxhp = new TextField();
        GridPane.setConstraints(maxhp, 1, 1);

        Label instructions3 = new Label("Current HP: ");
        GridPane.setConstraints(instructions3, 0, 2);

        TextField curhp = new TextField();
        GridPane.setConstraints(curhp, 1, 2);

        Label instructions4 = new Label("Remaining Evolutions:");
        GridPane.setConstraints(instructions4, 0, 3);

        TextField evolutions = new TextField();
        GridPane.setConstraints(evolutions, 1, 3);

        CheckBox persistent = new CheckBox("Persistent Conditions? Number: ");
        GridPane.setConstraints(persistent, 0, 4);

        TextField persnum = new TextField();
        GridPane.setConstraints(persnum, 1, 4);

        CheckBox injuries = new CheckBox("Injuries/Volatile Conditions? Number:");
        GridPane.setConstraints(injuries, 0, 5);

        TextField injnum = new TextField();
        GridPane.setConstraints(injnum, 1, 5);

        CheckBox stuck = new CheckBox("Stuck?");
        GridPane.setConstraints(stuck, 0, 6);

        CheckBox slow = new CheckBox("Slowed?");
        GridPane.setConstraints(slow, 0, 7);

        CheckBox shiny = new CheckBox("Shiny?");
        GridPane.setConstraints(shiny, 0, 9);

        CheckBox legendary = new CheckBox("Legendary?");
        GridPane.setConstraints(legendary, 0, 10);

        CheckBox pokeball = new CheckBox("Pokeball adjustment?");
        GridPane.setConstraints(pokeball, 0, 11);

        TextField pokeballCalc = new TextField();
        GridPane.setConstraints(pokeballCalc, 1, 11);

        CheckBox misc = new CheckBox("Misc Adjustments:");
        GridPane.setConstraints(misc, 0, 12);

        TextField miscNum = new TextField();
        GridPane.setConstraints(miscNum, 1, 12);

        Button calculate = new Button("Calculate");
        GridPane.setConstraints(calculate, 0, 14);

        Label output = new Label("");
        GridPane.setConstraints(output, 1, 14);

        calculate.setOnAction(e -> {
            try {
                int rate = 100;
                rate -= Integer.valueOf(level.getText()) * 2;

                int percentage = (int) (Double.parseDouble(curhp.getText()) / Double.parseDouble(maxhp.getText()) * 100.0);
                if (Integer.valueOf(curhp.getText()) == 1) {
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

                if (Integer.valueOf(evolutions.getText()) == 2) {
                    rate += 10;
                } else if (Integer.valueOf(evolutions.getText()) == 0) {
                    rate -= 10;
                }

                if (shiny.isSelected()) {
                    rate -= 10;
                }
                if (legendary.isSelected()) {
                    rate -= 30;
                }

                if (persistent.isSelected()) {
                    rate += 10 * Integer.valueOf(persnum.getText());
                }
                if (injuries.isSelected()) {
                    rate += 5 * Integer.valueOf(injnum.getText());
                }
                if (stuck.isSelected()) {
                    rate += 10;
                }
                if (slow.isSelected()) {
                    rate += 5;
                }

                if (pokeball.isSelected()) {
                    rate += Integer.valueOf(pokeballCalc.getText());
                }
                if (misc.isSelected()) {
                    rate += Integer.valueOf(miscNum.getText());
                }

                output.setText(Integer.toString(rate));
            } catch (Exception ex) {
                output.setText("Invalid Input");
            }
        });

        pane.getChildren().add(instructions);
        pane.getChildren().add(level);
        pane.getChildren().add(instructions2);
        pane.getChildren().add(maxhp);
        pane.getChildren().add(instructions3);
        pane.getChildren().add(curhp);
        pane.getChildren().add(instructions4);
        pane.getChildren().add(evolutions);
        pane.getChildren().add(persistent);
        pane.getChildren().add(persnum);
        pane.getChildren().add(injuries);
        pane.getChildren().add(injnum);
        pane.getChildren().add(stuck);
        pane.getChildren().add(slow);
        pane.getChildren().add(shiny);
        pane.getChildren().add(legendary);
        pane.getChildren().add(pokeball);
        pane.getChildren().add(pokeballCalc);
        pane.getChildren().add(misc);
        pane.getChildren().add(miscNum);
        pane.getChildren().add(calculate);
        pane.getChildren().add(output);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("PTU Capture Rate Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
