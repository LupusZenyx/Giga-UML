// import java.util.Scanner;

// public class PasswordValidator {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Bitte geben Sie Ihr Passwort ein: ");
//         String passwort = scanner.nextLine();


//         PasswordValidator validator = new PasswordValidator();
//         PasswordValidationResult result = validator.check(passwort, 8, 12);

//         if (result.isLengthError() || result.isUppercaseError() || result.isLowercaseError() || result.isDigitError() || result.isSpecialCharError()) {
//             System.out.println("Das Passwort enthält folgende Fehler:");

//             if (result.isLengthError()) {
//                 System.out.println(" - Das Passwort muss zwischen 8 und 12 Zeichen lang sein.");
//             }

//             if (result.isUppercaseError()) {
//                 System.out.println(" - Das Passwort muss mindestens einen Großbuchstaben enthalten.");
//             }

//             if (result.isLowercaseError()) {
//                 System.out.println(" - Das Passwort muss mindestens einen Kleinbuchstaben enthalten.");
//             }

//             if (result.isDigitError()) {
//                 System.out.println(" - Das Passwort muss mindestens eine Ziffer enthalten.");
//             }

//             if (result.isSpecialCharError()) {
//                 System.out.println(" - Das Passwort muss mindestens ein Sonderzeichen enthalten.");
//             }
//         } else {
//             System.out.println("Das Passwort ist gültig.");
//         }
//     }
// }
