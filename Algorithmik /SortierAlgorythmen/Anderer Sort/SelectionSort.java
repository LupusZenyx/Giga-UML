public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {34, 23, 36, 12, 18, 14};
        selektionssortieren(array);
        System.out.println("Sortiertes Array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void selektionssortieren(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minimalerIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minimalerIndex]) {
                    minimalerIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minimalerIndex];
            array[minimalerIndex] = temp;
        }
    }
}