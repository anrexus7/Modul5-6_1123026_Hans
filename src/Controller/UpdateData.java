package Controller;

import Model.Class.DataPenduduk;
import Model.Class.DatabaseHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class UpdateData {

    public boolean updateValueToDB(Map<String, Object> allInput) {
        DataPenduduk tempData = Temporary.temp(allInput);
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();

        String query = "UPDATE data_penduduk SET "
                + "nama = ?, "
                + "tempatLahir = ?, "
                + "tanggalLahir = ?, "
                + "jenisKelamin = ?, "
                + "golDarah = ?, "
                + "alamat = ?, "
                + "rtRw = ?, "
                + "kelDesa = ?, "
                + "kecamatan = ?, "
                + "agama = ?, "
                + "statusPerkawinan = ?, "
                + "pekerjaan = ?, "
                + "kewarganegaraan = ?, "
                + "foto = ?, "
                + "tandaTangan = ?, "
                + "berlakuHingga = ?, "
                + "kotaPembuatanKTP = ?, "
                + "tanggalPembuatanKTP = ? "
                + "WHERE NIK = ?";

        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, tempData.getNama());
            stmt.setString(2, tempData.getTempatLahir());
            stmt.setDate(3, new java.sql.Date(tempData.getTanggalLahir().getTime()));
            stmt.setString(4, tempData.getJenisKelamin().toString());
            stmt.setString(5, tempData.getGolDarah().toString());
            stmt.setString(6, tempData.getAlamat());
            stmt.setString(7, tempData.getRtRw());
            stmt.setString(8, tempData.getKelDesa());
            stmt.setString(9, tempData.getKecamatan());
            stmt.setString(10, tempData.getAgama().toString());
            stmt.setString(11, tempData.getStatusPerkawinan().toString());
            stmt.setString(12, tempData.getPekerjaan());
            stmt.setString(13, tempData.getKewarganegaraan());
            stmt.setString(14, tempData.getFoto());
            stmt.setString(15, tempData.getTandaTangan());
            stmt.setString(16, tempData.getBerlakuHingga());
            stmt.setString(17, tempData.getKotaPembuatanKTP());
            stmt.setDate(18, new java.sql.Date(tempData.getTanggalPembuatanKTP().getTime()));
            stmt.setString(19, tempData.getNIK());

            stmt.executeUpdate();
            conn.disconnect();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
