import java.util.PriorityQueue;

// Node of Huffman Tree
class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class HuffmanCoding {

    // Print Huffman Codes
    static void printCodes(Node root, String code) {

        // Leaf node contains a character
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        // Left edge = 0
        printCodes(root.left, code + "0");

        // Right edge = 1
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        char chars[] = {'A', 'B', 'C', 'D'};
        int freq[] = {5, 9, 12, 13};

        // Min Heap based on frequency
        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.freq - b.freq);

        // Create node for each character
        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        // Build Huffman Tree
        while (pq.size() > 1) {

            // Remove two minimum frequency nodes
            Node left = pq.poll();
            Node right = pq.poll();

            // Create parent node
            Node parent = new Node('-', left.freq + right.freq);
            parent.left = left;
            parent.right = right;

            // Add parent back to queue
            pq.add(parent);
        }

        // Root of Huffman Tree
        Node root = pq.poll();

        System.out.println("Huffman Codes:");
        printCodes(root, "");
    }
}