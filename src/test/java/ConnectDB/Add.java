package ConnectDB;

import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.entity.RoleEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.STServiceUtil;
import org.junit.Test;

import java.util.List;

public class Add {
  @Test
  public void testDelCartItem(){

  }


  @Test
  public void addBrand(){
    BrandEntity brand = new BrandEntity();
    brand.setName("ASUS");
    brand.setDescription("tao la ASUS");
    STRepoUtil.getBrandRepo().save(brand);
  }

  @Test
  public void addCate(){
    CategoryEntity category = new CategoryEntity();
    category.setName("CHUOT");
    category.setDescription("tao la CHUOT");
    STRepoUtil.getCategoryRepo().save(category);
  }

  @Test
  public void addProduct(){
    ProductEntity product = new ProductEntity();
    BrandEntity brand = STRepoUtil.getBrandRepo().findById(1);
    CategoryEntity category = STRepoUtil.getCategoryRepo().findById(2);
    product.setName("Chuot ASUS");
    product.setDescription("tao la chuot Asus");
    product.setPrice(123);
    product.setQuantity(5);
    product.setPhoto("456.jpg");
    product.setBrandEntity(brand);
    product.setCategoryEntity(category);
    STRepoUtil.getProductRepo().save(product);
  }

  @Test
  public void addRole(){
    RoleEntity roleEntity = new RoleEntity();
    roleEntity.setName("CUSTOMER");
    roleEntity.setDescription("tao la CUSTOMER");
    STRepoUtil.getRoleRepo().save(roleEntity);
  }

    @Test
  public void TestInsertUserEntity() {
    RoleEntity role = STRepoUtil.getRoleRepo().findById(1);
    UserEntity userEntity = new UserEntity();
    userEntity.setEmail("alion1.com");
    userEntity.setPassword("tong");
    userEntity.setPhotos("789.jpg");
    userEntity.setFirstName("Tong");
    userEntity.setLastName("Huynh Duc");
    userEntity.setRoleEntity(role);
    STRepoUtil.getUserRepo().save(userEntity);
  }

  @Test
  public void TestInsertRoleEntity() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("ADMIN");
        roleEntity.setDescription("manager website");
          RoleEntity roleEntity1 = new RoleEntity();
          roleEntity1.setName("USER");
          roleEntity1.setDescription("Using website");
          STRepoUtil.getRoleRepo().save(roleEntity);
            STRepoUtil.getRoleRepo().save(roleEntity1);

  }
  @Test
  public void testPagination() {
      List<UserEntity> list = STRepoUtil.getUserRepo().pagination(2,10);
  }

  @Test
  public void countUser() {
      Integer count = STRepoUtil.getUserRepo().Count("userId");
      System.out.println(count);
    }

    @Test
  public void testPagination2(){
    List<ProductDTO> productDTOS = STServiceUtil.getProductService().getProducts(10);
      List<ProductDTO> list = productDTOS;
    }

}
