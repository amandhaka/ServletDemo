package com.example.servletDemo;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    public HelloServlet(){
        System.out.println("HelloServlet Class object created");
    }
    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("Inside doPost");
        PrintWriter pw;
        response.setContentType("text/html");
        pw=response.getWriter();
        String name=request.getParameter("name");
        int internId=Integer.parseInt(request.getParameter("internId"));
        int teamId=Integer.parseInt(request.getParameter("teamId"));
        System.out.println("Taken parameters");
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/training", "amandhaka","");
            Statement statement=connection.createStatement();
            String query="insert into interns(internId,internName,teamId) values(" + internId +",'"+name+"',"+teamId+");";
            int rowsImpacted=statement.executeUpdate(query);


            System.out.println("Rows Impacted : "+rowsImpacted);

        } catch(Exception e) {
            System.out.println("Error "+e);
        }
        pw.close();
        System.out.println("Details Entered Successfully");
    }
    public void destroy() {
    }
}