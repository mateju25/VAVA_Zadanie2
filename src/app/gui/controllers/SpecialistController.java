package app.gui.controllers;

import app.model.Administrator;
import app.model.Programator;
import app.model.RentSystem;
import app.model.SafetyConsultant;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SpecialistController implements BasicController{
    public TextField textCertificate1;
    public TextField textName1;
    public TextField textValue1;
    public TextField textPrax1;
    public TextField textEdu1;
    public ChoiceBox<String> choiceType1;
    public TextField textName2;
    public TextField textValue2;
    public TextField textPrax2;
    public TextField textEdu2;
    public CheckBox checkAudit2;
    public TextField textCertificate2;
    public TextField textName3;
    public TextField textValue3;
    public TextField textPrax3;
    public TextField textEdu3;
    public ChoiceBox<String> choiceType3;
    public TextField textCertificate3;
    public TextField textPlatform3;
    public TabPane tabsType;
    public Label warning;

    public void initialize() {
        choiceType1.getItems().addAll("Java", "C++", "ABAP", "VBA", "Python", "Ruby", "iOS", "Iné");
        choiceType3.getItems().addAll("Aplikačný", "Sieťový", "SAP", "Iné");
    }

    public void proceed() {
        if (tabsType.getSelectionModel().isSelected(0)) {
            if (textCertificate1.getText().length() != 0 &&
                    textName1.getText().length() != 0 &&
                    textPrax1.getText().length() != 0 &&
                    textValue1.getText().length() != 0 &&
                    textEdu1.getText().length() != 0 &&
                    choiceType1.getSelectionModel().getSelectedItem() != null) {
                double temp;
                try {
                    temp = Double.parseDouble(textValue1.getText());
                } catch (NumberFormatException a) {
                    warning.setText("Zadal si neplatnú hodnotu v Cena!");
                    return;
                }
                ArrayList<String> list = new ArrayList<>();
                list.add(textCertificate1.getText());
                RentSystem.getInstance().addSpecialist(new Programator(textName1.getText(), false, temp, textPrax1.getText(), textEdu1.getText(), list, choiceType1.getSelectionModel().getSelectedItem()));
            } else {
                warning.setText("Vyplň všetky polia!");
                return;
            }
        } else {
            if (tabsType.getSelectionModel().isSelected(1)) {
                if (textCertificate2.getText().length() != 0 &&
                        textName2.getText().length() != 0 &&
                        textPrax2.getText().length() != 0 &&
                        textValue2.getText().length() != 0 &&
                        textEdu2.getText().length() != 0) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(textCertificate2.getText());
                    double temp;
                    try {
                        temp = Double.parseDouble(textValue2.getText());
                    } catch (NumberFormatException a) {
                        warning.setText("Zadal si neplatnú hodnotu v Cena!");
                        return;
                    }
                    RentSystem.getInstance().addSpecialist(new SafetyConsultant(textName2.getText(), false, temp, textPrax2.getText(), textEdu2.getText(), list, checkAudit2.isSelected()));
                } else {
                    warning.setText("Vyplň všetky polia!");
                    return;
                }
            } else {
                if (textCertificate3.getText().length() != 0 &&
                        textName3.getText().length() != 0 &&
                        textPrax3.getText().length() != 0 &&
                        textValue3.getText().length() != 0 &&
                        textPlatform3.getText().length() != 0 &&
                        textEdu3.getText().length() != 0 &&
                        choiceType3.getSelectionModel().getSelectedItem() != null) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(textCertificate3.getText());
                    double temp;
                    try {
                        temp = Double.parseDouble(textValue3.getText());
                    } catch (NumberFormatException a) {
                        warning.setText("Zadal si neplatnú hodnotu v Cena!");
                        return;
                    }
                    RentSystem.getInstance().addSpecialist(new Administrator(textName3.getText(), false, temp, textPrax3.getText(), textEdu3.getText(), list, choiceType3.getSelectionModel().getSelectedItem(), textPlatform3.getText()));
                } else {
                    warning.setText("Vyplň všetky polia!");
                    return;
                }
            }
        }
        cancel();
    }

    public void cancel() {
        Stage stage = (Stage) tabsType.getScene().getWindow();
        stage.close();

    }
}
