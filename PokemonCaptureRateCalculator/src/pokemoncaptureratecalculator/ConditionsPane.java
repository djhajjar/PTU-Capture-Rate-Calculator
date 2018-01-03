/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemoncaptureratecalculator;

import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class ConditionsPane extends GridPane {

    private CheckBox burned, frozen, paralysis, poisoned;
    private CheckBox badSleep, confused, cursed, disabled, rage, flinch, infatuation, sleep, suppressed, tempHP, injuries;
    private CheckBox stuck, slowed, shiny, legendary;
    private TextField injuryNum, disabledNum;

    public ConditionsPane() {
        super();

        getChildren().clear();

        Label title = new Label("Persistant Conditions");
        setConstraints(title, 0, 0);

        this.burned = new CheckBox("Burned?");
        setConstraints(this.burned, 0, 1);

        this.frozen = new CheckBox("Forzen?");
        setConstraints(this.frozen, 0, 2);

        this.paralysis = new CheckBox("Paralysis?");
        setConstraints(this.paralysis, 0, 3);

        this.poisoned = new CheckBox("Poisoned?");
        setConstraints(this.poisoned, 0, 4);

        //bad sleep; confused; cursed; disabled; rage; flinch; infatuation; sleep; suppressed; temporary hit points
        Label blank = new Label(" ");
        setConstraints(blank, 0, 5);

        Label title2 = new Label("Volatile Conditions");
        setConstraints(title2, 0, 6);

        this.badSleep = new CheckBox("Bad Sleep?");
        setConstraints(this.badSleep, 0, 7);

        this.confused = new CheckBox("Confused?");
        setConstraints(this.confused, 0, 8);

        this.cursed = new CheckBox("Cursed?");
        setConstraints(this.cursed, 0, 9);

        this.disabled = new CheckBox("Disabled? Number:");
        setConstraints(this.disabled, 0, 10);

        this.disabledNum = new TextField();
        setConstraints(this.disabledNum, 1, 10);

        this.rage = new CheckBox("Rage?");
        setConstraints(this.rage, 0, 11);

        this.flinch = new CheckBox("Flinch?");
        setConstraints(this.flinch, 0, 12);

        this.infatuation = new CheckBox("Infatuation?");
        setConstraints(this.infatuation, 0, 13);

        this.sleep = new CheckBox("Sleep?");
        setConstraints(this.sleep, 0, 14);

        this.suppressed = new CheckBox("Suppressed?");
        setConstraints(this.suppressed, 0, 15);

        this.tempHP = new CheckBox("Temp HP?");
        setConstraints(this.tempHP, 0, 16);

        this.injuries = new CheckBox("Injuries? Number:");
        setConstraints(this.injuries, 0, 17);

        this.injuryNum = new TextField();
        setConstraints(this.injuryNum, 1, 17);

        Label blank2 = new Label(" ");
        setConstraints(blank2, 0, 18);

        Label title3 = new Label("Other Conditions");
        setConstraints(title3, 0, 19);

        this.slowed = new CheckBox("Slowed?");
        setConstraints(this.slowed, 0, 20);

        this.stuck = new CheckBox("Stuck?");
        setConstraints(this.stuck, 0, 21);

        this.shiny = new CheckBox("Shiny?");
        setConstraints(this.shiny, 0, 22);

        this.legendary = new CheckBox("Legendary?");
        setConstraints(this.legendary, 0, 23);
        
        getChildren().add(title);
        getChildren().add(this.burned);
        getChildren().add(this.frozen);
        getChildren().add(this.paralysis);
        getChildren().add(this.poisoned);
        getChildren().add(blank);
        getChildren().add(title2);
        getChildren().add(this.badSleep);
        getChildren().add(this.confused);
        getChildren().add(this.cursed);
        getChildren().add(this.disabled);
        getChildren().add(this.disabledNum);
        getChildren().add(this.rage);
        getChildren().add(this.flinch);
        getChildren().add(this.infatuation);
        getChildren().add(this.sleep);
        getChildren().add(this.suppressed);
        getChildren().add(this.tempHP);
        getChildren().add(this.injuries);
        getChildren().add(this.injuryNum);
        getChildren().add(blank2);
        getChildren().add(title3);
        getChildren().add(this.slowed);
        getChildren().add(this.stuck);
        getChildren().add(this.shiny);
        getChildren().add(this.legendary);
    }

    public int getRate() {
        int rate = 0;

        if (this.burned.isSelected()) {
            rate += 10;
        }
        if (this.frozen.isSelected()) {
            rate += 10;
        }
        if (this.paralysis.isSelected()) {
            rate += 10;
        }
        if (this.poisoned.isSelected()) {
            rate += 10;
        }

        if (this.badSleep.isSelected()) {
            rate += 5;
        }
        if (this.confused.isSelected()) {
            rate += 5;
        }
        if (this.cursed.isSelected()) {
            rate += 5;
        }
        if (this.disabled.isSelected()) {
            rate += 5 * Integer.valueOf(this.disabled.getText());
        }
        if (this.rage.isSelected()) {
            rate += 5;
        }
        if (this.flinch.isSelected()) {
            rate += 5;
        }
        if (this.infatuation.isSelected()) {
            rate += 5;
        }
        if (this.sleep.isSelected()) {
            rate += 5;
        }
        if (this.suppressed.isSelected()) {
            rate += 5;
        }
        if (this.tempHP.isSelected()) {
            rate += 5;
        }
        if (this.injuries.isSelected()) {
            rate += 5 * Integer.valueOf(this.injuryNum.getText());
        }

        //private CheckBox stuck, slowed, shiny, legendary;
        if (this.stuck.isSelected()) {
            rate += 10;
        }
        if (this.slowed.isSelected()) {
            rate += 5;
        }
        if (this.shiny.isSelected()) {
            rate -= 10;
        }
        if (this.legendary.isSelected()) {
            rate -= 30;
        }

        return rate;
    }
}
