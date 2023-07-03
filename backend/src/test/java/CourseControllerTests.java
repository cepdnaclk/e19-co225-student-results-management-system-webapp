import com.academetrics.Controller.CourseController;
import com.academetrics.DTO.CourseDTO;
import com.academetrics.Entity.Course;
import com.academetrics.Service.CourseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(CourseController.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    @Test
    public void testAddNewCourse() throws Exception {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName("English");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/course/addNewCourse")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(courseDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Course Saved"))
                .andDo(print());
    }

    @Test
    public void testGetAllCourses() throws Exception {
        Course course1 = new Course("ENG101", "English 101", 3);
        Course course2 = new Course("MATH101", "Mathematics 101", 4);

        List<Course> courseList = Arrays.asList(course1, course2);

        when(courseService.getAllCourses()).thenReturn(courseList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/course/showAllCourses"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].code").value("ENG101"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("English 101"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].credits").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].code").value("MATH101"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Mathematics 101"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].credits").value(4))
                .andDo(print());
    }

    // Utility method to convert an object to JSON string
    private static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
