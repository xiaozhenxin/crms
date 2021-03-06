package com.bh.crms.service;

import com.bh.crms.pojo.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServlet",urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    /**
     * 1.接受前端的传输数据
     * 2.把数据进行封装
     * 3.接受后端的书局保存到request域中
     * 4.跳转页面
     */
    private  CustomerService customerService = new CustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cname = request.getParameter("cname");
        String gender = request.getParameter("gender");
        String cellphone = request.getParameter("cellphone");
        String email = request.getParameter("email");
        Customer c = new Customer(cname,gender,cellphone,email);
           List<Customer> list = customerService.listAll(c);
        request.setAttribute("custom",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
