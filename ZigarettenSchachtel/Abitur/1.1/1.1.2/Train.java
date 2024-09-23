import java.util.ArrayList;
import java.util.List;

public class Train {
  private int id;
  private List<Waggon> waggons;

  public void Zug(int id) {
    this.id = id;
    this.waggons = new ArrayList<>();
  }

  public void anhaengen(Waggon waggon) {
    this.waggons.add(waggon);
  }

  public int getId() {
    return id;
  }

  public List<Waggon> getWaggons() {
    return waggons;
  }
}

