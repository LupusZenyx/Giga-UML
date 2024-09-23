public class "aufgabe 3.1" {

    public boolean pruefen(String passwort, int minLength, int maxLength) {
        if (passwort.length() < minLength || passwort.length() > maxLength) {
            return false; // Die Länge des Passworts ist außerhalb des erlaubten Bereichs.
        }

        boolean containsUppercase = false;
        boolean containsLowercase = false;
        boolean containsDigit = false;
        boolean containsSpecialChar = false;

        for (char c : passwort.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsUppercase = true;
            } else if (Character.isLowerCase(c)) {
                containsLowercase = true;
            } else if (Character.isDigit(c)) {
                containsDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                containsSpecialChar = true;
            }
        }

        return containsUppercase && containsLowercase && containsDigit && containsSpecialChar;
    }
}