package com.example.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author TuanNA
 * @Date 05/06/2022 11:45 PM
 * @Version 1.0
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_inventory")
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skuCode;
    private Integer quantity;
}
