package app.gui.controllers;

import app.model.Employer;
import app.model.RentSystem;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EmployerController implements BasicController{
    public TextField textName1;
    public TextField textBusiness;
    public TextField textEmployes;
    public Button addNewPosition;
    public ListView<String> listEmployees;
    public ChoiceBox<String> choiceEmployeeType;
    public Label warning;
    public Button btnLogo;

    private Image tempImg = null;

    public void initialize() {
        choiceEmployeeType.getItems().addAll("Programátor", "Bezpečák", "Administrátor");
    }

    public void addEmployee() {
        listEmployees.getItems().add(choiceEmployeeType.getSelectionModel().getSelectedItem());
    }

    public void loadImage() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(listEmployees.getScene().getWindow());
        if (selectedFile != null) {
            BufferedImage buff = ImageIO.read(selectedFile);
            tempImg = SwingFXUtils.toFXImage(buff, null);
            btnLogo.setText("Načítané");
        }
    }

    public void cancel() {
        Stage stage = (Stage) listEmployees.getScene().getWindow();
        stage.close();
    }

    public void createEmployer() {
        if (textBusiness.getText().length() != 0 &&
                textName1.getText().length() != 0 &&
                textEmployes.getText().length() != 0 &&
                listEmployees.getItems().size() != 0) {
            int temp;
            try {
                temp = Integer.parseInt(textEmployes.getText());
            } catch (NumberFormatException a) {
                warning.setText("Zadal si neplatnú hodnotu v Počet zamestnancov!");
                return;
            }

            RentSystem.getInstance().addEmployer(new Employer(textName1.getText(), textBusiness.getText(), temp, tempImg, new ArrayList<>(listEmployees.getItems())));
        } else {
            warning.setText("Vyplň všetky polia!");
            return;
        }
        cancel();
    }
}
