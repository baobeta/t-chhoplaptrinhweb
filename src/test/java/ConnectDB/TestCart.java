package ConnectDB;

import com.example.techshop.entity.ShoppingSessionEntity;
import com.example.techshop.utils.STRepoUtil;
import org.junit.Test;

public class TestCart {

  @Test
  public void testAddCartItem(){
    STRepoUtil.getCartItemRepo().addProductToCart(1,1);
  }

  @Test
  public void testUpdateCartItem(){
    STRepoUtil.getCartItemRepo().updateCart(1,1,3);
  }

  @Test
  public void testDeleteCartItem(){
    Integer sessionId = STRepoUtil.getUserRepo().findSessionById(1).getSessionId();
    STRepoUtil.getCartItemRepo().deleteCartItem(sessionId,1);

  }

}
