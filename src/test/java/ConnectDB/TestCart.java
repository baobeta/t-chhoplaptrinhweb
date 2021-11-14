package ConnectDB;

import com.example.techshop.command.CategoryCommand;
import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.entity.RoleEntity;
import com.example.techshop.entity.ShoppingSessionEntity;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.STServiceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class TestCart {

  @Test
  public void testAddCartItem(){
    STRepoUtil.getCartItemRepo().addProductToCart(2,1);
  }

  @Test
  public void testUpdateCartItem(){
    STRepoUtil.getCartItemRepo().updateCartItem(2,1,2);
  }

  @Test
  public void testDeleteCartItem(){
    STRepoUtil.getCartItemRepo().deleteCartItem(1,1);
  }

  @Test
  public void testCart(){
    List<CartItemDTO> cartItemDTOS = STServiceUtil.getCartItemService().getCartItemsByCusId(1);
    if (cartItemDTOS != null){
      System.out.println("duoc roi ne");
    }
  }

  @Test
  public void getRole(){
    RoleEntity roleEntity = STRepoUtil.getRoleRepo().getRoleByName("USER");
    System.out.println("duoc roi ne");
  }

  @Test
  public void testGetBrandByCate(){
//    CategoryCommand command = new CategoryCommand();
//    command.
//    List<BrandEntity> brandEntities = STRepoUtil.getCategoryRepo().getBrandInCate(1);
//    System.out.println("duoc roi ne");
  }

  @Test
  public void testPagination(){
    Map<String, Object> properties = new HashMap<String,Object>();
    List<ProductDTO> productDTOS = STServiceUtil.getProductService().getProducts(properties);
    System.out.println("duoc roi ne");

  }

}
