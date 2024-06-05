package controller;

import BO.OrderBo;
import BO.ProductBo;
import dto.OrderItemDetailDto;
import dto.tm.OrderItemTm;
import dto.tm.OrderTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewOrderItemFormController implements Initializable {
    public TableView tblOrderItem;
    public TableColumn colProductId;
    public TableColumn colProductName;
    public TableColumn colQty;
    public TableColumn colAmount;

    public Button deleteOrderBtn;
    public TableColumn colSupplier;
    private ProductBo productBo = new ProductBo();

    private OrderBo orderBo = new OrderBo();
    private String orderId;
    public void deleteOrderBtnOnacntion(ActionEvent actionEvent) {
        orderBo.delete(orderBo.getOrder(orderId));
        loadItemTable(null);
    }

    public void loadItemTable(OrderTm orderTm){
        if(orderTm!=null){
            List<OrderItemDetailDto> orderItemDetailDtoList = orderTm.getOrderItemDetails();
            ObservableList<OrderItemTm> itemTm = FXCollections.observableArrayList();

            orderId = orderTm.getOrderId();

            for(OrderItemDetailDto item: orderItemDetailDtoList){
                OrderItemTm orderItemTm = new OrderItemTm(
                        item.getOrderId(),
                        productBo.getProduct(item.getProductId()).getProductName(),
                        item.getProductId(),
                        item.getAmount(),
                        item.getQty(),
                        item.getSupplierName()
                );

                itemTm.add(orderItemTm);
            }
            tblOrderItem.setItems(itemTm);
        }else{
            tblOrderItem.setItems(null);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colProductId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colSupplier.setCellValueFactory(new PropertyValueFactory<>("supplier"));


    }
}
