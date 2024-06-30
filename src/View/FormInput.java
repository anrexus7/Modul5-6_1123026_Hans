package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

import Model.Controller.SavingData;
import Model.Enum.Agama;
import Model.Enum.GolonganDarah;
import Model.Enum.JenisKelamin;
import Model.Enum.StatusPerkawinan;
import org.jdatepicker.impl.*;

public class FormInput extends JFrame implements ActionListener {
    private JTextField nikField, namaField, tempatLahirField, alamatField, rtRwField, kelDesaField, kecamatanField, kotaPembuatanKtpField;

    private JDatePickerImpl tanggalLahirField, tanggalPembuatanKtpField;

    private ButtonGroup groupGender, groupGolDar, groupKewarganegaraan;
    private JTextField additionalWnaField;

    private JComboBox<String> comboBoxAgama, comboBoxStatusKawin;

    private ArrayList<JCheckBox> listPekerjaan;

    private JFileChooser fileFoto, fileTandaTangan;

    private JButton buttonSubmit;

    Map<String, String> userInputText, userInputRadio, userInputComboBox;
    Map<String, Date> userInputDate;
    Map<String, File> userInputFileChooser;

    Map<String,Object> allInput = new HashMap<>();

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
        formContainer.add(createInputTextPanel(nikField, "NIK : "), gbc);

