package com.example.demo.utile;

import com.example.demo.security.UserService;
import com.example.demo.security.userApp;
import com.example.demo.testBean.InitBean;
import com.example.demo.testBean.TestBean;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class preRun implements CommandLineRunner {
    private final Log logger=LogFactory.getLog(preRun.class);
    @Autowired
    UserService userService;


    @Override
    public void run(String... args) throws Exception {
       /* ApplicationContext ctx =  new AnnotationConfigApplicationContext(TestBean.class);

        TestBean testBean = ctx.getBean(TestBean.class);
        testBean.getMessageFromTestBean();
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        InitBean obj = (InitBean) context.getBean("InitBean");
        context.close();
        List<userApp> users=userService.findUserAll();
        if (users.size()<5){
            logger.info("the users collection is empty we should insert a user");

        }
*/
    }
}
