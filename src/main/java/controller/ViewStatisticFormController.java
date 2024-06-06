package controller;

import BO.OrderBo;
import BO.ProductBo;
import dto.OrderDto;
import dto.OrderItemDetailDto;
import dto.tm.CustomerTm;
import dto.tm.StatisticTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewStatisticFormController implements Initializable {
    public TableView tblStatistics;
    public TableColumn colStatisticName;
    public TableColumn colValue;
    public DatePicker datePicker;
    public Button getPdfBtn;

    public void getPdfBtnOnaction(ActionEvent actionEvent) {
    }

    public void datePickerOnaction(ActionEvent actionEvent) {
    }
    private OrderBo orderBo = new OrderBo();
    private ProductBo productBo = new ProductBo();
    public void loadSatisticTable(){
        ObservableList<StatisticTm> tmList = FXCollections.observableArrayList();
        List<OrderDto> allOrders = orderBo.all();
        Double totalGainAmount = 0d;
        Double totalSpendAmount =0d;
        Double totalOrders =0d;

        for(OrderDto orderDto:allOrders){
            totalGainAmount += orderDto.getTotalPrice();
            totalOrders++;
            List<OrderItemDetailDto> orderItemDetailDtos = orderDto.getOrderItemDetails();
            for(OrderItemDetailDto orderItemDetailDto : orderItemDetailDtos){
                totalSpendAmount += productBo.getProduct(orderItemDetailDto.getProductId()).getBuyingUnitPrice()*orderItemDetailDto.getQty();
            }
        }
        boolean addfirst = tmList.add(new StatisticTm("Total Amount gained ", totalGainAmount));
        boolean addSecond = tmList.add(new StatisticTm("Total Amount Spends ", totalSpendAmount));
        boolean addThird = tmList.add(new StatisticTm("Total Profit  ", totalGainAmount-totalSpendAmount));
        boolean addForth = tmList.add(new StatisticTm("Total orders", totalOrders));

        tblStatistics.setItems(tmList);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colStatisticName.setCellValueFactory(new PropertyValueFactory<>("statisticName"));
        colValue.setCellValueFactory(new PropertyValueFactory<>("statisticValue"));

        loadSatisticTable();
    }
}
