package com.ilacstok.eczane.Domain;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "ilacstok")
public class StokDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String Tur;
    private String Ad;
    private String Kamaci;
    private Integer Doz;
    private Integer Adet;
    private String Firma;
}
