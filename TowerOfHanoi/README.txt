#Portf�lje


##Stack og heap

En stack er en mindre m�ngde af hukommelse allokeret  til en process.
Stack baseret hukommelse er et simpelt LIFO(Last In First Out) system, som er hurtigere end systemet brugt til den dynamiske heap-hukkommelse.
P� stacken lagres der for eksempel: primitive datatyper, adresser til objekter p� heapen, og andre funktions kald.

Heap-hukkomelse er ikke organiseret ligesom p� stacken, det tager oftest l�ngere tid at finde noget p� heapen, end p� stacken(delvist fordi at heapen oftest er meget st�rer).
P� heapen er mindre elementer er de hurtigst fundne elementer.
Objekter bliver lagret p� heapen.


##JVM JRE og JDK

JVM eller Java Virtual Machine er er den virrtuelle maskine som k�rer alt java byte-kode. Den gengiver et fuldt system som prossesen kan k�rer i.
JVM kan allokerer egen CPU kraft og hukkommelse, som giver flere processer plads til at k�rer sammen.

JRE er akronymet for Java Runtime Environment. JRE er en standalone JVM. Det bruges til browser baseret java applikationer.

JDK, Java Development Kit bruges, ligesom et normalt til udvikling af programmer i java.
JDK inkluderer en JVM og v�rkt�jer til udvikling af java applikationer.


## IntelliJ IDEA

IntelliJ IDEA er et IDE for blandt andet java udvikling. IDEA st�r for Intergrated Development Invironment Aplicaction.
IntelliJ IDEA indeholder mange hj�lpsomme funktioner, men ogs� nogle knap s� hj�lpsomme.
Funktioner inkluderer "Coding assistance", "Built in tools and integration", "Plugin ecosystem" (se mere p� [Wikipedia](https://en.wikipedia.org/wiki/IntelliJ_IDEA#Features)) og integration med allerede eksisterende version control systemer.


##Primitive typer

En liste som kort beskriver hver primitiv datatype:

Fixed Point Typer:

  *Byte: Den mindste integer type. St�rrelse p� 8 bit.
  *Short: En "kort" integer type. St�rrelse 16 bit.
  *Int: Gamle standard for integer typen. St�rrelse 32 bit.
  *Long: Nyerer standard for integer typer. St�rrelse 64 bit.

Floating Point Typer:

  *Float: Den mindste float type. st�rrelse p� 32 bit.
  *Double: Den nyerer standard for float typer. st�rrelse 64 bit.

Andre typer

  *Boolean: st�rrelse 1 bit. bruges ofte til at lagrer sandt/falsk.  
  *Char: st�rrelse 16 bit. kan indehole et tegn.
  

##Accessor

En accessor er en funktion som henter en v�rdi, uden at �ndre nogle v�rdier hos m�let.
fx:
	public int getGreen() {
       		return green;
	}

##Methode signatur

methode signaturen bestemmer hvilke parametre som methoden kr�ver og hvilke argumenter som retuneres af methoden.

Nedest�ende methode har signaturen void (int,int,int).
public void set(int red, int green, int blue){


##Returtype

Returtypen af en methode bestemmer hvilken datatype som returneres.
Returtypen void bestemmer at intet returneres, den returnerer ikke null.
Kald til en vodfunktion kan ikke lagrers i et variabel som fx. en int eller string kan.


##Pakker

En pakke er en samling af klasser og andre n�dv�ndige filer et program har brug for for at fungerer.


##En klasser

Er sandsynligvis en "typo".


##Klasser

er programfiler fo java, de indeholder kildekoden for programmer og fungerer som skabelon for objekter.


##Objekter

Et objekt er en instans af en klasse. Klassen beskriver hvordan objektet opf�rer sig, men ikke objektets v�rdier.


##Referencer

En reference er en symbolisering af data.
fx: 
int Heltal = 4
Dette er en reference til data i form af tallet fire som datatypen int. referencen heder Heltal, hvis den kaldes vil den fungerer som en reference til tallet 4 og kaldet vil se Heltal som tallet 4.