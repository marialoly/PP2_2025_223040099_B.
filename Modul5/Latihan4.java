/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul05;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author lolyn
 */
public class Latihan4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable () {
            public void run(){
                JFrame frame = new JFrame ("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //1. atur layout manager ke BorderLayout
                frame.setLayout(new BorderLayout());
                
                //buat komponen 
                JLabel label = new JLabel ("Label ada di Atas (NORTH)");
                JButton button = new JButton ("Tombol ada di Bawah (SOUTH)");
                
                //3. tambahkan aksi ActionListener ke tombol
                button.addActionListener(e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });
                
                //4.tambahkan komponen ke frame DENGAN POSISI
                frame.add(label, BorderLayout.NORTH);
                frame.add(button, BorderLayout.SOUTH);
                
                //menambahkan komponen lain 
                frame.add(new JButton ("WEST"), BorderLayout.WEST);
                frame.add(new JButton ("EAST"), BorderLayout.EAST);
                frame.add(new JButton ("CENTER"), BorderLayout.CENTER);
                
                frame.setVisible(true);
            }
        });
    }
}
