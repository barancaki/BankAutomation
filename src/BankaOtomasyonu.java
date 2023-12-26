import javax.swing.*;
import java.util.ArrayList;

public class BankaOtomasyonu {

    public static void main(String[] args) {
        // Hesapları ve kayıtlı kullanıcıları tutmak için ArrayList'ler oluşturuluyor.
        ArrayList<Hesap> hesaplar = new ArrayList<>();
        ArrayList<Kullanici> kayitliKullanicilar = new ArrayList<>();

        // Kullanıcı arayüzü için JTextArea oluşturuluyor.
        JTextArea sonucArea = new JTextArea();

        // SwingUtilities.invokeLater, arayüz güncellemelerini Swing EDT (Event Dispatch Thread) üzerinde gerçekleştirmek için kullanılır.
        // RenkliBankaOtomasyonuUI sınıfı, arayüzü başlatmak ve gerekli parametreleri iletmek için kullanılır.
        SwingUtilities.invokeLater(() -> new RenkliBankaOtomasyonuUI(hesaplar, kayitliKullanicilar));
    }
}
