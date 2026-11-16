import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder(); //складываем все результаты в одну строку, а в конце печатаем разом
        MinStackImpl stack = new MinStackImpl(); //создаем стек

        String line; //сюда будет класться прочитанная строка
        while ((line = reader.readLine()) != null) {
            line = line.trim(); // убираются пробелы по краям строки
            if (line.isEmpty()) {
                break;   // пустая строка = конец ввода
            }

            StringTokenizer st = new StringTokenizer(line); //по умолчанию режет по пробелам
            String cmd = st.nextToken(); //достаем первый токен

            switch (cmd) {
                case "push" -> stack.push(Integer.parseInt(st.nextToken())); //кладем на вершину
                case "pop"  -> stack.pop(); //снимаем верхний элемент
                case "top"  -> result.append(stack.top()).append('\n'); //
                case "min"  -> result.append(stack.min()).append('\n'); //берем текущий минимум стека и дописываем его в копилку с переводом строки
            }
        }

        System.out.print(result);
    }
}