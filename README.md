# 📚 PerpustakaanApp

Aplikasi perpustakaan berbasis desktop yang dikembangkan menggunakan Java Swing, MySQL, dan Apache NetBeans. Sistem ini dirancang untuk membantu pengelolaan data buku, anggota, serta proses peminjaman dan pengembalian buku secara efisien melalui antarmuka yang sederhana dan mudah digunakan.

## 🚀 Fitur Utama

### 👨‍💼 Admin

* Login admin
* Dashboard admin
* Kelola data buku

  * Tambah buku
  * Ubah data buku
  * Hapus buku
  * Lihat daftar buku
* Kelola data anggota

  * Tambah anggota
  * Ubah data anggota
  * Hapus anggota
  * Lihat daftar anggota
* Kelola peminjaman buku
* Kelola pengembalian buku
* Monitoring status peminjaman
* Logout

### 👨‍🎓 Anggota

* Registrasi akun anggota
* Login anggota
* Melihat katalog buku
* Mengajukan peminjaman buku
* Melihat riwayat peminjaman
* Melihat status peminjaman
* Logout

---

## 🛠️ Teknologi yang Digunakan

| Teknologi       | Keterangan                       |
| --------------- | -------------------------------- |
| Java            | Bahasa pemrograman utama         |
| Java Swing      | Pembuatan antarmuka desktop      |
| Apache NetBeans | IDE pengembangan                 |
| MySQL           | Database                         |
| JDBC            | Koneksi Java ke MySQL            |
| FlatLaf         | Modern Look and Feel untuk Swing |
| jBCrypt         | Hashing password                 |

---

## 🏗️ Arsitektur Project

Project menggunakan pola pemisahan tanggung jawab (Separation of Concerns) agar kode lebih terstruktur dan mudah dipelihara.

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

### config

Berisi konfigurasi aplikasi.

Contoh:

* Database Connection
* Session Management
* Main Application

### controller

Menangani komunikasi antara View dan Service.

Contoh:

* LoginController
* BukuController
* AnggotaController
* PeminjamanController

### dao

Berisi seluruh operasi database.

Fungsi:

* Insert Data
* Update Data
* Delete Data
* Select Data

Contoh:

* UserDAO
* BukuDAO
* AnggotaDAO
* PeminjamanDAO

### model

Representasi objek atau entitas database.

Contoh:

* User
* Admin
* Anggota
* Buku
* Peminjaman

### service

Berisi business logic aplikasi.

Contoh:

* Login Service
* Registrasi Service
* Peminjaman Service
* Pengembalian Service

### utils

Berisi helper dan utility class.

Contoh:

* PasswordUtil
* MessageUtil
* DateUtil
* LogoutUtil

### view

Berisi seluruh tampilan aplikasi.

```text
view/
├── auth/
├── admin/
└── anggota/
```

---

## 🔒 Keamanan

Password pengguna disimpan menggunakan hashing dengan jBCrypt sehingga tidak tersimpan dalam bentuk teks asli di database.

Contoh hasil hashing:

```text
$2a$10$6Kqg0vN2uHfN6A4gM8Nf6u2jQzqvA2s4sQ2zYQ2d2rP7r6W9hM2xG
```

---

## 🗄️ Database

Database yang digunakan adalah MySQL dengan tabel utama:

```text
users
admin
anggota
buku
peminjaman
```

Relasi utama:

```text
users
│
├── admin
└── anggota

anggota
│
└── peminjaman

buku
│
└── peminjaman
```

---

## 🎨 User Interface

Aplikasi menggunakan FlatLaf untuk memberikan tampilan modern pada Java Swing.

Fitur tampilan:

* Clean UI
* Modern Design
* Responsive Components
* Better User Experience

---

## 📦 Library

Seluruh library disimpan pada folder:

```text
lib/
```

Contoh:

```text
lib/
├── flatlaf-3.x.jar
├── mysql-connector-j.jar
└── jbcrypt.jar
```

---

## ⚙️ Instalasi

### 1. Clone Repository

```bash
git clone https://github.com/username/perpustakaanapp.git
```

### 2. Import Project

* Buka Apache NetBeans
* Pilih Open Project
* Pilih folder project

### 3. Tambahkan Library

* Klik kanan project
* Properties
* Libraries
* Add JAR/Folder
* Pilih seluruh file JAR pada folder lib

### 4. Konfigurasi Database

Buat database:

```sql
CREATE DATABASE perpustakaan;
```

Sesuaikan konfigurasi koneksi pada:

```text
src/config/Database.java
```

### 5. Jalankan Project

Jalankan:

```text
Main.java
```

atau gunakan shortcut:

```text
Shift + F6
```

---

## 📸 Screenshot

Tambahkan screenshot aplikasi di sini.

```text
docs/
├── login.png
├── dashboard-admin.png
├── data-buku.png
└── peminjaman.png
```

---

## 👨‍💻 Author

Samōra Library