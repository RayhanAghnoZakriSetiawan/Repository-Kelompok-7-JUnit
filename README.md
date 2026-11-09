# 5W + 1H

| Pertanyaan | Jawaban | 
|----|------|
| What (Apa)  | JUnit adalah framework open-source untuk unit testing pada bahasa Java. Framework ini dipakai untuk menulis dan menjalankan tes otomatis yang berulang (repeatable tests) terhadap method atau class. Versi terbaru adalah JUnit 5 (Jupiter). |
| Who (Siapa)  | Dibuat oleh Kent Beck dan Erich Gamma. Penggunanya adalah developer Java, QA/tester otomasi, dan tim yang menerapkan TDD/CI-CD.  |
| When (Kapan)  | Dipakai saat developer selesai menulis atau mengubah kode (regression test), saat menerapkan TDD (tes ditulis sebelum kode), dan pada setiap build di pipeline CI (Jenkins, GitHub Actions).  | 
| Where (Di mana)  | Dipakai di lingkungan Java (IDE seperti IntelliJ, Eclipse, NetBeans) dan build tool Maven/Gradle. Bisa juga dipadukan dengan Selenium untuk web UI testing.  | 
| Why (Mengapa)  | Bug ketahuan lebih awal, kualitas kode terjaga, refactoring jadi aman, pengujian otomatis lebih cepat dan murah dibanding manual, dan hasilnya (pass/fail) jelas.  | 
| How (Bagaimana)  | Tambahkan dependency JUnit, buat class tes, tandai method dengan anotasi (@Test, @BeforeEach, @AfterEach, dll.), lalu validasi hasil dengan assertion (assertEquals, assertTrue, dll.). Jalankan lewat IDE atau mvn test.  | 

# Skripsi/Tesis tentang Selenium (Luar Negeri)
Berikut 8 skripsi/tesis dari luar negeri yang membahas Selenium.
| No | Judul | Penulis | Jenis & Institusi | Tahun | Fokus |
|---|---|---|---|---|---|
| 1 | A Comparative Analysis: Web Application Testing vs. Mobile Application Testing | Sachin Sarvothama | Master's thesis, Czech University of Life Sciences Prague (Ceko) | 2024 | Selenium untuk web vs Appium untuk mobile, otomasi untuk kualitas dan keandalan software |
| 2 | Agilni razvoj i automatizirano testiranje web aplikacije primjenom alata Selenium (Pengembangan Agile dan pengujian otomatis aplikasi web dengan Selenium) | Ivan Balogović | Master's thesis, J. J. Strossmayer University of Osijek (Kroasia) | 2019 | Agile dan automated web testing |
| 3 | Automated testing with Selenium (Testarea automată cu selenium) | Maxim Zalescuic | Master's thesis, Technical University of Moldova (Moldova) | 2019 | Modul pengujian otomatis halaman web dengan Selenium WebDriver, WebDriverIO, dan CodeceptJS |
| 4 | Framework pro tvorbu generovatelných automatizovaných funkčních testů s využitím nástroje Selenium WebDriver | Jakub Jaroš | Master's thesis, University of Economics, Prague (Ceko) | 2019 | Prototipe framework Python + Selenium WebDriver untuk functional test yang bisa di-generate |
| 5 | Building a flex test automation framework with JUnit, Selenium 2 and Selenium-flex | (tidak tercantum di hasil pencarian) | Master's thesis, University of Jyväskylä (Finlandia) | 2013 | Framework otomasi dengan JUnit + Selenium (paling relevan dengan topik JUnit) |
| 6 | Automation Testing, Selenium Tool (Quality Analysis) | (tidak tercantum di hasil pencarian) | Master of Engineering thesis, Thapar University (India) | n/a | Penjelasan tool Selenium dan otomasi pengujian situs |
| 7 | Automatické testy v Selenium framework (Automation tests in Selenium framework) | Adam Kučera | Bachelor's thesis, University of Hradec Králové (Ceko) | n/a | Tes UI dengan C# + Selenium WebDriver, dijalankan juga di Kubernetes cluster |
| 8 | Software testing automation using Selenium (Automatizace testování softwaru nástrojem Selenium) | Vojtěch Votlučka | Bachelor's thesis, University of Economics, Prague (Ceko) | n/a | Selenium WebDriver + Java untuk functional testing internet banking, plus perbandingan biaya manual vs otomatis |


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

# Sample Sederhana 
a. Dependency Maven (pom.xml)
```
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.2.5</version>
        </plugin>
    </plugins>
</build>
```

b. Class yang akan dites: Calculator.java
```java
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Pembagi tidak boleh nol");
        }
        return (double) a / b;
    }
}
```
c. Class tes: CalculatorTest.java

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc;

    @BeforeAll
    static void initAll() {
        System.out.println("Mulai semua tes");
    }

    @BeforeEach
    void setUp() {
        calc = new Calculator();   // objek baru sebelum tiap tes
    }

    @Test
    @DisplayName("Penjumlahan 2 + 3 = 5")
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calc.subtract(4, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(12, calc.multiply(3, 4));
    }

    @Test
    void testDivide() {
        assertEquals(2.5, calc.divide(5, 2), 0.001);
    }

    @Test
    @DisplayName("Pembagian dengan nol harus melempar exception")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.divide(10, 0));
    }

    @Test
    @Disabled("Contoh tes yang dinonaktifkan")
    void testSkipped() {
        fail("Tidak akan dijalankan");
    }

    @AfterEach
    void tearDown() {
        calc = null;
    }

    @AfterAll
    static void doneAll() {
        System.out.println("Selesai semua tes");
    }
}
```

d. Cara menjalankan
•	Lewat IDE: klik kanan CalculatorTest lalu pilih Run.
•	Lewat terminal: mvn test
Hasil yang diharapkan:
```
Tests run: 6, Failures: 0, Errors: 0, Skipped: 1
```

e. Contoh @ParameterizedTest (bonus)
```java
@ParameterizedTest
@CsvSource({"1,2,3", "5,5,10", "-1,1,0"})
void testAddParameterized(int a, int b, int expected) {
    assertEquals(expected, new Calculator().add(a, b));
}
Catatan: @ParameterizedTest memerlukan modul junit-jupiter-params, yang sudah termasuk dalam artifact junit-jupiter.
```

# Referensi Tambahan
•	Dokumentasi resmi JUnit 5: https://junit.org/junit5/docs/current/user-guide/

•	Repository contoh resmi di GitHub: junit-team/junit5-samples

•	Buku: JUnit in Action (Tahchiev, dkk.)

•	Buku: Test Driven Development: By Example (Kent Beck)
