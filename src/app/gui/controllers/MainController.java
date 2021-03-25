package app.gui.controllers;

import app.gui.listCells.ListCellEmployer;
import app.gui.listCells.ListCellSpecialist;
import app.model.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    public ListView<Employer> viewEmployers1;
    public Button btnAddSpecialist1;
    public Button btnRemoveSpec1;
    public ListView<Specialist> viewSpecialist1;
    public Button btmAddEmp1;
    public Button btnRemoveEmp1;

    public void initialize() {
        viewEmployers1.getItems().clear();
        viewEmployers1.getItems().addAll(RentSystem.getInstance().getListOfEmployers());
        viewEmployers1.setCellFactory(param -> new ListCellEmployer());
        viewSpecialist1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        viewSpecialist1.getItems().clear();
        viewSpecialist1.getItems().addAll(RentSystem.getInstance().getListOfSpecialists());
        viewSpecialist1.setCellFactory(param -> new ListCellSpecialist());
    }

    public void addSpecialist() {
        try {
            newWindow("/app/gui/views/specialist.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        viewSpecialist1.getItems().clear();
        viewSpecialist1.getItems().addAll(RentSystem.getInstance().getListOfSpecialists());
    }

    public void removeSpecialist() {
        if (RentSystem.getInstance().removeSpecialist(viewSpecialist1.getSelectionModel().getSelectedItem())) {
            viewSpecialist1.getItems().clear();
            viewSpecialist1.getItems().addAll(RentSystem.getInstance().getListOfSpecialists());
        }
    }

    public void addEmployer() {
        try {
            newWindow("/app/gui/views/employer.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        viewEmployers1.getItems().clear();
        viewEmployers1.getItems().addAll(RentSystem.getInstance().getListOfEmployers());
    }

    public void removeEmployer() {
        if (RentSystem.getInstance().removeEmployer(viewEmployers1.getSelectionModel().getSelectedItem())) {
            viewEmployers1.getItems().clear();
            viewEmployers1.getItems().addAll(RentSystem.getInstance().getListOfEmployers());
        }
    }



    private void newWindow(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage window = new Stage();
        window.setResizable(false);
        window.getIcons().add(new Image(getClass().getResourceAsStream("/app/gui/views/Icon.png")));
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        window.showAndWait();
    }

    public void addRent() {
        if (viewEmployers1.getSelectionModel().getSelectedItem() != null && viewSpecialist1.getSelectionModel().getSelectedItems() != null) {
            ArrayList<Specialist> list = new ArrayList<>(viewSpecialist1.getSelectionModel().getSelectedItems());
            list.removeIf(Specialist::isTaken);
            for (Specialist spec :
                    list) {
                if (spec instanceof Programator)
                    viewEmployers1.getSelectionModel().getSelectedItem().getPositions().remove("Programátor");
                if (spec instanceof Administrator)
                    viewEmployers1.getSelectionModel().getSelectedItem().getPositions().remove("Administrátor");
                if (spec instanceof SafetyConsultant)
                    viewEmployers1.getSelectionModel().getSelectedItem().getPositions().remove("Bezpečák");
            }

            if (list.size() == 0)
                return;
            RentSystem.getInstance().getListOfRents().add(new Rent(list, viewEmployers1.getSelectionModel().getSelectedItem()));
            for (Specialist spec:
                    viewSpecialist1.getSelectionModel().getSelectedItems()) {
                spec.setTaken(true);
            }
            viewSpecialist1.getItems().clear();
            viewSpecialist1.getItems().addAll(RentSystem.getInstance().getListOfSpecialists());
            viewEmployers1.getItems().clear();
            viewEmployers1.getItems().addAll(RentSystem.getInstance().getListOfEmployers());
        }
    }

    public void aboutRents() {
        try {
            newWindow("/app/gui/views/rents.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        viewSpecialist1.getItems().clear();
        viewSpecialist1.getItems().addAll(RentSystem.getInstance().getListOfSpecialists());
    }
}
