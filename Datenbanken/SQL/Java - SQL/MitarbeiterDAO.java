import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MitarbeiterDAO {
    public List<Mitarbeiter> getAllMitarbeiter() {
        List<Mitarbeiter> mitarbeiterList = new ArrayList<>();
        String query = "SELECT id, nachname, vorname FROM mitarbeiter";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nachname = resultSet.getString("nachname");
                String vorname = resultSet.getString("vorname");
                Mitarbeiter mitarbeiter = new Mitarbeiter(id, nachname, vorname);
                mitarbeiterList.add(mitarbeiter);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mitarbeiterList;
    }
}
