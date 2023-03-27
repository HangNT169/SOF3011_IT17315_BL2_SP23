package com.poly.hangnt169.B10_CRUDHibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hangnt169
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "category")
public class Category {

    /**
     * Java 3: JDBC => Truy van tren SQL
     * Java 4: Hibernate => Truy van tren thuc the (Entity) : HQL(Hibernate Query Language)
     * Java 5 >: JPA
     * 1. ORM (Object Relationship Mapping)
     * bigint -> Long
     * nvarchar/varchar -> String
     * bit -> Boolean
     * Class Doi tuong <=> Table
     * Cac thuoc tinh trong Class => Cac column (cot) trong Table
     * 1 column SQL => Khoa chinh, Khoa ngoai, Cot
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

}
