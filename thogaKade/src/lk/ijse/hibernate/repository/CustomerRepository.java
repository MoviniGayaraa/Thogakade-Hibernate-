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
import lk.ijse.hibernate.bo.custom.CustomerBo;
import lk.ijse.hibernate.bo.custom.impl.CustomerBOImpl;
import lk.ijse.hibernate.config.SessionFactoryConfig;
import lk.ijse.hibernate.dto.CustomerDTO;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;


public class CustomerRepository {
 CustomerBo customerBo = new CustomerBOImpl();
    private final Session session;

    public Button root;
    public TextField txtCust_Id;
    public TextField txtCust_name;
    public TextField txtcust_address;
    public TextField txtcontact;


    public CustomerRepository(){
        session = SessionFactoryConfig.getInstance().getSession();
    }

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
        int id = Integer.parseInt((txtCust_Id.getText()));
        String CustomerName = txtCust_name.getText();
        String address = txtcust_address.getText();
        String contact =txtcontact.getText();

        CustomerDTO dto = new CustomerDTO(id, CustomerName, address, contact);
        try {
            boolean isSaved = customerBo.saveCustomer(dto);

            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved");
            }
        } catch (Exception e) {
           new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        int id = Integer.parseInt((txtCust_Id.getText()));
        String CustomerName = txtCust_name.getText();
        String address = txtcust_address.getText();
        String contact =txtcontact.getText();

        CustomerDTO dto = new CustomerDTO(id, CustomerName, address, contact);
        try {
            boolean isUpdate = customerBo.updateCustomer(dto);

            if(isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Update");
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String id = txtCust_Id.getText();
        try {
            boolean isDelete = customerBo.deleteCustomer(Integer.parseInt(id));
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Delete!");
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
}
