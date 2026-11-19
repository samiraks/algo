
public class BST {

    static class Node {
        int key;
        Node left, right;
        Node(int key) {
            this.key = key;
        }
    }

    private Node root = null;

    // ---------- insert ----------
    public void insert(int x) {
        root = insertRec(root, x);
    }

    private Node insertRec(Node node, int x) {
        if (node == null) return new Node(x); //если узел не определен, формируем новый
        if (x < node.key)       node.left  = insertRec(node.left,  x); //если добавляемый меньше ключа узла, добавляем влево
        else if (x > node.key)  node.right = insertRec(node.right, x); // если больше то вправо
        // если x == node.key — дубликат, ничего не делаем
        return node;
    }

    // ---------- has ----------
    public boolean has(int x) {
        Node cur = root;
        while (cur != null) {
            if (x == cur.key) return true;
            if (x < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }

    // ---------- delete ----------
    public void delete(int x) {
        root = deleteRec(root, x);
    }

    private Node deleteRec(Node node, int x) {
        if (node == null) return null;                 // ключа нет — ничего не меняем
        if (x < node.key) {
            node.left = deleteRec(node.left, x);
        } else if (x > node.key) {
            node.right = deleteRec(node.right, x);
        } else {
            // нашли узел
            if (node.left == null)  return node.right; // 0 или только правый потомок
            if (node.right == null) return node.left;  // только левый потомок
            // два потомка: берём минимум из правого поддерева
            int minRight = minKey(node.right);
            node.key = minRight;
            node.right = deleteRec(node.right, minRight);
        }
        return node;
    }

    private int minKey(Node node) {
        while (node.left != null) node = node.left;
        return node.key;
    }

    // ---------- next: минимальный ключ, строго больший x ----------
    /** @return минимальный ключ > x, либо null, если такого нет */
    public Integer next(int x) {
        Node cur = root;
        Integer res = null;
        while (cur != null) {
            if (cur.key > x) {
                res = cur.key;      // кандидат — попробуем найти меньше
                cur = cur.left;
            } else {
                cur = cur.right;    // текущий и левое поддерево не подходят
            }
        }
        return res;
    }

    // ---------- prev: максимальный ключ, строго меньший x ----------
    /** @return максимальный ключ < x, либо null, если такого нет */
    public Integer prev(int x) {
        Node cur = root;
        Integer res = null;
        while (cur != null) {
            if (cur.key < x) {
                res = cur.key;      // кандидат — попробуем найти больше
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return res;
    }
}