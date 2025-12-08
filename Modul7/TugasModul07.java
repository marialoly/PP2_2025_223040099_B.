/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 package id.ac.unpas.modul07;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class TugasModul07 extends JFrame {

    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private DefaultTableModel tableModel;
    private JTable tableData;
    private JTabbedPane tabbedPane;

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {
                "Matematika Dasar",
                "Bahasa Indonesia",
                "Algoritma dan Pemrograman I",
                "Praktikum Pemrograman II"
        };
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        JButton btnReset = new JButton("Reset");
        JButton btnSimpan = new JButton("Simpan Data");

        panel.add(btnReset);
        panel.add(btnSimpan);

        btnReset.addActionListener(e -> {
            txtNama.setText("");
            txtNilai.setText("");
            cmbMatkul.setSelectedIndex(0);
            JOptionPane.showMessageDialog(TugasModul07.this, "Form berhasil direset");
        });

        btnSimpan.addActionListener(e -> prosesSimpan());

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JButton btnHapus = new JButton("Hapus Data");
        bottomPanel.add(btnHapus);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        btnHapus.addActionListener(e -> {
            int row = tableData.getSelectedRow();
            if (row > -1) {
                tableModel.removeRow(row);
                JOptionPane.showMessageDialog(TugasModul07.this, "Data berhasil dihapus");
            } else {
                JOptionPane.showMessageDialog(
                        TugasModul07.this,
                        "Pilih baris yang akan dihapus!",
                        "Tidak ada data dipilih",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        return panel;
    }

    private void prosesSimpan() {
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nama siswa tidak boleh kosong!",
                    "Error Validasi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this,
                    "Nama minimal 3 karakter!",
                    "Error Validasi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this,
                        "Nilai harus 0 - 100!",
                        "Error Validasi",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Nilai harus berupa angka!",
                    "Error Validasi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String grade;
        switch (nilai / 10) {
            case 10:
            case 9:
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "AB";
                break;
            case 6:
                grade = "B";
                break;
            case 5:
                grade = "BC";
                break;
            case 4:
                grade = "C";
                break;
            case 3:
                grade = "D";
                break;
            default:
                grade = "E";
        }

        Object[] data = {nama, matkul, nilai, grade};
        tableModel.addRow(data);

        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");

        tabbedPane.setSelectedIndex(1);
    }

    public TugasModul07() {
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);

        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TugasModul07().setVisible(true));
    }
}
