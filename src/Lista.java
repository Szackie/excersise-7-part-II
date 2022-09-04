import java.io.FileWriter;
import java.io.IOException;

class Lista {
    int[] liczby;
    int pojemnosc;
    int rozmiar;

    Lista(int pojemnosc) {
        this.pojemnosc = pojemnosc;
        this.liczby = new int[pojemnosc];
        this.rozmiar = 0;
    }

    void dodajElement(int element) {
        if (this.rozmiar == this.pojemnosc) {
            System.out.println("Lista jest pełna");
        } else {
            this.liczby[rozmiar] = element;
            rozmiar++;
        }
    }

    int znajdz(int szukanyElement) {
        for (int i = 0; i < rozmiar; i++) {
            if (liczby[i] == szukanyElement)
                return i;
        }
        return -1;
    }

    void pisz() {
        System.out.println("Informacje o liscie: ");
        System.out.println("Pojemnosc: " + pojemnosc);
        System.out.println("Rozmiar: " + rozmiar);
        System.out.println("Lista elementów: ");
        for (int liczba : liczby) {
            System.out.println(liczba);
        }
    }

    void usunPierwszy(int element) {
        if (znajdz(element) != -1) {
            for (int i = znajdz(element); i < rozmiar-1; i++)
                liczby[i] = liczby[i + 1];
            liczby[rozmiar-1] = 0;
            rozmiar--;
        }
        else
            System.out.println("Nie znaleziono podanego elementu na liscie");

    }
    void usunPowtorzenia(){
        for(int i=rozmiar-1;i>=0;i--)
        if(znajdz(liczby[i])!=i)
            usunPierwszy(liczby[i]);
    }
    @SuppressWarnings("unused")
    void odwroc() {
        int temp;
        for (int i = 0; i <= rozmiar / 2; i++)
        {
            temp=liczby[i];
            liczby[i]=liczby[rozmiar-i];
            liczby[rozmiar-i]=temp;
        }
    }
    @SuppressWarnings("unused")
    void zapiszDoPliku(String nazwaPliku){
        try {
            FileWriter writer=new FileWriter(nazwaPliku);
            for(int i=0;i<rozmiar;i++)
            writer.write(liczby[i]);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){
        final int N = 10;
        Lista l = new Lista(N);
        for (int i = 0; i < N/2; ++i) {
            l.dodajElement( (1 << i) );
        }
        l.dodajElement(2);
        l.dodajElement(8);
        l.pisz();
        l.usunPierwszy(2);
        l.pisz();
        for (int i = 0; i < N/2; ++i) {
            l.dodajElement( (1 << i) );
        }
        l.pisz();
        System.out.println("Po usunięciu powtórzeń:");
        l.usunPowtorzenia();
        l.pisz();

    }
}
