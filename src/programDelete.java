import db.DB;
import db.DbExeption;
import db.DbIntegrityExeception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class programDelete {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM Department "
                        +"WHERE "
                        +"(Id = ?)");

            st.setInt(1, 4);

            int rowsAffected = st.executeUpdate();

            System.out.println("Rows affected: " + rowsAffected);
        }
        catch (SQLException e) {
            throw new DbIntegrityExeception(e.getMessage());
        }
            finally {
                DB.closeStatement(st);
                DB.closeConnection();
            }
    }
}
