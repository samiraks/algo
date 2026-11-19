public class BST {

    /** Узел AVL-дерева: ключ, потомки, высота поддерева. */
    static class Node {
        int key;
        Node left, right;
        int height;                    // высота поддерева с корнем в этом узле

        Node(int key) {
            this.key = key;
            this.height = 0;           // лист имеет высоту 0
        }
    }

    private Node root = null;

    // ---------- вспомогательные: высота и баланс ----------

    /** Высота поддерева; для null — (-1), чтобы лист имел высоту 0. */
    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    /** Пересчитать высоту узла по высотам потомков. */
    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    /** Balance Factor = height(left) - height(right). */
    private int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    // ---------- повороты ----------

    /** Малый правый поворот (случай LL). */
    private Node rotateRight(Node y) {
        Node x = y.left; //берем левого потомка проблемного узла
        Node B = x.right; //смотрим есть ли у него правый ребенок

        x.right = y; //узел у становится правым ребенком
        y.left = B; //то что было правым у х, становится левым у

        updateHeight(y);
        updateHeight(x);
        return x;                      // новый корень поддерева
    }

    /** Малый левый поворот (случай RR). */
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node B = y.left;

        y.left = x;
        x.right = B;

        updateHeight(x);
        updateHeight(y);
        return y;                      // новый корень поддерева
    }

    /** Привести поддерево к балансу; вернуть новый корень. */
    private Node balance(Node node) {
        updateHeight(node);
        int bf = balanceFactor(node);

        // LL: левое поддерево слишком высокое, левый потомок не «правый»
        if (bf > 1 && balanceFactor(node.left) >= 0) {
            return rotateRight(node);
        }
        // LR: левое поддерево высокое, но левый потомок «правый»
        if (bf > 1 && balanceFactor(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // RR: правое поддерево слишком высокое
        if (bf < -1 && balanceFactor(node.right) <= 0) {
            return rotateLeft(node);
        }
        // RL: правое высокое, но правый потомок «левый»
        if (bf < -1 && balanceFactor(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;                   // уже сбалансировано
    }

    // ---------- insert ----------

    public void insert(int x) {
        root = insertRec(root, x);
    }

    private Node insertRec(Node node, int x) {
        if (node == null) return new Node(x);

        if (x < node.key)       node.left  = insertRec(node.left,  x);
        else if (x > node.key)  node.right = insertRec(node.right, x);
        else                    return node;   // дубликат — не вставляем

        return balance(node);                  // обновить высоту и сбалансировать
    }

    // ---------- has (без изменений) ----------

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
        if (node == null) return null;

        if (x < node.key) {
            node.left = deleteRec(node.left, x);
        } else if (x > node.key) {
            node.right = deleteRec(node.right, x);
        } else {
            if (node.left == null)  return node.right; // 0/1 потомок
            if (node.right == null) return node.left;
            int minRight = minKey(node.right);
            node.key = minRight;
            node.right = deleteRec(node.right, minRight);
        }

        return balance(node);                      // после удаления — балансируем
    }

    private int minKey(Node node) {
        while (node.left != null) node = node.left;
        return node.key;
    }

    // ---------- next / prev (без изменений) ----------

    public Integer next(int x) {
        Node cur = root;
        Integer res = null;
        while (cur != null) {
            if (cur.key > x) {
                res = cur.key;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }

    public Integer prev(int x) {
        Node cur = root;
        Integer res = null;
        while (cur != null) {
            if (cur.key < x) {
                res = cur.key;
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return res;
    }
}
