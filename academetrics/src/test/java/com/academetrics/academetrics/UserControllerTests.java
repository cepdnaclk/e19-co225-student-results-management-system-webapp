//import com.academetrics.academetrics.DTO.UserDTO;
//import com.academetrics.academetrics.DTO.UserRegistrationDTO;
//import com.academetrics.academetrics.Entity.User;
//import com.academetrics.academetrics.Service.UserService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//@WebMvcTest(UserController.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserControllerTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private UserService userService;
//
//    @InjectMocks
//    private UserController userController;
//
//    @Test
//    public void testGetAllUsers() throws Exception {
//        User user1 = new User();
//        user1.setId(1);
//        user1.setUserName("john");
//        user1.setMail("john@example.com");
//
//        User user2 = new User();
//        user2.setId(2);
//        user2.setUserName("jane");
//        user2.setMail("jane@example.com");
//
//        List<User> userList = Arrays.asList(user1, user2);
//
//        when(userService.getAllUsers()).thenReturn(userList);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/user/"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userName").value("john"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mail").value("john@example.com"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].userName").value("jane"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].mail").value("jane@example.com"))
//                .andDo(print());
//    }
//
//    @Test
//    public void testSaveUser() throws Exception {
//        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
//        userRegistrationDTO.setUserName("john");
//        userRegistrationDTO.setMail("john@example.com");
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/user/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(userRegistrationDTO)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Saved"))
//                .andDo(print());
//    }
//
//    // Utility method to convert an object to JSON string
//    private static String asJsonString(Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
//
//
