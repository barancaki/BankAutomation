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

        // Kullanıcı arayüzü için bir panel oluşturuluyor ve düzeni belirleniyor.
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.setBackground(new Color(26, 188, 156)); // Türküaz rengi

        // Kullanıcı arayüzü için beş adet düğme oluşturuluyor.
        JButton yeniHesapBtn = new JButton("Yeni Hesap Oluştur");
        JButton hesapListeleBtn = new JButton("Hesapları Listele");
        JButton paraYatirBtn = new JButton("Para Yatır");
        JButton paraCekBtn = new JButton("Para Çek");
        JButton krediBasvuruBtn = new JButton("Kredi Başvurusu Yap");

        // Düğmelerin görünümü özelleştiriliyor.
        stilliDugmeYap(yeniHesapBtn);
        stilliDugmeYap(hesapListeleBtn);
        stilliDugmeYap(paraYatirBtn);
        stilliDugmeYap(paraCekBtn);
        stilliDugmeYap(krediBasvuruBtn);

        // Her bir düğme için ActionListener'lar tanımlanıyor.
        yeniHesapBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Yeni hesap oluşturuluyor ve sonuç alanına bilgi yazdırılıyor.
                Hesap yeniHesap = HesapYonetimi.yeniHesapOlustur();
                hesaplar.add(yeniHesap);
                sonucArea.setText("Yeni hesap oluşturuldu:\n" + yeniHesap);
            }
        });

        hesapListeleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hesaplar listeleniyor ve sonuç alanına bilgi yazdırılıyor.
                sonucArea.setText("Hesaplar:\n");
                for (Hesap hesap : hesaplar) {
                    sonucArea.append(hesap.toString() + "\n");
                }
            }
        });

        paraYatirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Para yatırma işlemi yapılıyor ve sonuç alanına bilgi yazdırılıyor.
                HesapYonetimi.paraYatir(hesaplar, sonucArea);
            }
        });

        paraCekBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Para çekme işlemi yapılıyor ve sonuç alanına bilgi yazdırılıyor.
                HesapYonetimi.paraCek(hesaplar, sonucArea);
            }
        });

        krediBasvuruBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kredi başvurusu yapılıyor ve sonuç alanına bilgi yazdırılıyor.
                KrediYonetimi.krediBasvuruYap(hesaplar, sonucArea);
            }
        });

        // Düğmeler panelde sırayla ekleniyor.
        panel.add(yeniHesapBtn);
        panel.add(hesapListeleBtn);
        panel.add(paraYatirBtn);
        panel.add(paraCekBtn);
        panel.add(krediBasvuruBtn);

        // Sonuç alanı için JTextArea ve bir JScrollPane oluşturuluyor.
        sonucArea = new JTextArea();
        sonucArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(sonucArea);
        panel.add(scrollPane);

        // Panel JFrame'e ekleniyor.
        add(panel);

        // JFrame'in özellikleri belirleniyor.
        setTitle("Banka Otomasyonu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true); // Bu satırı ekledim
    }

    // Düğme stillerini özelleştiren metot.
    private void stilliDugmeYap(JButton button) {
        button.setBackground(new Color(46, 204, 113)); // Yeşil renk
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }
}
