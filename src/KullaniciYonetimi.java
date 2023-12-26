import javax.swing.*;
import java.util.ArrayList;

// KullaniciYonetimi sınıfı, kayıtlı kullanıcıları yönetir.
public class KullaniciYonetimi {

    // Kayıtlı kullanıcıların listesi
    private static ArrayList<Kullanici> kayitliKullanicilar = new ArrayList<>();

    // Yeni kullanıcı kaydı oluşturan metot.
    public static void kullaniciKayit(String kullaniciAdi, String sifre, ArrayList<Kullanici> kayitliKullanicilar) {
        // Eğer kullanıcı daha önce kaydedilmemişse, yeni kullanıcı oluşturulup listeye eklenir.
        if (!kullaniciVarMi(kullaniciAdi)) {
            Kullanici yeniKullanici = new Kullanici(kullaniciAdi, sifre);
            kayitliKullanicilar.add(yeniKullanici);
        }
    }

    // Kullanıcı girişi kontrolü yapan metot.
    public static boolean kullaniciGiris(String kullaniciAdi, String sifre, ArrayList<Kullanici> kayitliKullanicilar) {
        // Kayıtlı kullanıcılar arasında kullanıcı adı ve şifresi uyan bir kullanıcı varsa true döner.
        for (Kullanici kullanici : kayitliKullanicilar) {
            if (kullanici.getKullaniciAdi().equals(kullaniciAdi) && kullanici.getSifre().equals(sifre)) {
                return true;
            }
        }
        // Uygun kullanıcı bulunamazsa false döner.
        return false;
    }

    // Belirtilen kullanıcı adının kayıtlı olup olmadığını kontrol eden yardımcı metot.
    private static boolean kullaniciVarMi(String kullaniciAdi) {
        for (Kullanici kullanici : kayitliKullanicilar) {
            if (kullanici.getKullaniciAdi().equals(kullaniciAdi)) {
                return true;
            }
        }
        return false;
    }
}
