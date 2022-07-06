package com.allsheng.servlet;

import javax.servlet.Servlet;

public class BankServlet implements Servlet {

    @Override
    public void service() {
        System.out.println("BankServlet running...");
    }
}
