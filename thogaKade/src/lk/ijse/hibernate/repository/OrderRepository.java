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
import lk.ijse.hibernate.bo.custom.OrderBo;
import lk.ijse.hibernate.bo.custom.impl.OrderBOImpl;
import lk.ijse.hibernate.config.SessionFactoryConfig;
import lk.ijse.hibernate.dto.ItemDTO;
import lk.ijse.hibernate.dto.OrderDTO;
import org.hibernate.Session;
import java.io.IOException;
import java.net.URL;

public class OrderRepository {

   OrderBo orderBo = new OrderBOImpl();
    private final Session session;

    public Button root;
    public TextField txtOrder_id;
    public TextField txtOrder_Date;
    public TextField txtCust_Id;
    public TextField txtQty;

    public OrderRepository(){session = SessionFactoryConfig.getInstance().getSession();}

    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/lk/ijse/hibernate/view/MainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    public void saveOnAction(ActionEvent actionEvent) {
        int id = Integer.parseInt((txtOrder_id.getText()));
        int Cust_id = Integer.parseInt(txtCust_Id.getText());
        String OrderDate =(txtOrder_Date.getText());
        int QtyOnHand = Integer.parseInt((txtQty.getText()));

        OrderDTO dto = new OrderDTO(id, Cust_id, OrderDate, QtyOnHand);
        try {
            boolean isSaved = orderBo.saveOrder(dto);

            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Order Saved");
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }


    public void deleteOnAction(ActionEvent actionEvent) {
        String id = txtOrder_id.getText();
        try {
            boolean isDelete = orderBo.deleteItem(Integer.parseInt(id));
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION,"Order Delete!");
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }
}
