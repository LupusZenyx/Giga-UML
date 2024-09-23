public class Waggon {
  private String id;
  private String zielbahnhof;
  public Waggon naechsterWaggon;

  public Waggon(String id, String zielbahnhof) {
    this.id = id;
    this.zielbahnhof = zielbahnhof;
  }

  public String getId() {
    return id;
  }

  public String getZielbahnhof() {
    return zielbahnhof;
  }
}