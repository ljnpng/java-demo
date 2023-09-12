package me.lyou.ioc.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CustomService implements ApplicationContextAware, BeanPostProcessor , InitializingBean {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println( "postProcessBeforeInitialization "  + beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println( "postProcessAfterInitialization "  + beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    /**
     * 这个跟继承 BeanFactoryAware 接口作用一样
     */
    @Autowired
    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    public void sayHello(){
        System.out.println("hello " + beanFactory.getBean(this.getClass()));
        System.out.println("hello " + applicationContext.getBean(this.getClass()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println( "setApplicationContext" );
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println( "afterPropertiesSet" );
    }
}
