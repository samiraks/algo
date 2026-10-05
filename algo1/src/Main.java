import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(isBalanced("[]"));
        System.out.println(isBalanced("[](){}"));
        System.out.println(isBalanced("[({})]"));
        System.out.println(isBalanced("[({}()){}]"));
        System.out.println(isBalanced("{]"));
        System.out.println(isBalanced("({)}"));
        System.out.println(isBalanced("("));
        System.out.println(isBalanced(")"));
    }

    static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 1. Открывающая скобка — кладём в стопку
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // 2. Закрывающая скобка — проверяем верхнюю
            else {
                // закрывать нечего
                if (stack.isEmpty()) {
                    return false;
                }

                char last = stack.pop(); // снимаем верхнюю

                // не тот тип скобки
                if (c == ')' && last != '(') return false;
                if (c == ']' && last != '[') return false;
                if (c == '}' && last != '{') return false;
            }
        }

        // В конце стопка должна быть пустой
        return stack.isEmpty();
    }
}
