import java.util.ArrayList;
import java.util.List;

public class Gleis {
  private List<Waggon> waggons;

  public Gleis() {
    this.waggons = new ArrayList<>();
  }

  public void anhaengen(Waggon waggon) {
    this.waggons.add(waggon);
  }

  public List<Waggon> getWaggons() {
    return waggons;
  }

public void abstellen(Waggon waggon) {
}

public void entnehmen() {
}

public boolean isEmpty() {
    return false;
}
}