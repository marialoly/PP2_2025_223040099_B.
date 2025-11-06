/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author lolyn
 */
public class TugasModul5 {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable () {
            public void run(){
                JFrame frame = new JFrame ("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //1. atur layout manager ke BorderLayout
                frame.setLayout(new BorderLayout());
                
                //2. buat komponen 
                JLabel label = new JLabel ("Label ada di Atas (NORTH)");
                JButton button = new JButton ("Tombol ada di Bawah (SOUTH)");
                JButton buttonWest = new JButton ("WEST");
                JButton buttonEast = new JButton ("EAST");
                JButton buttonCenter = new JButton ("CENTER");
                
                //3. tambahkan aksi ActionListener ke tombol
                button.addActionListener(e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });
                
                //MENAMBHAKAN AKSI UNTUK TOMBOL SELAIN SOUTH
                
                //West : mengubah warna teks label
                buttonWest.addActionListener (e -> {
                    label.setForeground(Color.RED);
                    label.setText("Tombol WEST diklik (teks jadi merah)!");
                });
                
                //East : mengubah warna backgorund frame
                buttonEast.addActionListener (e -> {
                    label.setForeground(Color.BLUE);
                    label.setText("Tombol East diklik (teks jadi biru)!");
                });
                
                //CENTER : mengubah ukuran dan gaya font label
                buttonCenter.addActionListener(e -> {
                    label.setForeground(Color.GRAY);
                    label.setText("Tombol CENTER diklik (teks jadi Abu-abu)!");
                });
                
                //4. menambahkan komponen ke frame dengan posisi
                frame.add(label, BorderLayout.NORTH);
                frame.add(button, BorderLayout.SOUTH);
                
                frame.add(buttonWest, BorderLayout.WEST);
                frame.add(buttonEast, BorderLayout.EAST);
                frame.add(buttonCenter, BorderLayout.CENTER);
                
                frame.setVisible(true);
            }
        });
    }
    
}
