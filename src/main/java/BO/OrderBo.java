package BO;

import dao.CustomerDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import dao.ProductDao;
import dto.OrderDto;
import dto.OrderItemDetailDto;
import entity.Customer;
import entity.Order;
import entity.OrderDetailKey;
import entity.OrderItemDetail;

import java.util.List;

public class OrderBo implements SuperBo<OrderDto>{
    private OrderDao orderDao = new OrderDao();
    private CustomerDao customerDao = new CustomerDao();
    private ProductDao productDao = new ProductDao();
    private OrderDetailBo orderDetailBo = new OrderDetailBo();
    private OrderDetailDao orderDetailDao = new OrderDetailDao();

    public int getOrderId(){
        return orderDao.getLastOrderId();
    }

    @Override
    public boolean save(OrderDto dto) {
        Order order = new Order(
                dto.getCustomerName(),
                dto.getDate()
        );

        Customer c = customerDao.getCustomer(dto.getCustomerName());

        order.setCustomer(c);

        for(OrderItemDetailDto detailDto: dto.getOrderItemDetails()){
            OrderItemDetail orderItemDetail = new OrderItemDetail(
                    new OrderDetailKey(dto.getOrderId(), detailDto.getProductId()),
                    productDao.getProduct(detailDto.getProductId()),
                    order,
                    detailDto.getQty(),
                    detailDto.getAmount()
                    );
            orderDetailDao.saveOrderDetail(orderItemDetail);
        }

        return orderDao.saveOrder(order);

    }

    @Override
    public boolean update(OrderDto dto) {
        return false;
    }

    @Override
    public boolean delete(OrderDto dto) {
        return false;
    }

    @Override
    public List<OrderDto> all() {
        return null;
    }
}
