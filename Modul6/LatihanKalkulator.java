/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul06;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author lolyn
 */
public class LatihanKalkulator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // 1. Membuat frame utama
                JFrame frame = new JFrame("Kalkulator Sederhana");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 400);
                frame.setLayout(new BorderLayout(5, 5));

                // 2. Membuat komponen layar kalkulator (TextField)
                JTextField layar = new JTextField();
                layar.setEditable(false); // tidak bisa diketik manual
                layar.setHorizontalAlignment(JTextField.RIGHT); // rata kanan
                layar.setFont(new Font("Arial", Font.BOLD, 24));
                frame.add(layar, BorderLayout.NORTH);

                // 3. Membuat panel untuk tombol-tombol
                JPanel panelTombol = new JPanel();
                panelTombol.setLayout(new GridLayout(4, 4, 5, 5));

                // 4. Daftar teks untuk tombol (angka & operator)
                String[] tombol = {
                    "7", "8", "9", "/",
                    "4", "5", "6", "*",
                    "1", "2", "3", "-",
                    "0", ".", "=", "+"
                };

                // 5. Tambahkan setiap tombol ke panel
                for (String teks : tombol) {
                    JButton btn = new JButton(teks);
                    btn.setFont(new Font("Arial", Font.BOLD, 18));
                    panelTombol.add(btn);
                }

                // 6. Tambahkan panel tombol ke frame
                frame.add(panelTombol, BorderLayout.CENTER);

                // 7. Tampilkan jendela
                frame.setVisible(true);
            }
        });
    }
    
}
