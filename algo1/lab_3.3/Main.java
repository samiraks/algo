import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class Main {

    // Универсальный метод для тестирования
    private static <T extends Comparable<T>> void test(String label, T[] input) {
        T[] copy = input.clone();
        T[] expected = input.clone();

        // Эталонная сортировка из стандартной библиотеки Java
        Arrays.sort(expected);

        // Наша обобщенная сортировка
        Sorting<T> sorter = new InsertionSort<>();
        sorter.sort(copy);

        // Проверка результата
        boolean ok = Arrays.equals(expected, copy);

        System.out.println(label + ": " + (ok ? "OK" : "FAIL"));
        System.out.println("  До:     " + Arrays.toString(input));
        System.out.println("  После:  " + Arrays.toString(copy));
        System.out.println();
    }

    public static void main(String[] args) {
        // 1. Integer
        test("Integer", new Integer[]{5, 3, 8, 1, 9, 3, 7, 1});

        // 2. String
        test("String", new String[]{"браслет", "апельсин", "дата", "вишня", "амплитуда"});

        // 3. LocalDateTime
        test("LocalDateTime", new LocalDateTime[]{
                LocalDateTime.of(2024, 5, 1, 10, 0),
                LocalDateTime.of(2023, 1, 15, 8, 30),
                LocalDateTime.of(2024, 5, 1, 10, 0),
                LocalDateTime.of(2025, 12, 31, 23, 59)
        });

        // 4. Student
        test("Student", new Student[]{
                new Student("Алиса", 20),
                new Student("Боря", 22),
                new Student("Алина", 19),
                new Student("Кристина", 21)
        });

        // 5. UUID
        test("UUID", new UUID[]{
                UUID.fromString("c5f5a7d2-1111-4444-8888-000000000000"),
                UUID.fromString("00000000-0000-0000-0000-000000000001"),
                UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee")
        });
    }
}
