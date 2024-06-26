package Model.Class;

import Model.Enum.Agama;
import Model.Enum.GolonganDarah;
import Model.Enum.JenisKelamin;
import Model.Enum.StatusPerkawinan;

import java.util.Date;

public class DataPenduduk {
    private String NIK;
    private String nama;
    private String tempatLahir;
    private Date tanggalLahir;
    private JenisKelamin jenisKelamin;
    private GolonganDarah golDarah;
    private String alamat;
    private String rtRw;
    private String kelDesa;
    private String kecamatan;
    private Agama agama;
    private StatusPerkawinan statusPerkawinan;
    private String pekerjaan;
    private String kewarganegaraan;
    private String foto;
    private String tandaTangan;
    private String berlakuHingga;
    private String kotaPembuatanKTP;
    private Date tanggalPembuatanKTP;

    public DataPenduduk() {
    }

    public DataPenduduk(String NIK, String nama, String tempatLahir, Date tanggalLahir, JenisKelamin jenisKelamin, GolonganDarah golDarah, String alamat, String rtRw, String kelDesa, String kecamatan, Agama agama, StatusPerkawinan statusPerkawinan, String pekerjaan, String kewarganegaraan, String foto, String tandaTangan, String berlakuHingga, String kotaPembuatanKTP, Date tanggalPembuatanKTP) {
        this.NIK = NIK;
        this.nama = nama;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.golDarah = golDarah;
        this.alamat = alamat;
        this.rtRw = rtRw;
        this.kelDesa = kelDesa;
        this.kecamatan = kecamatan;
        this.agama = agama;
        this.statusPerkawinan = statusPerkawinan;
        this.pekerjaan = pekerjaan;
        this.kewarganegaraan = kewarganegaraan;
        this.foto = foto;
        this.tandaTangan = tandaTangan;
        this.berlakuHingga = berlakuHingga;
        this.kotaPembuatanKTP = kotaPembuatanKTP;
        this.tanggalPembuatanKTP = tanggalPembuatanKTP;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public GolonganDarah getGolDarah() {
        return golDarah;
    }

    public void setGolDarah(GolonganDarah golDarah) {
        this.golDarah = golDarah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRtRw() {
        return rtRw;
    }

    public void setRtRw(String rtRw) {
        this.rtRw = rtRw;
    }

    public String getKelDesa() {
        return kelDesa;
    }

    public void setKelDesa(String kelDesa) {
        this.kelDesa = kelDesa;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public Agama getAgama() {
        return agama;
    }

    public void setAgama(Agama agama) {
        this.agama = agama;
    }

    public StatusPerkawinan getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(StatusPerkawinan statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTandaTangan() {
        return tandaTangan;
    }

    public void setTandaTangan(String tandaTangan) {
        this.tandaTangan = tandaTangan;
    }

    public String getBerlakuHingga() {
        return berlakuHingga;
    }

    public void setBerlakuHingga(String berlakuHingga) {
        this.berlakuHingga = berlakuHingga;
    }

    public String getKotaPembuatanKTP() {
        return kotaPembuatanKTP;
    }

    public void setKotaPembuatanKTP(String kotaPembuatanKTP) {
        this.kotaPembuatanKTP = kotaPembuatanKTP;
    }

    public Date getTanggalPembuatanKTP() {
        return tanggalPembuatanKTP;
    }

    public void setTanggalPembuatanKTP(Date tanggalPembuatanKTP) {
        this.tanggalPembuatanKTP = tanggalPembuatanKTP;
    }
}
