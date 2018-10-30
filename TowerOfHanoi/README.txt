#Portfølje


##Stack og heap

En stack er en mindre mængde af hukommelse allokeret  til en process.
Stack baseret hukommelse er et simpelt LIFO(Last In First Out) system, som er hurtigere end systemet brugt til den dynamiske heap-hukkommelse.
På stacken lagres der for eksempel: primitive datatyper, adresser til objekter på heapen, og andre funktions kald.

Heap-hukkomelse er ikke organiseret ligesom på stacken, det tager oftest længere tid at finde noget på heapen, end på stacken(delvist fordi at heapen oftest er meget stører).
På heapen er mindre elementer er de hurtigst fundne elementer.
Objekter bliver lagret på heapen.


##JVM JRE og JDK

JVM eller Java Virtual Machine er er den virrtuelle maskine som kører alt java byte-kode. Den gengiver et fuldt system som prossesen kan kører i.
JVM kan allokerer egen CPU kraft og hukkommelse, som giver flere processer plads til at kører sammen.

JRE er akronymet for Java Runtime Environment. JRE er en standalone JVM. Det bruges til browser baseret java applikationer.

JDK, Java Development Kit bruges, ligesom et normalt til udvikling af programmer i java.
JDK inkluderer en JVM og værktæjer til udvikling af java applikationer.


## IntelliJ IDEA

IntelliJ IDEA er et IDE for blandt andet java udvikling. IDEA står for Intergrated Development Invironment Aplicaction.
IntelliJ IDEA indeholder mange hjælpsomme funktioner, men også nogle knap så hjælpsomme.
Funktioner inkluderer "Coding assistance", "Built in tools and integration", "Plugin ecosystem" (se mere på [Wikipedia](https://en.wikipedia.org/wiki/IntelliJ_IDEA#Features)) og integration med allerede eksisterende version control systemer.


##Primitive typer

En liste som kort beskriver hver primitiv datatype:

Fixed Point Typer:

  *Byte: Den mindste integer type. Størrelse på 8 bit.
  *Short: En "kort" integer type. Størrelse 16 bit.
  *Int: Gamle standard for integer typen. Størrelse 32 bit.
  *Long: Nyerer standard for integer typer. Størrelse 64 bit.

Floating Point Typer:

  *Float: Den mindste float type. størrelse på 32 bit.
  *Double: Den nyerer standard for float typer. størrelse 64 bit.

Andre typer

  *Boolean: størrelse 1 bit. bruges ofte til at lagrer sandt/falsk.  
  *Char: størrelse 16 bit. kan indehole et tegn.
  

##Accessor

En accessor er en funktion som henter en værdi, uden at ændre nogle værdier hos målet.
fx:
	public int getGreen() {
       		return green;
	}

##Methode signatur

methode signaturen bestemmer hvilke parametre som methoden kræver og hvilke argumenter som retuneres af methoden.

Nedestående methode har signaturen void (int,int,int).
public void set(int red, int green, int blue){


##Returtype

Returtypen af en methode bestemmer hvilken datatype som returneres.
Returtypen void bestemmer at intet returneres, den returnerer ikke null.
Kald til en vodfunktion kan ikke lagrers i et variabel som fx. en int eller string kan.


##Pakker

En pakke er en samling af klasser og andre nødvændige filer et program har brug for for at fungerer.


##En klasser

Er sandsynligvis en "typo".


##Klasser

er programfiler fo java, de indeholder kildekoden for programmer og fungerer som skabelon for objekter.


##Objekter

Et objekt er en instans af en klasse. Klassen beskriver hvordan objektet opfører sig, men ikke objektets værdier.


##Referencer

En reference er en symbolisering af data.
fx: 
int Heltal = 4
Dette er en reference til data i form af tallet fire som datatypen int. referencen heder Heltal, hvis den kaldes vil den fungerer som en reference til tallet 4 og kaldet vil se Heltal som tallet 4.