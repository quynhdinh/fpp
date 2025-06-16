package lab13.prog2;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReadPerson {

    private static final Logger LOG = Logger.getLogger(ReadPerson.class.getName());

    public Person getPerson(long id) throws SQLException {
        try (Connection conn = ConnectManager.getConnection()) {
            String query = "SELECT * FROM person WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setLong(1, id);
            ResultSet rs = stat.executeQuery();
            List<Person> people = populatePersonList(rs);
            if (people.isEmpty()) return null;
            return people.getFirst();
        } catch (SQLException e) {
            LOG.warning("SQLException thrown:\n" + e.getMessage());
            throw e;
        }
    }

    public List<Person> getPersonList() throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectManager.getConnection();
            String query2 = "SELECT * FROM person";
            PreparedStatement stat = conn.prepareStatement(query2);
            //no need to set parameters now
            ResultSet rs = stat.executeQuery();
            return populatePersonList(rs);
        } catch (SQLException e) {
            //log exception
            LOG.warning("SQLException thrown:\n" + e.getMessage());
            throw e;
        } finally {
            //close connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOG.warning("SQLException thrown when trying to close Connection:\n" + e.getMessage());
                }
            }
        }
    }

    private List<Person> populatePersonList(ResultSet rs) throws SQLException {
        List<Person> list = new ArrayList<>();
        String id, firstName, lastName, ssn;
        while (rs.next()) {
            id = rs.getString("id").trim();
            firstName = rs.getString("firstname").trim();
            lastName = rs.getString("lastname").trim();
            ssn = rs.getString("ssn").trim();
            list.add(new Person(id, firstName, lastName, ssn));
        }
        return list;
    }

    // return the id of this person, -1 if error
    public long savePerson(Person person) throws SQLException {
        long id = System.currentTimeMillis() / 100;
        String sql = "INSERT INTO person (id, firstname, lastname, ssn) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectManager.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setLong(1, id);
            stat.setString(2, person.firstName());
            stat.setString(3, person.lastName());
            stat.setString(4, person.ssn());
            int i = stat.executeUpdate();
            LOG.info("Saved successfully" + i);
            if (i > 0) return id;
        } catch (SQLException e) {
            LOG.warning("SQLException thrown:\n" + e.getMessage());
            throw e;
        }
        return -1;
    }
}