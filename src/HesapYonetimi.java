import javax.swing.*;
import java.util.ArrayList;

// HesapYonetimi sınıfı, hesap işlemlerini yönetir.
public class HesapYonetimi {

    // Yeni hesap oluşturan metot.
    public static Hesap yeniHesapOlustur() {
        // Kullanıcıdan hesap sahibinin adını alarak yeni bir hesap oluşturulur.
        String hesapSahibi = JOptionPane.showInputDialog(null, "Hesap Sahibinin Adını Girin:");
        return new Hesap(hesapSahibi, 0);
    }

    // Belirtilen hesaba para yatıran metot.
    public static void paraYatir(ArrayList<Hesap> hesaplar, JTextArea sonucArea) {
        // Kullanıcıdan hesap numarasını alarak ilgili hesabı bulur.
        String hesapNumarasi = JOptionPane.showInputDialog(null, "Hesap Numarasını Girin:");
        Hesap hesap = findHesap(hesaplar, hesapNumarasi);
        if (hesap != null) {
            try {
                // Kullanıcıdan yatırılacak tutarı alır ve hesaba yatırma işlemi gerçekleştirilir.
                double yatirilanTutar = Double.parseDouble(JOptionPane.showInputDialog(null, "Yatırmak İstediğiniz Tutarı Girin:"));
                hesap.paraYatir(yatirilanTutar);
                sonucArea.setText(yatirilanTutar + " TL yatırıldı.\nYeni Bakiye: " + hesap.getBakiye() + " TL");
            } catch (NumberFormatException ex) {
                // Geçersiz tutar formatı durumunda kullanıcıya uyarı mesajı gösterilir.
                sonucArea.setText("Geçersiz tutar formatı");
            }
        } else {
            // Hesap bulunamadı durumunda kullanıcıya bilgi mesajı gösterilir.
            sonucArea.setText("Hesap bulunamadı");
        }
    }

    // Belirtilen hesaptan para çeken metot.
    public static void paraCek(ArrayList<Hesap> hesaplar, JTextArea sonucArea) {
        // Kullanıcıdan hesap numarasını alarak ilgili hesabı bulur.
        String hesapNumarasi = JOptionPane.showInputDialog(null, "Hesap Numarasını Girin:");
        Hesap hesap = findHesap(hesaplar, hesapNumarasi);
        if (hesap != null) {
            try {
                // Kullanıcıdan çekilecek tutarı alır ve hesaptan çekme işlemi gerçekleştirilir.
                double cekilenTutar = Double.parseDouble(JOptionPane.showInputDialog(null, "Çekmek İstediğiniz Tutarı Girin:"));
                if (hesap.paraCek(cekilenTutar)) {
                    sonucArea.setText(cekilenTutar + " TL çekildi.\nYeni Bakiye: " + hesap.getBakiye() + " TL");
                } else {
                    // Yetersiz bakiye durumunda kullanıcıya bilgi mesajı gösterilir.
                    sonucArea.setText("Yetersiz bakiye. İşlem iptal edildi.");
                }
            } catch (NumberFormatException ex) {
                // Geçersiz tutar formatı durumunda kullanıcıya uyarı mesajı gösterilir.
                sonucArea.setText("Geçersiz tutar formatı");
            }
        } else {
            // Hesap bulunamadı durumunda kullanıcıya bilgi mesajı gösterilir.
            sonucArea.setText("Hesap bulunamadı");
        }
    }

    // Belirtilen hesap numarasına sahip hesabı bulan metot.
    public static Hesap findHesap(ArrayList<Hesap> hesaplar, String hesapNumarasi) {
        for (Hesap hesap : hesaplar) {
            if (hesap.getHesapNumarasi().equals(hesapNumarasi)) {
                return hesap;
            }
        }
        return null;
    }
}
