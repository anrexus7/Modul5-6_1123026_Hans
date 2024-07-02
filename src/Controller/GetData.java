package Controller;

import Model.Class.DataPenduduk;
import Model.Class.DatabaseHandler;
import Model.Enum.Agama;
import Model.Enum.GolonganDarah;
import Model.Enum.JenisKelamin;
import Model.Enum.StatusPerkawinan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetData {

    public GetData() {
    }

    public DataPenduduk fetchDataFromDB(String NIK) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "SELECT * FROM data_penduduk WHERE NIK='" + NIK + "'";
        DataPenduduk user = new DataPenduduk();
        user.setNIK(NIK);
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setNama(rs.getString("nama"));
                user.setTempatLahir(rs.getString("tempatLahir"));
                user.setTanggalLahir(rs.getDate("tanggalLahir"));

                switch (rs.getString("jenisKelamin")) {
                    case "PRIA":
                        user.setJenisKelamin(JenisKelamin.PRIA);
                        break;
                    case "WANITA":
                        user.setJenisKelamin(JenisKelamin.WANITA);
                        break;
                }

                switch (rs.getString("golDarah")) {
                    case "A":
                        user.setGolDarah(GolonganDarah.A);
                        break;
                    case "B":
                        user.setGolDarah(GolonganDarah.B);
                        break;
                    case "O":
                        user.setGolDarah(GolonganDarah.O);
                        break;
                    case "AB":
                        user.setGolDarah(GolonganDarah.AB);
                        break;
                }

                user.setAlamat(rs.getString("alamat"));
                user.setRtRw(rs.getString("rtRw"));
                user.setKelDesa(rs.getString("kelDesa"));
                user.setKecamatan(rs.getString("kecamatan"));

                switch (rs.getString("agama")) {
                    case "KRISTEN":
                        user.setAgama(Agama.KRISTEN);
                        break;
                    case "KATOLIK":
                        user.setAgama(Agama.KATOLIK);
                        break;
                    case "BUDHA":
                        user.setAgama(Agama.BUDHA);
                        break;
                    case "HINDU":
                        user.setAgama(Agama.HINDU);
                        break;
                    case "ISLAM":
                        user.setAgama(Agama.ISLAM);
                        break;
                    case "KONGHUCHU":
                        user.setAgama(Agama.KONGHUCHU);
                        break;
                    default:
                        user.setAgama(Agama.KEPERCAYAAN);
                        break;
                }

                switch (rs.getString("statusPerkawinan")) {
                    case "BELUM_MENIKAH":
                        user.setStatusPerkawinan(StatusPerkawinan.BELUM_MENIKAH);
                        break;
                    case "MENIKAH":
                        user.setStatusPerkawinan(StatusPerkawinan.MENIKAH);
                        break;
                    case "JANDA":
                        user.setStatusPerkawinan(StatusPerkawinan.JANDA);
                        break;
                    case "DUDA":
                        user.setStatusPerkawinan(StatusPerkawinan.DUDA);
                        break;
                }

                user.setPekerjaan(rs.getString("pekerjaan"));
                user.setKewarganegaraan(rs.getString("kewarganegaraan"));
                user.setFoto(rs.getString("foto"));
                user.setTandaTangan(rs.getString("tandaTangan"));
                user.setBerlakuHingga(rs.getString("berlakuHingga"));
                user.setKotaPembuatanKTP(rs.getString("kotaPembuatanKTP"));
                user.setTanggalPembuatanKTP(rs.getDate("tanggalPembuatanKTP"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }
}
