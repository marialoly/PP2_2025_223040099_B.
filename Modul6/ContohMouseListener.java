/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul06;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event. MouseAdapter;
import java.awt.event. MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lolyn
 */
public class ContohMouseListener {
    public static void main(String[] args){
        JFrame frame = new JFrame("Contoh MouseListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        
        //1. buat komponen (Event Source)
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(200, 200));
        
        //2. buat event listener (menggunakan mouseadapter
        MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                //saat mouse masuk, ubah warna menjadi biru
                panel.setBackground(Color.CYAN);
            }
            @Override
            public void mouseExited(MouseEvent e){
                //saat mouse keluar, kembalikan warna
                panel.setBackground(Color.LIGHT_GRAY);
            }
            @Override
            public void mouseClicked(MouseEvent e){
                //saat diklik, tampilkan koordinat klik
                System.out.println("Mouse di klik di: x=" + e.getX() +  ", y=" + e.getY());
            }
        };
        
        //3. daftarkan listener ke source
        panel.addMouseListener(adapter);
        
        frame.add(panel);
        frame.setVisible(true);
            
    }
    
    
    
}
