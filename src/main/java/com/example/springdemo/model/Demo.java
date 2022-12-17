package com.example.springdemo.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "users")
public class Demo implements Serializable {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY);
  //  private Long id;
    private  String name;
    private  String phone;


}
