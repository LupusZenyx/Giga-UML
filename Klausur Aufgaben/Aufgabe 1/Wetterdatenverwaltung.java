public class Wetterdatenverwaltung {

    public static double suchenMaxTemperatur(double[][] datenTabelle) {
      double maxTemperatur = Double.MAX_VALUE;
      for (int i = 0; i < datenTabelle.length; i++) {
        double temperatur = datenTabelle[i][0];
        if (temperatur > maxTemperatur) {
          maxTemperatur = temperatur;
        }
      }
           return maxTemperatur;
    }
  
    public static StationsDaten suchenStationsDaten(double[][] datenTabelle, int stationsNummer) {
      StationsDaten stationsDaten = new StationsDaten();
      for (int i = 0; i < datenTabelle.length; i++) {
        if (datenTabelle[i][0] == stationsNummer) {
          stationsDaten.setTemperatur(datenTabelle[i][1]);
          stationsDaten.setLuftfeuchte(datenTabelle[i][2]);
          stationsDaten.setLuftdruck(datenTabelle[i][3]);
          break;
        }
      }
      return stationsDaten;
    }
  
    public static void main(String[] args) {
      double[][] datenTabelle = {
        {11,2, 45, 995},
        {11,9, 45, 1005},
        {11,5, 42, 995}
      };
  
      double maxTemperatur = suchenMaxTemperatur(datenTabelle);
      System.out.println("Die höchste Temperatur beträgt " + maxTemperatur + " Grad Celsius.");
  
      StationsDaten stationsDaten = suchenStationsDaten(datenTabelle, 2);
      System.out.println("Die Daten der Messstation 2 sind:");
      System.out.println("Temperatur: " + stationsDaten.getTemperatur());
      System.out.println("Luftfeuchte: " + stationsDaten.getLuftfeuchte());
      System.out.println("Luftdruck: " + stationsDaten.getLuftdruck());
    }
  }