        gbc.gridx++;
        namaField = new JTextField(20);
        formContainer.add(createInputTextPanel(namaField, "Nama : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        tempatLahirField = new JTextField(20);
        formContainer.add(createInputTextPanel(tempatLahirField, "Tempat Lahir : "), gbc);

        gbc.gridx++;
        tanggalLahirField = new JDatePickerImpl(createDatePanel(), new DateLabelFormatter());
        formContainer.add(createInputDatePanel(tanggalLahirField, "Tanggal Lahir : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        formContainer.add(createInputRadioGenderPanel("Gender : "), gbc);

        gbc.gridx++;
        formContainer.add(createInputRadioGolDarPanel("Golongan Darah : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        alamatField = new JTextField(20);
        formContainer.add(createInputTextPanel(alamatField, "Alamat : "), gbc);

        gbc.gridx++;
        rtRwField = new JTextField(20);
        formContainer.add(createInputTextPanel(rtRwField, "RT/RW : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        kelDesaField = new JTextField(20);
        formContainer.add(createInputTextPanel(kelDesaField, "Kel/Desa : "), gbc);

        gbc.gridx++;
        kecamatanField = new JTextField(20);
        formContainer.add(createInputTextPanel(kecamatanField, "Kecamatan : "), gbc);

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
        formContainer.add(createInputFileChooserPanel(fileFoto, "Foto : "), gbc);

        gbc.gridy++;
        fileTandaTangan = new JFileChooser();
        formContainer.add(createInputFileChooserPanel(fileTandaTangan, "Tanda Tangan : "), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        kotaPembuatanKtpField = new JTextField(20);
        gbc.anchor = GridBagConstraints.EAST;
        formContainer.add(createInputTextPanel(kotaPembuatanKtpField, "Kota Pembuatan KTP : "), gbc);

        gbc.gridx++;
        tanggalPembuatanKtpField = new JDatePickerImpl(createDatePanel(), new DateLabelFormatter());
        formContainer.add(createInputDatePanel(tanggalPembuatanKtpField, "Tanggal Pembuatan KTP : "), gbc);

        buttonSubmit = new JButton("Submit!");
        buttonSubmit.setBounds(10, 100, 200, 40);
        buttonSubmit.addActionListener(this);
        buttonSubmit.setEnabled(true);
        buttonSubmit.setVisible(true);

        gbc.gridy++;
        gbc.gridx--;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formContainer.add(buttonSubmit, gbc);

        JScrollPane scrollPane = new JScrollPane(formContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(scrollPane);
        this.setVisible(true);
    }

    private static JPanel createPanel(String labelText) {
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

    private JDatePanelImpl createDatePanel() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl datePanel;
        datePanel = new JDatePanelImpl(model, p);

        return datePanel;
    }

    private JPanel createInputDatePanel(JDatePickerImpl datePicker, String labelText) {
        JPanel panel = createPanel(labelText);

        panel.add(datePicker);

        return panel;
    }

    private JPanel createInputRadioGenderPanel(String labelText) {
        JPanel panel = createPanel(labelText);

        JRadioButton radioButtonM = new JRadioButton(String.valueOf(JenisKelamin.PRIA));
        JRadioButton radioButtonF = new JRadioButton(String.valueOf(JenisKelamin.WANITA));

        radioButtonM.setActionCommand(radioButtonM.getText());
        radioButtonF.setActionCommand(radioButtonF.getText());

        groupGender = new ButtonGroup();
        groupGender.add(radioButtonM);
        groupGender.add(radioButtonF);

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

        radioButtonA.setActionCommand(radioButtonA.getText());
        radioButtonB.setActionCommand(radioButtonB.getText());
        radioButtonAB.setActionCommand(radioButtonAB.getText());
        radioButtonO.setActionCommand(radioButtonO.getText());

        groupGolDar = new ButtonGroup();
        groupGolDar.add(radioButtonA);
        groupGolDar.add(radioButtonB);
        groupGolDar.add(radioButtonAB);
        groupGolDar.add(radioButtonO);

        panel.add(radioButtonA);
        panel.add(radioButtonB);
        panel.add(radioButtonAB);
        panel.add(radioButtonO);

        return panel;
    }

    private JPanel createInputComboBoxAgamaPanel(String labelText) {
        JPanel panel = createPanel(labelText);

        Agama[] values = Agama.values();
        Object[] arrChoices = new Object[values.length + 1];
        arrChoices[0] = "";
        System.arraycopy(values, 0, arrChoices, 1, values.length);

        comboBoxAgama = new JComboBox(arrChoices);
        panel.add(comboBoxAgama);

        return panel;
    }

    private JPanel createInputComboBoxStatusKawinPanel(String labelText) {
        JPanel panel = createPanel(labelText);

        StatusPerkawinan[] values = StatusPerkawinan.values();
        Object[] arrChoices = new Object[values.length + 1];
        arrChoices[0] = "";
        System.arraycopy(values, 0, arrChoices, 1, values.length);

        comboBoxStatusKawin = new JComboBox(arrChoices);
        panel.add(comboBoxStatusKawin);

        return panel;
    }

    private JPanel createInputCheckBoxPekerjaanPanel(String labelText) {
        JPanel panel = createPanel(labelText);

        JCheckBox checkKaryawanSwasta = new JCheckBox("Karyawan Swasta");
        JCheckBox checkPNS = new JCheckBox("PNS");
        JCheckBox checkWiraswasta = new JCheckBox("Wiraswasta");
        JCheckBox checkAkademisi = new JCheckBox("Akademisi");
        JCheckBox checkPengangguran = new JCheckBox("Pengangguran");

        listPekerjaan = new ArrayList<>();

        listPekerjaan.add(checkKaryawanSwasta);
        listPekerjaan.add(checkPNS);
        listPekerjaan.add(checkWiraswasta);
        listPekerjaan.add(checkAkademisi);
        listPekerjaan.add(checkPengangguran);

        for (JCheckBox pekerjaan : listPekerjaan) {
            panel.add(pekerjaan);
        }

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
            } else {
                checkKaryawanSwasta.setEnabled(true);
                checkPNS.setEnabled(true);
                checkWiraswasta.setEnabled(true);
                checkAkademisi.setEnabled(true);
            }
        });

        return panel;
    }

    private JPanel createInputRadioKewarganegaraanPanel(String labelText) {
        JPanel panel = createPanel(labelText);

        JRadioButton radioButtonWNI = new JRadioButton("WNI");
        JRadioButton radioButtonWNA = new JRadioButton("WNA");

        radioButtonWNI.setActionCommand("WNI");
        radioButtonWNA.setActionCommand("WNA");

        groupKewarganegaraan = new ButtonGroup();
        groupKewarganegaraan.add(radioButtonWNI);
        groupKewarganegaraan.add(radioButtonWNA);

        additionalWnaField = new JTextField(20);
        additionalWnaField.setVisible(false);

        panel.add(radioButtonWNI);
        panel.add(radioButtonWNA);
        panel.add(additionalWnaField);

        radioButtonWNA.addActionListener(e -> {
            if (radioButtonWNA.isSelected()) {
                additionalWnaField.setVisible(true);
                panel.revalidate();
                panel.repaint();
            }
        });

        radioButtonWNI.addActionListener(e -> {
            if (radioButtonWNI.isSelected()) {
                additionalWnaField.setVisible(false);
                panel.revalidate();
                panel.repaint();
            }
        });

        return panel;
    }

    private JPanel createInputFileChooserPanel(JFileChooser fileChooser, String labelText) { //need fixing shit :v
        JPanel panel = createPanel(labelText);
        panel.add(fileChooser);
        return panel;
    }

    private void onSubmit() {
        LinkedList<Boolean> isValid = new LinkedList<>();
        isValid.add(validatingText());
        isValid.add(validatingDate());
        isValid.add(validatingRadio());
        isValid.add(validatingComboBox());
        isValid.add(validatingFileChooser());
        isValid.add(validatingCheckBox());

        boolean isReallyValid = true;

        Iterator<Boolean> iterator = isValid.iterator();
        while (iterator.hasNext() && isReallyValid) {
            isReallyValid = iterator.next();
        }

        allInput.putAll(userInputText);
        allInput.putAll(userInputDate);
        allInput.putAll(userInputRadio);
        allInput.putAll(userInputComboBox);
        allInput.putAll(userInputFileChooser);

        if (isReallyValid) {
            for(Object temp : allInput.values()){
                System.out.println(temp);
            }

            new SavingData(allInput);

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "ISI NU BALEG NYING :V ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validatingText() {
        boolean validating = true;

        userInputText = new HashMap<>();
        userInputText.put("nik", nikField.getText());
        userInputText.put("nik", nikField.getText());
        userInputText.put("nama", namaField.getText());
        userInputText.put("tempatLahir", tempatLahirField.getText());
        userInputText.put("alamat", alamatField.getText());
        userInputText.put("rtRw", rtRwField.getText());
        userInputText.put("kelDesa", kelDesaField.getText());
        userInputText.put("kecamatan", kecamatanField.getText());
        userInputText.put("kotaPembuatanKtp", kotaPembuatanKtpField.getText());
        userInputText.put("additionalWNA", additionalWnaField.getText());

        Iterator<Map.Entry<String, String>> iteratorText = userInputText.entrySet().iterator();
        while (iteratorText.hasNext() && validating) {

            Map.Entry<String, String> entry = iteratorText.next();
            String key = entry.getKey();
            String textField = entry.getValue();

            if (textField.isEmpty()) {
                validating = false;
            }

            if (key.equals("additionalWNA")) {
                validating = true;
            }

        }

        return validating;
    }

    private boolean validatingDate() {
        boolean validating = true;

        userInputDate = new HashMap<>();
        userInputDate.put("tanggalLahir", (Date) tanggalLahirField.getModel().getValue());
        userInputDate.put("tanggalPembuatanKTP", (Date) tanggalPembuatanKtpField.getModel().getValue());

        Iterator<Date> iteratorDate = userInputDate.values().iterator();
        while (iteratorDate.hasNext() && validating) {
            Date dateField = iteratorDate.next();

            if (dateField == null) {
                validating = false;
            }
        }

        return validating;
    }

    private boolean validatingRadio() {
        boolean validating = true;
        userInputRadio = new HashMap<>();
        userInputRadio.put("gender", groupGender.getSelection().getActionCommand());
        userInputRadio.put("golDar", groupGolDar.getSelection().getActionCommand());
        userInputRadio.put("kewarganegaraan", groupKewarganegaraan.getSelection().getActionCommand());

        Iterator<String> iteratorRadio = userInputRadio.values().iterator();
        while (iteratorRadio.hasNext() && validating) {
            String groupField = iteratorRadio.next();

            if (groupField.equals("WNA") && userInputText.get("additionalWNA").isEmpty()) {
                validating = false;
            } else if (groupField.equals("WNI")) {
                userInputText.put("additionalWNA",""); //memastikan kosong
                validating = true;
            }

            if (groupField == null) {
                validating = false;
            }
        }

        return validating;
    }

    private boolean validatingComboBox() {
        boolean validating = true;

        userInputComboBox = new HashMap<>();
        userInputComboBox.put("agama", comboBoxAgama.getSelectedItem().toString());
        userInputComboBox.put("statusKawin", comboBoxStatusKawin.getSelectedItem().toString());

        Iterator<String> iteratorComboBox = userInputComboBox.values().iterator();
        while (iteratorComboBox.hasNext() && validating) {
            String comboBoxField = iteratorComboBox.next();

            if (comboBoxField.isEmpty()) {
                validating = false;
            }
        }

        return validating;
    }

    private boolean validatingCheckBox() {
        boolean validating = false;
        String pekerjaan = "";

        for (JCheckBox checkPekerjaan : listPekerjaan) {
            if (checkPekerjaan.getText().equals("Pengangguran") && listPekerjaan.get(4).isSelected()) {
                validating = true;
                break;
            } else {
                if (checkPekerjaan.isSelected()) {
                    validating = true;
                    break;
                }
            }
        }
        for (JCheckBox checkPekerjaan : listPekerjaan) {
            if(checkPekerjaan.isSelected()){
                pekerjaan += checkPekerjaan.getText() + " ";
            }
        }

        allInput.put("pekerjaan", pekerjaan);

        return validating;
    }

    private boolean validatingFileChooser() {
        boolean validating = true;

        userInputFileChooser = new HashMap<>();
        userInputFileChooser.put("fileFoto", fileFoto.getSelectedFile());
        userInputFileChooser.put("fileTandaTangan", fileTandaTangan.getSelectedFile());

        Iterator<File> iteratorFile = userInputFileChooser.values().iterator();
        while (iteratorFile.hasNext() && validating) {
            File fileChooser = iteratorFile.next();
            if (fileChooser == null) {
                validating = false;
            }
        }

        return validating;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        onSubmit();
    }
}
