package lab13.prog2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReadAddress {

    private static final Logger LOG = Logger.getLogger(ReadAddress.class.getName());

    public Address getAddress(long id) throws SQLException {
        try (Connection conn = ConnectManager.getConnection()) {
            String query = "SELECT * FROM address WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setLong(1, id);
            ResultSet rs = stat.executeQuery();
            List<Address> addresses = populateAddressList(rs);
            if (addresses.isEmpty()) return null;
            return addresses.getFirst();
        } catch (SQLException e) {
            LOG.warning("SQLException thrown:\n" + e.getMessage());
            throw e;
        }
    }

    private List<Address> populateAddressList(ResultSet rs) throws SQLException {
        List<Address> list = new ArrayList<>();
        long id;
        String street, city, state, zip;
        while (rs.next()) {
            id = rs.getLong("id");
            street = rs.getString("street").trim();
            city = rs.getString("city").trim();
            state = rs.getString("state").trim();
            zip = rs.getString("zip").trim();
            list.add(new Address(id, street, city, state, zip));
        }
        return list;
    }

    public int saveAddress(Address dummy) throws SQLException {
        String sql = "INSERT INTO address (id, street, city, state, zip) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectManager.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setLong(1, dummy.id());
            stat.setString(2, dummy.street());
            stat.setString(3, dummy.city());
            stat.setString(4, dummy.state());
            stat.setString(5, dummy.zip());
            int i = stat.executeUpdate();
            if (i > 0) {
                LOG.info("Save " + dummy.id() + " succesfully!");
            }
            return i;
        } catch (SQLException e) {
            LOG.warning("SQLException thrown:\n" + e.getMessage());
        }
        return -1;
    }
}