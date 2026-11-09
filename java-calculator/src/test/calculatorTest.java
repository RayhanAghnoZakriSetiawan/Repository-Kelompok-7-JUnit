import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource({"1,2,3", "5,5,10", "-1,1,0"})
    void testAddParameterized(int a, int b, int expected) {
        assertEquals(expected, new Calculator().add(a, b));
    }

}

