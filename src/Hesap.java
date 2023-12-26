import javax.swing.JOptionPane;

// Hesap sınıfı, bir banka hesabını temsil eder.
public class Hesap {

    private static int hesapSayac = 1;

    private String hesapNumarasi;
    private String hesapSahibi;
    private double bakiye;

    // Hesap sınıfının yapıcı metodu, bir hesap oluştururken çağrılır.
    public Hesap(String hesapSahibi, double bakiye) {
        // Her hesap oluşturulduğunda unique bir hesap numarası atanır.
        this.hesapNumarasi = "H" + hesapSayac++;
        this.hesapSahibi = hesapSahibi;
        this.bakiye = bakiye;
    }

    // Hesap numarasını getiren metot.
    public String getHesapNumarasi() {
        return hesapNumarasi;
    }

    // Bakiyeyi getiren metot.
    public double getBakiye() {
        return bakiye;
    }

    // Belirtilen tutarı hesaba yatıran metot.
    public void paraYatir(double tutar) {
        if (tutar > 0) {
            bakiye += tutar;
            System.out.println(tutar + " TL hesabınıza yatırıldı. Yeni bakiye: " + bakiye + " TL");
        } else {
            // Geçersiz tutar durumunda kullanıcıya uyarı mesajı gösterilir.
            JOptionPane.showMessageDialog(null, "Geçersiz tutar. Pozitif bir değer giriniz.", "Uyarı", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Belirtilen tutarı hesaptan çeken metot.
    public boolean paraCek(double tutar) {
        if (tutar > 0 && tutar <= bakiye) {
            bakiye -= tutar;
            System.out.println(tutar + " TL hesabınızdan çekildi. Yeni bakiye: " + bakiye + " TL");
            return true;
        } else {
            // Geçersiz tutar veya yetersiz bakiye durumunda kullanıcıya uyarı mesajı gösterilir.
            JOptionPane.showMessageDialog(null, "Geçersiz tutar. Lütfen uygun bir miktar giriniz.", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    // Kredi başvurusu yapma metodu.
    public boolean krediBasvuru(double gelir, double krediMiktari) {
        if (gelir >= 1000 && krediMiktari > 0 && krediMiktari <= gelir * 5) {
            bakiye += krediMiktari;
            System.out.println("Kredi başvurunuz onaylandı. " + krediMiktari + " TL hesabınıza yatırıldı.");
            return true;
        } else {
            // Kredi başvurusu reddedildiğinde veya geçersiz durumda kullanıcıya uyarı mesajı gösterilir.
            JOptionPane.showMessageDialog(null, "Kredi başvurunuz reddedildi. Lütfen geçerli bir miktar giriniz.", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    // Hesap bilgilerini metin olarak döndüren metot.
    @Override
    public String toString() {
        return "Hesap Numarası: " + hesapNumarasi + ", Sahibi: " + hesapSahibi + ", Bakiye: " + bakiye + " TL";
    }
}
