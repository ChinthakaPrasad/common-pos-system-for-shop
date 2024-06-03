package BO;

import dto.OrderItemDetailDto;

import java.util.List;

public class OrderDetailBo implements SuperBo<OrderItemDetailDto>{
    @Override
    public boolean save(OrderItemDetailDto dto) {

        return false;
    }

    @Override
    public boolean update(OrderItemDetailDto dto) {
        return false;
    }

    @Override
    public boolean delete(OrderItemDetailDto dto) {
        return false;
    }

    @Override
    public List<OrderItemDetailDto> all() {
        return null;
    }
}
