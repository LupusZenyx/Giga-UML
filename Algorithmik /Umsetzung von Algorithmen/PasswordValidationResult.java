// public class PasswordValidationResult {
//     private boolean lengthError;
//     private boolean uppercaseError;
//     private boolean lowercaseError;
//     private boolean digitError;
//     private boolean specialCharError;

//     // Getter und Setter für die verschiedenen Fehler

//     public void setLengthError(boolean lengthError) {
//         this.lengthError = lengthError;
//     }

//     public void setUppercaseError(boolean uppercaseError) {
//         this.uppercaseError = uppercaseError;
//     }

//     public void setLowercaseError(boolean lowercaseError) {
//         this.lowercaseError = lowercaseError;
//     }

//     public void setDigitError(boolean digitError) {
//         this.digitError = digitError;
//     }

//     public void setSpecialCharError(boolean specialCharError) {
//         this.specialCharError = specialCharError;
//     }

//     public PasswordValidationResult pruefen(String passwort, int minLength, int maxLength) {
    
//         PasswordValidationResult result = new PasswordValidationResult();

//         if (passwort.length() < minLength || passwort.length() > maxLength) {
//             result.setLengthError(true);
//         }

//         boolean containsUppercase = false;
//         boolean containsLowercase = false;
//         boolean containsDigit = false;
//         boolean containsSpecialChar = false;

//         for (char c : passwort.toCharArray()) {
//             if (Character.isUpperCase(c)) {
//                 containsUppercase = true;
//             } else if (Character.isLowerCase(c)) {
//                 containsLowercase = true;
//             } else if (Character.isDigit(c)) {
//                 containsDigit = true;
//             } else if (!Character.isLetterOrDigit(c)) {
//                 containsSpecialChar = true;
//             }
//         }

//         result.setUppercaseError(!containsUppercase);
//         result.setLowercaseError(!containsLowercase);
//         result.setDigitError(!containsDigit);
//         result.setSpecialCharError(!containsSpecialChar);

//         return result;
// }}

