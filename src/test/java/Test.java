import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import project.controller.ClickCountController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Test {
    private MockMvc mockMvc;
    private ClickCountController controller;

    @Autowired
    public Test(MockMvc mockMvc, ClickCountController controller) {
        this.mockMvc = mockMvc;
        this.controller = controller;
    }
}
