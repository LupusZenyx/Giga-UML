public class Array {
    public Kunde search(Kunde[] array, int kundennummer) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2;

        while (left <= right && array[middle].getKundennummer() != kundennummer) {
            if (array[middle].getKundennummer() < kundennummer) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            middle = (left + right) / 2;
        }

        if (left > right) {
            return null;
        } else {
            return array[middle];
        }
    }
}