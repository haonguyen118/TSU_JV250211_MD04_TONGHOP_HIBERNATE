package com.example.com.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_name",columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String userName;
    @Column(name = "password", columnDefinition = "varchar(15)", nullable = false)
    private String password;

}
