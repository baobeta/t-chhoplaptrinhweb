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
  public void testFindAll(){

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
    category.setName("BAN PHIM");
    category.setDescription("tao la BAN PHIM");
    STRepoUtil.getCategoryRepo().save(category);
  }

  @Test
  public void addProduct(){
    ProductEntity product = new ProductEntity();
    BrandEntity brand = STRepoUtil.getBrandRepo().findById(1);
    CategoryEntity category = STRepoUtil.getCategoryRepo().findById(3);
    product.setName("Ban phim ASUS");
    product.setDescription("tao la ban phim Asus");
    product.setPrice(1234555);
    product.setQuantity(5);
    product.setPhoto("456.jpg");
    product.setBrandEntity(brand);
    product.setCategoryEntity(category);
    STRepoUtil.getProductRepo().save(product);
  }
  @Test
  public void addProductNew() {
    ProductEntity product = new ProductEntity();
    ProductEntity product1 = new ProductEntity();
    ProductEntity product2 = new ProductEntity();
    ProductEntity product3 = new ProductEntity();
    ProductEntity product4 = new ProductEntity();
    BrandEntity brand = STRepoUtil.getBrandRepo().findById(1);
    CategoryEntity category = STRepoUtil.getCategoryRepo().findById(1);
    product.setName("Chuot ASUS 1");
    product.setDescription("tao la chuot Asus 1");
    product.setPrice(123);
    product.setQuantity(5);
    product.setPhoto("456.jpg");
    product.setBrandEntity(brand);
    product.setCategoryEntity(category);


    product1.setName("Chuot ASUS 2");
    product1.setDescription("tao la chuot Asus 1");
    product1.setPrice(123);
    product1.setQuantity(5);
    product1.setPhoto("456.jpg");
    product1.setBrandEntity(brand);
    product1.setCategoryEntity(category);

    product2.setName("Chuot ASUS 3");
    product2.setDescription("tao la chuot Asus 1");
    product2.setPrice(123);
    product2.setQuantity(5);
    product2.setPhoto("456.jpg");
    product2.setBrandEntity(brand);
    product2.setCategoryEntity(category);


    product3.setName("Chuot ASUS 4");
    product3.setDescription("tao la chuot Asus 1");
    product3.setPrice(123);
    product3.setQuantity(5);
    product3.setPhoto("456.jpg");
    product3.setBrandEntity(brand);
    product3.setCategoryEntity(category);

    product4.setName("Chuot ASUS 5");
    product4.setDescription("tao la chuot Asus 1");
    product4.setPrice(123);
    product4.setQuantity(5);
    product4.setPhoto("456.jpg");
    product4.setBrandEntity(brand);
    product4.setCategoryEntity(category);

    STRepoUtil.getProductRepo().save(product);
    STRepoUtil.getProductRepo().save(product1);
    STRepoUtil.getProductRepo().save(product2);
    STRepoUtil.getProductRepo().save(product3);
    STRepoUtil.getProductRepo().save(product4);

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
    userEntity.setEmail("alion3.com");
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

//    @Test
//  public void testPagination2(){
//    List<ProductDTO> productDTOS = STServiceUtil.getProductService().getProducts(10);
//      List<ProductDTO> list = productDTOS;
//    }

}
