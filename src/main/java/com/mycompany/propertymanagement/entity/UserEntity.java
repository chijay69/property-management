package com.mycompany.propertymanagement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "USER_TABLE")
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "USER_FULLNAME", nullable = false, length = 55)
    private String fullname;
    @Column(name = "USER_PHONE")
    private Long phone;
    @Column(name = "USER_EMAIL", nullable = false)
    private String email;
    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;
}
