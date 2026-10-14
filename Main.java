import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
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

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Level Order Traversal
        System.out.print("Level Order Traversal: ");
        levelOrder(root);

        // Nth Level Traversal
        System.out.print("\nEnter n: ");
        n = sc.nextInt();

        System.out.print("Nodes at level " + n + ": ");
        nthLevel(root, 1);
    }
}