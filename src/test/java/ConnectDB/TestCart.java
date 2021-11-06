package ConnectDB;

import com.example.techshop.entity.ShoppingSessionEntity;
import com.example.techshop.utils.STRepoUtil;
import org.junit.Test;

public class TestCart {

  @Test
  public void testShoppingCart(){

    STRepoUtil.getCartItemRepo().addProduct(1);

  }
  @Test
  public void testShoppingSession(){
    ShoppingSessionEntity newSession = new ShoppingSessionEntity();
    newSession.setUserEntity(STRepoUtil.getUserRepo().findById(1));
    newSession.setTotal(0);
    STRepoUtil.getShoppingSessionRepo().save(newSession);
  }

}
