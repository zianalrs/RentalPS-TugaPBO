# Sistem Manajemen Rental PS

**Nama:** Zian Alrais

**NIM:** 2509116064

---

## Studi Kasus

Program ini adalah aplikasi berbasis konsol (Java) untuk mengelola usaha rental PlayStation. Pengguna dapat melihat daftar PlayStation beserta statusnya, melakukan booking berdasarkan durasi sewa, melihat riwayat transaksi, serta mengelola data PlayStation (tambah, ubah status, dan hapus). Harga sewa dihitung otomatis sesuai jenis PlayStation: PS4 Rp10.000 per jam dan PS5 Rp15.000 per jam.

---

## Diagram Kelas

<img width="1541" height="1185" alt="diagram-kelas-sederhana" src="https://github.com/user-attachments/assets/647421af-f565-4a48-8079-01e54408d9e2" />


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
<img width="322" height="220" alt="image" src="https://github.com/user-attachments/assets/506cd304-3c5b-457d-aeac-cdfec0de400c" />


Menu utama muncul saat program dijalankan dan berisi lima pilihan: Lihat PlayStation, Booking PS, Lihat Transaksi, Kelola PlayStation, dan Keluar. Menu ditampilkan berulang sampai pengguna memilih 0.

### Lihat PlayStation
<img width="305" height="428" alt="image" src="https://github.com/user-attachments/assets/0982dd14-ec44-464e-9586-a42939c99fe9" />


Menampilkan seluruh PlayStation beserta ID, jenis, status (Tersedia atau Disewa), dan harga per jam. Data awal berisi dua unit PS4 dan satu unit PS5.

### Booking PS
<img width="308" height="147" alt="image" src="https://github.com/user-attachments/assets/bb2e2e85-4997-457b-b804-3a8b05ba0183" />


Pengguna memilih ID PlayStation yang ingin disewa. Jika ID tidak ditemukan atau PlayStation sedang disewa, booking dibatalkan. Pengguna kemudian mengisi ID pelanggan, nama, nomor HP, ID transaksi, dan durasi sewa. ID pelanggan dan ID transaksi harus unik, sehingga program meminta input ulang jika ID sudah dipakai.

### Booking Berhasil
<img width="301" height="192" alt="image" src="https://github.com/user-attachments/assets/5f691326-eb57-48d1-9023-f8fe47158f5e" />


Setelah data valid, program menampilkan rincian booking dan menghitung total bayar dari durasi dikali harga per jam. Harga diambil dari method `getHargaPerJam()` milik subclass PS4 atau PS5, dan status PlayStation otomatis berubah menjadi "Disewa".

### Lihat Transaksi
<img width="308" height="110" alt="image" src="https://github.com/user-attachments/assets/b86ef93d-8c71-4c5b-87f7-4bc0e61c1a30" />


Menampilkan riwayat transaksi yang berisi ID transaksi, nama pelanggan, jenis PS, durasi, dan total bayar. Jika belum ada transaksi, program menampilkan pesan "Belum ada transaksi."

### Kelola PlayStation
<img width="307" height="210" alt="image" src="https://github.com/user-attachments/assets/742e18dd-8f1b-4ac6-8aa5-adea6aa83088" />


Submenu untuk mengelola data PlayStation, yaitu menambah, melihat, mengubah status, dan menghapus PS. Pilihan 0 mengembalikan pengguna ke menu utama.

#### Tambah PS
<img width="313" height="192" alt="image" src="https://github.com/user-attachments/assets/d59844df-2819-496c-a743-ad463c4b7dfe" />



Pengguna memasukkan ID PS yang belum terpakai, lalu memilih jenisnya (PS4 atau PS5). Program membuat objek subclass yang sesuai dan menambahkannya ke daftar.

#### Ubah Status PS
<img width="302" height="256" alt="image" src="https://github.com/user-attachments/assets/b0f1f590-8d77-4131-888a-c67043e9a26f" />



Pengguna memasukkan ID PS, lalu mengubah statusnya secara manual menjadi Tersedia atau Disewa. Fitur ini berguna, misalnya, saat sewa sudah selesai dan PS perlu dikembalikan ke status Tersedia.

#### Hapus PS
<img width="308" height="118" alt="image" src="https://github.com/user-attachments/assets/e058bfd6-d4ef-4eca-908c-4cb248d5072f" />


Menghapus PlayStation berdasarkan ID. PS yang sedang berstatus "Disewa" tidak dapat dihapus, dan program menampilkan pesan penolakan.

### Keluar Program
<img width="410" height="255" alt="image" src="https://github.com/user-attachments/assets/05381867-f6d0-4002-b10b-a11972bcd00a" />


Memilih 0 pada menu utama menghentikan program dan menampilkan pesan terima kasih.
