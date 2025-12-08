/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul07;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author lolyn
 */
public class ManajemenNilaiSiswaApp extends JFrame {
    private JTextField txtNama;
    private JTextField txtNilai;
    private JTable tableData;
    private JComboBox<String> cmbMatkul;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    
    //Method untuk membuat desain Tab Input
    private JPanel createInputPanel(){
    JPanel panel = new JPanel (new GridLayout(4, 2, 10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
    //Komponen Nama
    panel.add(new JLabel("Nama Siswa:"));
    txtNama = new JTextField();
    panel.add(txtNama);
    
    //Komponen Mata Pelajaran (ComboBox)
    panel.add(new JLabel("Mata Pelajaran"));
    String[] matkul = {"Matematika Dasar", "Bahasa Indonesia", 
        "Algortima dan Pemrograman I", "Praktikum Pemrograman II"};
    cmbMatkul = new JComboBox<>(matkul);
    panel.add(cmbMatkul);
    
    //Komponen Nilai
    panel.add(new JLabel ("Nilai (0-100):"));
    txtNilai = new JTextField();
    panel.add(txtNilai);
    
    //Tombol Simpan
    JButton btnSimpan = new JButton("Simpan Data");
    panel.add(new JLabel ("")); //Placeholder kosong agar tombol di kanan
    panel.add(btnSimpan);
    
    //Event handling tombol simpan
    btnSimpan.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            prosesSimpan();
        }
    });
    
    return panel;
    }
    //Method untuk membuat desain Tab Tabel
    private JPanel createTablePanel(){
        JPanel panel = new JPanel (new BorderLayout());
        
        //Setup Model Tabel (Kolom)
        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);
        
        //Membungkus tabel dengan ScrollPane agar bisa discroll jika data banyak
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    //Logika Validasi dan Penyimpanan Data
    private void prosesSimpan(){
        //1. Ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();
        
        //2. Validasi input
        //validasi 1. cek apakah nama kosong
        if (nama.trim() .isEmpty()){
            JOptionPane.showMessageDialog(this, "Nama kelas tidak boleh kosong!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return; //Hentikan proses
        }
        
        //validasi 2. cek apakah nilai berupa angka dalam range valid
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100){
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0 - 100!",
                        "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
             } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                         "Error Validasi", JOptionPane.ERROR_MESSAGE);
                 return;
             }
        //3. Logika Bisnis (Menentukan Grade
        String grade;
        if (nilai >= 80) grade = "A";
        else if (nilai >= 70) grade = "AB";
        else if (nilai >= 60) grade = "B";
        else if (nilai >= 50) grade = "B";
        else if (nilai >= 40) grade = "C";
        else if (nilai >= 30) grade = "D";
        else grade = "E";
        
        //4. masukkan ke tabel (update model)
        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);
        
        //5. Reset from dan pindah tab
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
        
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
        tabbedPane.setSelectedIndex(1); //otomatis pindah ke tabel
    }
    
    public ManajemenNilaiSiswaApp(){
    //1. konfigurasi frame utama
    setTitle("Aplikasi Manajemen Nilai Siswa");
    setSize(500, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null); //posisi di tengah layar
    
    //2. inisialisasi tabbed pane
    tabbedPane = new JTabbedPane();
    
    //3. Membuat Panel untuk Tab 1 (form input)
    JPanel panelInput = createInputPanel();
    tabbedPane.addTab("Input Data", panelInput);
    
    //4. membuat panel untuk Tab 2 (tabel data)
    JPanel panelTabel = createTablePanel();
    tabbedPane.addTab("Daftar Nilai", panelTabel);
    
    //Menambahkan TabbedPane ke Frame
    add(tabbedPane);
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new ManajemenNilaiSiswaApp() .setVisible(true);
        });
    }
}
