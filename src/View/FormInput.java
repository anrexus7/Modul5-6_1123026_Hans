package View;
import javax.swing.*;
import java.awt.*;
import java.util.Properties;

import Model.Enum.Agama;
import Model.Enum.GolonganDarah;
import Model.Enum.JenisKelamin;
import Model.Enum.StatusPerkawinan;
import org.jdatepicker.impl.*;

public class FormInput extends JFrame {

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
        gbc.insets = new Insets(10, 10, 10, 30);// Top, left, bottom, right padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        formContainer.add(createInputTextPanel("NIK : "), gbc);

        gbc.gridx++;
        formContainer.add(createInputTextPanel("Nama : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 10, 75);
        formContainer.add(createInputTextPanel("Tempat Lahir : "), gbc);

        gbc.gridx++;
        formContainer.add(createInputDatePanel("Tanggal Lahir : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.insets = new Insets(10, 10, 10, 140);
        formContainer.add(createInputRadioGenderPanel("Gender : "), gbc);

        gbc.gridx++;
        formContainer.add(createInputRadioGolDarPanel("Golongan Darah : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.insets = new Insets(10, 10, 10, 50);
        formContainer.add(createInputTextPanel("Alamat : "), gbc);

        gbc.gridx++;
        gbc.insets = new Insets(10, 0, 10, 20);
        formContainer.add(createInputTextPanel("RT/RW : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.insets = new Insets(10, 10, 10, 55);
        formContainer.add(createInputTextPanel("Kel/Desa : "), gbc);

        gbc.gridx++;
        formContainer.add(createInputTextPanel("Kecamatan : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.insets = new Insets(10, 10, 10, 155);
        formContainer.add(createInputComboBoxAgamaPanel("Agama : "), gbc);

        gbc.gridx++;
        gbc.insets = new Insets(10, 0, 10, 175);
        formContainer.add(createInputComboBoxStatusKawinPanel("Status Perkawinan : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 10, 70);
        formContainer.add(createInputCheckBoxPekerjaanPanel("Pekerjaan : "), gbc);

        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 10, 400);
        formContainer.add(createInputRadioKewarganegaraanPanel("Kewarganegaraan : "), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 10, 100);
        formContainer.add(createInputFileChooserPanel("Foto : "), gbc);

        gbc.gridx++;
        formContainer.add(createInputFileChooserPanel("Tanda Tangan : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        formContainer.add(createInputTextPanel("Kota Pembuatan KTP : "), gbc);

        gbc.gridx++;
        formContainer.add(createInputDatePanel("Tanggal Pembuatan KTP : "), gbc);

        this.add(formContainer);
        this.setVisible(true);

    }

    private static JPanel createPanel(String labelText){
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(labelText);
        panel.add(label);

        return panel;
    }

    private JPanel createInputTextPanel(String labelText) {
        JPanel panel = createPanel(labelText);
        panel.add(new JTextField(20));

        return panel;
    }

    private JPanel createInputDatePanel(String labelText) {
        JPanel panel = createPanel(labelText);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        panel.add(datePicker);

        return panel;
    }

    private JPanel createInputRadioGenderPanel(String labelText) {
        JPanel panel = createPanel(labelText);

        JRadioButton radioButtonM = new JRadioButton(String.valueOf(JenisKelamin.PRIA));
        JRadioButton radioButtonF = new JRadioButton(String.valueOf(JenisKelamin.WANITA));

        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonM);
        group.add(radioButtonF);

        panel.add(radioButtonM);
        panel.add(radioButtonF);

        return panel;
    }

    private JPanel createInputRadioGolDarPanel(String labelText) {
        JPanel panel = createPanel(labelText);

        JRadioButton radioButtonA = new JRadioButton(String.valueOf(GolonganDarah.A));
        JRadioButton radioButtonB = new JRadioButton(String.valueOf(GolonganDarah.B));
        JRadioButton radioButtonAB = new JRadioButton(String.valueOf(GolonganDarah.AB));
        JRadioButton radioButtonO = new JRadioButton(String.valueOf(GolonganDarah.O));

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

        Object[] arrChoices = {String.valueOf(Agama.KRISTEN),
                String.valueOf(Agama.KATOLIK),
                String.valueOf(Agama.ISLAM),
                String.valueOf(Agama.BUDHA),
                String.valueOf(Agama.HINDU),
                String.valueOf(Agama.KONGHUCHU),
                String.valueOf(Agama.KEPERCAYAAN)};

        JComboBox choices = new JComboBox(arrChoices);
        panel.add(choices);

        return panel;
    }

    private static JPanel createInputComboBoxStatusKawinPanel(String labelText){
        JPanel panel = createPanel(labelText);

        Object[] arrChoices = {String.valueOf(StatusPerkawinan.BELUM_MENIKAH),
                String.valueOf(StatusPerkawinan.MENIKAH),
                String.valueOf(StatusPerkawinan.DUDA),
                String.valueOf(StatusPerkawinan.JANDA)};

        JComboBox choices = new JComboBox(arrChoices);
        panel.add(choices);

        return panel;
    }

    private static JPanel createInputCheckBoxPekerjaanPanel(String labelText){
        JPanel panel = createPanel(labelText);

        JCheckBox checkKaryawanSwasta = new JCheckBox("Karyawan Swasta");
        JCheckBox checkPNS= new JCheckBox("PNS");
        JCheckBox checkWiraswasta= new JCheckBox("Wiraswasta");
        JCheckBox checkAkademisi= new JCheckBox("Akademisi");
        JCheckBox checkPengangguran= new JCheckBox("Pengangguran");

        panel.add(checkKaryawanSwasta);
        panel.add(checkPNS);
        panel.add(checkWiraswasta);
        panel.add(checkAkademisi);
        panel.add(checkPengangguran);

        return panel;
    }

    private static JPanel createInputRadioKewarganegaraanPanel(String labelText){
        JPanel panel = createPanel(labelText);

        JRadioButton radioButtonWNI = new JRadioButton("WNI");
        JRadioButton radioButtonWNA = new JRadioButton("WNA");

        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonWNI);
        group.add(radioButtonWNA);

        panel.add(radioButtonWNI);
        panel.add(radioButtonWNA);

        return panel;
    }

    private static JPanel createInputFileChooserPanel(String labelText){ //need fixing shit :v
        JPanel panel = createPanel(labelText);

        JFileChooser fileChooser = new JFileChooser();

        panel.add(fileChooser);

        return panel;
    }
}
