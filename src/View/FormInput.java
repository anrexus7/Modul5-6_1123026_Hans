package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import Model.Enum.Agama;
import Model.Enum.GolonganDarah;
import Model.Enum.JenisKelamin;
import Model.Enum.StatusPerkawinan;
import org.jdatepicker.impl.*;

public class FormInput extends JFrame implements ActionListener{
    private static JTextField nikField,namaField,tempatLahirField,alamatField, rtRwField, kelDesaField,kecamatanField,kotaPembuatanKtpField;
    private static JDatePickerImpl tanggalLahirField,tanggalPembuatanKtpField;
    private static JRadioButton radioButtonM,radioButtonF;
    private static JRadioButton radioButtonA,radioButtonB,radioButtonAB,radioButtonO;
    private static JComboBox<String> comboBoxAgama,comboBoxStatusKawin;
    private static JCheckBox checkKaryawanSwasta,checkPNS,checkWiraswasta,checkAkademisi,checkPengangguran;
    private static JRadioButton radioButtonWNI,radioButtonWNA;
    private static JTextField additionalWnaField;
    private static JFileChooser fileFoto, fileTandaTangan;
    JButton buttonSubmit;

    public FormInput() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Input Data Screen");
        this.setBounds(400, 200, 1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel formContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 80);// Top, left, bottom, right padding
        gbc.anchor = GridBagConstraints.EAST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        nikField = new JTextField(20);
        formContainer.add(createInputTextPanel(nikField,"NIK : "), gbc);

