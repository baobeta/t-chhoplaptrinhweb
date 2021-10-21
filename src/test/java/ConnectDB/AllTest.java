package ConnectDB;


import com.example.techshop.entity.RoleEntity;
import com.example.techshop.utils.STRepoUtil;
import org.junit.Test;

public class AllTest {

  @Test
  public void TestConnect(){
    RoleEntity entity = new RoleEntity();
    entity.setName("ADMIN");
    entity.setDescription("hihi");
    STRepoUtil.getRoleRepo().save(entity);
  }

}
