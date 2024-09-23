import java.util.List;

public class Main {
    public static void main(String[] args) {
        MitarbeiterDAO mitarbeiterDAO = new MitarbeiterDAO();
        List<Mitarbeiter> mitarbeiterList = mitarbeiterDAO.getAllMitarbeiter();

        for (Mitarbeiter mitarbeiter : mitarbeiterList) {
            System.out.println(mitarbeiter);
        }
    }
}
