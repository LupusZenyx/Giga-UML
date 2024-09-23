public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.erzeugenTestliste();
        shop.ausgebenErsterTestliste();
        shop.ausgebenLetzterTestliste();

        shop.bestellen(4711, 100);
        shop.bestellen(4766, 200);

        System.out.println(shop.getUmsatz()); // Gibt 300 zurück
    }
}
