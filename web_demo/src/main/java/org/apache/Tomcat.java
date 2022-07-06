package org.apache;



import javax.servlet.Servlet;
import java.io.FileReader;
import java.util.Properties;
import java.util.Scanner;

// 模拟一个tomcat
public class Tomcat {
    public static void main(String[] args) throws Exception {
        System.out.println("Tomcat启动，输入地址：");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        FileReader reader = new FileReader("web_demo/src/main/resources/web.properties");
        Properties properties = new Properties();
        properties.load(reader);
        reader.close();

        String className = properties.getProperty(path);
        Class clazz = Class.forName(className);

        Object o = clazz.newInstance();
        Servlet servlet = (Servlet) o;
        servlet.service();
    }
}
