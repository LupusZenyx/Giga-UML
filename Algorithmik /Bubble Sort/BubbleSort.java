import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] zahlen = new int[10];
        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = (int) (Math.random() * 100);
        }

        System.out.println("Unsortiertes Array:");
        System.out.println(Arrays.toString(zahlen));

        bubbleSort(zahlen);
        
        System.out.println("Sortiertes Array:");
        System.out.println(Arrays.toString(zahlen));

    }
    

    private static void bubbleSort(int[] zahlen) {
        boolean aufsteigend = true;
        for (int i = zahlen.length - 1; i >= 0; i--) {
            boolean getauscht = false;
            for (int j = 0; j < i; j++) {
                if (aufsteigend = true){
                    if (zahlen[j] > zahlen[j + 1]) {
                        int temp = zahlen[j];
                        zahlen[j] = zahlen[j + 1];
                        zahlen[j + 1] = temp;
                        getauscht = true;
                    }
                } else if (aufsteigend = false){
                    if (zahlen[j] < zahlen[j + 1]) {
                        int temp = zahlen[j];
                        zahlen[j] = zahlen[j + 1];
                        zahlen[j + 1] = temp;
                        getauscht = true;
                    } else {
                        System.out.println("sort direction could not be defined");
                        getauscht = false;
                        }
                }
            }
            if (getauscht == false){
                break;
            }
            getauscht = false;
        }
    }
}