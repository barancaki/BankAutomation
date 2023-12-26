import javax.swing.*;
import java.util.ArrayList;

// KrediYonetimi sınıfı, kredi başvurularını yönetir.
public class KrediYonetimi {

    // Kredi başvurusu yapma metodu.
    public static void krediBasvuruYap(ArrayList<Hesap> hesaplar, JTextArea sonucArea) {
        // Kullanıcıdan hesap numarasını alarak ilgili hesabı bulur.
        String hesapNumarasi = JOptionPane.showInputDialog(null, "Hesap Numaranızı Girin:");
        Hesap hesap = HesapYonetimi.findHesap(hesaplar, hesapNumarasi);
        if (hesap != null) {
            try {
                // Kullanıcıdan aylık gelir ve kredi miktarını alarak kredi başvurusu yapar.
                double gelir = Double.parseDouble(JOptionPane.showInputDialog(null, "Aylık Gelirinizi Girin:"));
                double krediMiktari = Double.parseDouble(JOptionPane.showInputDialog(null, "Başvurduğunuz Kredi Miktarını Girin:"));
                if (hesap.krediBasvuru(gelir, krediMiktari)) {
                    // Kredi başvurusu onaylandığında bilgi mesajı gösterilir.
                    sonucArea.setText("Kredi başvurunuz onaylandı. " + krediMiktari + " TL hesabınıza yatırıldı.");
                } else {
                    // Kredi başvurusu reddedildiğinde bilgi mesajı gösterilir.
                    sonucArea.setText("Kredi başvurunuz reddedildi.");
                }
            } catch (NumberFormatException ex) {
                // Geçersiz değer formatı durumunda kullanıcıya uyarı mesajı gösterilir.
                sonucArea.setText("Geçersiz değer formatı");
            }
        } else {
            // Hesap bulunamadı durumunda kullanıcıya bilgi mesajı gösterilir.
            sonucArea.setText("Hesap bulunamadı");
        }
    }
}
