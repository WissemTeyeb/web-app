package com.example.demo.service;

import com.example.demo.errors.NotFoundException;
import com.example.demo.model.ToDO;
import com.example.demo.repo.DataRepo;
import com.example.demo.security.userApp;
import com.example.demo.security.userRepo;
import com.example.demo.utile.preRun;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class) //mean run tests on spring runner
public class ToDoServiceTest {
    /*  We can use the @MockBean to add mock objects to the Spring
      application context. The mock will replace any existing bean of the same type in the application context.
      If no bean of the same type is defined, a new one will be added.
      This annotation is useful in integration tests where a particular bean,
      like an external service, needs to be mocked*/
    private final Log logger = LogFactory.getLog(ToDoServiceTest.class);
    @MockBean
    DataRepo dataRepository;
    @Autowired
    ToDoService toDoService;
    @MockBean
    private userRepo uRepo;

    @Test
    public void testFetDataByID() {
        logger.info("testFetDataByID launched");
        ToDO data1 = new ToDO("1", "1", "wiss", "teyeb");
        ToDO data2 = new ToDO("1", "1", "siwar", "teyeb");
        List<ToDO> mockData = Arrays.asList(data1, data2);
        userApp mockUser = new userApp("1", "wissem", "75712600", null);
        given(uRepo.findById("1")).willReturn(java.util.Optional.of(mockUser));
        given(dataRepository.findAllByUserID("1")).willReturn(mockData);
        assertThat(toDoService.getDataById("1")).hasSize(2).contains( data2);
    }
    //spring context will be worked , so we tell to the Spring toi inject TodoService while testing
    @TestConfiguration
    static class ToDoServiceContextConfiguration {
        @Bean
        public ToDoService toDoService() {
            return new ToDoService();
        }
    }

}
