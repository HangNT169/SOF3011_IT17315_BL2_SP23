package com.poly.hangnt169.B5_CRUDListFixCung.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hangnt169
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SinhVien {

    private String mssv;
    private String ten;
    private int tuoi;
    private String diaChi;
    private boolean gioiTinh;

}
