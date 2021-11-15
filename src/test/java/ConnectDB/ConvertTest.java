package ConnectDB;

import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.dto.OrderItemDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.dto.UserDTO;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.list.CartItemListConverter;
import com.example.techshop.utils.convert.list.OrderDetailListConverter;
import com.example.techshop.utils.convert.list.OrderItemListConverter;
import com.example.techshop.utils.convert.list.ProductListConverter;
import com.example.techshop.utils.convert.list.UserListConverter;
import java.util.List;
import org.junit.Test;

public class ConvertTest {



  @Test
  public void TestConvertEntity(){
//
//    BrandDTO brandDTO = BrandConverter.entity2Dto(STRepoUtil.getBrandRepo().findById(1));
//    CartItemDTO cartItemDTO = CartItemConverter.entity2Dto(STRepoUtil.getCartItemRepo().findById(1));
//    CategoryDTO categoryDTO = CategoryConverter.entity2Dto(STRepoUtil.getCategoryRepo().findById(1));
//    CustomerDTO customerDTO = CustomerConverter.entity2Dto(STRepoUtil.getCustomerRepo().findById(1));
//    OrderDetailDTO orderDetailDTO = OrderDetailConverter.entity2Dto(STRepoUtil.getOrderDetailRepo()
//        .findById(4));
//    OrderItemDTO orderItemDTO = OrderItemConverter.entity2Dto(STRepoUtil.getOrderItemRepo()
//        .findById(4));
//    ProductDTO productDTO = ProductConverter.entity2Dto(STRepoUtil.getProductRepo().findById(1));
//    RoleDTO roleDTO = RoleConverter.entity2Dto(STRepoUtil.getRoleRepo().findById(2));
//    ShoppingSessionDTO shoppingSessionDTO = ShoppingSessionConverter.entity2Dto(STRepoUtil.getShoppingSessionRepo()
//        .findById(1));
//    UserDTO userDTO = UserConverter.entity2Dto(STRepoUtil.getUserRepo().findById(4));
//
//    System.out.println("done!!!");


//    BrandEntity brandEntity =new BrandEntity();
//    CartItemEntity cartItemEntity =new CartItemEntity();
//    CategoryEntity categoryEntity =new CategoryEntity();
//    CustomerEntity customerEntity =new CustomerEntity();
//    OrderDetailEntity orderDetailEntity =new OrderDetailEntity();
//    OrderItemEntity orderItemEntity =new OrderItemEntity();
//    ProductEntity productEntity =new ProductEntity();
//    RoleEntity roleEntity =new RoleEntity();
//    ShoppingSessionEntity shoppingSessionEntity =new ShoppingSessionEntity();
//    UserEntity userEntity =new UserEntity();

  }
  @Test
  public void TestConvertList(){
//    List<CartItemDTO> cartItemDTOS = CartItemListConverter.entity2Dto(STRepoUtil.getCartItemRepo()
//        .findAll());
    List<ProductDTO> productDTOS = ProductListConverter.entity2Dto(STRepoUtil.getProductRepo()
        .findAll());
//    List<OrderDetailDTO> orderDetailDTOS = OrderDetailListConverter.entity2Dto(STRepoUtil.getOrderDetailRepo()
//        .findAll());
//
//    List<OrderItemDTO> orderItemDTOS = OrderItemListConverter.entity2Dto(STRepoUtil.getOrderItemRepo()
//        .findAll());
//
//    List<UserDTO> userDTOS = UserListConverter.entity2Dto(STRepoUtil.getUserRepo().findAll());

    System.out.println("done!!!");
  }

  @Test
  public void TestConvertList2(){
    List<ProductDTO> productDTOS = ProductListConverter.entity2Dto(STRepoUtil.getProductRepo()
        .findAll());

    System.out.println("done!!!");
  }
}
