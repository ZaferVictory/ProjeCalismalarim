package OkulProjesi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ogretmen {

    // kaydedilen öğretmenleri bir depo gibi bir seye koyanilmem için map a ihtiyacım var
    static Scanner scan= new Scanner(System.in);
    static Map<String, String> ogretmenlerMap=new HashMap<>();

    public static void feykOgretmenEkle(){
        ogretmenlerMap.put("123456789546","Ali, Can, 1980, Matematik");
        ogretmenlerMap.put("123456789565","Veli, Yan, 1981, Fizik");
        ogretmenlerMap.put("123456789587","Ayse, Can, 1982, Kimya");
        ogretmenlerMap.put("123456789578","Ali, San, 1983, Kimya");
        ogretmenlerMap.put("123456789598","Alp, Yan, 1984, Matematik");
    }

    public static void ogretmenMenu() throws InterruptedException {
        String tercih="";
        do {

            System.out.println("================YILDIZ KOLEJI================"+
                    "\n================  ANAMENU  ================\n"+
                    "\n"+
                    "\t 1-Ogretmenler listesi yazdir \t\n"+
                    "\t 2-Soyisimden Ogretmen Bulma\n"+
                    "\t 3-Branstan Ogretmen Bulma\n"+
                    "\t 4-Bilgilerini girerek Ogretmen Ekleme\n"+
                    "\t 5-Kimlik No ile Kayit Silme\n"+
                    "\t A-ANA MENU \n"+
                    "\t Q CIKIS\n" );

            tercih=scan.nextLine();
            switch (tercih){
                case "1"://ogretmen listesini yazdir
                    ogretmenListesiYazdir();
                     break;
                case "2":
                    soyisimdenOgretmenBulma();
                    break;
                case "3":
                    branstanOgretmenBulma();
                    break;
                case "4":
                    OgretmenEkleme();
                    break;
                case "5":
                    tcNoİleogretmenSil();
                    break;
                case "a":
                case "A":
                    Depo.anaMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("Lutfen Gecerli Tercih Yapınız");
            }

        }while (!tercih.equalsIgnoreCase("q"));
        Depo.projedurdur();
    }




    public static void ogretmenListesiYazdir() throws InterruptedException {
       Set<Map.Entry<String,String>> ogretmenEntrySet= ogretmenlerMap.entrySet();
        System.out.println("================YILDIZ KOLEJI================"+
                "\n================  ANAMENU  ================\n"+
                "TcNo         Isim  Soyisim  D.Yili  Brans");

        for (Map.Entry<String,String> each:ogretmenEntrySet) {
            String eacKey=each.getKey();
            String eachValue=each.getValue();

            //System.out.println(eacKey+ " "+ eachValue);

            String eachValuearr[]= eachValue.split(", ");
            System.out.printf("%11s %-6s  %-8s %4s   %s \n" , eacKey,eachValuearr[0],eachValuearr[1],
                    eachValuearr[2],eachValuearr[3]);

        }
        Thread.sleep(5000);

    }
    public static void soyisimdenOgretmenBulma() throws InterruptedException {
        System.out.printf("aradiginiz ogretmenin soyismini giriniz");
        System.out.println("");
        String istenenSoyisim= scan.nextLine();
        Set<Map.Entry<String,String>> ogretmenEntrySet= ogretmenlerMap.entrySet();
        System.out.println("================YILDIZ KOLEJI================"+
                "\n======SOYISIM ILE OGRETMEN ARAMA  ======\n"+
                "TcNo         Isim  Soyisim  D.Yili  Brans");

        for (Map.Entry<String,String> each:ogretmenEntrySet) {
            String eacKey=each.getKey();
            String eachValue=each.getValue();

            String eachValuearr[]= eachValue.split(", ");
            if (istenenSoyisim.equalsIgnoreCase(eachValuearr[1])){
                System.out.printf("%11s %-6s  %-8s %4s   %s \n" , eacKey,eachValuearr[0],eachValuearr[1],
                        eachValuearr[2],eachValuearr[3]);
            }


        }
        Thread.sleep(5000);

    }
    public static void branstanOgretmenBulma() throws InterruptedException {
        System.out.printf("aradiginiz ogretmenin bransını giriniz");
        System.out.println("");
        String istenenBrans= scan.nextLine();

        Set<Map.Entry<String,String>> ogretmenEntrySet= ogretmenlerMap.entrySet();
        System.out.println("================YILDIZ KOLEJI================"+
                "\n======BRANS ILE OGRETMEN ARAMA  ======\n"+
                "TcNo         Isim  Soyisim  D.Yili  Brans");
        for (Map.Entry<String,String> each:ogretmenEntrySet) {
            String eacKey=each.getKey();
            String eachValue=each.getValue();

            String eachValuearr[]= eachValue.split(", ");
            if (istenenBrans.equalsIgnoreCase(eachValuearr[3])){
                System.out.printf("%11s %-6s  %-8s %4s   %s \n" , eacKey,eachValuearr[0],eachValuearr[1],
                        eachValuearr[2],eachValuearr[3]);
            }


        }
        Thread.sleep(5000);
    }
    public static void OgretmenEkleme() {
        System.out.println("tc no");
        String kimlikNo= scan.nextLine();
        System.out.println("isim gir");
        String isim= scan.nextLine();
        System.out.println("soyisim gir");
        String soyisim= scan.nextLine();
        System.out.println("dogum tarihi gir");
        String dogumTarihi= scan.nextLine();
        System.out.println("brans gir");
        String brans= scan.nextLine();

        String eklenecekValue=isim+ ", "+ soyisim+", "+ dogumTarihi+", "+brans;
        ogretmenlerMap.put(kimlikNo,eklenecekValue);


    }
    public static void tcNoİleogretmenSil() {
        System.out.println("silinecek ogretmen kimlik no giriniz");
        String silinecekOgretmen=scan.nextLine();
        String silinecekValue=ogretmenlerMap.get(silinecekOgretmen);
        String sonucValue=ogretmenlerMap.remove(silinecekOgretmen);

        try {
            boolean sonuc=sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz tc numarasi ile ogretmen bulunamadi");
        }

    }
}
