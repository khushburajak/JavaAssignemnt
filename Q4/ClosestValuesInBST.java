package Q4;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class ClosestValuesInBST {
    public static List<Integer> closestValues(TreeNode root, double target, int x) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(Pair::getDiff));

        inorderTraversal(root, target, x, pq);

        while (!pq.isEmpty()) {
            result.add(pq.poll().value);
        }

        return result;
    }

    private static void inorderTraversal(TreeNode root, double target, int x, PriorityQueue<Pair> pq) {
        if (root == null) return;

        inorderTraversal(root.left, target, x, pq);

        double diff = Math.abs(target - root.val);
        if (pq.size() < x) {
            pq.offer(new Pair(diff, root.val));
        } else {
            if (diff < pq.peek().diff) {
                pq.poll();
                pq.offer(new Pair(diff, root.val));
            }
        }

        inorderTraversal(root.right, target, x, pq);
    }

    static class Pair {
        double diff;
        int value;

        public Pair(double diff, int value) {
            this.diff = diff;
            this.value = value;
        }

        public double getDiff() {
            return diff;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        double target = 3.8;
        int x = 2;
        List<Integer> closest = closestValues(root, target, x);

        System.out.println("Closest values to " + target + " are: " + closest);
    }
}