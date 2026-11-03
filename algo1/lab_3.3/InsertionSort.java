public class InsertionSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] array) {
        // Если массив пустой или состоит из 1 элемента, сортировать нечего
        if (array == null || array.length < 2) {
            return;
        }

        // Проходим по массиву, начиная со второго элемента (индекс 1)
        for (int i = 1; i < array.length; i++) {
            T key = array[i]; // Запоминаем текущий элемент
            int j = i - 1;

            // Сдвигаем элементы, которые больше key, на одну позицию вправо
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }

            // Вставляем key на освободившееся место
            array[j + 1] = key;
        }
    }
}
