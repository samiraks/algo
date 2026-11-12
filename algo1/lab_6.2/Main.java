import java.util.*; // Scanner для чтения ввода

public class Main {
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       long n = sc.nextLong();
       long w = sc.nextLong();
       long h = sc.nextLong();

       long left = 1;//Левая граница
       long right = Math.max(w,h) * n;//Правая граница, Самый худший случай
       long ans = right; //Переменная для хранения ответа, Изначально предполагаем худший вариант

       while (left <= right) {
           long mid = left + (right - left)/2;//Находим середину
           if(canFit(mid,w,h,n)){
               ans = mid;//Раз помещаются, запоминаем этот размер как возможный ответ
               right = mid - 1;// гарантированно подходящий размер
           }
           else {
               left = mid + 1;
           }
       }
       System.out.println(ans);
       sc.close();
   }
   private static boolean canFit(long M, long w, long h, long n){
       long countW = M/w; //Сколько дипломов поместится в ряд по ширине
       long countH = M/h; //Сколько дипломов поместится в ряд по высоте
       if(countW > 0 && countH > 0 && countW > n / countH) {
           return true;
       }
       return countW * countH >= n;
   }
}
