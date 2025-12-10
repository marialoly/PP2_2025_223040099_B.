/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul09;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author lolyn
 */
public class AplikasiFileIO extends JFrame {
    
    //Komponen GUI
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText;
    private JButton btnSaveBinary, btnLoadBinary;
    private JFileChooser fileChooser;

    public AplikasiFileIO() {
        super("Tutorial File IO & Exception Handling");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Instalasi komponen
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();

        //Panel tombol
        JPanel buttonPanel = new JPanel();   // ← nama benar
        btnOpenText = new JButton("Buka Text");
        btnSaveText = new JButton("Simpan Text");
        btnSaveBinary = new JButton("Simpan Config (Binary)");
        btnLoadBinary = new JButton("Muat Config (Binary)");

        //Tambahkan tombol ke panel
        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);

        //Layout 
        add(new JScrollPane(textArea), BorderLayout.CENTER); // ← JScollPane harus kapital
        add(buttonPanel, BorderLayout.SOUTH);

        //-----Event Handling----
        //1 MEMBACA FILE TEKS (TEXT STREAM)
        btnOpenText.addActionListener(e -> bukaFileTeks());
        
        //2 MENULIS FILE TEKS (TEXT STREAM)
        btnSaveText.addActionListener(e -> simpanFileTeks());
        
        //3 MENULIS FILE BINARY (BYTE STREAM)
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        
        //4 MEMBACA FILE BINARY (BYTE STREAM)
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
       
      
        setVisible(true);
        
    }

    // CONTOH: MEMBACA FILE TEKS DENGAN TRY-CATCH-FINALLY KONVENSIONAL
    private void bukaFileTeks() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();
            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(file)); // ← diperbaiki
                textArea.setText("");

                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }

                JOptionPane.showMessageDialog(this, "File berhasil dimuat");

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan: " + ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file: " + ex.getMessage());
            } 
            finally {
                try {
                    if (reader != null) reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // CONTOH: MENULIS FILE MENGGUNAKAN TRY-CATCH-RESOURCE -LEBIH MODERN
    private void simpanFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + ex.getMessage());
            }
        }
    }

    // CONTOH : MENULIS BINARY -MENYIMPAN FONT SAAT INI KE FILE.BIN
    private void simpanConfigBinary() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();

            try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
                out.writeInt(textArea.getFont().getSize());
                JOptionPane.showMessageDialog(this, "Config berhasil disimpan");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan config: " + ex.getMessage());
            }
        }
    }

    // CONTOH MEMBACA BINARY -MENGAMBIL UKURAN FONT DARI FILE.BIN
    private void muatConfigBinary() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();

            try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {

                int fontSize = in.readInt();
                textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));

                JOptionPane.showMessageDialog(this, "Config berhasil dimuat");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca config: " + ex.getMessage());
            }
        }
    }
    // Latihan 2 muat notes otomatis
    private void muatNotesOtomatis(){
        File file = new File ("last_notes.txt");
        
        if (!file.exists()){
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            textArea.setText("");
            
            String line;
            while ((line = reader.readLine()) != null){
                textArea.append(line + "\n");
            }
        } catch (IOException ex){
            System.out.println("Gagal memuat last_notes.txt" + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplikasiFileIO().setVisible(true);
        });
    }
}
