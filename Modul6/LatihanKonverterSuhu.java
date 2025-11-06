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
import javax.swing.JTextField;
/**
 *
 * @author lolyn
 */
public class LatihanKonverterSuhu {
     public static void main(String[] args) {
        // 1. Membuat frame utama.
        JFrame frame = new JFrame("Konversi Suhu Celcius ke Fahrenheit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 150);
        frame.setLayout(new FlowLayout());

        // 2. Membuat komponen-komponen.
        JLabel labelCelcius = new JLabel("Celcius:");
        JTextField inputCelcius = new JTextField(10);
        JButton buttonKonversi = new JButton("Konversi");
        JLabel labelFahrenheit = new JLabel("Fahrenheit:");
        JLabel hasilLabel = new JLabel(""); // label kosong untuk hasil

        // 3. Menambahkan komponen ke frame.
        frame.add(labelCelcius);
        frame.add(inputCelcius);
        frame.add(buttonKonversi);
        frame.add(labelFahrenheit);
        frame.add(hasilLabel);

        // 4. Menambahkan ActionListener pada tombol "Konversi".
        buttonKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // a. Ambil input dari JTextField
                    String input = inputCelcius.getText();
                    double celcius = Double.parseDouble(input);

                    // b. Hitung Fahrenheit
                    double fahrenheit = (celcius * 9 / 5) + 32;

                    // c. Tampilkan hasil ke JLabel
                    hasilLabel.setText(String.format("%.2f °F", fahrenheit));
                } catch (NumberFormatException ex) {
                    // d. Jika input bukan angka.
                    hasilLabel.setText("Input tidak valid!");
                }
            }
        });

        // 5. Menampilkan frame ke layar.
        frame.setVisible(true);
    }
    
}
//.