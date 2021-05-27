package project;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import project.controller.ClickCountController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MyTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClickCountController controller;

    public MyTest() {

    }

    @Test
    public void test() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getValueTest() throws Exception {
        MvcResult res = mockMvc.perform(get("/click-counter/value"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        JSONObject json = new JSONObject(res.getResponse().getContentAsString());
        String count = json.getString("value");
        assertThat(count).matches("\\d+");
    }

    @Test
    public void updValueTest() throws Exception {
        mockMvc.perform(post("/click-counter/update"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
