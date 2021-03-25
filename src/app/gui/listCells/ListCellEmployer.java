package app.gui.listCells;

import app.model.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ListCellEmployer extends ListCell<Employer> {

    public Label textName;
    public Label textBusiness;
    public Label textDesc;
    public ImageView imageView;
    public Label textCount;
    public Pane pane;

    private FXMLLoader mLLoader;
    @Override
    protected void updateItem(Employer emp, boolean empty) {
        super.updateItem(emp, empty);

        if(empty || emp == null) {

            setText(null);
            setGraphic(null);

        } else {

            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/app/gui/views/listCellEmployer.fxml"));
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            ((ListCellEmployer) mLLoader.getController()).textName.setText(emp.getName());
            ((ListCellEmployer) mLLoader.getController()).textBusiness.setText(emp.getFieldOfBusiness());
            ((ListCellEmployer) mLLoader.getController()).textCount.setText(String.valueOf(emp.getCount()));
            if (emp.getLogo() == null) {
                ((ListCellEmployer) mLLoader.getController()).imageView.setImage(new Image(getClass().getResourceAsStream("/app/gui/views/None.png")));
            } else {
                ((ListCellEmployer) mLLoader.getController()).imageView.setImage(emp.getLogo());
            }
            String desc = "Hľadá: ";
            for (String str :
                    emp.getPositions()) {
                desc += str + ", ";
            }
            ((ListCellEmployer) mLLoader.getController()).textDesc.setText(desc);
            setText(null);
            setGraphic( ((ListCellEmployer) mLLoader.getController()).pane);
        }

    }
}

