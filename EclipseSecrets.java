import java.util.Scanner;

public class EclipseSecrets {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SECRET_ALPHABET = "QWERTYUIOPASDFGHJKLZXCVBNM";

    public static String encrypt(String message) {
        message = message.toUpperCase();
        StringBuilder encryptedMessage = new StringBuilder();

        for (char letter : message.toCharArray()) {
            if (ALPHABET.contains(String.valueOf(letter))) {
                int index = ALPHABET.indexOf(letter);
                encryptedMessage.append(SECRET_ALPHABET.charAt(index));
            } else {
                encryptedMessage.append(letter);
            }
        }

        return encryptedMessage.toString();
    }

    public static String decrypt(String encryptedMessage) {
        encryptedMessage = encryptedMessage.toUpperCase();
        StringBuilder decryptedMessage = new StringBuilder();

        for (char letter : encryptedMessage.toCharArray()) {
            if (SECRET_ALPHABET.contains(String.valueOf(letter))) {
                int index = SECRET_ALPHABET.indexOf(letter);
                decryptedMessage.append(ALPHABET.charAt(index));
            } else {
                decryptedMessage.append(letter);
            }
        }

        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to EclipseSecrets!");
        System.out.println("1. Encrypt a message");
        System.out.println("2. Decrypt a message");
        System.out.print("Enter your choice (1/2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.print("Enter the message to encrypt: ");
            String message = scanner.nextLine();
            String encryptedMessage = encrypt(message);
            System.out.println("Encrypted message: " + encryptedMessage);
        } else if (choice == 2) {
            System.out.print("Enter the message to decrypt: ");
            String encryptedMessage = scanner.nextLine();
            String decryptedMessage = decrypt(encryptedMessage);
            System.out.println("Decrypted message: " + decryptedMessage);
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }
}
