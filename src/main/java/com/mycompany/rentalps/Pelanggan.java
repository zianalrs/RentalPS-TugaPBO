/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalps;

/**
 *
 * @author LOQ
 */
public class Pelanggan {
    private int idPelanggan;
    private String nama;
    private String noHp;

    public Pelanggan(int idPelanggan, String nama, String noHp) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.noHp = noHp;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void tampilkanData() {
        System.out.println(idPelanggan + " | " + nama + " | " + noHp);
    }
}