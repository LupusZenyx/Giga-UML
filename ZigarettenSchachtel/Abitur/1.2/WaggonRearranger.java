import java.util.Stack;

public class WaggonRearranger {

  public static void rearrangeWagons(Gleis gleis1, Gleis gleis2, Gleis gleis3) {
    Stack<Waggon> waggonStack = new Stack<>();

    // Add all waggons from track 2 and 3 to the stack
    for (Waggon waggon : gleis2.getWaggons()) {
      waggonStack.push(waggon);
    }
    for (Waggon waggon : gleis3.getWaggons()) {
      waggonStack.push(waggon);
    }
    for (Waggon waggon : gleis1.getWaggons()){
      waggonStack.push(waggon);
    }

    // Clear the tracks 2 and 3
    gleis2.getWaggons().clear();
    gleis3.getWaggons().clear();
    gleis1.getWaggons().clear();

    // While the stack is not empty, add the waggons to the corresponding tracks
    while (!waggonStack.isEmpty()) {
      Waggon waggon = waggonStack.pop();
      if (waggon.getZielbahnhof().equals("A")) {
        gleis1.anhaengen(waggon);
      } else if (waggon.getZielbahnhof().equals("B")) {
        gleis2.anhaengen(waggon);
      } else if (waggon.getZielbahnhof().equals("C")) {
        gleis3.anhaengen(waggon);
      }
    }
  }
}