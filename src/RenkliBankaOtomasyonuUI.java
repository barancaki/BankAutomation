import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// RenkliBankaOtomasyonuUI sınıfı, kullanıcı giriş ekranını temsil eder.
public class RenkliBankaOtomasyonuUI extends JFrame {

    // Banka otomasyonu için hesaplar ve kayıtlı kullanıcılar listeleri
    private ArrayList<Hesap> hesaplar;
    private ArrayList<Kullanici> kayitliKullanicilar;

    // Kullanıcı giriş ekranındaki bileşenler
    private JTextField kullaniciAdiField;
    private JPasswordField sifreField;

    // Kullanıcı giriş ekranını oluşturan yapıcı metot.
    public RenkliBankaOtomasyonuUI(ArrayList<Hesap> hesaplar, ArrayList<Kullanici> kayitliKullanicilar) {
        this.hesaplar = hesaplar;
        this.kayitliKullanicilar = kayitliKullanicilar;

        // Ana panel oluşturulur ve düzeni belirlenir.
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setBackground(new Color(26, 188, 156)); // Türkuaz rengi

        // Kullanıcı adı ve şifre etiketleri oluşturulur.
        JLabel kullaniciAdiLabel = new JLabel("Kullanıcı Adı:");
        kullaniciAdiField = new JTextField();

        JLabel sifreLabel = new JLabel("Şifre:");
        sifreField = new JPasswordField();

        // Kayıt ol ve giriş yap düğmeleri oluşturulur ve stillenir.
        JButton kayitOlBtn = new JButton("Kayıt Ol");
        JButton girisYapBtn = new JButton("Giriş Yap");

        stilliDugmeYap(kayitOlBtn);
        stilliDugmeYap(girisYapBtn);

        // Kayıt ol düğmesine tıklanınca gerçekleşecek işlemler
        kayitOlBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kullanıcı adı ve şifre alınır
                String kullaniciAdi = kullaniciAdiField.getText();
                String sifre = new String(sifreField.getPassword());
                // Kullanıcı kaydı yapılır ve başarılı bir şekilde tamamlandığına dair mesaj gösterilir.
                KullaniciYonetimi.kullaniciKayit(kullaniciAdi, sifre, kayitliKullanicilar);
                JOptionPane.showMessageDialog(null, "Kayıt başarıyla tamamlandı. Şimdi giriş yapabilirsiniz.");
            }
        });

        // Giriş yap düğmesine tıklanınca gerçekleşecek işlemler
        girisYapBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kullanıcı adı ve şifre alınır
                String kullaniciAdi = kullaniciAdiField.getText();
                String sifre = new String(sifreField.getPassword());
                // Kullanıcı girişi kontrol edilir
                if (KullaniciYonetimi.kullaniciGiris(kullaniciAdi, sifre, kayitliKullanicilar)) {
                    // Giriş başarılıysa banka otomasyonu penceresi açılır
                    JOptionPane.showMessageDialog(null, "Giriş başarılı. Banka otomasyonuna hoş geldiniz!");
                    SwingUtilities.invokeLater(() -> {
                        BankaOtomasyonuUI bankaOtomasyonuUI = new BankaOtomasyonuUI(hesaplar);
                        bankaOtomasyonuUI.setTitle("Banka Otomasyonu");
                        bankaOtomasyonuUI.setSize(400, 400);
                        bankaOtomasyonuUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        bankaOtomasyonuUI.setLocationRelativeTo(null);
                        bankaOtomasyonuUI.setVisible(true);
                    });
                    // Kullanıcı giriş ekranını kapat
                    dispose();
                } else {
                    // Giriş başarısızsa kullanıcıya uyari mesajı gösterilir.
                    JOptionPane.showMessageDialog(null, "Geçersiz kullanıcı adı veya şifre. Lütfen tekrar deneyin.");
                }
            }
        });

        // Bileşenler panel üzerine eklenir
        panel.add(kullaniciAdiLabel);
        panel.add(kullaniciAdiField);
        panel.add(sifreLabel);
        panel.add(sifreField);
        panel.add(kayitOlBtn);
        panel.add(girisYapBtn);

        // Panel JFrame'a eklenir
        add(panel);

        // JFrame özellikleri belirlenir
        setTitle("Banka Otomasyonu - Giriş Ekranı");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Düğme stillendirme metodu
    private void stilliDugmeYap(JButton button) {
        button.setBackground(new Color(46, 204, 113)); // Yeşil renk
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }
}
