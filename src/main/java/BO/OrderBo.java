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

import java.util.ArrayList;
import java.util.List;

public class OrderBo implements SuperBo<OrderDto>{
    private OrderDao orderDao = new OrderDao();
    private CustomerDao customerDao = new CustomerDao();
    private ProductDao productDao = new ProductDao();
    private OrderDetailBo orderDetailBo = new OrderDetailBo();
    private OrderDetailDao orderDetailDao = new OrderDetailDao();

    public String getOrderId(){
        String lastOrderId =  orderDao.getLastOrderId();
        if(lastOrderId != null){
            int num = Integer.parseInt(lastOrderId.split("[ ]")[1]);
            num++;
            return "Order "+ String.format("%03d",num);
        }
       return "Order 001";
    }

    @Override
    public boolean save(OrderDto dto) {
        Order order = new Order(
                dto.getCustomerName(),
                dto.getDate()
        );

        Customer c = customerDao.getCustomer(dto.getCustomerName());
        order.setOrderId(dto.getOrderId());
        order.setCustomer(c);
        order.setTotalPrice(dto.getTotalPrice());

        System.out.println(order.getOrderId());
        boolean b = orderDao.saveOrder(order);

        for(OrderItemDetailDto detailDto: dto.getOrderItemDetails()){
            OrderItemDetail orderItemDetail = new OrderItemDetail(
                    new OrderDetailKey(dto.getOrderId(), detailDto.getProductId()),
                    productDao.getProduct(detailDto.getProductId()),
                    order,
                    detailDto.getSupplierName(),
                    detailDto.getQty(),
                    detailDto.getAmount()
                    );
            orderDetailDao.saveOrderDetail(orderItemDetail);
        }

        return b;

    }

    @Override
    public boolean update(OrderDto dto) {
        return false;
    }

    @Override
    public boolean delete(OrderDto dto) {
        return orderDao.deleteOrder(dto.getOrderId());

    }

    @Override
    public List<OrderDto> all() {
        List<Order> orderList = orderDao.getAllOrder();
        List<OrderDto> orderDtoList = new ArrayList<>();


        for(Order order: orderList){
            List<OrderItemDetailDto> orderItemDetailDtos = new ArrayList<>();

            for(OrderItemDetail orderItemDetail: order.getOrderItemDetails()){
                orderItemDetailDtos.add(new OrderItemDetailDto(
                        orderItemDetail.getId().getOrderId(),
                        orderItemDetail.getId().getProductId(),
                        orderItemDetail.getAmount(),
                        orderItemDetail.getQty(),
                        orderItemDetail.getSupplierName()
                ));
            }
            orderDtoList.add(new OrderDto(
                    order.getOrderId(),
                    order.getCustomerName(),
                    order.getTotalPrice(),
                    order.getDate(),
                    orderItemDetailDtos
            ));
        }

        return orderDtoList;
    }
    public OrderDto getOrder(String id){
        Order order = orderDao.getOrder(id);
        return new OrderDto(
                order.getOrderId(),
                order.getCustomerName(),
                order.getTotalPrice(),
                order.getDate(),
                null
        );
    }
}
