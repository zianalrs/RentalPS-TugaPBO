/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalps;

/**
 *
 * @author LOQ
 */
public class PS5 extends PlayStation {

    public PS5(int idPs) {
        super(idPs, "PS5");
    }

    @Override
    public int getHargaPerJam() {
        return 15000;
    }
}
