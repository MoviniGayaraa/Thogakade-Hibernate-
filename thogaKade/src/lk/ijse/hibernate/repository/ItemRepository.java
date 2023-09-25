package lk.ijse.hibernate.repository;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.hibernate.bo.custom.ItemBo;
import lk.ijse.hibernate.bo.custom.impl.ItemBOImpl;
import lk.ijse.hibernate.config.SessionFactoryConfig;
import lk.ijse.hibernate.dto.ItemDTO;
import org.hibernate.Session;
import java.io.IOException;
import java.net.URL;

public class ItemRepository {
    public TextField txtItem_id;
    public TextField txtItem_name;
    public TextField txtQty;
    public TextField txtPrice;

    ItemBo itemBo = new ItemBOImpl();
    private final Session session;

    public Button root;

    public ItemRepository(){ session = SessionFactoryConfig.getInstance().getSession();}

    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/lk/ijse/hibernate/view/MainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        int id = Integer.parseInt((txtItem_id.getText()));
        String ItemName = txtItem_name.getText();
        int QtyOnHand = Integer.parseInt(txtQty.getText());
        double unitePrice = Double.parseDouble(txtPrice.getText());

        ItemDTO dto = new ItemDTO(id, ItemName, QtyOnHand, unitePrice);
        try {
            boolean isSaved = itemBo.saveItem(dto);

            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Item Saved");
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }


    public void updateOnAction(ActionEvent actionEvent) {
        int id = Integer.parseInt((txtItem_id.getText()));
        String  ItemName = txtItem_name.getText();
        int QtyOnHand = Integer.parseInt(txtQty.getText());
        double unitePrice = Double.parseDouble(txtPrice.getText());

        ItemDTO dto = new ItemDTO(id, ItemName, QtyOnHand, unitePrice);
        try {
            boolean isUpdate = itemBo.updateItem(dto);

            if(isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"Item Update");
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String id = txtItem_id.getText();
        try {
            boolean isDelete = itemBo.deleteItem(Integer.parseInt(id));
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION,"Item Delete!");
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }


}
