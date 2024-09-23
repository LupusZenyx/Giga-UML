public class StationsDaten {

    private double temperatur;
    private double luftfeuchte;
    private double luftdruck;
  
    public StationsDaten() {
      this.temperatur = 0;
      this.luftfeuchte = 0;
      this.luftdruck = 0;
    }
  
    public double getTemperatur(){
      return temperatur;
    }
  
    public void setTemperatur(double temperatur){
      this.temperatur = temperatur;
    }
  
    public double getLuftfeuchte() {
      return luftfeuchte;
    }
  
    public void setLuftfeuchte(double luftfeuchte) {
      this.luftfeuchte = luftfeuchte;
    }
  
    public double getLuftdruck() {
      return luftdruck;
    }
  
    public void setLuftdruck(double luftdruck) {
      this.luftdruck = luftdruck;
    }
}