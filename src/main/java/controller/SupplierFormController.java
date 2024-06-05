package controller;

import BO.SupplierBo;
import dto.CustomerDto;
import dto.SupplierDto;
import dto.tm.CustomerTm;
import dto.tm.ProductTm;
import dto.tm.SupplierTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SupplierFormController implements Initializable {

    public Button refreshBtn;
    public Button updateSupplierBtn;
    public TableView tblSupplier;
    @FXML
    private TextField supplierName;

    @FXML
    private TextField supplierRemarks;

    @FXML
    private TextField supplierPhoneNumber;

    @FXML
    private TextField supplierAddress;

    @FXML
    private Button addSupplierBtn;

    @FXML
    private TextField searchSupplier;

    @FXML
    private TableColumn<?, ?> tblSupplierName;

    @FXML
    private TableColumn<?, ?> tblPhoneNumber;

    @FXML
    private TableColumn<?, ?> tblAddress;

    @FXML
    private TableColumn<?, ?> tblEmail;

    @FXML
    private TableColumn<?, ?> tblRemarks;

    @FXML
    private TableColumn<?, ?> tblAction;

    @FXML
    private Button goBackBtn;

    @FXML
    private Button clearAllBtn;

    @FXML
    private TextField supplierEmail;

    private SupplierBo supplierBo= new SupplierBo();



    public void addSupplierBtnOnaction(javafx.event.ActionEvent actionEvent) {
        SupplierDto dto = new SupplierDto(
                0,
                supplierName.getText(),
                supplierPhoneNumber.getText(),
                supplierAddress.getText(),
                supplierEmail.getText(),
                supplierRemarks.getText());

        if(supplierBo.save(dto)){
            new Alert(Alert.AlertType.INFORMATION,"Supplier Added!").show();
            loadSupplierTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Supplier Added Unsuccessful").show();
        }
    }

    public void searchSupplierOnaction(javafx.event.ActionEvent actionEvent) {
        String searchName = searchSupplier.getText();
        ObservableList<SupplierTm> filterTmList = FXCollections.observableArrayList();
        for(SupplierTm supplierTm: tmList){
            if(supplierTm.getSupplierName().equalsIgnoreCase(searchName.toLowerCase())){
                filterTmList.add(supplierTm);
            }
        }
        tblSupplier.setItems(filterTmList);
    }

    public void goBackBtnOnaction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goBackBtn.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml")));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }


    public void refreshBtnOnaction(javafx.event.ActionEvent actionEvent) {
        loadSupplierTable();
        clearFields();
        searchSupplier.clear();
    }

    public void updateSupplierBtnOnaction(javafx.event.ActionEvent actionEvent) {
        SupplierDto dto = new SupplierDto(
                0,
                supplierName.getText(),
                supplierPhoneNumber.getText(),
                supplierAddress.getText(),
                supplierEmail.getText(),
                supplierRemarks.getText());

        if(supplierBo.save(dto)){
            new Alert(Alert.AlertType.INFORMATION,"Supplier Updated!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Supplier Updated Unsuccessful").show();
        }
    }
    private ObservableList<SupplierTm> tmList = FXCollections.observableArrayList();
    private void loadSupplierTable() {
        tmList = FXCollections.observableArrayList();

        List<SupplierDto> dtoList  = supplierBo.all();
        for (SupplierDto dto:dtoList) {
            Button btn = new Button("Delete");
            SupplierTm c = new SupplierTm(
                    dto.getSupplierId(),
                    dto.getSupplierName(),
                    dto.getSupplierPhone(),
                    dto.getSupplierAddress(),
                    dto.getSupplierEmail(),
                    dto.getRemarks(),
                    btn
            );

            btn.setOnAction(actionEvent -> {
                deleteCustomer(dto);
            });

            tmList.add(c);
        }
        tblSupplier.setItems(tmList);
    }
    private void deleteCustomer(SupplierDto dto) {

        boolean isDeleted = supplierBo.delete(dto);
        if (isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Supplier Deleted!").show();
            loadSupplierTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
        }

    }

    private void setData(SupplierTm newValue) {
        if (newValue != null) {
            supplierName.setText(newValue.getSupplierName());
            supplierPhoneNumber.setText(newValue.getSupplierPhone());
            supplierAddress.setText(newValue.getSupplierAddress());
            supplierEmail.setText(newValue.getSupplierEmail());
            supplierRemarks.setText(newValue.getRemarks());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblSupplierName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        tblPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("supplierPhone"));
        tblAddress.setCellValueFactory(new PropertyValueFactory<>("supplierAddress"));
        tblEmail.setCellValueFactory(new PropertyValueFactory<>("supplierEmail"));
        tblRemarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        tblAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadSupplierTable();

        tblSupplier.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData((SupplierTm) newValue);
        });

    }

    private void clearFields() {
        tblSupplier.refresh();
        supplierName.clear();
        supplierPhoneNumber.clear();
        supplierAddress.clear();
        supplierEmail.clear();
        supplierRemarks.clear();
    }


    public void onMouseClickAction(MouseEvent mouseEvent) {

    }
}
