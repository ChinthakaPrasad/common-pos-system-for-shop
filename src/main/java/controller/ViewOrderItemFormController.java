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
    private ProductBo productBo = new ProductBo();

    private OrderBo orderBo = new OrderBo();
    private String orderId;
    public void deleteOrderBtnOnacntion(ActionEvent actionEvent) {
        orderBo.delete(orderBo.getOrder(orderId));
        tblOrderItem.refresh();
    }

    public void loadItemTable(OrderTm orderTm){
        List<OrderItemDetailDto> orderItemDetailDtoList = orderTm.getOrderItemDetails();
        ObservableList<OrderItemTm> itemTm = FXCollections.observableArrayList();

        orderId = orderTm.getOrderId();

        for(OrderItemDetailDto item: orderItemDetailDtoList){
            OrderItemTm orderItemTm = new OrderItemTm(
                    item.getOrderId(),
                    productBo.getProduct(item.getProductId()).getProductName(),
                    item.getProductId(),
                    item.getAmount(),
                    item.getQty()
            );

            itemTm.add(orderItemTm);
        }
        tblOrderItem.setItems(itemTm);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colProductId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));


    }
}
