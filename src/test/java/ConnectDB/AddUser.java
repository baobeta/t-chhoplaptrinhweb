package ConnectDB;

import com.example.techshop.entity.RoleEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.STRepoUtil;
import org.junit.Test;

import java.util.List;

public class AddUser {


    @Test
  public void TestInsertUserEntity() {
    RoleEntity role = STRepoUtil.getRoleRepo().findById(1);
    UserEntity userEntity = new UserEntity();
    userEntity.setEmail("Hellomaycung@gmail.com");
    userEntity.setPassword("baodeptrai");
    userEntity.setPhotos("789.jpg");
    userEntity.setFirstName("Bao");
    userEntity.setLastName("Le");
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
}
