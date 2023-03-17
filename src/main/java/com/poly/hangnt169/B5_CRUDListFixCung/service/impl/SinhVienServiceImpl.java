package com.poly.hangnt169.B5_CRUDListFixCung.service.impl;

import com.poly.hangnt169.B5_CRUDListFixCung.entity.SinhVien;
import com.poly.hangnt169.B5_CRUDListFixCung.service.SinhVienService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hangnt169
 */
public class SinhVienServiceImpl implements SinhVienService {


    @Override
    public List<SinhVien> fakeData() {
        List<SinhVien> lists = new ArrayList<>();
        // code
        lists.add(new SinhVien("HangNT169", "Nguyễn Thuý Hằng", 10, "Hà Nội", false));
        lists.add(new SinhVien("PhongTT35", "Trần Tuấn Phong", 11, "Hà Nội1", true));
        lists.add(new SinhVien("NguyenVV4", "Vũ Văn Nguyên", 12, "Hà Nội2", true));
        lists.add(new SinhVien("KhanhPG", "Phạm Gia Khánh", 13, "Hà Nội", true));
        lists.add(new SinhVien("TienNH21", "Nguyễn Hoàng Tiến", 14, "Hà Nội3", true));
        lists.add(new SinhVien("DungNA29", "Nguyễn Anh Dũng", 15, "Hà Nội4", true));
        return lists;
    }

    @Override
    public SinhVien getOne(List<SinhVien> lists, int index) {
        return lists.get(index);
    }

    @Override
    public void removeStudent(List<SinhVien> lists, int index) {
        lists.remove(index);
    }
}
