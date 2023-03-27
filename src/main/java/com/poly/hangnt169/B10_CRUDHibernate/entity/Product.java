package com.poly.hangnt169.B10_CRUDHibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hangnt169
 */
@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // category_id : Khoa ngoai
    // Cac loai quan he : 1-1 :OneToOne, 1-N: OneToMany, N-1: ManyToOne, N-N: ManyToMany
    // Category - Product
    // 1 Category => Nhieu Product
    // 1 Product => 1 Category
//    @Column
//    private Long categoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    // name : ten cot trong bang product, referencedCoumnName : Ten cot trong bang Category
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Float price;

    @Column(name = "description")
    private String description;

}
