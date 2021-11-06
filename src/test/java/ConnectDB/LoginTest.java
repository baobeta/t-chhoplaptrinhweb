package ConnectDB;

import com.example.techshop.dto.UserDTO;
import com.example.techshop.utils.STServiceUtil;
import org.junit.Test;

public class LoginTest {

  @Test
  public void findUserTest(){
    UserDTO dto = new UserDTO();
    dto = STServiceUtil.getUserService().findUser("1@1.1","1");
  }
}
