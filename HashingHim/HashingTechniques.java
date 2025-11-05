package dsaPracs;

import java.util.*;

public class HashingTechniques {

    static int mod = 10;

    // Linear probing for collision resolution
    static void linearProbe(Integer[] table, int key, int hash) {
        int size = table.length;
        while (table[hash] != null) {
            hash = (hash + 1) % size;
        }
        table[hash] = key;
    }

    // Hashing using Modulo Division method
    static Integer[] moduloDivision(int[] keys) {
        Integer[] table = new Integer[mod];
        for (int key : keys) {
            int h = key % mod;
            linearProbe(table, key, h);
        }
        return table;
    }

    // Hashing using Digit Extraction method
    static Integer[] digitExtraction(int[] keys) {
        Integer[] table = new Integer[mod];
        for (int key : keys) {
            String s = String.valueOf(key);
            int first = Character.getNumericValue(s.charAt(0));
            int last = Character.getNumericValue(s.charAt(s.length() - 1));
            int h = (first + last) % mod;
            linearProbe(table, key, h);
        }
        return table;
    }

    // Hashing using Fold Shift method
    static Integer[] foldShift(int[] keys) {
        Integer[] table = new Integer[mod];
        for (int key : keys) {
            String s = String.valueOf(key);
            int sum = 0;
            for (int i = 0; i < s.length(); i += 2) {
                String part = s.substring(i, Math.min(i + 2, s.length()));
                sum += Integer.parseInt(part);
            }
            int h = sum % mod;
            linearProbe(table, key, h);
        }
        return table;
    }

    // Hashing using Fold Boundary method
    static Integer[] foldBoundary(int[] keys) {
        Integer[] table = new Integer[mod];
        for (int key : keys) {
            String s = String.valueOf(key);
            int sum = 0;
            for (int i = 0; i < s.length(); i += 2) {
                String part = s.substring(i, Math.min(i + 2, s.length()));
                // Reverse every alternate block
                if ((i / 2) % 2 == 1) {
                    part = new StringBuilder(part).reverse().toString();
                }
                sum += Integer.parseInt(part);
            }
            int h = sum % mod;
            linearProbe(table, key, h);
        }
        return table;
    }

    // Print formatted hash table output
    static void printTable(String name, Integer[] table) {
        System.out.println(name + ": " + Arrays.toString(table));
    }

    // Main driver
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keys separated by space: ");
        String[] input = sc.nextLine().split(" ");

        int[] keys = Arrays.stream(input)
                           .mapToInt(Integer::parseInt)
                           .toArray();

        System.out.println("\n====== HASHING TECHNIQUES OUTPUT ======");
        printTable("Modulo Division", moduloDivision(keys));
        printTable("Digit Extraction", digitExtraction(keys));
        printTable("Fold Shift", foldShift(keys));
        printTable("Fold Boundary", foldBoundary(keys));

        sc.close();
    }
}
