import javax.swing.*;
import java.util.ArrayList;

public class KullaniciYonetimi {

    private static ArrayList<Kullanici> kayitliKullanicilar = new ArrayList<>();

    public static void kullaniciKayit(String kullaniciAdi, String sifre, ArrayList<Kullanici> kayitliKullanicilar) {
        if (!kullaniciVarMi(kullaniciAdi)) {
            Kullanici yeniKullanici = new Kullanici(kullaniciAdi, sifre);
            kayitliKullanicilar.add(yeniKullanici);
        }
    }

    public static boolean kullaniciGiris(String kullaniciAdi, String sifre, ArrayList<Kullanici> kayitliKullanicilar) {
        for (Kullanici kullanici : kayitliKullanicilar) {
            if (kullanici.getKullaniciAdi().equals(kullaniciAdi) && kullanici.getSifre().equals(sifre)) {
                return true;
            }
        }
        return false;
    }

    private static boolean kullaniciVarMi(String kullaniciAdi) {
        for (Kullanici kullanici : kayitliKullanicilar) {
            if (kullanici.getKullaniciAdi().equals(kullaniciAdi)) {
                return true;
            }
        }
        return false;
    }
}
