package net.cyllene.gasprice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
//@WebMvcTest(controllers = {ExampleController.class})
@AutoConfigureMockMvc
class ExperimentalControllerTest {
    @Inject
    private MockMvc mockMvc;

    @Disabled
    @Test
    public void controllerShouldWork() throws Exception {
        List<String> expectedList = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        ResultActions resultActions = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("overview"))
                .andExpect(model().attribute("tasks", is(expectedList)));

        MvcResult mvcResult = resultActions.andReturn();
        ModelAndView mv = mvcResult.getModelAndView();
        System.out.println(mv == null ? "no mv" : mv.getViewName());
    }

/*
    @Test
    public void testParameterTransfer() throws Exception {
        final String PASS_PARAM = "Some value";
        mockMvc.perform(get("/hello").param("name", PASS_PARAM))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("message", equalTo(PASS_PARAM)))
                .andExpect(content().string(containsString("Parameter provided: <span class=\"red\">" + PASS_PARAM)));
    }
*/

}
