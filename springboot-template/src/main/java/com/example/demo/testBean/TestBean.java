package com.example.demo.testBean;

import com.example.demo.utile.preRun;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class TestBean {
    private final Log logger= LogFactory.getLog(TestBean.class);

    public void  getMessageFromTestBean(){

        logger.info("message from TestBean");
    }
}
