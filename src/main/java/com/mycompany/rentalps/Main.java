/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rentalps;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author LOQ
 */
public class Main {

    static Scanner input = new Scanner(System.in);

    static ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    static ArrayList<PlayStation> daftarPS = new ArrayList<>();
    static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    public static void main(String[] args) {

        // Data awal PlayStation
        daftarPS.add(new PS4(1));
        daftarPS.add(new PS4(2));
        daftarPS.add(new PS5(3));

        int pilihan;

        do {
            System.out.println("================================");
            System.out.println("   SELAMAT DATANG DI RENTAL PS  ");
            System.out.println("================================");
            System.out.println("1. Lihat PlayStation");
            System.out.println("2. Booking PS");
            System.out.println("3. Lihat Transaksi");
            System.out.println("4. Kelola PlayStation");
            System.out.println("0. Keluar");
            System.out.println("================================");
            System.out.print("Pilih >> ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    lihatPS();
                    break;

                case 2:
                    bookingPS();
                    break;

                case 3:
                    lihatTransaksi();
                    break;

                case 4:
                    menuPlayStation();
                    break;

                case 0:
                    System.out.println("\nTerima kasih telah menggunakan Rental PS.");
                    break;

                default:
                    System.out.println("\nPilihan tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    // ==============================
    // CEK ID PLAYSTATION
    // ==============================
    static boolean cekIdPS(int id) {

        for (PlayStation ps : daftarPS) {
            if (ps.getIdPs() == id) {
                return true;
            }
        }

        return false;
    }

    // ==============================
    // CEK ID PELANGGAN
    // ==============================
    static boolean cekIdPelanggan(int id) {

        for (Pelanggan pelanggan : daftarPelanggan) {
            if (pelanggan.getIdPelanggan() == id) {
                return true;
            }
        }

        return false;
    }

    // ==============================
    // CEK ID TRANSAKSI
    // ==============================
    static boolean cekIdTransaksi(int id) {

        for (Transaksi transaksi : daftarTransaksi) {
            if (transaksi.getIdTransaksi() == id) {
                return true;
            }
        }

        return false;
    }

    // ==============================
    // LIHAT PLAYSTATION
    // ==============================
    static void lihatPS() {

        System.out.println("\n================================");
        System.out.println("        DAFTAR PLAYSTATION      ");
        System.out.println("================================");

        if (daftarPS.isEmpty()) {
            System.out.println("Belum ada data PlayStation.");
            return;
        }

        for (PlayStation ps : daftarPS) {
            ps.tampilkanData();
            System.out.println("--------------------------------");
        }
    }

    // ==============================
    // MENU KELOLA PLAYSTATION
    // ==============================
    static void menuPlayStation() {

        int pilihan;

        do {
            System.out.println("\n================================");
            System.out.println("        KELOLA PLAYSTATION      ");
            System.out.println("================================");
            System.out.println("1. Tambah PS");
            System.out.println("2. Lihat PS");
            System.out.println("3. Ubah Status PS");
            System.out.println("4. Hapus PS");
            System.out.println("0. Kembali");
            System.out.println("================================");
            System.out.print("Pilih >> ");
            pilihan = input.nextInt();

            switch (pilihan) {

                case 1:
                    tambahPS();
                    break;

                case 2:
                    lihatPS();
                    break;

                case 3:
                    ubahPS();
                    break;

                case 4:
                    hapusPS();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nPilihan tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    // ==============================
    // TAMBAH PLAYSTATION
    // ==============================
    static void tambahPS() {

        System.out.println("\n================================");
        System.out.println("        TAMBAH PLAYSTATION      ");
        System.out.println("================================");

        int id;

        while (true) {

            System.out.print("Masukkan ID PS >> ");
            id = input.nextInt();

            if (cekIdPS(id)) {
                System.out.println("ID PS sudah digunakan.");
                System.out.println("Silakan masukkan ID lain.");
            } else {
                break;
            }
        }

        System.out.println("\n1. PS4");
        System.out.println("2. PS5");
        System.out.print("Pilih jenis PS >> ");
        int pilihanJenis = input.nextInt();

        if (pilihanJenis == 1) {

            daftarPS.add(new PS4(id));
            System.out.println("PS4 berhasil ditambahkan.");

        } else if (pilihanJenis == 2) {

            daftarPS.add(new PS5(id));
            System.out.println("PS5 berhasil ditambahkan.");

        } else {

            System.out.println("Jenis PS tidak tersedia.");
        }
    }

    // ==============================
    // UBAH STATUS PLAYSTATION
    // ==============================
    static void ubahPS() {

        System.out.println("\n================================");
        System.out.println("     UBAH STATUS PLAYSTATION    ");
        System.out.println("================================");

        System.out.print("Masukkan ID PS >> ");
        int id = input.nextInt();

        for (PlayStation ps : daftarPS) {

            if (ps.getIdPs() == id) {

                System.out.println("\nJenis PS : " + ps.getJenisPs());
                System.out.println("Status   : " + ps.getStatus());

                System.out.println("\n1. Tersedia");
                System.out.println("2. Disewa");
                System.out.print("Pilih status >> ");
                int pilihan = input.nextInt();

                if (pilihan == 1) {

                    ps.setStatus("Tersedia");
                    System.out.println("Status berhasil diubah.");

                } else if (pilihan == 2) {

                    ps.setStatus("Disewa");
                    System.out.println("Status berhasil diubah.");

                } else {

                    System.out.println("Pilihan tidak tersedia.");
                }

                return;
            }
        }

        System.out.println("ID PS tidak ditemukan.");
    }

    // ==============================
    // HAPUS PLAYSTATION
    // ==============================
    static void hapusPS() {

        System.out.println("\n================================");
        System.out.println("        HAPUS PLAYSTATION       ");
        System.out.println("================================");

        System.out.print("Masukkan ID PS >> ");
        int id = input.nextInt();

        for (PlayStation ps : daftarPS) {

            if (ps.getIdPs() == id) {

                if (ps.getStatus().equalsIgnoreCase("Disewa")) {

                    System.out.println("PS sedang disewa.");
                    System.out.println("PS tidak dapat dihapus.");
                    return;
                }

                daftarPS.remove(ps);

                System.out.println("PS berhasil dihapus.");
                return;
            }
        }

        System.out.println("ID PS tidak ditemukan.");
    }

    // ==============================
    // BOOKING PLAYSTATION
    // ==============================
    static void bookingPS() {

        System.out.println("\n================================");
        System.out.println("       BOOKING PLAYSTATION      ");
        System.out.println("================================");

        lihatPS();

        System.out.print("\nMasukkan ID PS >> ");
        int idPs = input.nextInt();

        PlayStation psDipilih = null;

        for (PlayStation ps : daftarPS) {

            if (ps.getIdPs() == idPs) {
                psDipilih = ps;
                break;
            }
        }

        if (psDipilih == null) {

            System.out.println("ID PS tidak ditemukan.");
            return;
        }

        if (psDipilih.getStatus().equalsIgnoreCase("Disewa")) {

            System.out.println("PS sedang disewa.");
            return;
        }

        // ID Pelanggan
        int idPelanggan;

        while (true) {

            System.out.print("Masukkan ID Pelanggan >> ");
            idPelanggan = input.nextInt();

            if (cekIdPelanggan(idPelanggan)) {

                System.out.println("ID Pelanggan sudah digunakan.");
                System.out.println("Silakan masukkan ID lain.");

            } else {

                break;
            }
        }

        input.nextLine();

        System.out.print("Masukkan nama pelanggan >> ");
        String nama = input.nextLine();

        System.out.print("Masukkan nomor HP >> ");
        String noHp = input.nextLine();

        // ID Transaksi
        int idTransaksi;

        while (true) {

            System.out.print("Masukkan ID Transaksi >> ");
            idTransaksi = input.nextInt();

            if (cekIdTransaksi(idTransaksi)) {

                System.out.println("ID Transaksi sudah digunakan.");
                System.out.println("Silakan masukkan ID lain.");

            } else {

                break;
            }
        }

        System.out.print("Masukkan durasi sewa (jam) >> ");
        int durasi = input.nextInt();

        // Mengambil harga dari subclass PS4 atau PS5
        int hargaPerJam = psDipilih.getHargaPerJam();

        int totalBayar = durasi * hargaPerJam;

        Pelanggan pelanggan = new Pelanggan(
                idPelanggan,
                nama,
                noHp
        );

        Transaksi transaksi = new Transaksi(
                idTransaksi,
                nama,
                psDipilih.getJenisPs(),
                durasi,
                totalBayar
        );

        daftarPelanggan.add(pelanggan);
        daftarTransaksi.add(transaksi);

        psDipilih.setStatus("Disewa");

        System.out.println("\n================================");
        System.out.println("         BOOKING BERHASIL       ");
        System.out.println("================================");
        System.out.println("ID Transaksi : " + idTransaksi);
        System.out.println("Nama         : " + nama);
        System.out.println("Jenis PS     : " + psDipilih.getJenisPs());
        System.out.println("Durasi       : " + durasi + " jam");
        System.out.println("Harga/Jam    : Rp" + hargaPerJam);
        System.out.println("Total Bayar  : Rp" + totalBayar);
    }

    // ==============================
    // LIHAT TRANSAKSI
    // ==============================
    static void lihatTransaksi() {

        System.out.println("\n================================");
        System.out.println("         DAFTAR TRANSAKSI       ");
        System.out.println("================================");

        if (daftarTransaksi.isEmpty()) {

            System.out.println("Belum ada transaksi.");
            return;
        }

        for (Transaksi transaksi : daftarTransaksi) {

            transaksi.tampilkanData();
            System.out.println("--------------------------------");
        }
    }
}
