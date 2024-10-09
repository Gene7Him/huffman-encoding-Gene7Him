package src;

import java.util.*;
import java.util.PriorityQueue;

/**
 *
 * @author Eugene Faison
 * @version 1.0
 */
public class HuffmanEncoding {

    private HuffmanNode root;
    private Map<Character, String> encodingMap = new TreeMap<>();
    private Map<Character, Double> frequencies = new TreeMap<>();

    /**
     * @param frequencyMap adds constructor and Builds tree
     */
    public HuffmanEncoding(Map<Character, Integer> frequencyMap) {
        buildTree(frequencyMap);
        encodingMap = new HashMap<>();
        generateCodes(root, "");
    }

    private void buildTree(Map<Character, Integer> frequencyMap) {
        Queue<HuffmanNode> tree = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            tree.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (tree.size() > 1) {
            HuffmanNode left = tree.poll();
            HuffmanNode right = tree.poll();
            HuffmanNode newNode = new HuffmanNode(left.data + right.data, left, right);
            tree.offer(newNode);
        }

        root = tree.poll();
    }

    private void generateCodes(HuffmanNode node, String code) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                encodingMap.put(node.data, code);
            }
            generateCodes(node.left, code + "0");
            generateCodes(node.right, code + "1");
        }
    }

    /**
     * @return encodingMap
     */
    public Map<Character, String> getEncodingMap() {
        return encodingMap;
    }


    public String encode(String input) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : input.toCharArray()) {
            encodedString.append(encodingMap.get(c));
        }
        return encodedString.toString();
    }

    public String decode(String encodedString) {
        StringBuilder decodedString = new StringBuilder();
        HuffmanNode current = root;
        for (int i = 0; i < encodedString.length(); i++) {
            current = (encodedString.charAt(i) == '0') ? current.left : current.right;
            if (current.left == null && current.right == null) {
                decodedString.append(current.data);
                current = root;
            }
        }
        return decodedString.toString();
    }


    @Override
    public String toString() {
        return "HuffmanEncoding{" +
                "root=" + root +
                ", encodingMap=" + encodingMap +
                ", frequencies=" + frequencies +
                '}';
    }
}
