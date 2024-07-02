package Controller;

import Model.Class.DataPenduduk;
import Model.Enum.Agama;
import Model.Enum.GolonganDarah;
import Model.Enum.JenisKelamin;
import Model.Enum.StatusPerkawinan;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Date;
import java.util.Map;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Temporary {
    public static DataPenduduk temp(Map<String, Object> allInput){
        DataPenduduk tempData = new DataPenduduk();

        tempData.setNIK((String) allInput.get("nik"));
        tempData.setNama((String) allInput.get("nama"));
        tempData.setTempatLahir((String) allInput.get("tempatLahir"));

        tempData.setTanggalLahir((Date) allInput.get("tanggalLahir"));

        if (allInput.get("gender").equals("PRIA")) {
            tempData.setJenisKelamin(JenisKelamin.PRIA);
        } else {
            tempData.setJenisKelamin(JenisKelamin.WANITA);
        }

        if (allInput.get("golDar").equals("A")) {
            tempData.setGolDarah(GolonganDarah.A);
        }else if(allInput.get("golDar").equals("B")){
            tempData.setGolDarah(GolonganDarah.B);
        }else if(allInput.get("golDar").equals("AB")){
            tempData.setGolDarah(GolonganDarah.AB);
        }else {
            tempData.setGolDarah(GolonganDarah.O);
        }

        tempData.setAlamat((String) allInput.get("alamat"));
        tempData.setRtRw((String) allInput.get("rtRw"));
        tempData.setKelDesa((String) allInput.get("kelDesa"));
        tempData.setKecamatan((String) allInput.get("kecamatan"));

        if(allInput.get("agama").equals("KRISTEN")){
            tempData.setAgama(Agama.KRISTEN);
        }else if(allInput.get("agama").equals("KATOLIK")){
            tempData.setAgama(Agama.KATOLIK);
        }else if(allInput.get("agama").equals("BUDHA")){
            tempData.setAgama(Agama.BUDHA);
        }else if(allInput.get("agama").equals("HINDU")){
            tempData.setAgama(Agama.HINDU);
        }else if(allInput.get("agama").equals("ISLAM")){
            tempData.setAgama(Agama.ISLAM);
        }else if(allInput.get("agama").equals("KONGHUCHU")){
            tempData.setAgama(Agama.KONGHUCHU);
        }else{
            tempData.setAgama(Agama.KEPERCAYAAN);
        }

        if(allInput.get("statusKawin").equals("MENIKAH")){
            tempData.setStatusPerkawinan(StatusPerkawinan.MENIKAH);
        }else if(allInput.get("statusKawin").equals("JANDA")){
            tempData.setStatusPerkawinan(StatusPerkawinan.JANDA);
        }else if(allInput.get("statusKawin").equals("DUDA")){
            tempData.setStatusPerkawinan(StatusPerkawinan.DUDA);
        }else {
            tempData.setStatusPerkawinan(StatusPerkawinan.BELUM_MENIKAH);
        }

        tempData.setPekerjaan((String) allInput.get("pekerjaan"));

        tempData.setKewarganegaraan(allInput.get("kewarganegaraan").toString()+" "+allInput.get("additionalWNA"));

        File foto = (File) allInput.get("fileFoto");
        moveFile(foto);
        tempData.setFoto(foto.getName());

        File tandaTangan = (File) allInput.get("fileTandaTangan");
        moveFile(tandaTangan);
        tempData.setTandaTangan(tandaTangan.getName());

        tempData.setBerlakuHingga("Seumur Hidup");
        tempData.setKotaPembuatanKTP((String) allInput.get("kotaPembuatanKtp"));
        tempData.setTanggalPembuatanKTP((Date) allInput.get("tanggalPembuatanKTP"));

        return tempData;
    }

    private static void moveFile(File file){
        Path sourcePath = file.toPath();
        Path targetPath = Paths.get("C:\\Kuliah\\semester pendek (2 ke 3)\\OOP\\Modul5dan6_1123026_Hans\\src\\img", file.getName());
        try {
            Files.copy(sourcePath, targetPath, REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
