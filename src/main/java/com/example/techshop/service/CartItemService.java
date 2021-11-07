package com.example.techshop.service;

import com.example.techshop.utils.STRepoUtil;

public class CartItemService {

  public void addProductToCart(Integer cusId, Integer productId){
    STRepoUtil.getCartItemRepo().addProductToCart(cusId,productId);
  }

  public void updateCartItem(Integer cusId, Integer productId, int quantity){
    STRepoUtil.getCartItemRepo().updateCartItem(cusId,productId,quantity);
  }

  public void deleteCartItem(Integer sessionId, Integer productId){

  }

}
