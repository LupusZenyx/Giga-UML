public class Main {

  public static void main(String[] args) {
    Gleis gleis1 = new Gleis();
    Gleis gleis2 = new Gleis();
    Gleis gleis3 = new Gleis();

    // Add some waggons to the tracks
    gleis2.anhaengen(new Waggon("1", "A"));
    gleis2.anhaengen(new Waggon("2", "B"));
    gleis3.anhaengen(new Waggon("3", "A"));
    gleis3.anhaengen(new Waggon("4", "B"));
    gleis1.anhaengen(new Waggon("5", "C"));
    gleis1.anhaengen(new Waggon("6", "C"));

    // Rearrange the waggons
    WaggonRearranger.rearrangeWagons(gleis1, gleis2, gleis3);

    // Print the contents of the tracks
    System.out.println("Gleis 1:");
    for (Waggon waggon : gleis1.getWaggons()) {
      System.out.println(waggon.getId() + " (" + waggon.getZielbahnhof() + ")");
    }
    System.out.println("Gleis 2:");
    for (Waggon waggon : gleis2.getWaggons()) {
      System.out.println(waggon.getId() + " (" + waggon.getZielbahnhof() + ")");
    }
    System.out.println("Gleis 3:");
    for (Waggon waggon : gleis3.getWaggons()) {
      System.out.println(waggon.getId() + " (" + waggon.getZielbahnhof() + ")");
    }
  }
}