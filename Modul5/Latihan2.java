/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul05;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author lolyn
 */
public class Latihan2 {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable (){
            public void run() {
                JFrame frame = new JFrame ("Jendela dengan Label");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //1. buat komponen JLabel
                JLabel label = new JLabel ("ini adalah JLabel.");

                //2. tambahkan JLabel ke JFrame
                //secara default, JFrame menggunakan BorderLayout,
                //dan .add() akan menambahkan ke bagian tengah (CENTER).
                frame.add(label);

                frame.setVisible(true);
            }
        });
    
    }
    
}
