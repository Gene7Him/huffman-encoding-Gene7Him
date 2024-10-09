package src;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author Eugene Faison
 * @version 1.0
 */
public class HuffmanTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Huffman Encoding!");
        System.out.print("Please enter a string to encode: ");
        String input = scanner.nextLine();

        // Step 1: Analyze character frequencies
        Map<Character, Integer> frequencyMap = calculateFrequency(input);
        System.out.println("\nCharacter Frequencies:");
        printFrequency(frequencyMap);

        // Step 2: Build Huffman Tree and generate codes
        HuffmanEncoding huffmanTree = new HuffmanEncoding(frequencyMap);
        Map<Character, String> huffmanCodes = huffmanTree.getEncodingMap();
        System.out.println("\nHuffman Codes:");
        printCodes(huffmanCodes);

        // Step 3: Encode the input string
        String encodedString = huffmanTree.encode(input);
        System.out.println("\nEncoded String: " + encodedString);

        // Step 4: Decode the encoded string
        String decodedString = huffmanTree.decode(encodedString);
        System.out.println("Decoded String: " + decodedString);

        // Step 5: Calculate and display bit savings
        int originalBits = input.length() * 8; // Assuming 8-bit ASCII encoding
        int encodedBits = encodedString.length();
        System.out.println("\nOriginal size: " + originalBits + " bits");
        System.out.println("Encoded size: " + encodedBits + " bits");
        System.out.println("Space saved: " + (originalBits - encodedBits) + " bits");
    }

    private static Map<Character, Integer> calculateFrequency(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    private static void printFrequency(Map<Character, Integer> frequencyMap) {
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
    }

    private static void printCodes(Map<Character, String> huffmanCodes) {
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
    }
}
