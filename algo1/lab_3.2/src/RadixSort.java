import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {

    @Override
    public void sort(List<BigInteger> nums) {
        if (nums.size() <= 1) return;

        // 20 проходов: от единиц до самого старшего разряда
        for (int digitPos = 0; digitPos < 20; digitPos++) {
            countingSortByDigit(nums, digitPos);
        }
    }

    // Сортировка подсчетом для одной конкретной цифры
    private void countingSortByDigit(List<BigInteger> nums, int digitPos) {
        int n = nums.size();
        List<BigInteger> result = new ArrayList<>(n);

        // Массив-коробочка для цифр 0..9
        int[] count = new int[10];

        // 1. Считаем цифры
        for (BigInteger num : nums) {
            int digit = getDigit(num, digitPos);
            count[digit]++;
        }

        // 2. Префиксные суммы (для стабильности)
        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // Заполняем результирующий список пустыми значениями (нулями)
        for (int i = 0; i < n; i++) {
            result.add(BigInteger.ZERO);
        }

        // 3. Расставляем с конца (стабильно)
        for (int i = n - 1; i >= 0; i--) {
            BigInteger num = nums.get(i);
            int digit = getDigit(num, digitPos);

            // Узнаем позицию
            int pos = count[digit] - 1;
            result.set(pos, num);

            // Уменьшаем счетчик
            count[digit] = count[digit] - 1;
        }

        // 4. Возвращаем обратно
        for (int i = 0; i < n; i++) {
            nums.set(i, result.get(i));
        }
    }

    // Вспомогательная функция: достает цифру на позиции digitPos (0 = единицы, 1 = десятки...)
    private int getDigit(BigInteger num, int digitPos) {
        BigInteger exp = BigInteger.TEN.pow(digitPos); // 10 в степени digitPos
        BigInteger digit = num.divide(exp).mod(BigInteger.TEN); // (num / 10^pos) % 10
        return digit.intValue();
    }
}