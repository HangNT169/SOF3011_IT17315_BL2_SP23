package com.poly.hangnt169.B3_XuLyForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author hangnt169
 */
@WebServlet(name = "XuLyFormController", value = {
        "/login", "/ket-qua"
})
public class XuLyFormController extends HttpServlet {
    // controller là tầng trung gian trao đổi giữa client (giao diện - jsp ) với server
    // thông qua phương thức HTTP.
    // Ở Java 4,5 chỉ làm việc với 2 phương thức :
    // GET : Hien thi
    // POST: Xu ly
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Truyen gia tri tu servlet sang jsp(view)
        request.setAttribute("h1", "Xin chao1");
        // chuyen trang
        request.getRequestDispatcher("/view/buoi1/fomr-login.jsp").forward(request, response);
//        response.sendRedirect("/fomr-login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy giá trị từ view(JSP)sang Controller(Servlet)
        String username = request.getParameter("uname");
        String password = request.getParameter("psw");

        // Truyền giá trị từ servlet sang JSP
        request.setAttribute("u1", username);
        request.setAttribute("u2", password);

        // chuyển trang
        request.getRequestDispatcher("/view/buoi1/ket-qua-login.jsp").forward(request, response);
    }
}
