import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BankaOtomasyonuUI extends JFrame {

    private ArrayList<Hesap> hesaplar;
    private JTextArea sonucArea;

    public BankaOtomasyonuUI(ArrayList<Hesap> hesaplar) {
        this.hesaplar = hesaplar;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.setBackground(new Color(26, 188, 156)); // Türkuaz rengi

        JButton yeniHesapBtn = new JButton("Yeni Hesap Oluştur");
        JButton hesapListeleBtn = new JButton("Hesapları Listele");
        JButton paraYatirBtn = new JButton("Para Yatır");
        JButton paraCekBtn = new JButton("Para Çek");
        JButton krediBasvuruBtn = new JButton("Kredi Başvurusu Yap");

        stilliDugmeYap(yeniHesapBtn);
        stilliDugmeYap(hesapListeleBtn);
        stilliDugmeYap(paraYatirBtn);
        stilliDugmeYap(paraCekBtn);
        stilliDugmeYap(krediBasvuruBtn);

        yeniHesapBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hesap yeniHesap = HesapYonetimi.yeniHesapOlustur();
                hesaplar.add(yeniHesap);
                sonucArea.setText("Yeni hesap oluşturuldu:\n" + yeniHesap);
            }
        });

        hesapListeleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sonucArea.setText("Hesaplar:\n");
                for (Hesap hesap : hesaplar) {
                    sonucArea.append(hesap.toString() + "\n");
                }
            }
        });

        paraYatirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HesapYonetimi.paraYatir(hesaplar, sonucArea);
            }
        });

        paraCekBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HesapYonetimi.paraCek(hesaplar, sonucArea);
            }
        });

        krediBasvuruBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KrediYonetimi.krediBasvuruYap(hesaplar, sonucArea);
            }
        });

        panel.add(yeniHesapBtn);
        panel.add(hesapListeleBtn);
        panel.add(paraYatirBtn);
        panel.add(paraCekBtn);
        panel.add(krediBasvuruBtn);

        sonucArea = new JTextArea();
        sonucArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(sonucArea);
        panel.add(scrollPane);

        add(panel);

        setTitle("Banka Otomasyonu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true); // Bu satırı ekledim
    }

    private void stilliDugmeYap(JButton button) {
        button.setBackground(new Color(46, 204, 113)); // Yeşil renk
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }
}
