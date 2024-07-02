package Controller;

import Model.Class.DatabaseHandler;

import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData{
    public boolean DeleteDataFromDB(String NIK){
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();

        String query = "DELETE FROM data_penduduk WHERE NIK='" + NIK + "'";
        try {
            Statement stmt = conn.con.createStatement();
            int check = stmt.executeUpdate(query);
            conn.disconnect();

            if(check==0){
                return (false);
            }
            return (true);

        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return (false);
        }
    }
}
