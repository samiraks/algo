import java.util.Scanner;
import java.util.Locale; // Нужно для точки

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US); // Читаем тоже с точкой
        if (!sc.hasNextDouble()) return;

        double a = sc.nextDouble();

        double left = 1.0;
        double right = a; // Правая = a (так как при x >= 1 функция растет быстрее, чем x)

        // Если a < 1, то ответ будет чуть меньше 1, но по условию a >= 1
        if (right < left) right = 2.0;

        // Бинарный поиск
        for (int i = 0; i < 100; i++) {
            double mid = left + (right - left) / 2.0;

            if (calculate(mid) >= a) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        // Выводим результат С ТОЧКОЙ (Locale.US гарантирует точку)
        System.out.printf(Locale.US, "%.6f\n", right);

        sc.close();
    }

    private static double calculate(double x) {
        return x * x - x + Math.sqrt(x);
    }
}
