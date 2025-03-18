import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class HashtableExperiment {

    private static int linearCount = 0;
    private static int doubleCount = 0;
    public static void main(String[] args) {

        // Check usage is correct
        if (args.length < 2 || args.length > 3) {
            System.err.println("Usage: java Hashtable Experiment <dataSource> <loadFactor> [<debugLevel>]");
            return;
        }

        // Get arguments 
        int dataSource = Integer.parseInt(args[0]);
        double loadFactor = Double.parseDouble(args[1]);
        int debugLevel;

        if (args.length == 3) {
            debugLevel = Integer.parseInt(args[2]);
        } else {
            debugLevel = 0;
        }
        
        int tableCapacity = (int) Math.ceil(TwinPrimeGenerator.generateTwinPrime(95500, 96000));
        LinearProbing linearProbing = new LinearProbing(tableCapacity, loadFactor);
        DoubleHashing doubleHashing = new DoubleHashing(tableCapacity, loadFactor);

        if (dataSource == 1) {
            insertRandomNumbers(linearProbing, doubleHashing, loadFactor);
        } else if (dataSource == 2) {
            insertDates(linearProbing, doubleHashing, loadFactor);
        } else {
            insertWordList(linearProbing, doubleHashing, loadFactor);
        }

        String source = "";
        //int linearCount = 0;
        //int doubleCount = 0;
        int index = 0;

        // Handle debug levels
        if (debugLevel == 0) {
            System.out.println("\nHashtableExperiment: Found a twin prime table capacity: " + TwinPrimeGenerator.generateTwinPrime(95500,96000));
            System.out.println("HashtableExperiment: Input: " + source + "   Load Factor: " + loadFactor);
            System.out.println("    Using Linear Probing");
            System.out.println("HashtableExperiment: size of hash table is " + (int)Math.ceil(TwinPrimeGenerator.generateTwinPrime(95500, 96000) * loadFactor));
            System.out.println("Inserted " + linearCount + " elements, of which " + (linearCount - linearProbing.size) + " were duplicates");
            System.out.println("Avg. no. of probes = " + String.format("%.2f", linearProbing.avgProbes()));
            System.out.println("\n    Using Double Hashing");
            System.out.println("HashtableExperiment: size of hash table is " + (int)Math.ceil(TwinPrimeGenerator.generateTwinPrime(95500, 96000) * loadFactor));
            System.out.println("Inserted " + doubleCount + " elements, of which " + (doubleCount - doubleHashing.size) + " were duplicates");
            System.out.println("Avg. no. of probes = " + String.format("%.2f", doubleHashing.avgProbes()));

        } else if (debugLevel == 1) {
            // Save hash tables to files and print console info
            try {
                linearProbing.dumpToFile("linear-dump.txt");
                doubleHashing.dumpToFile("double-dump.txt");
                System.out.println("\nHashtableExperiment: Found a twin prime table capacity: " + TwinPrimeGenerator.generateTwinPrime(95500,96000));
                System.out.println("HashtableExperiment: Input: " + source + "   Load Factor: " + loadFactor);
                System.out.println("    Using Linear Probing");
                System.out.println("HashtableExperiment: size of hash table is " + (int)Math.ceil(TwinPrimeGenerator.generateTwinPrime(95500, 96000) * loadFactor));
                System.out.println("Inserted " + linearCount + " elements, of which " + (linearCount - linearProbing.size) + " were duplicates");
                System.out.println("Avg. no. of probes = " + String.format("%.2f", linearProbing.avgProbes()));
                System.out.println("HashtableExperiment: Saved dump of hash table");
                System.out.println("\n    Using Double Hashing");
                System.out.println("HashtableExperiment: size of hash table is " + (int)Math.ceil(TwinPrimeGenerator.generateTwinPrime(95500, 96000) * loadFactor));
                System.out.println("Inserted " + doubleCount + " elements, of which " + (doubleCount - doubleHashing.size) + " were duplicates");
                System.out.println("Avg. no. of probes = " + String.format("%.2f", doubleHashing.avgProbes()));
                System.out.println("HashtableExperiment: Saved dump of hash table");
            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found.");
                e.printStackTrace();
            }
        } else if (debugLevel == 2) {
            // Print each element and it's info to the console
            for (HashObject obj : linearProbing.table) {
                if (obj != null) {
                    System.out.println("table[" + index + "]: " + obj.toString());
                }
                index++;
            }
            
        }

    }

    /**
     * Inserts random numbers into the given hash tables (linear probing and double hashing)
     * until both tables reach the load factor. 
     * @param linearProbing LinearProbing hash table to insert random numbers into.
     * @param doubleHashing DoubleHashing hash table to insert random numbers into.
     * @param loadFactor The load factor determines when to stop inserting
     */
    private static void insertRandomNumbers(LinearProbing linearProbing, DoubleHashing doubleHashing,double loadFactor) {
        Random random = new Random();
    
        while (((double)linearProbing.getSize() / linearProbing.capacity) < loadFactor || ((double)doubleHashing.getSize() / doubleHashing.capacity) < loadFactor) {
            int randomNum = random.nextInt();

            if (((double) linearProbing.getSize() / linearProbing.capacity) < loadFactor) {
                linearProbing.insert(randomNum);
                linearCount++;
            }
    
            if (((double) doubleHashing.getSize() / doubleHashing.capacity) < loadFactor) {
                doubleHashing.insert(randomNum);
                doubleCount++;
            }
        }
    }
    
    /**
     * Inserts dates into the given hash tables (linear probing and double hashing)
     * until both tables reach the load factor. 
     * @param linearProbing LinearProbing hash table to insert dates into.
     * @param doubleHashing DoubleHashing hash table to insert dates into.
     * @param loadFactor The load factor determines when to stop inserting
     */
    private static void insertDates(LinearProbing linearProbing, DoubleHashing doubleHashing,double loadFactor) {
        long current = new Date().getTime();
    
        while (((double)linearProbing.getSize() / linearProbing.capacity) < loadFactor || ((double)doubleHashing.getSize() / doubleHashing.capacity) < loadFactor) {
            current += 1000;
            Date date = new Date(current);

            if (((double) linearProbing.getSize() / linearProbing.capacity) < loadFactor) {
                linearProbing.insert(date);
                linearCount++;
            }
    
            if (((double) doubleHashing.getSize() / doubleHashing.capacity) < loadFactor) {
                doubleHashing.insert(date);
                doubleCount++;
            }
        }
    }
    
    /**
     * Inserts a word list into the given hash tables (linear probing and double hashing)
     * until both tables reach the load factor. 
     * @param linearProbing LinearProbing hash table to insert word list into.
     * @param doubleHashing DoubleHashing hash table to insert word list into.
     * @param loadFactor The load factor determines when to stop inserting
     */
    private static void insertWordList(LinearProbing linearProbing, DoubleHashing doubleHashing, double loadFactor) {
        List<String> wordList = new ArrayList<>();
    
    
        try (BufferedReader reader = new BufferedReader(new FileReader("word-list.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // 
        for (String word : wordList) {
    
            if (((double) linearProbing.getSize() / linearProbing.capacity) < loadFactor) {
                linearProbing.insert(word);
                linearCount++;
            }
    
            if (((double) doubleHashing.getSize() / doubleHashing.capacity) < loadFactor) {
                doubleHashing.insert(word);
                doubleCount++;
            }
        }
    }
}





