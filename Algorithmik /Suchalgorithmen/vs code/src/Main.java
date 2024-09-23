public class Main {
    public static void main(String[] args) {
        SearchArray searchArray = new SearchArray();
        int[] zahlen = new int[]{112, 131, 140, 199, 201, 209, 332, 345, 588, 666, 723, 799, 810, 889, 899};
        System.out.println("Value: 666");
        System.out.println("Place: " + searchArray.search(zahlen, 666) + " (Number: " + zahlen[searchArray.search(zahlen, 666)] + ")");
        System.out.println("Value 889");
        System.out.println("Place: " + searchArray.search(zahlen, 889) + " (Number: " + zahlen[searchArray.search(zahlen, 889)] + ")");
        System.out.println("Value 899");
        System.out.println("Place: " + searchArray.search(zahlen, 899) + " (Number: " + zahlen[searchArray.search(zahlen, 899)] + ")");
        System.out.println("Value 112");
        System.out.println("Place: " + searchArray.search(zahlen, 112) + " (Number: " + zahlen[searchArray.search(zahlen, 112)] + ")");
        System.out.println("Value 10");
        System.out.println("Place: " + searchArray.search(zahlen, 10) + " (Expected: -1)");
    }
}