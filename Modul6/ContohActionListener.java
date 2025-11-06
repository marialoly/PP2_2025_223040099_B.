/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author lolyn
 */
public class ContohActionListener {
    public static void main(String[] args){
        JFrame frame = new JFrame("Contoh ActionListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize (300, 150);
        frame.setLayout(new FlowLayout());
        
        //1. buat komponen (event source dan komponen lain)
        JLabel label = new JLabel ("Halo, klik tombol di bawah!");
        JButton button = new JButton ("Klik saya!");
        
        //2.buat event listener
        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            //3. logika yang dieksekusi saat event terjadi
            label.setText("Tombol telah diklik");
            }
        };
        
        //4. daftarkan listener ke source
        button.addActionListener(listener);
        
        //tambahkan komponen ke frame
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }
    
    
    
}
