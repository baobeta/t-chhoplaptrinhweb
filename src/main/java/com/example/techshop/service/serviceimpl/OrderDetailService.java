package com.example.techshop.service.serviceimpl;

import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.OrderDetailEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.service.iservice.IOrderDetailService;
import com.example.techshop.utils.MailUtils;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.OrderDetailConverter;
import com.example.techshop.utils.convert.list.OrderDetailListConverter;
import com.example.techshop.utils.convert.list.ProductListConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDetailService implements IOrderDetailService {
    public List<OrderDetailDTO> pagingnation(Integer pageNumber, Integer pageSize) {
        List<OrderDetailEntity> entities = STRepoUtil.getOrderDetailRepo().pagination(pageNumber,pageSize);
        return OrderDetailListConverter.entity2Dto(entities);

    }

    public List<OrderDetailDTO> pagingnation(Integer pageNumber, Integer pageSize, String col, String value) {
        List<OrderDetailEntity> entities = STRepoUtil.getOrderDetailRepo().pagination(pageNumber,pageSize, col, value);
        return OrderDetailListConverter.entity2Dto(entities);

    }
    public List<OrderDetailDTO> pagingnation(Integer pageNumber, Integer pageSize, boolean value) {
        List<OrderDetailEntity> entities = STRepoUtil.getOrderDetailRepo().pagination(pageNumber,pageSize, "ispaid", value);
        return OrderDetailListConverter.entity2Dto(entities);

    }


    public Integer CountOrderDetailList(String col, String value) {
        return STRepoUtil.getOrderDetailRepo().Count("orderDetailId", col, value);
    }
    public Integer CountOrderDetailList( boolean value) {
        return STRepoUtil.getOrderDetailRepo().Count("orderDetailId", "isPaid", value);
    }

    public Map<Integer, Integer> getIncomeInMonth(int year){
        List<Object[]> list = STRepoUtil.getOrderDetailRepo().getIncomeInMonth(year);
        Map<Integer, Integer> data = new HashMap<>();
        for(int i=1;i<=12;i++) {
            data.put(i,0);
        }
        for(Object[] item : list){
            Integer  index = Integer.valueOf(item[0].toString());
            Integer value = Integer.valueOf(item[1].toString());
            data.replace(index,value);
            System.out.println(index);


        }
        return data;
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

    public List<Integer> getYear() {
        return STRepoUtil.getOrderDetailRepo().getYears();
    }
    public Integer CountOrderDetailNotConFirmed() {
        return STRepoUtil.getOrderDetailRepo().Count("orderDetailId","ispaid",false);
    }

    @Override
    public void sendConfirmationMail(OrderDetailDTO orderDetail) {
        MailUtils mailSender = new MailUtils(orderDetail.getUserDTO().getEmail());
        mailSender.sendMail(MailUtils.mailHeaders()+MailUtils.mailContent(orderDetail)+MailUtils.mailFooter());
    }
}
