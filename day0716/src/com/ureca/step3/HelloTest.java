package com.ureca.step3;

import com.ureca.step3.MessageBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/ureca/step3/applicationContext.xml");

//        MessageBean msg = (MessageBean) ctx.getBean("msgBean");
//        MessageBean msg = ctx.getBean("msgBean", MessageBean.class);
        MessageBean msg = ctx.getBean(MessageBean.class);
        msg.sayHello("레인");
    }
}
