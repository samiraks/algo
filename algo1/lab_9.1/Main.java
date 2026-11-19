import java.io.*;

/**
 * Точка входа: читает команды из stdin, вызывает методы BST, пишет ответ в stdout.
 * Пустая строка = конец ввода.
 * Поддерживаемые команды: insert x, delete x, has x, next x, prev x.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        BST tree = new BST();

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();

            // Пустая строка — сигнал окончания ввода
            if (line.isEmpty()) break;

            String[] parts = line.split("\\s+");
            String cmd = parts[0];
            int x = Integer.parseInt(parts[1]);

            switch (cmd) {
                case "insert":
                    tree.insert(x);
                    break;
                case "delete":
                    tree.delete(x);
                    break;
                case "has":
                    out.append(tree.has(x) ? 't' : 'f').append('\n');
                    break;
                case "next": {
                    Integer r = tree.next(x);
                    if (r != null) out.append(r).append('\n');
                    break;
                }
                case "prev": {
                    Integer r = tree.prev(x);
                    if (r != null) out.append(r).append('\n');
                    break;
                }
                default:
                    // неизвестная команда — игнорируем
            }
        }

        System.out.print(out);
    }
}
