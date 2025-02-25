package com.example;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.servlet.ServletContainer;

import com.example.Database.Tabels;
import com.example.configurations.RestConfig;

public class Server {
    public static void main(String[] args) {

        //mvn exec:java -Dexec.mainClass="com.example.Server"

        Tabels.init();

        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8080);
            tomcat.getConnector();

            Context context = tomcat.addWebapp("/app", new File("src/main/webapp").getAbsolutePath());

            ServletContainer servletContainer = new ServletContainer(new RestConfig());
            tomcat.addServlet("/app", "BackendHndler", servletContainer);
            context.addServletMappingDecoded("/rest/*", "BackendHndler");

            tomcat.start();
            System.out.println("Server running at: http://localhost:8080/app");
            tomcat.getServer().await();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}