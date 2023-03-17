package com.poly.hangnt169.B5_CRUDListFixCung.controller;

import com.poly.hangnt169.B5_CRUDListFixCung.entity.SinhVien;
import com.poly.hangnt169.B5_CRUDListFixCung.service.SinhVienService;
import com.poly.hangnt169.B5_CRUDListFixCung.service.impl.SinhVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hangnt169
 */
@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",  // GET
        "/sinh-vien/search",   // GET
        "/sinh-vien/remove",   // GET
        "/sinh-vien/detail",   // GET
        "/sinh-vien/view-add",  //GET
        "/sinh-vien/add",       // POST
        "/sinh-vien/view-update",  // GET
        "/sinh-vien/update",      // POST
})
public class SinhVienServlet extends HttpServlet {

    private List<SinhVien> lists = new ArrayList<>();
    private SinhVienService service = new SinhVienServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay ra duong dan tren trinh duyet
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // hien thi du lieu
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("search")) {
            // search du lieu
            this.searchSinhVien(request, response);
        } else if (uri.contains("remove")) {
            // Remove du lieu
            this.removeSinhVien(request, response);
        } else if (uri.contains("detail")) {
            // detail du lieu
            this.detailSinhVien(request, response);
        } else if (uri.contains("view-add")) {
            // hien thi form add
            this.viewAddSinhVien(request, response);
        } else if (uri.contains("view-update")) {
            // hien thi form update
            this.viewUpdateSinhVien(request, response);
        } else {
            // neu khong vao cac case tren thi quay lai trang hien thi
            this.hienThiSinhVien(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI(); // Lay duoc gia tri o tren duong dan
        if (uri.contains("add")) {
            // hien thi du lieu
            this.addSinhVien(request, response);
        } else if (uri.contains("update")) {
            // search du lieu
            this.updateSinhVien(request, response);
        } else {
            // neu khong vao cac case tren thi quay lai trang hien thi
            this.hienThiSinhVien(request, response);
        }
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //B1: Lay toan bo gia tri tu form
        String ma = request.getParameter("mssv");
        String ten = request.getParameter("ten");
        String tuoiStr = request.getParameter("tuoi");
        String diaChiStr = request.getParameter("diaChi");
        String gioiTinhStr = request.getParameter("gioiTinh");

        // B2: Khoi tao 1 doi tuong
        SinhVien sv = new SinhVien(ma,ten,Integer.valueOf(tuoiStr),diaChiStr,Boolean.valueOf(gioiTinhStr));

        // B3: Add vao list
        lists.add(sv);

        // B4: Chuyen trang
        request.setAttribute("listSinhVien", lists);
        request.getRequestDispatcher("/view/buoi5/sinhviens.jsp").forward(request, response);
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay gia tu jsp ve servlet
        String viTri = request.getParameter("id");
        // Lay ra sv theo vi tri
        SinhVien sv = service.getOne(lists,Integer.parseInt(viTri));
        request.setAttribute("sv1",sv);
        request.getRequestDispatcher("/view/buoi5/update-sinh-vien.jsp").forward(request,response);
    }

    private void viewAddSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/buoi5/add-sinh-vien.jsp").forward(request, response);
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay gia tu jsp ve servlet
        String viTri = request.getParameter("id1");
        // Lay ra sv theo vi tri
        SinhVien sv = service.getOne(lists,Integer.parseInt(viTri));
        request.setAttribute("sv1",sv);
        request.getRequestDispatcher("/view/buoi5/detail-sinh-vien.jsp").forward(request,response);
    }

    private void removeSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Lay gia tu jsp ve servlet
        String viTri = request.getParameter("id");
        service.removeStudent(lists,Integer.valueOf(viTri));
        // chuyen lai trang hien thi
        // C1: Copy code lai ham hien thi
//        if(lists.isEmpty()){
//            lists = service.fakeData();
//        }
//        // Truyen gia tri tu servlet => jsp
//        request.setAttribute("listSinhVien", lists);
//        request.getRequestDispatcher("/view/buoi5/sinhviens.jsp").forward(request, response);
        // C2: chuyen sang trang hien thi
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(lists.isEmpty()){
            lists = service.fakeData();
        }
        // Truyen gia tri tu servlet => jsp
        request.setAttribute("listSinhVien", lists);
        request.getRequestDispatcher("/view/buoi5/sinhviens.jsp").forward(request, response);
    }

}
