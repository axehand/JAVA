package com.ohgiraffers.secction01.contextlistener;


import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {

    public ContextListener() {

        System.out.println("context listener 인스턴스 생성");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("context attribute added");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("context attribute removed");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("context attribute replaced");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context Init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context Destroy");
    }
}
