package com.example.com.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seed")
public class Seed {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "seed_id")
    private Long seedId;
    @Column(name = "seed_name",columnDefinition = "varchar(100)",nullable = false,unique = true)
    private String seedName;
    @Column(name = "quantity",columnDefinition = "int check (quantity >0)",nullable = false)
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "catalog_id", referencedColumnName = "catalog_id")
    private Category category;

}
