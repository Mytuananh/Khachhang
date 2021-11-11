package com.codegym.controller;

import com.codegym.service.UserImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserImpl userImpl;

    public void init(){
        userImpl = new UserImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
        action ="";
    }
    try {
        switch (action) {
            case "create":{
                showNewForm(request,response);
                break;
            }
            case "edit":{
                showEditForm(request,response);
                break;
            }
            case "delete":{
                deleteUser(request,response);
                break;
            }
            default:
                listUser(request,response);
                break;
        }
    } catch (SQLException ex) {
        throw new ServletException(ex);
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
