import javax.swing.*;
import java.util.ArrayList;

public class HesapYonetimi {

    public static Hesap yeniHesapOlustur() {
        String hesapSahibi = JOptionPane.showInputDialog(null, "Hesap Sahibinin Adını Girin:");
        return new Hesap(hesapSahibi, 0);
    }

    public static void paraYatir(ArrayList<Hesap> hesaplar, JTextArea sonucArea) {
        String hesapNumarasi = JOptionPane.showInputDialog(null, "Hesap Numarasını Girin:");
        Hesap hesap = findHesap(hesaplar, hesapNumarasi);
        if (hesap != null) {
            try {
                double yatirilanTutar = Double.parseDouble(JOptionPane.showInputDialog(null, "Yatırmak İstediğiniz Tutarı Girin:"));
                hesap.paraYatir(yatirilanTutar);
                sonucArea.setText(yatirilanTutar + " TL yatırıldı.\nYeni Bakiye: " + hesap.getBakiye() + " TL");
            } catch (NumberFormatException ex) {
                sonucArea.setText("Geçersiz tutar formatı");
            }
        } else {
            sonucArea.setText("Hesap bulunamadı");
        }
    }

    public static void paraCek(ArrayList<Hesap> hesaplar, JTextArea sonucArea) {
        String hesapNumarasi = JOptionPane.showInputDialog(null, "Hesap Numarasını Girin:");
        Hesap hesap = findHesap(hesaplar, hesapNumarasi);
        if (hesap != null) {
            try {
                double cekilenTutar = Double.parseDouble(JOptionPane.showInputDialog(null, "Çekmek İstediğiniz Tutarı Girin:"));
                if (hesap.paraCek(cekilenTutar)) {
                    sonucArea.setText(cekilenTutar + " TL çekildi.\nYeni Bakiye: " + hesap.getBakiye() + " TL");
                } else {
                    sonucArea.setText("Yetersiz bakiye. İşlem iptal edildi.");
                }
            } catch (NumberFormatException ex) {
                sonucArea.setText("Geçersiz tutar formatı");
            }
        } else {
            sonucArea.setText("Hesap bulunamadı");
        }
    }

    public static Hesap findHesap(ArrayList<Hesap> hesaplar, String hesapNumarasi) {
        for (Hesap hesap : hesaplar) {
            if (hesap.getHesapNumarasi().equals(hesapNumarasi)) {
                return hesap;
            }
        }
        return null;
    }
}
