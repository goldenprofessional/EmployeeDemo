package com.revature.EmployeeDemo;

import sun.misc.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class DefaultController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getPathInfo().replaceFirst("/", "");
        InputStream fileStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (fileStream == null) {
            resp.setStatus(404);
            resp.getWriter().println("<h1>File Not Found</h1>");
        } else {
            resp.setContentType(getServletContext().getMimeType(fileName));
            IOUtils.copy(fileStream, resp.getOutputStream());
        }
    }
}