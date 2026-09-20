/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalps;

/**
 *
 * @author LOQ
 */
public class PlayStation {

    private int idPs;
    private String jenisPs;
    private String status;

    public PlayStation(int idPs, String jenisPs) {
        this.idPs = idPs;
        this.jenisPs = jenisPs;
        this.status = "Tersedia";
    }

    public int getIdPs() {
        return idPs;
    }

    public String getJenisPs() {
        return jenisPs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHargaPerJam() {
        return 10000;
    }

    public void tampilkanData() {
        System.out.println("ID PS       : " + idPs);
        System.out.println("Jenis PS    : " + jenisPs);
        System.out.println("Status      : " + status);
        System.out.println("Harga/Jam   : Rp" + getHargaPerJam());
    }
}
