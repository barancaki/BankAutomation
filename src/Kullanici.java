// Kullanici sınıfı, banka otomasyonu için kullanıcı bilgilerini temsil eder.
public class Kullanici {

    // Kullanıcının adı ve şifresi
    private String kullaniciAdi;
    private String sifre;

    // Kullanıcı sınıfının yapıcı metodu, kullanıcı adı ve şifre alarak bir kullanıcı oluşturur.
    public Kullanici(String kullaniciAdi, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }

    // Kullanıcının adını getiren metot.
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    // Kullanıcının şifresini getiren metot.
    public String getSifre() {
        return sifre;
    }
}
