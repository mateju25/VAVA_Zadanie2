package app.gui.controllers;

import app.model.Rent;
import app.model.RentSystem;
import app.model.Specialist;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class RentsController implements BasicController{
    public Button btnCancel;
    public Button btnRemoveRent;
    public ListView<Rent> viewRents;

    public void initialize() {

        viewRents.setCellFactory(param -> new ListCell<Rent>() {
            @Override
            protected void updateItem(Rent item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null) {
                    setText(null);
                } else {
                    setText(item.getInfo());
                }
            }
        });

        viewRents.getItems().clear();
        viewRents.getItems().addAll(RentSystem.getInstance().getListOfRents());
    }

    public void cancel() {
        Stage stage = (Stage) viewRents.getScene().getWindow();
        stage.close();
    }

    public void removeRent() {
        if (viewRents.getSelectionModel().getSelectedItem() == null)
            return;
        for (Specialist spec :
                viewRents.getSelectionModel().getSelectedItem().getEmployees()) {
            spec.setTaken(false);
        }
        RentSystem.getInstance().getListOfRents().remove(viewRents.getSelectionModel().getSelectedItem());
        viewRents.getItems().clear();
        viewRents.getItems().addAll(RentSystem.getInstance().getListOfRents());
    }
}
