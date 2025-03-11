public class TwinPrimeGenerator {

    private static boolean isPrime(int num) {
        // Greater than 1
        if (num <= 1) {
            return false;
        }

        // Loop checks if it has any divisors
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int generateTwinPrime(int min, int max) {
        for (int i = min; i <= max - 2; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                return i + 2; // Primes found, gives the larger one
            }
        }
        return -1; // No twin prime
    }

    public static void main(String[] args) {
        int min = 95500;
        int max = 96000;

        int twinPrime = generateTwinPrime(min, max);
        if (twinPrime != -1) {
            System.out.println(twinPrime);
        } else {
            System.out.println("No twin prime found.");
        }
    }
}