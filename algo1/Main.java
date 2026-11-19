import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        BST tree = new BST();

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) break;          // пустая строка — конец ввода

            String[] parts = line.split("\\s+");
            String cmd = parts[0];
            int x = Integer.parseInt(parts[1]);

            switch (cmd) {
                case "insert": tree.insert(x); break;
                case "delete": tree.delete(x); break;
                case "has":    out.append(tree.has(x) ? 't' : 'f').append('\n'); break;
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
                default: break;
            }
        }
        System.out.print(out);
    }
}