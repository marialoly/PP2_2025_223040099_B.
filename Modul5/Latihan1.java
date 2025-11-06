/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul05;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author lolyn
 */
public class Latihan1 {
    public static void main(String [] args){
        //Menjalankan kode GUO di Event Dispatch Thread (EDT)
        //ini adalah praktik terbaik menghindari masalah thread
        SwingUtilities.invokeLater(new Runnable () {
            public void run() {
                 //1. Buat objek JFrame
                JFrame frame = new JFrame ("Jendela Pertamaku");
            
                 //2. Atur ukuran jendela (lebar 400, tinggi 300)
                frame.setSize(400, 300);
            
                 //3. atur aksi saat tombol close (x) ditekan
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
                 //4.Buat jendela terlihat
                frame.setVisible(true);
            }
        });
    }
    
}
