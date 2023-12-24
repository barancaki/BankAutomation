import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RenkliBankaOtomasyonuUI extends JFrame {

    private ArrayList<Hesap> hesaplar;
    private ArrayList<Kullanici> kayitliKullanicilar;
    private JTextField kullaniciAdiField;
    private JPasswordField sifreField;

    public RenkliBankaOtomasyonuUI(ArrayList<Hesap> hesaplar, ArrayList<Kullanici> kayitliKullanicilar) {
        this.hesaplar = hesaplar;
        this.kayitliKullanicilar = kayitliKullanicilar;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setBackground(new Color(26, 188, 156)); // Türkuaz rengi

        JLabel kullaniciAdiLabel = new JLabel("Kullanıcı Adı:");
        kullaniciAdiField = new JTextField();

        JLabel sifreLabel = new JLabel("Şifre:");
        sifreField = new JPasswordField();

        JButton kayitOlBtn = new JButton("Kayıt Ol");
        JButton girisYapBtn = new JButton("Giriş Yap");

        stilliDugmeYap(kayitOlBtn);
        stilliDugmeYap(girisYapBtn);

        kayitOlBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kullaniciAdi = kullaniciAdiField.getText();
                String sifre = new String(sifreField.getPassword());
                KullaniciYonetimi.kullaniciKayit(kullaniciAdi, sifre, kayitliKullanicilar);
                JOptionPane.showMessageDialog(null, "Kayıt başarıyla tamamlandı. Şimdi giriş yapabilirsiniz.");
            }
        });

        girisYapBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kullaniciAdi = kullaniciAdiField.getText();
                String sifre = new String(sifreField.getPassword());
                if (KullaniciYonetimi.kullaniciGiris(kullaniciAdi, sifre, kayitliKullanicilar)) {
                    JOptionPane.showMessageDialog(null, "Giriş başarılı. Banka otomasyonuna hoş geldiniz!");
                    // Otomasyonu başlat
                    SwingUtilities.invokeLater(() -> {
                        BankaOtomasyonuUI bankaOtomasyonuUI = new BankaOtomasyonuUI(hesaplar);
                        bankaOtomasyonuUI.setTitle("Renkli Banka Otomasyonu");
                        bankaOtomasyonuUI.setSize(400, 400);
                        bankaOtomasyonuUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        bankaOtomasyonuUI.setLocationRelativeTo(null);
                        bankaOtomasyonuUI.setVisible(true);
                    });
                    // Kullanıcı öncesi işlemler penceresini kapat
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Geçersiz kullanıcı adı veya şifre. Lütfen tekrar deneyin.");
                }
            }
        });

        panel.add(kullaniciAdiLabel);
        panel.add(kullaniciAdiField);
        panel.add(sifreLabel);
        panel.add(sifreField);
        panel.add(kayitOlBtn);
        panel.add(girisYapBtn);

        add(panel);

        setTitle("Renkli Banka Otomasyonu - Giriş Ekranı");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void stilliDugmeYap(JButton button) {
        button.setBackground(new Color(46, 204, 113)); // Yeşil renk
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }
}
