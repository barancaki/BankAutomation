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
        bakiye += tutar;
    }

    public boolean paraCek(double tutar) {
        if (tutar > bakiye) {
            return false;
        } else {
            bakiye -= tutar;
            return true;
        }
    }

    public boolean krediBasvuru(double gelir, double krediMiktari) {
        if (gelir >= 1000 && krediMiktari <= gelir * 5) {
            bakiye += krediMiktari;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Hesap Numarası: " + hesapNumarasi + ", Sahibi: " + hesapSahibi + ", Bakiye: " + bakiye + " TL";
    }
}
