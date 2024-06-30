package View;

import Model.Class.DataPenduduk;

import javax.swing.*;
import java.awt.*;

public class HasilKTP extends JFrame {
    public HasilKTP(DataPenduduk showData) {
        initComponents(showData);
    }

    private void initComponents(DataPenduduk showData) {
        this.setTitle("Hasil Rekaman");
        this.setBounds(400, 200, 1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel container = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);// Top, left, bottom, right padding
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        container.add(createLeftLayout(showData));
        this.setVisible(true);
    }

    private JPanel createLeftLayout(DataPenduduk showData){
        JPanel leftContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbcL = new GridBagConstraints();
        gbcL.insets = new Insets(10, 10, 10, 10);// Top, left, bottom, right padding
        gbcL.anchor = GridBagConstraints.WEST;

        gbcL.gridx = 0;
        gbcL.gridy = 0;
        leftContainer.add(createShowTextPanel(showData.getNIK(), "NIK : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getNama(), "Nama : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getTempatLahir()+", "+showData.getTanggalLahir(), "Tempat/Tgl Lahir : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getJenisKelamin().name(), "Jenis Kelamin : "), gbcL);

        gbcL.gridx++;
        leftContainer.add(createShowTextPanel(showData.getGolDarah().name(), "Gol. Darah : "), gbcL);

        gbcL.gridx--;
        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getAlamat(), "Alamat : "), gbcL);

        gbcL.gridy++;
        gbcL.insets = new Insets(10, 40, 10, 10);
        leftContainer.add(createShowTextPanel(showData.getRtRw(), "RT/RW : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getKelDesa(), "Kel/Desa : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getKecamatan(), "Kecamatan : "), gbcL);

        gbcL.gridy++;
        gbcL.insets = new Insets(10, 10, 10, 10);
        leftContainer.add(createShowTextPanel(showData.getAgama().name(), "Agama : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getStatusPerkawinan().name(), "Status Perkawinan : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getPekerjaan(), "Pekerjaan : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getKewarganegaraan(), "Kewarganegaraan : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getBerlakuHingga(), "Berlaku Hingga : "), gbcL);

        return leftContainer;
    }

    private JPanel createrightLayout(DataPenduduk showData) {
        JPanel rightContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbcR = new GridBagConstraints();
        gbcR.insets = new Insets(10, 10, 10, 10);// Top, left, bottom, right padding
        gbcR.anchor = GridBagConstraints.CENTER;

        gbcR.gridx = 0;
        gbcR.gridy = 0;
        rightContainer.add(createShowTextPanel(showData.getKotaPembuatanKTP(), ""), gbcR);

        gbcR.gridy++;
        rightContainer.add(createShowTextPanel(String.valueOf(showData.getTanggalPembuatanKTP()), ""), gbcR);

        return rightContainer;
    }

    private JPanel createPanel(String labelText) {
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(labelText);
        panel.add(label);

        return panel;
    }

    private JPanel createShowTextPanel(String field, String labelText) {
        JPanel panel;
        JTextArea textArea = new JTextArea(field);

        if(labelText.equals("")){
            panel = new JPanel();
        }else {
            panel = createPanel(labelText);

            if(labelText.equalsIgnoreCase("NIK : ")){
                Font font = new Font("SansSerif", Font.BOLD, 16);
                textArea.setFont(font);
            }
        }

        panel.add(textArea);
        return panel;
    }
}
