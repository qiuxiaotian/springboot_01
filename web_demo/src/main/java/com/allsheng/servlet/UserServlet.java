package com.allsheng.servlet;

import javax.servlet.Servlet;

public class UserServlet implements Servlet {

    @Override
    public void service() {
        System.out.println("UserServlet running...");
    }
}
