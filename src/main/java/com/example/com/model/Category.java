package com.example.com.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table( name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private Long id;
    @Column(name = "catalog_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String catalogName;
    @Column(name = "description", columnDefinition = "text", nullable = false)
    private String description;
    @Column(name = "status",columnDefinition = "bit default(1)")
    private boolean status;
    @OneToMany(mappedBy = "category")
    private List<Seed> listProduct = new ArrayList<>();
}
