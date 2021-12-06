package ConnectDB;

import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.entity.OrderDetailEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.utils.MailUtils;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.STServiceUtil;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductTest {

  @Test
  public void testAddUserRepo() {
//    ProductEntity productEntity = new ProductEntity();
//    productEntity.setName("Bàn phím K3");
//    productEntity.setDescription("Đây là bàn phím");
//    productEntity.setPrice(25);
//    productEntity.setQuantity(7);
//    productEntity.setBrandEntity(STRepoUtil.getBrandRepo().findById(1));
//    productEntity.setCategoryEntity(STRepoUtil.getCategoryRepo().findById(1));
//    STRepoUtil.getProductRepo().save(productEntity);
  }

  @Test
  public void testEditProductRepo() {
    ProductEntity productUpdate = STRepoUtil.getProductRepo().findById(1);
    productUpdate.setName("Bàn phím linh tinh");
    STRepoUtil.getProductRepo().update(productUpdate);
  }

  @Test
  public void testDeleteProdcutRepo() {
//    List<Integer> ids = new ArrayList<>();
//    ids.add(12);
//    STRepoUtil.getProductRepo().delete(ids);
  }

  @Test
  public void testCriteria() {
    Map<String, Object> properties = new HashMap<String, Object>();
//    properties.put("brandId", 2);
    properties.put("cateId", 1);
    properties.put("sort", "price-ASC");
    properties.put("name", "laptop");
    properties.put("firstIndex",0);
    properties.put("maxResult",6);
//    List<ProductEntity> products = (List<ProductEntity>) STRepoUtil.getProductRepo().searchResult(properties)[0];
    List<ProductDTO> dtos = (List<ProductDTO>) STServiceUtil.getProductService().getProducts(properties)[0];
    System.out.println("khong biet");
  }

  @Test
  public void testPropertiesMap(){
    Map<String, Object> properties = new HashMap<String, Object>();
    properties.put("name","laptop");
    properties.put("sort","price-ASC");
    properties.put("cusId",1);

    String name = "";
    String sort ="";
    Integer cusId =0;

    if(properties.containsKey("name")){
      name = (String) properties.get("name");
    }
    if(properties.containsKey("sort")){
      sort = (String) properties.get("sort");
    }
    if(properties.containsKey("cusId")){
      cusId = (Integer) properties.get("cusId");
    }

    System.out.println(name+sort+cusId);

    System.out.println("khong biet");

  }

  @Test
  public void testGetNewProduct() {
    List<ProductEntity> products = STRepoUtil.getProductRepo().getNewProducts();
    System.out.println("khong biet");
  }
  @Test
  public void testIsSaleProduct() {
    List<ProductEntity> products = STRepoUtil.getProductRepo().getIsSaleOffProducts();
    System.out.println("khong biet");
  }

  @Test
  public void sendMail(){
    MailUtils mailUtils = new MailUtils("alion160801@gmail.com");
    mailUtils.sendMail("hihi");
  }

  @Test
  public void testOrder (){
    OrderDetailEntity orderDetail = new OrderDetailEntity();
    orderDetail.setUserEntity(STRepoUtil.getUserRepo().findById(1));
    STRepoUtil.getOrderDetailRepo().save(orderDetail);
    System.out.println(orderDetail.getOrderDetailId());
  }

  @Test
  public void testProductsCategory(){
    List<CategoryDTO> categories = STServiceUtil.getCategoryService().getAllCategory();
    Map<CategoryDTO, List<ProductDTO>> productEntityList = STServiceUtil.getCategoryService().buildProductInCate(categories);
    System.out.println("khong biet");

  }

  @Test
  public void test(){
    List<CategoryEntity> entities = STRepoUtil.getCategoryRepo().findAll();
    System.out.println("khong biet");

  }
}
