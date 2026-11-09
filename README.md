# 5W + 1H

| Pertanyaan | Jawaban | 
|----|------|
| What (Apa)  | JUnit adalah framework open-source untuk unit testing pada bahasa Java. Framework ini dipakai untuk menulis dan menjalankan tes otomatis yang berulang (repeatable tests) terhadap method atau class. Versi terbaru adalah JUnit 5 (Jupiter). |
| Who (Siapa)  | Dibuat oleh Kent Beck dan Erich Gamma. Penggunanya adalah developer Java, QA/tester otomasi, dan tim yang menerapkan TDD/CI-CD.  |
| When (Kapan)  | Dipakai saat developer selesai menulis atau mengubah kode (regression test), saat menerapkan TDD (tes ditulis sebelum kode), dan pada setiap build di pipeline CI (Jenkins, GitHub Actions).  | 
| Where (Di mana)  | Dipakai di lingkungan Java (IDE seperti IntelliJ, Eclipse, NetBeans) dan build tool Maven/Gradle. Bisa juga dipadukan dengan Selenium untuk web UI testing.  | 
| Why (Mengapa)  | Bug ketahuan lebih awal, kualitas kode terjaga, refactoring jadi aman, pengujian otomatis lebih cepat dan murah dibanding manual, dan hasilnya (pass/fail) jelas.  | 
| How (Bagaimana)  | Tambahkan dependency JUnit, buat class tes, tandai method dengan anotasi (@Test, @BeforeEach, @AfterEach, dll.), lalu validasi hasil dengan assertion (assertEquals, assertTrue, dll.). Jalankan lewat IDE atau mvn test.  | 

## Anotasi penting JUnit 5
| Anotasi | Fungsi | 
|----|------|
| @Test  | Menandai method sebagai tes |
| @BeforeEach / @AfterEach  | Dijalankan sebelum/sesudah setiap tes  |
| @Disabled  | Menonaktifkan tes  | 
| Where (Di mana)  | Dipakai di lingkungan Java (IDE seperti IntelliJ, Eclipse, NetBeans) dan build tool Maven/Gradle. Bisa juga dipadukan dengan Selenium untuk web UI testing.  | 
| @DisplayName  | Nama tes yang mudah dibaca  | 
| @ParameterizedTest  | Tes yang sama dengan banyak data  |

Tautan sumber
1.	https://theses.cz/id/evf5p6/zaverecna_prace.pdf_
2.	https://dabar.srce.hr/en/islandora/object/etfos%3A2301
3.	https://repository.utm.md/handle/5014/13341
4.	https://theses.cz/id/mw0pgh?lang=en
5.	https://thesis.jyu.fi/Record/jyx.123456789_90442
6.	https://tudr.thapar.edu/bitstreams/d989b2aa-dc50-4eaa-9f2e-cf19b7680be2/download
7.	https://theses.cz/id/fy81t9/STAG95965_Archive.pdf?lang=en
8.	https://vskp.vse.cz/english/45895
Catatan: Beberapa judul asli berbahasa Ceko, Kroasia, atau Finlandia, tetapi umumnya tersedia abstrak berbahasa Inggris. Untuk nomor 5 dan 6, nama penulis dan tahun belum terverifikasi dari hasil pencarian, sehingga perlu dicek langsung di tautan sebelum dikutip.
