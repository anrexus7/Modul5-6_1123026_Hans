package View;

import Model.Class.DataPenduduk;
import Controller.GetData;

import javax.swing.*;
import java.awt.*;

public class HasilKTP extends JFrame {
    private static DataPenduduk showData;
    public HasilKTP(boolean isSuccess, String NIK) {
        if(!isSuccess){
            JOptionPane.showMessageDialog(null, "Task Failed !", "Error", JOptionPane.ERROR_MESSAGE);
        }else {
            GetData dataFromDB = new GetData();
            showData = dataFromDB.fetchDataFromDB(NIK);

            initComponents();
        }
    }

    private void initComponents() {
        this.setTitle("Hasil Rekaman");
        this.setBounds(400, 200, 800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel container = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 10, 0);// Top, left, bottom, right padding


        JLabel header = new JLabel("Republik Harapan Bangsa");
        header.setFont(new Font("SansSerif", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        container.add(header, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        container.add(createLeftLayout(),gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.CENTER;
        container.add(createRightLayout(),gbc);

        this.add(container);
        this.setVisible(true);
    }

    private JPanel createLeftLayout(){
        JPanel leftContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbcL = new GridBagConstraints();
        gbcL.insets = new Insets(0, 10, 10, 0);// Top, left, bottom, right padding
        gbcL.anchor = GridBagConstraints.WEST;

        gbcL.gridx = 0;
        gbcL.gridy = 0;
        leftContainer.add(createShowTextPanel(showData.getNIK(), "NIK : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getNama(), "Nama : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getTempatLahir()+", "+showData.getTanggalLahir(), "Tempat/Tgl Lahir : "), gbcL);

        gbcL.gridy++;
        gbcL.insets = new Insets(0, 10, 10, 0);
        leftContainer.add(createShowTextPanel(showData.getJenisKelamin().toString(), "Jenis Kelamin : "), gbcL);

        gbcL.gridx++;
        gbcL.insets = new Insets(0, 0, 10, 100);
        leftContainer.add(createShowTextPanel(showData.getGolDarah().toString(), "Gol. Darah : "), gbcL);

        gbcL.gridx--;
        gbcL.gridy++;
        gbcL.insets = new Insets(0, 10, 10, 0);
        leftContainer.add(createShowTextPanel(showData.getAlamat(), "Alamat : "), gbcL);

        gbcL.gridy++;
        gbcL.insets = new Insets(0, 40, 10, 0);
        leftContainer.add(createShowTextPanel(showData.getRtRw(), "RT/RW : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getKelDesa(), "Kel/Desa : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getKecamatan(), "Kecamatan : "), gbcL);

        gbcL.gridy++;
        gbcL.insets = new Insets(0, 10, 10, 0);
        leftContainer.add(createShowTextPanel(showData.getAgama().toString(), "Agama : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getStatusPerkawinan().toString(), "Status Perkawinan : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getPekerjaan(), "Pekerjaan : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getKewarganegaraan(), "Kewarganegaraan : "), gbcL);

        gbcL.gridy++;
        leftContainer.add(createShowTextPanel(showData.getBerlakuHingga(), "Berlaku Hingga : "), gbcL);

        return leftContainer;
    }

    private JPanel createRightLayout() {
        JPanel rightContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbcR = new GridBagConstraints();
        gbcR.insets = new Insets(10, 10, 10, 10);// Top, left, bottom, right padding
        gbcR.anchor = GridBagConstraints.CENTER;

        gbcR.gridx = 0;
        gbcR.gridy = 0;
        rightContainer.add(createShowImage(showData.getFoto(), "pasFoto"), gbcR);

        gbcR.gridy++;
        System.out.println(showData.getFoto());
        rightContainer.add(createShowTextPanel(showData.getKotaPembuatanKTP(), ""), gbcR);

        gbcR.gridy++;
        rightContainer.add(createShowTextPanel(String.valueOf(showData.getTanggalPembuatanKTP()), ""), gbcR);

        gbcR.gridy++;
        rightContainer.add(createShowImage(showData.getTandaTangan(),"tanda tangan"), gbcR);

        return rightContainer;
    }

    private JPanel createPanel(String labelText) {
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(labelText);

        if(labelText.equalsIgnoreCase("NIK : ")) {
            Font font = new Font("SansSerif", Font.BOLD, 16);
            label.setFont(font);
        }

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
    
    private JLabel createShowImage(String path, String type){
        ImageIcon imageIcon = new ImageIcon(path);
        Image originalImage = imageIcon.getImage();
        Image scaledImage = originalImage;

        if(type.equals("pasFoto")){
            scaledImage = originalImage.getScaledInstance(200, 280, Image.SCALE_SMOOTH);
        }else{
            scaledImage = originalImage.getScaledInstance(200, 70, Image.SCALE_SMOOTH);
        }

        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel(scaledIcon);
        label.setVisible(true);
        return label;
    }
}
