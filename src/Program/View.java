package Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Kamil on 2016-10-07.
 */
public class View extends JFrame implements ActionListener {
    private JButton standard, apt, aptK, termopara;
    private JTextField wpisz, dW, dRW;
    private JLabel podaj, dRobocza, dWkladu, podpis;
    private JCheckBox czyEnter;
    private long lwk;

    public View() {
        setSize(420, 300);
        setLocation(150, 150);
        setTitle("Kalkulator długości wkładu   ver. 2.0");
        setLayout(null);

        standard = new JButton("Cu");
        standard.setBounds(40, 30, 100, 25);
        add(standard);
        standard.addActionListener(this);

        apt = new JButton("APT 2000");
        apt.setBounds(150, 30, 100, 25);
        add(apt);
        apt.addActionListener(this);
        aptK = new JButton("APT K");
        aptK.setBounds(150, 65, 100, 25);
        add(aptK);
        aptK.addActionListener(this);

        termopara = new JButton("Termopara");
        termopara.setBounds(260, 30, 100, 25);
        add(termopara);
        termopara.addActionListener(this);

        podaj = new JLabel("Podaj lwk: ");
        podaj.setBounds(75, 110, 100, 22);
        add(podaj);
        wpisz = new JTextField();
        wpisz.setText(String.valueOf(0));
        wpisz.setBounds(150, 110, 80, 22);
        add(wpisz);
        wpisz.setToolTipText("Wprowadź lwk");
        wpisz.addActionListener(this);

        dRobocza = new JLabel("Długość robocza: ");
        dRobocza.setBounds(35, 150, 120, 22);
        add(dRobocza);
        dRW = new JTextField();
        dRW.setBounds(150, 150, 80, 22);
        add(dRW);

        dWkladu = new JLabel("Długość wkładu: ");
        dWkladu.setBounds(40, 190, 120, 22);
        add(dWkladu);
        dW = new JTextField();
        dW.setBounds(150, 190, 80, 22);
        add(dW);
        podpis = new JLabel("created by Kamil Brzoza");
        podpis.setBounds(300, 250, 120, 15);
        podpis.setFont(new Font("Arial", Font.ITALIC, 9));
        add(podpis);

        czyEnter = new JCheckBox();
        czyEnter.setText("<Enter> dla wkładu Cu");
        czyEnter.setBounds(235, 113, 150, 14);
        czyEnter.setFont(new Font("Arial", Font.PLAIN, 12));
        czyEnter.setToolTipText("Uwaga! Klawisz <Enter> zatwierdza lwk wyłącznie dla wkładu Cu!");
        add(czyEnter);
        czyEnter.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            lwk = Integer.parseInt(wpisz.getText());
        } catch (NumberFormatException n) {
            wpisz.setText("Błąd");
        }
        long wypiszDRoboczaCu = lwk + 22;
        long wypiszDWkladuCu = lwk - 16;
        long wypiszDRoboczaAPT = lwk;
        long wypiszDWkladuAPT = lwk - 18;
        long wypiszDRoboczaTermo = lwk + 36;
        long wypiszDWkladuTermo = lwk + 2;
        long wypiszDRoboczaAptK = lwk + 24;
        long wypiszDWkladuAptK = lwk;

        if (source == standard) {
            dRW.setText(String.valueOf(wypiszDRoboczaCu));
            dW.setText(String.valueOf(wypiszDWkladuCu));
        } else if (source == apt) {
            dRW.setText(String.valueOf(wypiszDRoboczaAPT));
            dW.setText(String.valueOf(wypiszDWkladuAPT));
        } else if (source == aptK) {
            dRW.setText(String.valueOf(wypiszDRoboczaAptK));
            dW.setText(String.valueOf(wypiszDWkladuAptK));
        } else if (source == termopara) {
            dRW.setText(String.valueOf(wypiszDRoboczaTermo));
            dW.setText(String.valueOf(wypiszDWkladuTermo));
        } else if (czyEnter.isSelected() == true) {
            if (source == wpisz) {
                dRW.setText(String.valueOf(wypiszDRoboczaCu));
                dW.setText(String.valueOf(wypiszDWkladuCu));
            }
        }
    }
}



