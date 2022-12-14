package Intellegent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Market_HC2 {


    public static class Market {

	/* Basrili Market alis-veris programi.
     *{d,p,...l} {2.10,3.20....0.50}
     * 1. Adim: Ürünler ve fiyatlari iceren listeleri olusturunuz.
     *          No     Ürün         Fiyat
               ====  =======        =========
                00   Domates         2.10 TL
                01   Patates         3.20 TL
                02   Biber           1.50 TL
                03   Sogan          2.30 TL
                04   Havuc              3.10 TL
                05   Elma            1.20 TL
                06   Muz             1.90 TL
                07   Cilek              6.10 TL
                08   Kavun           4.30 TL
                09   Üzüm              2.70 TL
                10   Limon           0.50 TL
     * 2. Adim: Kullanicinin ürün nosuna göre listeden ürün secmesini isteyiniz.
     * 3. Adim: Kaç kg satin almak istedigini sorunuz.
     * 4. Adim: Alinacak bu ürünü sepete ekleyiniz ve Sepeti yazdiriniz.
     * 5. Baska bir ürün alip almak istemedigini sorunuz.
     * 6. Eger devam etmek istiyorsa yeniden ürün seçme kismina yönlendiriniz.
     * 7. Eger bitirmek istiyorsa ödeme kismina geciniz ve ödeme sonrasinda programi bitiriniz.
     */

        public static List<String> urunler = new ArrayList();
        public static List<Double> fiyatlar = new ArrayList();
        public static List<String> sepettekiUrunler = new ArrayList();
        public static List<Double> sepettekiFiyat = new ArrayList();
        public static List<Double> sepettekiKilo = new ArrayList();

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);

            urunler.addAll(Arrays.asList("Domates", "Patates", "Biber", "Sogan", "Havuç", "Elma","Muz  ", "Cilek", "Kavun", "Uzum", "Limon"));
            fiyatlar.addAll(Arrays.asList(2.1, 3.2, 1.5, 2.3, 3.1, 1.2, 1.9, 6.1, 4.3, 2.7, 0.5));
            int urunNo;
            double kg = 0.0;
            String devam;
            double toplam = 0.0;


            do {

                urunleriListele();
                System.out.println("Almak istediginiz urunun numarasini girin: ");
                urunNo = scan.nextInt();
                System.out.println("kaç kilo almak istiyorsunuz: ");
                kg = scan.nextDouble();
                sepeteEkle(urunNo, kg);
                toplam = sepetiYazdir();
                System.out.println();
                System.out.println("devam etmek istiyor musunuz(E/H)");
                devam = scan.next();

            } while (devam.equalsIgnoreCase("E"));

            odemeYap(toplam);

        }

        public static void odemeYap(double toplam) {

            Scanner scan = new Scanner(System.in);

            double miktar = 0;
            System.out.println("--------------------------------------------");
            System.out.println("odemeniz gereken miktar= " + toplam);
            System.out.println("------------------------------------------");

            do {

                System.out.println("Ne kadar paraniz var");
                miktar += scan.nextDouble();
                if (miktar < toplam) {
                    System.out.println("Paraniz yetersiz, ekleme yapin");
                    System.out.println("Ekleme yapacaginiz miktar : " + (toplam - miktar));
                }
            } while (miktar <= toplam);
            System.out.println("----------------------------------------------------");
            System.out.println("Su ana kadar" + miktar + " kadar odeme yaptiniz");
            System.out.println("toplam borcunuz " + toplam);
            System.out.println("--------------------------------------------------");

            System.out.println("para üstünüz= " + (miktar - toplam));
            System.out.println("Bizi tercih ettiginiz için tesekkürler");

        }

        public static double sepetiYazdir() {

            double sepettekiToplam = 0.0;
            System.out.println("URUNADI\tKILO\tTUTAR");
            System.out.println("------------------------------------------");
            for (int i = 0; i < sepettekiUrunler.size(); i++) {

                System.out.println(sepettekiUrunler.get(i) + "\t" + sepettekiKilo.get(i) + "\t\t" + sepettekiFiyat.get(i));
                sepettekiToplam += sepettekiFiyat.get(i);

            }

            return sepettekiToplam;


        }

        public static void sepeteEkle(int urunNo, double kg) {

            sepettekiUrunler.add(urunler.get(urunNo));
            sepettekiKilo.add(kg);
            sepettekiFiyat.add(fiyatlar.get(urunNo)*kg);


        }

        public static void urunleriListele() {

            System.out.println("NO\tURUNLER\t\tFIYATLAR");
            System.out.println("-------------------------------------------------------------");

            for (int i = 0; i < urunler.size(); i++) {

                System.out.println(i + "\t" + urunler.get(i) + "\t\t" + fiyatlar.get(i));
            }


        }

    }
}
