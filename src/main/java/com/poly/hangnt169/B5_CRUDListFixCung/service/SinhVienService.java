package com.poly.hangnt169.B5_CRUDListFixCung.service;

import com.poly.hangnt169.B5_CRUDListFixCung.entity.SinhVien;

import java.util.List;

/**
 * @author hangnt169
 */
public interface SinhVienService {

    List<SinhVien>fakeData();

    SinhVien getOne(List<SinhVien>lists,int index);

    void removeStudent(List<SinhVien>lists,int index);

}
