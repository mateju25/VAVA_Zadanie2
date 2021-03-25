package app.gui.listCells;

import app.model.Administrator;
import app.model.Programator;
import app.model.SafetyConsultant;
import app.model.Specialist;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class ListCellSpecialist extends ListCell<Specialist> {
    public Pane pane;
    public Label textName;
    public Label textValue;
    public Label textPrax;
    public Label textEdu;
    public Label textType;
    public Label textCertificates;
    public Label textDesc;
    public Rectangle available;
    public Label textTypeSPec;
    public Label lblAvail;
    private FXMLLoader mLLoader;
    @Override
    protected void updateItem(Specialist spec, boolean empty) {
        super.updateItem(spec, empty);

        if(empty || spec == null) {

            setText(null);
            setGraphic(null);

        } else {

            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/app/gui/views/listCellSpecialist.fxml"));
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (spec instanceof Programator)
                ((ListCellSpecialist) mLLoader.getController()).textTypeSPec.setText("Programátor");
            if (spec instanceof Administrator)
                ((ListCellSpecialist) mLLoader.getController()).textTypeSPec.setText("Administrátor");
            if (spec instanceof SafetyConsultant)
                ((ListCellSpecialist) mLLoader.getController()).textTypeSPec.setText("Bezpečák");


            ((ListCellSpecialist) mLLoader.getController()).textName.setText(spec.getName());
            ((ListCellSpecialist) mLLoader.getController()).textValue.setText(String.valueOf(spec.getCost()));
            ((ListCellSpecialist) mLLoader.getController()).textPrax.setText(spec.getLengthOfPractice());
            ((ListCellSpecialist) mLLoader.getController()).textEdu.setText(spec.getHighestEducation());
            ((ListCellSpecialist) mLLoader.getController()).textCertificates.setText(spec.getCertificates().get(0));
            if (spec instanceof Programator)
                ((ListCellSpecialist) mLLoader.getController()).textType.setText(((Programator) spec).getFocusType());
            else {
                if (((SafetyConsultant) spec).isInNBU())
                    ((ListCellSpecialist) mLLoader.getController()).textType.setText("Je auditor NBU");
                else
                    ((ListCellSpecialist) mLLoader.getController()).textType.setText("Nie je auditor NBU");
            }
            if (spec instanceof Administrator)
                ((ListCellSpecialist) mLLoader.getController()).textDesc.setText(((Administrator)spec).getPreferedSystem());
            if (spec.isTaken()) {
                ((ListCellSpecialist) mLLoader.getController()).available.setVisible(true);
                ((ListCellSpecialist) mLLoader.getController()).lblAvail.setVisible(true);
            }
            else {
                ((ListCellSpecialist) mLLoader.getController()).available.setVisible(false);
                ((ListCellSpecialist) mLLoader.getController()).lblAvail.setVisible(false);
            }
            setText(null);
            setGraphic( ((ListCellSpecialist) mLLoader.getController()).pane);
        }

    }
}
