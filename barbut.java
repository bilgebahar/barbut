import java.security.SecureRandom;
public class BarbutOyunu {
private static final SecureRandom generator = new SecureRandom();
// Kazanma, Kaybetme, Devam etme olasılıkları için oyun durumu
private enum OyunDurumu {
DEVAM,
KAZANDI,
KAYBETTI
};
// Zar toplamlarının kurallarına göre özel durumları 
private static final int IkiGelirse = 2; // Kaybetme Durumu
private static final int UcGelirse = 3; // Kaybetme Durumu
private static final int YediGelirse = 7; // Kazanma Durumu
private static final int OnbirGelirse = 11; // Kazanma Durumu
private static final int OnikiGelirse = 12; // Kaybetme Durumu
public static void main( String ... args ) {
int puan = 0;
OyunDurumu durum;
int ZarlarınToplamı = ZarlarıAt();
switch( ZarlarınToplamı ) {
// 7 yada 11 gelirse kazanma durumu
case YediGelirse:
case OnbirGelirse:
durum = OyunDurumu.KAZANDI;
break;
//  2, 3 yada 12 gelirse kaybetme durumu
case IkiGelirse:
case UcGelirse:
case OnikiGelirse:
durum = OyunDurumu.KAYBETTI;
// 4, 5, 6, 8, 9 yada 10 gelirse oyuna devam etme durumu
default:
durum = OyunDurumu.DEVAM;
puan = ZarlarınToplamı;
System.out.printf( "Oyuncunun puanı %d\n", puan );
break;
}
// Oyun durumuna göre devam etme ya da durma bölümü
while( durum == OyunDurumu.DEVAM ) {
ZarlarınToplamı = ZarlarıAt();
if( ZarlarınToplamı == puan ) {
durum = OyunDurumu.KAZANDI;
} else if( ZarlarınToplamı == YediGelirse ) {
durum = OyunDurumu.KAYBETTI;
}
}
if( durum == OyunDurumu.KAZANDI ) {
System.out.println( "Oyuncu Kazandı" );
} else {
System.out.println( "Oyuncu Kaybetti" );
}
}
// Zarların atılıp, toplanması
public static int ZarlarıAt() {
int BirinciZar = 1 + generator.nextInt( 6 );
int IkinciZar = 1 + generator.nextInt( 6 );
System.out.printf( "Oyuncunun attığı zar %d ve %d.%n", BirinciZar, IkinciZar );
return BirinciZar + IkinciZar;
}
}
