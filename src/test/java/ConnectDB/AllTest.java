package ConnectDB;


import com.example.techshop.dto.UserDTO;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.RoleEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.STServiceUtil;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AllTest {

//  @Test
//  public void TestConnect() {
//    List<BrandEntity> brandEntityList = STRepoUtil.getBrandRepo().findAll();
//
//  }
//
//  @Test
//  public void TestGetListUserEntity() {
//    List<UserEntity> getListUser = STRepoUtil.getUserRepo().findAll();
//    for (UserEntity entity : getListUser) {
//      System.out.println(entity.toString());
//    }
//  }
//
//
//  @Test
//  public void TestUpdateUserEntity() {
//    UserEntity userUpdate = STRepoUtil.getUserRepo().findById(4);
//    userUpdate.setFirstName("Baodeptrai");
//    userUpdate.setEmail("baodeptrai@gmail.com");
//    UserEntity user = STRepoUtil.getUserRepo().update(userUpdate);
//  }
//
//  @Test
//  public void TestInsertUserEntity() {
//    RoleEntity role = STRepoUtil.getRoleRepo().findById(1);
//    UserEntity userEntity = new UserEntity();
//    userEntity.setEmail("Hellomaycung@gmail.com");
//    userEntity.setPhotos("789.jpg");
//    userEntity.setFirstName("Bao");
//    userEntity.setLastName("Le");
//    userEntity.setRoleEntity(role);
//
//
//  }
//
//  @Test
//  public void TestDeleteUserEntity() {
//    List<Integer> list = new ArrayList<>();
//    list.add(5);
//    STRepoUtil.getUserRepo().delete(list);
//
//  }
//
//  @Test
//  public void TestFindByIDDTO() {
//   UserDTO list = STServiceUtil.getUserService().findById(4);
//  }
//

}