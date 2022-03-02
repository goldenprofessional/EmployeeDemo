package com.revature.EmployeeDemo;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import sun.net.httpserver.HttpServerImpl;

import javax.xml.ws.spi.http.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class EmployeeHttpServer {
    public static void main (String[] args) {
        try {
            HttpServer httpServer = HttpServerImpl.create(new InetSocketAddress(8080), 0);
            HttpContext hc = httpServer.createContext("/");
            hc.setHandler(new HttpHandler() {
                public void handle(HttpExchange httpExchange) throws IOException {
                    String s = "<h1>This is an Employees' Space.</h1>";
                    httpExchange.sendResponseHeaders(200, s.length());
                    OutputStream os = httpExchange.getResponseBody();
                    os.write(s.getBytes());
                    os.close();
                }
            });
            httpServer.start();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
