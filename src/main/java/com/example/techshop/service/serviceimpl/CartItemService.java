package com.example.techshop.service.serviceimpl;

import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.service.iservice.ICartItemService;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.STServiceUtil;
import com.example.techshop.utils.convert.list.CartItemListConverter;
import com.example.techshop.utils.convert.list.ProductListConverter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartItemService implements ICartItemService {

  public boolean addProductToCart(Integer cusId, Integer productId) {
    return STRepoUtil.getCartItemRepo().addProductToCart(cusId, productId);
  }

  public void updateCartItem(Integer cusId, Integer productId, int quantity) {
    STRepoUtil.getCartItemRepo().updateCartItem(cusId, productId, quantity);
  }

  public void deleteCartItem(Integer cusId, Integer productId,HttpServletRequest request,
      HttpServletResponse response) {
    STRepoUtil.getCartItemRepo().deleteCartItem(cusId,productId,request,response);
  }

  public void addCartInCookieToCus(Integer cusId, HttpServletRequest request,
      HttpServletResponse response) {
    STRepoUtil.getCartItemRepo().addCartInCookieToCus(cusId, request, response);
  }

  public List<CartItemDTO> getCartItemsByCusId(Integer cusId) {
    List<CartItemEntity> cartItemEntities = STRepoUtil.getCartItemRepo().getCartItemsByCusId(cusId);
    List<CartItemDTO> cartItemDTOS = CartItemListConverter.entity2Dto(cartItemEntities);
    return cartItemDTOS;
  }

  public List<CartItemDTO> inCookieCartItems(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    List<CartItemDTO> cartItemList = new ArrayList<CartItemDTO>();
    try {
      for (Cookie cookie : cookies) {
        if (cookie.getName().contains("productId")) {
          CartItemDTO cartItem = new CartItemDTO();
          ProductDTO product = STServiceUtil.getProductService()
              .findById(Integer.parseInt(cookie.getValue()));
          cartItem.setQuantity(1);
          cartItem.setProductDTO(product);
          cartItemList.add(cartItem);
        }
      }
    } catch (NumberFormatException e) {
      throw e;
    }
    return cartItemList;
  }

  public Integer deleteCartItemGreater30Day() {
    List<CartItemEntity> listcart = STRepoUtil.getCartItemRepo().getCartGreater30Day();
    List<Integer> ids = new ArrayList<>();
    for( CartItemEntity cart : listcart) {
      ids.add(cart.getCartItemId());
    }
    return STRepoUtil.getCartItemRepo().delete(ids);
  }

  public Integer countCartItemsGreater30Day(){
    return STRepoUtil.getCartItemRepo().getCartGreater30Day().size();
  }

}
