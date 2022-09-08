package OkulProjesi;

import java.util.Scanner;

public class Depo {

    static Scanner scan =new Scanner(System.in);

    public static void anaMenu() throws InterruptedException {

        String tercih="";
        do{
        System.out.println("================YILDIZ KOLEJI================"+
                "\n================  ANAMENU  ================\n"+
                "\n" +
                "\t  1- Okul Bilgileri Goruntule\n+" +
                "\t  2- Ogretmen Menu\n"+
                "\t  3- Ogrenci Menu\t\t\n"+
                "\t  Q- CIKIS");

        System.out.println("lutfen menuden tercihinizi yapiniz");
        tercih=scan.nextLine();

        switch (tercih){
            case "1" :// okul bilgilerine gıtmesi lazım
                Depo.okulBilgileriniyazdir();
                break;
            case "2" :
                ogretmen.ogretmenMenu();
                break;
            case "3" :
                ogrenci.ogrenciMenu();
                break;
            case "q" :
            case "Q" :
                break;
            default:
                System.out.println("lutfen gecerli bir tercih giriniz");
        }


        }while (!tercih.equalsIgnoreCase("q"));

        Depo.projedurdur();
    }

    public static void okulBilgileriniyazdir() throws InterruptedException {
        System.out.println("================YILDIZ KOLEJI================\n"+
                "\t\t adres  :"+ okul.adres+
                "\n\t\t telefon :"+okul.telefon);

        Thread.sleep(5000);

    }

    static void projedurdur() {

        System.out.println("okul projesinden ciktiniz");
        System.exit(0);
    }
}
