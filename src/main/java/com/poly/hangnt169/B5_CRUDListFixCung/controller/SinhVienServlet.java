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

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAddSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = service.fakeData();
        // Truyen gia tri tu servlet => jsp
        request.setAttribute("listSinhVien",lists);
        request.getRequestDispatcher("/view/buoi5/sinhviens.jsp").forward(request,response);
    }

}
