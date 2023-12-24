import javax.swing.*;
import java.util.ArrayList;

public class BankaOtomasyonu {

    public static void main(String[] args) {
        ArrayList<Hesap> hesaplar = new ArrayList<>();
        ArrayList<Kullanici> kayitliKullanicilar = new ArrayList<>();
        JTextArea sonucArea = new JTextArea();

        SwingUtilities.invokeLater(() -> new RenkliBankaOtomasyonuUI(hesaplar, kayitliKullanicilar));
    }
}
