package ConnectDB;

import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.dto.OrderItemDTO;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.entity.OrderItemEntity;
import com.example.techshop.entity.RoleEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.STServiceUtil;
import com.example.techshop.utils.convert.list.CategoryListConverter;
import com.example.techshop.utils.convert.list.OrderItemListConverter;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.junit.Test;

public class TestCart {

//  @Test
//  public void testAddCartItem(){
//    STRepoUtil.getCartItemRepo().addProductToCart(2,1);
//  }
//
//  @Test
//  public void testUpdateCartItem(){
//    STRepoUtil.getCartItemRepo().updateCartItem(2,1,2);
//  }
//
//  @Test
//  public void testCart(){
//    List<CartItemDTO> cartItemDTOS = STServiceUtil.getCartItemService().getCartItemsByCusId(1);
//    if (cartItemDTOS != null){
//      System.out.println("duoc roi ne");
//    }
//  }
//
//  @Test
//  public void getRole(){
//    RoleEntity roleEntity = STRepoUtil.getRoleRepo().getRoleByName("USER");
//    System.out.println("duoc roi ne");
//  }
//
//  @Test
//  public void testOrderDetail(){
//    List<OrderItemEntity> orderItems = STRepoUtil.getOrderItemRepo().getOrderItemsByOrderId(1);
//    List<OrderItemDTO> orderItemDTOS = OrderItemListConverter.entity2Dto(orderItems);
//    System.out.println("duoc roi ne");
//  }
//
//  @Test
//  public void testFormatNumber(){
//    System.out.println(currency(10000));
//  }
//  public String currency(Integer currencyAmount) {
//    Locale locale = new Locale("vi","VN");
//    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
//    numberFormat.setMaximumFractionDigits(0);
//    return numberFormat.format(currencyAmount);
//  }
//
//  @Test
//  public void testIncome(){
//    List<CategoryEntity> categoryEntities = STRepoUtil.getCategoryRepo().findAll();
//    System.out.println("duoc roi ne");
//  }
//
//  @Test
//  public void sortMap(){
//    List<CategoryEntity> entities = STRepoUtil.getCategoryRepo().findAll();
//    List<CategoryDTO> dtos = CategoryListConverter.entity2Dto(entities);
//    Map<CategoryDTO, List<BrandDTO>> map = STServiceUtil.getCategoryService().buildBrandInCate(dtos);
//    System.out.println("duoc roi ne");
//  }
}
