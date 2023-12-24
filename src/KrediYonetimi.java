import javax.swing.*;
import java.util.ArrayList;

public class KrediYonetimi {

    public static void krediBasvuruYap(ArrayList<Hesap> hesaplar, JTextArea sonucArea) {
        String hesapNumarasi = JOptionPane.showInputDialog(null, "Hesap Numaranızı Girin:");
        Hesap hesap = HesapYonetimi.findHesap(hesaplar, hesapNumarasi);
        if (hesap != null) {
            try {
                double gelir = Double.parseDouble(JOptionPane.showInputDialog(null, "Aylık Gelirinizi Girin:"));
                double krediMiktari = Double.parseDouble(JOptionPane.showInputDialog(null, "Başvurduğunuz Kredi Miktarını Girin:"));
                if (hesap.krediBasvuru(gelir, krediMiktari)) {
                    sonucArea.setText("Kredi başvurunuz onaylandı. " + krediMiktari + " TL hesabınıza yatırıldı.");
                } else {
                    sonucArea.setText("Kredi başvurunuz reddedildi.");
                }
            } catch (NumberFormatException ex) {
                sonucArea.setText("Geçersiz değer formatı");
            }
        } else {
            sonucArea.setText("Hesap bulunamadı");
        }
    }
}
