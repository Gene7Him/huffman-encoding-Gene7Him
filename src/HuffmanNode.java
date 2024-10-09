package src;

import java.util.PriorityQueue;

/**
 *
 * @author Eugene Faison
 * @version 1.0
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

    char data;
    private double probability;
    HuffmanNode left;
    HuffmanNode right;



    HuffmanNode(char data, double probability) {
        this.data = data;
        this.probability = probability;
    }

    HuffmanNode(double probability, HuffmanNode left, HuffmanNode right) {
        this.probability = probability;
        this.left = left;
        this.right = right;
    }





    @Override
    public int compareTo(HuffmanNode o) {
        return Double.compare(this.probability, o.probability);

    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "data=" + data +
                ", probability=" + probability +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
