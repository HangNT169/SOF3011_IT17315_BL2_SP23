package com.poly.hangnt169.B3_XuLyForm;
/**
 * @author hangnt169
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "XuLyFormController", value = "/login")
public class XuLyFormController extends HttpServlet {
    // controller là tầng trung gian trao đổi giữa client (giao diện - jsp ) với server
    // thông qua phương thức HTTP.
    // Ở Java 4,5 chỉ làm việc với 2 phương thức :
    // GET : Hien thi
    // POST: Xu ly
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Truyen gia tri tu servlet sang jsp(view)
        request.setAttribute("h1","Xin chao1");
        // chuyen trang
        request.getRequestDispatcher("/view/buoi1/fomr-login.jsp").forward(request,response);
//        response.sendRedirect("/fomr-login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