        gbc.gridx++;
        namaField = new JTextField(20);
        formContainer.add(createInputTextPanel(namaField,"Nama : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        tempatLahirField = new JTextField(20);
        formContainer.add(createInputTextPanel(tempatLahirField,"Tempat Lahir : "), gbc);

        gbc.gridx++;
        tanggalLahirField = new JDatePickerImpl(createDatePanel(), new DateLabelFormatter());
        formContainer.add(createInputDatePanel(tanggalLahirField,"Tanggal Lahir : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        formContainer.add(createInputRadioGenderPanel("Gender : "), gbc);

        gbc.gridx++;
        formContainer.add(createInputRadioGolDarPanel("Golongan Darah : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        alamatField = new JTextField(20);
        formContainer.add(createInputTextPanel(alamatField,"Alamat : "), gbc);

        gbc.gridx++;
        rtRwField = new JTextField(20);
        formContainer.add(createInputTextPanel(rtRwField,"RT/RW : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        kelDesaField = new JTextField(20);
        formContainer.add(createInputTextPanel(kelDesaField,"Kel/Desa : "), gbc);

        gbc.gridx++;
        kecamatanField = new JTextField(20);
        formContainer.add(createInputTextPanel(kecamatanField,"Kecamatan : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        formContainer.add(createInputComboBoxAgamaPanel("Agama : "), gbc);

        gbc.gridx++;

        formContainer.add(createInputComboBoxStatusKawinPanel("Status Perkawinan : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formContainer.add(createInputCheckBoxPekerjaanPanel("Pekerjaan : "), gbc);

        gbc.gridy++;
        formContainer.add(createInputRadioKewarganegaraanPanel("Kewarganegaraan : "), gbc);

        gbc.gridy++;
        fileFoto = new JFileChooser();
        formContainer.add(createInputFileChooserPanel(fileFoto,"Foto : "), gbc);

        gbc.gridy++;
        fileTandaTangan = new JFileChooser();
        formContainer.add(createInputFileChooserPanel(fileTandaTangan,"Tanda Tangan : "), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        kotaPembuatanKtpField = new JTextField(20);
        gbc.anchor = GridBagConstraints.EAST;
        formContainer.add(createInputTextPanel(kotaPembuatanKtpField,"Kota Pembuatan KTP : "), gbc);

        gbc.gridx++;
        tanggalPembuatanKtpField = new JDatePickerImpl(createDatePanel(), new DateLabelFormatter());
        formContainer.add(createInputDatePanel(tanggalPembuatanKtpField,"Tanggal Pembuatan KTP : "), gbc);

        buttonSubmit = new JButton("Submit!");
        buttonSubmit.setBounds(10, 100, 200, 40);
        buttonSubmit.addActionListener(this);
        buttonSubmit.setEnabled(true);
        buttonSubmit.setVisible(true);

        gbc.gridy++;
        gbc.gridx--;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formContainer.add(buttonSubmit,gbc);

        JScrollPane scrollPane = new JScrollPane(formContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(scrollPane);
        this.setVisible(true);
    }

    private static JPanel createPanel(String labelText){
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(labelText);
        panel.add(label);

        return panel;
    }

    private JPanel createInputTextPanel(JTextField text, String labelText) {
        JPanel panel = createPanel(labelText);
        panel.add(text);

        return panel;
    }

    private JDatePanelImpl createDatePanel(){
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

        return datePanel;
    }

    private JPanel createInputDatePanel(JDatePickerImpl datePicker, String labelText) {
        JPanel panel = createPanel(labelText);

        panel.add(datePicker);

        return panel;
    }

    private JPanel createInputRadioGenderPanel(String labelText) {
        JPanel panel = createPanel(labelText);

        radioButtonM = new JRadioButton(String.valueOf(JenisKelamin.PRIA));
        radioButtonF = new JRadioButton(String.valueOf(JenisKelamin.WANITA));

        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonM);
        group.add(radioButtonF);

        panel.add(radioButtonM);
        panel.add(radioButtonF);

        return panel;
    }

    private JPanel createInputRadioGolDarPanel(String labelText) {
        JPanel panel = createPanel(labelText);

        radioButtonA = new JRadioButton(String.valueOf(GolonganDarah.A));
        radioButtonB = new JRadioButton(String.valueOf(GolonganDarah.B));
        radioButtonAB = new JRadioButton(String.valueOf(GolonganDarah.AB));
        radioButtonO = new JRadioButton(String.valueOf(GolonganDarah.O));

        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonA);
        group.add(radioButtonB);
        group.add(radioButtonAB);
        group.add(radioButtonO);

        panel.add(radioButtonA);
        panel.add(radioButtonB);
        panel.add(radioButtonAB);
        panel.add(radioButtonO);

        return panel;
    }

    private static JPanel createInputComboBoxAgamaPanel(String labelText){
        JPanel panel = createPanel(labelText);

        Object[] arrChoices = Agama.values();

        comboBoxAgama = new JComboBox(arrChoices);
        panel.add(comboBoxAgama);

        return panel;
    }

    private static JPanel createInputComboBoxStatusKawinPanel(String labelText){
        JPanel panel = createPanel(labelText);

        Object[] arrChoices = StatusPerkawinan.values();

        comboBoxStatusKawin = new JComboBox(arrChoices);
        panel.add(comboBoxStatusKawin);

        return panel;
    }

    private static JPanel createInputCheckBoxPekerjaanPanel(String labelText){
        JPanel panel = createPanel(labelText);

        checkKaryawanSwasta = new JCheckBox("Karyawan Swasta");
        checkPNS= new JCheckBox("PNS");
        checkWiraswasta= new JCheckBox("Wiraswasta");
        checkAkademisi= new JCheckBox("Akademisi");
        checkPengangguran= new JCheckBox("Pengangguran");

        panel.add(checkKaryawanSwasta);
        panel.add(checkPNS);
        panel.add(checkWiraswasta);
        panel.add(checkAkademisi);
        panel.add(checkPengangguran);

        checkPengangguran.addActionListener(e -> {
            if (checkPengangguran.isSelected()) {
                checkKaryawanSwasta.setEnabled(false);
                checkPNS.setEnabled(false);
                checkWiraswasta.setEnabled(false);
                checkAkademisi.setEnabled(false);

                checkKaryawanSwasta.setSelected(false);
                checkPNS.setSelected(false);
                checkWiraswasta.setSelected(false);
                checkAkademisi.setSelected(false);
            }else {
                checkKaryawanSwasta.setEnabled(true);
                checkPNS.setEnabled(true);
                checkWiraswasta.setEnabled(true);
                checkAkademisi.setEnabled(true);
            }
        });

        return panel;
    }

    private static JPanel createInputRadioKewarganegaraanPanel(String labelText){
        JPanel panel = createPanel(labelText);

        radioButtonWNI = new JRadioButton("WNI");
        radioButtonWNA = new JRadioButton("WNA");

        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonWNI);
        group.add(radioButtonWNA);

        additionalWnaField = new JTextField(20);
        additionalWnaField.setVisible(false);

        panel.add(radioButtonWNI);
        panel.add(radioButtonWNA);
        panel.add(additionalWnaField);

        radioButtonWNA.addActionListener(e -> {
            if(radioButtonWNA.isSelected()) {
                additionalWnaField.setVisible(true);
                panel.revalidate();
                panel.repaint();
            }
            });

        radioButtonWNI.addActionListener(e -> {
            if(radioButtonWNI.isSelected()) {
                additionalWnaField.setVisible(false);
                panel.revalidate();
                panel.repaint();
            }
            });

        return panel;
    }

    private void onSubmit() {
//        new LoginScreen();
        this.dispose();

        System.out.println("nikField: " + nikField.getText());
        System.out.println("namaField: " + namaField.getText());
        System.out.println("tempatLahirField: " + tempatLahirField.getText());
        System.out.println("alamatField: " + alamatField.getText());
        System.out.println("rtRwField: " + rtRwField.getText());
        System.out.println("kelDesaField: " + kelDesaField.getText());
        System.out.println("kecamatanField: " + kecamatanField.getText());
        System.out.println("kotaPembuatanKtpField: " + kotaPembuatanKtpField.getText());

        // Print statements for JDatePickerImpl components
        System.out.println("tanggalLahirField: " + tanggalLahirField.getJFormattedTextField().getText());
        System.out.println("tanggalPembuatanKtpField: " + tanggalPembuatanKtpField.getJFormattedTextField().getText());

        // Print statements for JRadioButton components (gender)
        if (radioButtonM.isSelected()) {
            System.out.println("Gender: Male");
        } else if (radioButtonF.isSelected()) {
            System.out.println("Gender: Female");
        }

        // Print statements for JRadioButton components (blood type)
        if (radioButtonA.isSelected()) {
            System.out.println("Blood Type: A");
        } else if (radioButtonB.isSelected()) {
            System.out.println("Blood Type: B");
        } else if (radioButtonAB.isSelected()) {
            System.out.println("Blood Type: AB");
        } else if (radioButtonO.isSelected()) {
            System.out.println("Blood Type: O");
        }

        // Print statements for JComboBox components
        System.out.println("comboBoxAgama: " + comboBoxAgama.getSelectedItem());
        System.out.println("comboBoxStatusKawin: " + comboBoxStatusKawin.getSelectedItem());

        // Print statements for JCheckBox components
        System.out.println("checkKaryawanSwasta: " + (checkKaryawanSwasta.isSelected() ? "Selected" : "Not Selected"));
        System.out.println("checkPNS: " + (checkPNS.isSelected() ? "Selected" : "Not Selected"));
        System.out.println("checkWiraswasta: " + (checkWiraswasta.isSelected() ? "Selected" : "Not Selected"));
        System.out.println("checkAkademisi: " + (checkAkademisi.isSelected() ? "Selected" : "Not Selected"));
        System.out.println("checkPengangguran: " + (checkPengangguran.isSelected() ? "Selected" : "Not Selected"));

        // Print statements for JRadioButton components (nationality)
        if (radioButtonWNI.isSelected()) {
            System.out.println("Nationality: WNI");
        } else if (radioButtonWNA.isSelected()) {
            System.out.println("Nationality: WNA");
            System.out.println("additionalWnaField: " + additionalWnaField.getText());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Submit!":
                onSubmit();
//                 new LoginScreen();
//                 frame.dispose();
//                break;
//            case "UPDATE":
//                break;
            default:
                break;
        }
        System.out.println(command);
    }

    private static JPanel createInputFileChooserPanel(JFileChooser fileChooser, String labelText){ //need fixing shit :v
        JPanel panel = createPanel(labelText);
        panel.add(fileChooser);
        return panel;
    }
}
