package controller;

import BO.ProductBo;
import BO.SupplierBo;
import dto.ProductDto;
import dto.SupplierDto;
import dto.tm.CustomerTm;
import dto.tm.ProductTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ProductFormController implements Initializable {

    public Button refreshBtn;
    public Button updateProductBtn;
    public TableView tblProduct;
    public Button clearFieldBtn;
    public TextField unitBuyingPrice;
    public ComboBox cmbSupplier;
    @FXML
    private TextField productName;

    @FXML
    private TextField productRemarks;

    @FXML
    private TextField unitSellingPrice;

    @FXML
    private TextField unitType;

    @FXML
    private Button addProductBtn;

    @FXML
    private TextField searchProductField;

    @FXML
    private Button goBackBtn;

    @FXML
    private Button clearAllBtn;

    @FXML
    private TableColumn<?, ?> tblProductId;

    @FXML
    private TableColumn<?, ?> tblProductName;

    @FXML
    private TableColumn<?, ?> tblUnitPrice;

    @FXML
    private TableColumn<?, ?> tblUnitType;

    @FXML
    private TableColumn<?, ?> tblRemarks;

    @FXML
    private TableColumn<?, ?> tblAction;
    private ProductBo productBo = new ProductBo();



    public void addProductBtnOnaction(javafx.event.ActionEvent actionEvent) {
        boolean isExist = false;
        for(ProductTm p : tmList){
            if(p.getProductName().equalsIgnoreCase(productName.getText().toLowerCase())){
                isExist = true;
            }
        }
        if(!isExist && !productName.getText().isEmpty()){
            ProductDto dto = new ProductDto(0,
                    productName.getText(),
                    Double.parseDouble(unitSellingPrice.getText()),
                    Double.parseDouble(unitBuyingPrice.getText()),
                    cmbSupplier.getValue().toString(),
                    unitType.getText(),
                    productRemarks.getText());

            if(productBo.save(dto)){
                new Alert(Alert.AlertType.INFORMATION,"Product Added!").show();
                loadProductTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Product Added Unsuccessful").show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"Product Name already Exist").show();
        }

    }

    public void searchProductFieldOnaction(javafx.event.ActionEvent actionEvent) {
        String searchName = searchProductField.getText();
        ObservableList<ProductTm> filterTmList = FXCollections.observableArrayList();
        for(ProductTm productTm: tmList){
            if(productTm.getProductName().equalsIgnoreCase(searchName.toLowerCase())){
                filterTmList.add(productTm);
            }
        }
        tblProduct.setItems(filterTmList);
    }

    public void goBackBtnOnaction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goBackBtn.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml")));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }



    public void updateProductBtnOnaction(javafx.event.ActionEvent actionEvent) {
        ProductDto dto = new ProductDto(0,
                productName.getText(),
                Double.parseDouble(unitSellingPrice.getText()),
                Double.parseDouble(unitBuyingPrice.getText()),
                cmbSupplier.getValue().toString(),
                unitType.getText(),
                productRemarks.getText());

        if(productBo.update(dto)){
            new Alert(Alert.AlertType.INFORMATION,"Product Updated!").show();
            loadProductTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Product Updated Unsuccessful").show();
        }
    }

    private ObservableList<ProductTm> tmList = FXCollections.observableArrayList();
    private void loadProductTable() {
        tmList = FXCollections.observableArrayList();

        List<ProductDto> dtoList  = productBo.all();
        for (ProductDto dto:dtoList) {
            Button btn = new Button("Delete");
            ProductTm c = new ProductTm(
                    dto.getProductId(),
                    dto.getProductName(),
                    dto.getSellingUnitPrice(),
                    dto.getBuyingUnitPrice(),
                    dto.getSupplier(),
                    dto.getUnitType(),
                    dto.getRemarks(),
                    btn
            );

            btn.setOnAction(actionEvent -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete Confirmation");
                alert.setContentText("Do you want to delete? Which may affect delete all orders related to the Product too!");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    deleteProdcut(dto);
                }

            });

            tmList.add(c);
        }
        tblProduct.setItems(tmList);
    }

    private void deleteProdcut(ProductDto dto) {

        boolean isDeleted = productBo.delete(dto);
        if (isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Customer Deleted!").show();
            loadProductTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tblUnitPrice.setCellValueFactory(new PropertyValueFactory<>("sellingUnitPrice"));
        tblUnitType.setCellValueFactory(new PropertyValueFactory<>("unitType"));
        tblRemarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        tblAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadProductTable();
        loadSupplier();

        tblProduct.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData((ProductTm) newValue);
        });
    }

    private void setData(ProductTm newValue) {
        if (newValue != null) {
            productName.setText(newValue.getProductName());
            unitBuyingPrice.setText(String.valueOf(newValue.getBuyingUnitPrice()));
            unitSellingPrice.setText(String.valueOf(newValue.getSellingUnitPrice()));
            cmbSupplier.setValue(newValue.getSupplier());
            unitType.setText(newValue.getUnitType());
            productRemarks.setText(newValue.getRemarks());
        }
    }

    public void onMouseClickAction(MouseEvent mouseEvent) {

    }

    private void clearFields() {
        tblProduct.refresh();
        productName.clear();
        unitSellingPrice.clear();
        unitType.clear();
        productRemarks.clear();
    }

    public void clearFieldBtnOnaction(ActionEvent actionEvent) {
        clearFields();
    }

    public void refreshBtnOnaction(ActionEvent actionEvent) {
        loadProductTable();
        searchProductField.clear();
    }

    private SupplierBo supplierBo = new SupplierBo();
    public void loadSupplier(){
        ObservableList list = FXCollections.observableArrayList();
        List<SupplierDto> supplierDtoList = supplierBo.all();

        for(SupplierDto supplierDto: supplierDtoList){
            list.add(supplierDto.getSupplierName());
        }

        cmbSupplier.setItems(list);
    }
}
