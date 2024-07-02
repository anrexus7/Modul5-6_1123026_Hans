package Controller;

import Model.Class.DataPenduduk;
import Model.Class.DatabaseHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.TimeZone;

public class SavingData {
    public SavingData() {
    }

    public boolean insertValueToDB(Map<String, Object> allInput) {

        DataPenduduk tempData = Temporary.temp(allInput);

        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();

        String query = "INSERT INTO data_penduduk VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

            stmt.setString(1,null);
            stmt.setString(2, tempData.getNIK());
            stmt.setString(3, tempData.getNama());
            stmt.setString(4, tempData.getTempatLahir());
            stmt.setDate(5, new java.sql.Date(tempData.getTanggalLahir().getTime()));
            stmt.setString(6, tempData.getJenisKelamin().toString());
            stmt.setString(7, tempData.getGolDarah().toString());
            stmt.setString(8, tempData.getAlamat());
            stmt.setString(9, tempData.getRtRw());
            stmt.setString(10, tempData.getKelDesa());
            stmt.setString(11, tempData.getKecamatan());
            stmt.setString(12, tempData.getAgama().toString());
            stmt.setString(13, tempData.getStatusPerkawinan().toString());
            stmt.setString(14, tempData.getPekerjaan());
            stmt.setString(15, tempData.getKewarganegaraan());
            stmt.setString(16, tempData.getFoto());
            stmt.setString(17, tempData.getTandaTangan());
            stmt.setString(18, tempData.getBerlakuHingga());
            stmt.setString(19, tempData.getKotaPembuatanKTP());
            stmt.setDate(20, new java.sql.Date(tempData.getTanggalPembuatanKTP().getTime()));

            stmt.executeUpdate();
            conn.disconnect();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return (false);
        }
    }
}
