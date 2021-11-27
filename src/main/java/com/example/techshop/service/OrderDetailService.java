package com.example.techshop.service;

import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.OrderDetailEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.OrderDetailConverter;
import com.example.techshop.utils.convert.list.OrderDetailListConverter;
import com.example.techshop.utils.convert.list.ProductListConverter;

import java.util.List;

public class OrderDetailService {
    public List<OrderDetailDTO> pagingnation(Integer pageNumber, Integer pageSize) {
        List<OrderDetailEntity> entities = STRepoUtil.getOrderDetailRepo().pagination(pageNumber,pageSize);
        return OrderDetailListConverter.entity2Dto(entities);

    }

    public List<Object> getIncomeInMonth(int year){
        return STRepoUtil.getOrderDetailRepo().getIncomeInMonth(year);
    }
    public Integer CountOrderDetailList() {
        return STRepoUtil.getOrderDetailRepo().Count("orderDetailId");
    }

    public OrderDetailDTO update (OrderDetailDTO dto) {
        OrderDetailEntity entity = OrderDetailConverter.dto2Entity(dto);
        entity = STRepoUtil.getOrderDetailRepo().update(entity);
        OrderDetailDTO orderDTO = OrderDetailConverter.entity2Dto(entity);
        return orderDTO;
    }
    public OrderDetailDTO findById(Integer id) {
        return OrderDetailConverter.entity2Dto(STRepoUtil.getOrderDetailRepo().findById(id));
    }
}
