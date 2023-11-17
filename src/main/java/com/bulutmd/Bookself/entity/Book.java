package com.bulutmd.Bookself.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "bookself")
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id",nullable = false)
    private UUID id;
private String bookName;
private String bookWriter;
private int bookYear;

@CreationTimestamp
    private Date createdat;

@UpdateTimestamp
    private Date updateAt;
}
