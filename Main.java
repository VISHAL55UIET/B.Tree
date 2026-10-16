import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class Pair {
    Node node;
    int level;

    Pair(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class Main {

    public static int n;

    public static void nthLevel(Node root, int level) {
        if (root == null) return;

        if (level == n) {
            System.out.print(root.data + " ");
            return;
        }

        nthLevel(root.left, level + 1);
        nthLevel(root.right, level + 1);
    }

    static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));

        int currLevel = 1;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            Node current = p.node;
            int level = p.level;

            if (level != currLevel) {
                System.out.println();
                currLevel = level;
            }

            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.offer(new Pair(current.left, level + 1));
            }

            if (current.right != null) {
                queue.offer(new Pair(current.right, level + 1));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Level Order Traversal:");
        levelOrder(root);

        System.out.print("Enter n: ");
        n = sc.nextInt();

        System.out.print("Nodes at level " + n + ": ");
        nthLevel(root, 1);

        sc.close();
    }
}