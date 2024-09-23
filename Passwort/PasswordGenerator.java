// import java.util.Random;
// import java.util.Scanner;

// public class PasswordGenerator {

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Geben Sie den gewünschten Bereich für die Anzahl der Zeichen im Passwort ein (z.B. 8-12): ");
//         String rangeInput = scanner.nextLine();
//         String[] range = rangeInput.split("-");

//         int minLength = Integer.parseInt(range[0]);
//         int maxLength = Integer.parseInt(range[1]);

//         System.out.print("Generiertes Passwort: " + generatePassword(minLength, maxLength));

//         System.out.print("\nGeben Sie ein Passwort ein, um es zu überprüfen: ");
//         String passwordToCheck = scanner.nextLine();

//         String result = checkPassword(passwordToCheck, minLength, maxLength);
//         System.out.println(result);

//         scanner.close();
//     }

//     // Methode zum Generieren eines Passworts
//     public static String generatePassword(int minLength, int maxLength) {
//         String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//         String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
//         String digitChars = "0123456789";
//         String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

//         String allChars = uppercaseChars + lowercaseChars + digitChars + specialChars;

//         Random random = new Random();
//         int passwordLength = random.nextInt(maxLength - minLength + 1) + minLength;

//         StringBuilder password = new StringBuilder();

//         // Check if input is a number password
//         if (passwordToCheck.matches("\\d+")) {
//             password.append(passwordToCheck);
//         } else {
//             // Check if input is a letter-only password
//             if (passwordToCheck.matches("[a-zA-Z]+")) {
//                 password.append(passwordToCheck);
//             } else {
//                 // If input is not a number or letter-only password, generate a random password
//                 password.append(getRandomChar(uppercaseChars, random));
//                 password.append(getRandomChar(lowercaseChars, random));
//                 password.append(getRandomChar(digitChars, random));
//                 password.append(getRandomChar(specialChars, random));

//                 for (int i = 4; i < passwordLength; i++) {
//                     password.append(getRandomChar(allChars, random));
//                 }
//             }
//         }

//         // Mische die Zeichen im Passwort
//         char[] passwordArray = password.toString().toCharArray();
//         for (int i = passwordArray.length - 1; i > 0; i--) {
//             int index = random.nextInt(i + 1);
//             char temp = passwordArray[index];
//             passwordArray[index] = passwordArray[i];
//             passwordArray[i] = temp;
//         }

//         return new String(passwordArray);
//     }

//     // Hilfsmethode, um ein zufälliges Zeichen aus einem Zeichenstring zu erhalten
//     private static char getRandomChar(String characters, Random random) {
//         int index = random.nextInt(characters.length());
//         return characters.charAt(index);
//     }

//     // Methode zum Überprüfen eines Passworts
//     public static String checkPassword(String password, int minLength, int maxLength) {
//         boolean lengthInRange = (password.length() >= minLength) && (password.length() <= maxLength);
//         boolean containsUppercase = !password.equals(password.toLowerCase());
//         boolean containsLowercase = !password.equals(password.toUpperCase());
//         boolean containsDigit = password.matches(".*\\d.*");
//         boolean containsSpecialChar = !password.matches("[a-zA-Z0-9]*");

//         if (lengthInRange && containsUppercase && containsLowercase && containsDigit && containsSpecialChar) {
//             return "Das Passwort erfüllt alle Anforderungen.";
//         } else {
//             StringBuilder message = new StringBuilder("Das Passwort erfüllt nicht alle Anfroderungen");
//         }
