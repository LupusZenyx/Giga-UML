import java.util.ArrayList;
public class Kunde {

    public static void main(String[] args) {
        List<Kunde> kunden = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            kunden.add(new Kunde(i));
        }

        System.out.println("Unsortierte Kunden:");
        System.out.println(kunden);

        bubbleSort(kunden);
        
        System.out.println("Sortierte Kunden:");
        System.out.println(kunden);

    }
    

    private static void bubbleSort(List<Kunde> kunden) {
        boolean aufsteigend = true;
        for (int i = kunden.size() - 1; i >= 0; i--) {
            boolean getauscht = false;
            for (int j = 0; j < i; j++) {
                if (aufsteigend = true){
                    if (kunden.get(j).getKundenId() > kunden.get(j + 1).getKundenId()) {
                        Kunde temp = kunden.get(j);
                        kunden.set(j, kunden.get(j + 1));
                        kunden.set(j + 1, temp);
                        getauscht = true;
                    }
                } else if (aufsteigend = false){
                    if (kunden.get(j).getKundenId() < kunden.get(j + 1).getKundenId()) {
                        Kunde temp = kunden.get(j);
                        kunden.set(j, kunden.get(j + 1));
                        kunden.set(j + 1, temp);
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