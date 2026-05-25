# 📚 PerpustakaanApp

Aplikasi perpustakaan berbasis desktop menggunakan Java Swing dan Apache NetBeans ANT.  
Project ini menggunakan konsep OOP dan struktur folder yang terorganisir agar mudah dikembangkan dan dipelihara.

---

## ✨ Features

### Admin
- Login admin
- CRUD buku
- CRUD anggota
- Manajemen peminjaman
- Manajemen pengembalian
- Dashboard admin

### Anggota
- Login anggota
- Registrasi anggota
- Melihat daftar buku
- Melihat riwayat peminjaman

---

## 🛠 Tech Stack

- Java Swing
- Apache NetBeans
- ANT
- MySQL
- JDBC
- FlatLaf

---

## 📁 Project Structure

```text
src/
├── config/
├── controller/
├── dao/
├── model/
├── service/
├── utils/
└── view/
```

---

## 📦 Package Documentation

### config/
Berisi konfigurasi aplikasi.

Contoh:
- Koneksi database
- Session login
- Main application

---

### controller/
Berfungsi sebagai penghubung antara view dan business logic.

Contoh:
- LoginController
- BukuController
- AnggotaController

---

### dao/
Berisi query database.

Fungsi:
- INSERT
- UPDATE
- DELETE
- SELECT

Contoh:
- BukuDAO
- UserDAO

---

### model/
Berisi class object atau entity.

Contoh:
- Buku
- User
- Peminjaman

---

### service/
Berisi business logic aplikasi.

Contoh:
- Validasi login
- Validasi peminjaman
- Perhitungan denda

---

### utils/
Berisi helper atau utility class.

Contoh:
- PasswordUtil
- AlertUtil
- DateUtil

---

### view/
Berisi seluruh tampilan GUI aplikasi.

Struktur:
```text
view/
├── auth/
├── admin/
└── anggota/
```

---

## 🎨 UI Library

Project ini menggunakan FlatLaf untuk tampilan modern Java Swing.

Official Website:
https://www.formdev.com/flatlaf/

---

## 📚 Libraries

Semua library berada di folder:

```text
lib/
```

Contoh:
```text
lib/
├── flatlaf-3.7.1.jar
└── mysql-connector-j.jar
```

---

## ⚙️ Cara Menambahkan Library di Apache NetBeans

1. Klik kanan project
2. Pilih `Properties`
3. Pilih `Libraries`
4. Klik `Add JAR/Folder`
5. Pilih semua file `.jar` di folder `lib/`
6. Klik `Open`
7. Klik `OK`

---

## ▶️ Cara Menjalankan Project

1. Buka project di Apache NetBeans
2. Pastikan semua library sudah ditambahkan
3. Jalankan file:

```text
Main.java
```

atau tekan:

```text
Shift + F6
```

---

## 👨‍💻 Author

Akbar Purba
