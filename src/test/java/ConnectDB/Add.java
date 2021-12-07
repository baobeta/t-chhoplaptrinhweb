package ConnectDB;

import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.entity.RoleEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.STServiceUtil;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.junit.Test;

import java.util.*;

public class Add {
  private Object item;

//  @Test
//  public void testDelCartItem(){
//    List<Integer> list = STRepoUtil.getOrderDetailRepo().getYears();
//    System.out.println("");
//
//  }
//
//  @Test
//  public void testFindOrerByYear()  {
//
//    System.out.println("");
//  }
//
//  @Test
//  public void testFindAllCategory(){
//    List<CategoryDTO> dtos =STServiceUtil.getCategoryService().getAllCategory();
//    System.out.println("");
//  }
//  @Test
//  public void addBrand(){
//    BrandEntity brand = new BrandEntity();
//    brand.setName("LENOVO");
//    brand.setDescription("sản phẩm của LENOVO");
//    STRepoUtil.getBrandRepo().save(brand);
//  }
//
//  @Test
//  public void addCate(){
//    CategoryEntity category = new CategoryEntity();
//    category.setName("CHUỘT");
//    category.setDescription("đây là MÀN HÌNH");
//    STRepoUtil.getCategoryRepo().save(category);
//  }
//
//  @Test
//  public void addProduct(){
//    ProductEntity product = new ProductEntity();
//    CategoryEntity category = STRepoUtil.getCategoryRepo().findCategoryByName("MÀN HÌNH");
//    BrandEntity brand = STRepoUtil.getBrandRepo().findBrandByName("ACER");
//    product.setName("MÀN HÌNH ACER KHÔNG CHÊ ĐƯỢC LUÔN");
//    product.setDescription("MÀN HÌNH như này không mua hơi phí ");
//    product.setPrice(50);
//    product.setQuantity(20);
//    product.setBrandEntity(brand);
//    product.setCategoryEntity(category);
//    product.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
//    STRepoUtil.getProductRepo().save(product);
//  }
//  @Test
//  public void addProductNew() {
//    ProductEntity product = new ProductEntity();
//    ProductEntity product1 = new ProductEntity();
//    ProductEntity product2 = new ProductEntity();
//    ProductEntity product3 = new ProductEntity();
//    ProductEntity product4 = new ProductEntity();
//    BrandEntity brand = STRepoUtil.getBrandRepo().findById(1);
//    CategoryEntity category = STRepoUtil.getCategoryRepo().findById(1);
//    product.setName("Chuot ASUS 1");
//    product.setDescription("tao la chuot Asus 1");
//    product.setPrice(123);
//    product.setQuantity(5);
//    product.setPhoto("456.jpg");
//    product.setBrandEntity(brand);
//    product.setCategoryEntity(category);
//
//
//    product1.setName("Chuot ASUS 2");
//    product1.setDescription("tao la chuot Asus 1");
//    product1.setPrice(123);
//    product1.setQuantity(5);
//    product1.setPhoto("456.jpg");
//    product1.setBrandEntity(brand);
//    product1.setCategoryEntity(category);
//
//    product2.setName("Chuot ASUS 3");
//    product2.setDescription("tao la chuot Asus 1");
//    product2.setPrice(123);
//    product2.setQuantity(5);
//    product2.setPhoto("456.jpg");
//    product2.setBrandEntity(brand);
//    product2.setCategoryEntity(category);
//
//
//    product3.setName("Chuot ASUS 4");
//    product3.setDescription("tao la chuot Asus 1");
//    product3.setPrice(123);
//    product3.setQuantity(5);
//    product3.setPhoto("456.jpg");
//    product3.setBrandEntity(brand);
//    product3.setCategoryEntity(category);
//
//    product4.setName("Chuot ASUS 5");
//    product4.setDescription("tao la chuot Asus 1");
//    product4.setPrice(123);
//    product4.setQuantity(5);
//    product4.setPhoto("456.jpg");
//    product4.setBrandEntity(brand);
//    product4.setCategoryEntity(category);
//
//    STRepoUtil.getProductRepo().save(product);
//    STRepoUtil.getProductRepo().save(product1);
//    STRepoUtil.getProductRepo().save(product2);
//    STRepoUtil.getProductRepo().save(product3);
//    STRepoUtil.getProductRepo().save(product4);
//
//  }
//
//  @Test
//  public void addRole(){
//    RoleEntity roleEntity = new RoleEntity();
//    roleEntity.setName("ADMIN");
//    roleEntity.setDescription("tao la ADMIN");
//    STRepoUtil.getRoleRepo().save(roleEntity);
//  }
//
//    @Test
//  public void TestInsertUserEntity() {
//    RoleEntity role = STRepoUtil.getRoleRepo().getRoleByName("ADMIN");
//    UserEntity userEntity = new UserEntity();
//    userEntity.setEmail("tong2@gmail.com");
//    userEntity.setPassword("123");
//    userEntity.setPhotos("789.jpg");
//    userEntity.setFirstName("Tòng");
//    userEntity.setLastName("Huỳnh Đức");
//    userEntity.setRoleEntity(role);
//    STRepoUtil.getUserRepo().save(userEntity);
//  }
//
//  @Test
//  public void TestInsertRoleEntity() {
//        RoleEntity roleEntity = new RoleEntity();
//        roleEntity.setName("ADMIN");
//        roleEntity.setDescription("manager website");
//          RoleEntity roleEntity1 = new RoleEntity();
//          roleEntity1.setName("USER");
//          roleEntity1.setDescription("Using website");
//          STRepoUtil.getRoleRepo().save(roleEntity);
//            STRepoUtil.getRoleRepo().save(roleEntity1);
//
//  }
//  @Test
//  public void testPagination() {
//      List<UserEntity> list = STRepoUtil.getUserRepo().pagination(2,10);
//  }
//
//  @Test
//  public void countUser() {
//      Integer count = STRepoUtil.getUserRepo().Count("userId");
//      System.out.println(count);
//    }

//    @Test
//  public void testPagination2(){
//    List<ProductDTO> productDTOS = STServiceUtil.getProductService().getProducts(10);
//      List<ProductDTO> list = productDTOS;
//    }

}
