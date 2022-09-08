package OkulProjesi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ogrenci {

    static Scanner scan=new Scanner(System.in);
    static Map<String,String> ogrencilermap= new HashMap<>();

    public static void feykOgrenciEkle(){

        ogrencilermap.put("123456789541","Ali, Can, 2008, 3569, 12, A");
        ogrencilermap.put("123456789562","Veli, Yan, 2008, 3559, 12, B");
        ogrencilermap.put("123456789583","Ayse, Can, 2007, 4569, 12, A");
        ogrencilermap.put("123456789574","Ali, San, 2009, 1569, 11, A");
        ogrencilermap.put("123456789595","Alp, Yan, 2009, 3769, 11, A");

    }
    public static void ogrenciMenu() throws InterruptedException {
    String tercih="";
        do {


        System.out.println("================YILDIZ KOLEJI================"+
                "\n================  OGRENCI MENU  ================\n"+
                "\n"+
                "\t 1-Ogrenciler listesi yazdir \n"+
                "\t 2-Soyisimden Ogrenci Bulma\n"+
                "\t 3-Sinif ve Sube Ile Ogrenci Bulma\n"+
                "\t 4-Bilgilerini girerek Ogrenci Ekleme\n"+
                "\t 5-Kimlik No ile Kayit Silme\n"+
                "\t A-ANA MENU \n"+
                "\t Q CIKIS\n" );

        tercih=scan.nextLine();
        switch (tercih){

            case "1":
                ogrenciListesiYazdir();
                break;
            case "2":
                soyIsimdenOgrenciBulma();
                break;
            case "3":
                SinifVeSubeİleOgrenciBulma();
                break;
            case "4":
                ogrenciEkle();
                break;
            case "5":
                tcNOIleOgrenciSilme();
                break;
            case "a":
            case "A":
                Depo.anaMenu();
                break;
            case "q":
            case "Q":
                Depo.projedurdur();
                break;
        }

        }while (!tercih.equalsIgnoreCase("q"));// tercih Q olmadığı muddetce calismaya devam etsin
           Depo.projedurdur();// Q ya bastıgında depo dakı projeyi durdur metodu calisacak
    }



    public static void ogrenciListesiYazdir() throws InterruptedException {
        Set<Map.Entry<String,String>> myEntrySet=ogrencilermap.entrySet();
/*
ogrenci bilgilerimiz bir map in içinde ben bunları duzenlı olarak yazdırmak ıstıyorum. duzenlı olarak
yazdırabılmek içinde EntrySet e ihtiyacım var. key ve value leri ayrı ayrı parcadan olusan Entry set e atıyorum

Entry aynı mapler gıbı key ve value lerden olusuyor ancak biz Entry de daha rahat değişiklik yapabılıyoruz.
 */
        System.out.println("================YILDIZ KOLEJI================"+
                "\n================  OGRENCI LISTESI  ================\n " +
                "Tc No        Isim   Soyisim    D Yili   Okul No  Sinif  Sube");

        for (Map.Entry<String,String> each:myEntrySet) {

        String eachkey= each.getKey();
        String eachValue=each.getValue();
        String eachValuearr[]=eachValue.split(", ");// virgullerden ayırarak index olarak ayıracak bu sekılde

            System.out.printf("%-12s  %-6s  %-9s  %-7s  %-8s  %-5s  %-2s \n",eachkey, eachValuearr[0],eachValuearr[1],eachValuearr[2],eachValuearr[3],
                    eachValuearr[4],eachValuearr[5]);

        }
        Thread.sleep(5000);
    }

    public static void soyIsimdenOgrenciBulma() throws InterruptedException {
        Set<Map.Entry<String,String>> myEntrySet=ogrencilermap.entrySet();

        System.out.println("istediginiz ogrenci soyismini yaziniz");
        String istenilenSoyIsim=scan.nextLine();
        System.out.println("================YILDIZ KOLEJI================"+
                "\n================  OGRENCI LISTESI  ================\n " +
                "Tc No        Isim   Soyisim    D Yili   Okul No  Sinif  Sube");

        for (Map.Entry<String,String> each:myEntrySet) {

            String eachkey= each.getKey();
            String eachValue=each.getValue();
            String eachValuearr[]=eachValue.split(", ");// virgullerden ayırarak index olarak ayıracak bu sekılde

           if (istenilenSoyIsim.equalsIgnoreCase(eachValuearr[1])){

               System.out.printf("%-12s  %-6s  %-9s  %-7s  %-8s  %-5s  %-2s \n",eachkey, eachValuearr[0],eachValuearr[1],eachValuearr[2],eachValuearr[3],
                       eachValuearr[4],eachValuearr[5]);
           }

        }
        Thread.sleep(5000);

    }
    public static void SinifVeSubeİleOgrenciBulma() throws InterruptedException {
        Set<Map.Entry<String,String>> myEntrySet=ogrencilermap.entrySet();
        System.out.println("istediginiz ogrenci sinifini yaziniz");
        String istenilensinif=scan.nextLine();
        System.out.println("istediginiz ogrenci subesini yaziniz");
        String istenilensube=scan.nextLine();
        System.out.println("================YILDIZ KOLEJI================"+
                "\n================  OGRENCI LISTESI  ================\n " +
                "Tc No        Isim   Soyisim    D Yili   Okul No  Sinif  Sube");

        for (Map.Entry<String,String> each:myEntrySet) {

            String eachkey= each.getKey();
            String eachValue=each.getValue();
            String eachValuearr[]=eachValue.split(", ");// virgullerden ayırarak index olarak ayıracak bu sekılde

            if (istenilensinif.equalsIgnoreCase(eachValuearr[4]) && istenilensube.equalsIgnoreCase(eachValuearr[5])){

                System.out.printf("%-12s  %-6s  %-9s  %-7s  %-8s  %-5s  %-2s \n",eachkey, eachValuearr[0],eachValuearr[1],eachValuearr[2],eachValuearr[3],
                        eachValuearr[4],eachValuearr[5]);
            }

        }
        Thread.sleep(5000);
    }
    public static void ogrenciEkle() {

        System.out.println("Tc No");
        String tcno=scan.nextLine();
        System.out.println("isim");
        String isim=scan.nextLine();
        System.out.println("soy isim");
        String soyisim=scan.nextLine();
        System.out.println("dogum yili");
        String dogumyili=scan.nextLine();
        System.out.println("okul no");
        String okulno=scan.nextLine();
        System.out.println("sinif");
        String sinif=scan.nextLine();
        System.out.println("sube");
        String sube=scan.nextLine();

        String key= tcno;
        String value= isim+ ", "+ soyisim+", "+ dogumyili+", "+ okulno+", "+
                sinif+", "+sube;

        ogrencilermap.put(key, value);


    }
    public static void tcNOIleOgrenciSilme() {

        System.out.println("silinecek ogrenci kimlik numarasi giriniz");
        String silinecekOgrenci=scan.nextLine();
        String silinecekValue=ogrencilermap.get(silinecekOgrenci);
        String sonucValue=ogrencilermap.remove(silinecekOgrenci);

        try{
            boolean sonuc=sonucValue.equals(silinecekValue);
        }catch (Exception e){
            System.out.println("istediginiz tc numarasi ile ogrenci bulunamadi");
        }




    }
}
