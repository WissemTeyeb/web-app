package com.example.demo.TestSetup;

import com.example.demo.controllers.BasePathController;
import com.example.demo.model.ToDO;
import com.example.demo.repo.DataRepo;
import com.example.demo.security.SignInRequest;
import com.example.demo.security.UserService;
import com.example.demo.security.userApp;
import com.example.demo.service.ToDoService;
import com.example.demo.utile.preRun;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//The @SpringBootTest annotation tells Spring Boot
// to look for a main configuration class (one with @SpringBootApplication, for instance)
// and use that to start a Spring application context
//@RunWith(SpringRunner.class) //mean run tests on spring runner

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//(we need the spring boot to run because we need to do http request)

//@AutoConfigureMockMvc //(MockMvc make us able to simulate hhtp request)
//Another useful approach is to not start the server at all but to test only
// the layer below that, where Spring handles the incoming HTTP request
// and hands it off to your controller. That way, almost of the full stack is used,
// and your code will be called in exactly the same way as if it were processing
// a real HTTP request but without the cost of starting the server. To do that,
// use Spring’s MockMvc and ask for that
// to be injected for you by using the @AutoConfigureMockMvc annotation on the test
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public abstract class AbstractControllerSetupTest {

    private String USERNAME_TEST = "wissem";
    private String PASSWORD_TEST = "75712600";
    private String HEADER = "AUTHORIZATION";
    @MockBean
    private UserService userService;

    @Autowired
    public MockMvc mockMvc;
    private final Log logger = LogFactory.getLog(AbstractControllerSetupTest.class);

    @Autowired
    private PasswordEncoder passwordEncoder;
    @MockBean
    ToDoService toDoService;
    @Before
    public void setup() {
        ToDO data1 = new ToDO("1", "1", "wiss", "teyeb");
        ToDO data2 = new ToDO("1", "1", "siwar", "teyeb");
        List<ToDO> mockData = Arrays.asList(data1, data2);
        userApp mockUser = new userApp("1", USERNAME_TEST, passwordEncoder.encode(PASSWORD_TEST), null);
        given(userService.loadUserByUsername(USERNAME_TEST)).willReturn(mockUser);
        given(toDoService.getDataById("1")).willReturn(mockData);


    }

    private ResultActions login() throws Exception {
        SignInRequest signInRequest = new SignInRequest(USERNAME_TEST, PASSWORD_TEST);
        return this.mockMvc.perform(post("/url/api/auth/signin").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(signInRequest)));
    }

    private String getheader() {
        try {
            MvcResult result = login().andReturn();
            String header = result.getResponse().getContentAsString();
            return header;
        } catch (Exception e) {
            return null;
        }
    }

    public MockHttpServletRequestBuilder doGet(String url) {
        return get(url).header(HEADER, getheader());

    }

    public MockHttpServletRequestBuilder doPost(String url) {
        return post(url).header(HEADER, getheader());

    }
}
