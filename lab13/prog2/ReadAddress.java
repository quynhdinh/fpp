package lab13.prog2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadAddress {

    private String query = "SELECT * FROM address WHERE id = ?";

    public Address getAddress(int id) throws SQLException {
        try (Connection conn = ConnectManager.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            return populateAddressList(rs).get(0);
        } catch (SQLException e) {
//            LOG.warning("SQLException thrown:\n" + e.getMessage());
            throw e;
        }
    }

    private List<Address> populateAddressList(ResultSet rs) throws SQLException {
        List<Address> list = new ArrayList<>();
        String id, street, city, state, zip;
        while (rs.next()) {
            id = rs.getString("id").trim();
            street = rs.getString("street").trim();
            city = rs.getString("city").trim();
            state = rs.getString("state").trim();
            zip = rs.getString("zip").trim();
            list.add(new Address(id, street, city, state, zip));
        }
        return list;
    }

}