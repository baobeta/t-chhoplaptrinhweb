package ConnectDB;

import com.example.techshop.entity.ShoppingSessionEntity;
import com.example.techshop.utils.STRepoUtil;
import org.junit.Test;

public class TestCart {

  @Test
  public void testAddCartItem(){
    STRepoUtil.getCartItemRepo().addProductToCart(2,1);
  }

  @Test
  public void testUpdateCartItem(){
    STRepoUtil.getCartItemRepo().updateCartItem(1,1,6);
  }

  @Test
  public void testDeleteCartItem(){
    STRepoUtil.getCartItemRepo().deleteCartItem(1,1);
  }

}
