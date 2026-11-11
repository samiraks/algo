import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Читаем массив
        int n = sc.nextInt(); // первое число - количество элементов
        int[] arr = new int[n]; // создаем массив

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // читаем очередное число и кладём в ячейку a[i]
        }

        int m = sc.nextInt(); // количество запросов

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < m; i++) {
            int q = sc.nextInt();

            int closest = findClosest(arr, q); // Вызываем наш метод поиска и сохраняем ответ

            result.append(closest).append(" "); // Добавляем ответ в общую строку и ставим пробел
        }
        System.out.println(result.toString().trim());
    }

    private static int findClosest(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target){
                return arr[mid];
            }
            else if(arr[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        int best = arr[left];
        if(left > 0 ){
            int prev = arr[left - 1];
            if (Math.abs(prev - target) <= Math.abs(best - target)){
                best = prev;
            }
        }
        return best;
    }
}