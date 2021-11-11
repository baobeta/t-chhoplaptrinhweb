package ConnectDB;

import com.example.techshop.entity.ProductEntity;
import com.example.techshop.utils.STRepoUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductTest {

    @Test
    public void testAddUserRepo () {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName("Bàn phím K3");
        productEntity.setDescription("Đây là bàn phím");
        productEntity.setPrice(25);
        productEntity.setQuantity(7);
        productEntity.setBrandEntity(STRepoUtil.getBrandRepo().findById(1));
        productEntity.setCategoryEntity(STRepoUtil.getCategoryRepo().findById(1));
        STRepoUtil.getProductRepo().save(productEntity);
    }

    @Test
    public void testEditProductRepo () {
        ProductEntity productUpdate = STRepoUtil.getProductRepo().findById(1);
        productUpdate.setName("Bàn phím linh tinh");
        STRepoUtil.getProductRepo().update(productUpdate);
    }

    @Test
    public void testDeleteProdcutRepo() {
        List<Integer> ids = new ArrayList<>();
        ids.add(12);
        STRepoUtil.getProductRepo().delete(ids);

    }
}
