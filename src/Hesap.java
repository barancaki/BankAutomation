public class Hesap {
    private static int hesapSayac = 1;

    private String hesapNumarasi;
    private String hesapSahibi;
    private double bakiye;

    public Hesap(String hesapSahibi, double bakiye) {
        this.hesapNumarasi = "H" + hesapSayac++;
        this.hesapSahibi = hesapSahibi;
        this.bakiye = bakiye;
    }

    public String getHesapNumarasi() {
        return hesapNumarasi;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void paraYatir(double tutar) {
        if (tutar > 0) {
            bakiye += tutar;
            System.out.println(tutar + " TL hesabınıza yatırıldı. Yeni bakiye: " + bakiye + " TL");
        } else {
            JOptionPane.showMessageDialog(null, "Geçersiz tutar. Pozitif bir değer giriniz.", "Uyarı", JOptionPane.WARNING_MESSAGE);
        }
    }

    public boolean paraCek(double tutar) {
        if (tutar > 0 && tutar <= bakiye) {
            bakiye -= tutar;
            System.out.println(tutar + " TL hesabınızdan çekildi. Yeni bakiye: " + bakiye + " TL");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Geçersiz tutar. Lütfen uygun bir miktar giriniz.", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public boolean krediBasvuru(double gelir, double krediMiktari) {
        if (gelir >= 1000 && krediMiktari > 0 && krediMiktari <= gelir * 5) {
            bakiye += krediMiktari;
            System.out.println("Kredi başvurunuz onaylandı. " + krediMiktari + " TL hesabınıza yatırıldı.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Kredi başvurunuz reddedildi. Lütfen geçerli bir miktar giriniz.", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Hesap Numarası: " + hesapNumarasi + ", Sahibi: " + hesapSahibi + ", Bakiye: " + bakiye + " TL";
    }
}
