# Sistem Manajemen Rental PS

**Nama:** Zian Alrais

**NIM:** 2509116064

---

## Studi Kasus

Program ini adalah aplikasi berbasis konsol (Java) untuk mengelola usaha rental PlayStation. Pengguna dapat melihat daftar PlayStation beserta statusnya, melakukan booking berdasarkan durasi sewa, melihat riwayat transaksi, serta mengelola data PlayStation (tambah, ubah status, dan hapus). Harga sewa dihitung otomatis sesuai jenis PlayStation: PS4 Rp10.000 per jam dan PS5 Rp15.000 per jam.

---

## Diagram Kelas

<img width="1773" height="1762" alt="diagram-kelas" src="https://github.com/user-attachments/assets/66ddb503-8952-4cb1-a15a-55543a7c19f2" />


**Hierarki class:** `PS4` dan `PS5` merupakan subclass dari `PlayStation`. Keduanya mewarisi atribut (`idPs`, `jenisPs`, `status`) dan method (`getIdPs()`, `getStatus()`, `setStatus()`, `tampilkanData()`) dari superclass, lalu menyesuaikan harga sewa masing-masing dengan meng-override `getHargaPerJam()`.

---

## Penerapan Inheritance

### 1. Superclass `PlayStation`

Berisi atribut dan method umum yang dimiliki semua jenis PlayStation.

```java
public class PlayStation {
    private int idPs;
    private String jenisPs;
    private String status;

    public PlayStation(int idPs, String jenisPs) {
        this.idPs = idPs;
        this.jenisPs = jenisPs;
        this.status = "Tersedia";
    }

    public int getHargaPerJam() {
        return 10000;
    }
    // ...
}
```

### 2. Subclass `PS4` dan `PS5`

Kata kunci `extends` menunjukkan pewarisan dari `PlayStation`. Constructor subclass memanggil `super(...)` untuk mengisi data superclass, sedangkan `@Override` dipakai untuk menentukan harga sesuai jenisnya.

```java
public class PS4 extends PlayStation {

    public PS4(int idPs) {
        super(idPs, "PS4");
    }

    @Override
    public int getHargaPerJam() {
        return 10000;
    }
}
```

```java
public class PS5 extends PlayStation {

    public PS5(int idPs) {
        super(idPs, "PS5");
    }

    @Override
    public int getHargaPerJam() {
        return 15000;
    }
}
```

### 3. Pemanfaatan pada `Main`

Objek `PS4` dan `PS5` disimpan dalam satu `ArrayList<PlayStation>`. Saat booking, method `getHargaPerJam()` dipanggil lewat variabel bertipe `PlayStation`, dan Java otomatis memakai harga milik subclass yang sesuai (polymorphism).

```java
static ArrayList<PlayStation> daftarPS = new ArrayList<>();

daftarPS.add(new PS4(1));
daftarPS.add(new PS4(2));
daftarPS.add(new PS5(3));

// Mengambil harga dari subclass PS4 atau PS5
int hargaPerJam = psDipilih.getHargaPerJam();
int totalBayar = durasi * hargaPerJam;
```

---

## Tangkapan Layar Program

### Menu Utama
[ss menu utama]

Menu utama muncul saat program dijalankan dan berisi lima pilihan: Lihat PlayStation, Booking PS, Lihat Transaksi, Kelola PlayStation, dan Keluar. Menu ditampilkan berulang sampai pengguna memilih 0.

### Lihat PlayStation
[ss lihat playstation]

Menampilkan seluruh PlayStation beserta ID, jenis, status (Tersedia atau Disewa), dan harga per jam. Data awal berisi dua unit PS4 dan satu unit PS5.

### Booking PS
[ss input booking 1]

Pengguna memilih ID PlayStation yang ingin disewa. Jika ID tidak ditemukan atau PlayStation sedang disewa, booking dibatalkan.

[ss input booking 2]

Pengguna kemudian mengisi ID pelanggan, nama, nomor HP, ID transaksi, dan durasi sewa. ID pelanggan dan ID transaksi harus unik, sehingga program meminta input ulang jika ID sudah dipakai.

### Booking Berhasil
[ss booking berhasil]

Setelah data valid, program menampilkan rincian booking dan menghitung total bayar dari durasi dikali harga per jam. Harga diambil dari method `getHargaPerJam()` milik subclass PS4 atau PS5, dan status PlayStation otomatis berubah menjadi "Disewa".

### Lihat Transaksi
[ss lihat transaksi]

Menampilkan riwayat transaksi yang berisi ID transaksi, nama pelanggan, jenis PS, durasi, dan total bayar. Jika belum ada transaksi, program menampilkan pesan "Belum ada transaksi."

### Kelola PlayStation
[ss menu kelola playstation]

Submenu untuk mengelola data PlayStation, yaitu menambah, melihat, mengubah status, dan menghapus PS. Pilihan 0 mengembalikan pengguna ke menu utama.

#### Tambah PS
[ss input tambah ps]

Pengguna memasukkan ID PS yang belum terpakai, lalu memilih jenisnya (PS4 atau PS5). Program membuat objek subclass yang sesuai dan menambahkannya ke daftar.

#### Ubah Status PS
[ss input ubah status ps]

Pengguna memasukkan ID PS, lalu mengubah statusnya secara manual menjadi Tersedia atau Disewa. Fitur ini berguna, misalnya, saat sewa sudah selesai dan PS perlu dikembalikan ke status Tersedia.

#### Hapus PS
[ss input hapus ps]

Menghapus PlayStation berdasarkan ID. PS yang sedang berstatus "Disewa" tidak dapat dihapus, dan program menampilkan pesan penolakan.

### Keluar Program
[ss keluar program]

Memilih 0 pada menu utama menghentikan program dan menampilkan pesan terima kasih.
