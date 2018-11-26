package base.compression;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public interface DictionaryManager {

    //Populowanie listy biblioteki każdym symbolem z pliku
    default List<String> populateDictionaryList(File fileToConvert) throws IOException {
        //lista znaków - biblioteka
        List<String> dictionary = new LinkedList<>();
        //otworzenie pliku do konwersji
        Scanner conversionReader = new Scanner(new FileReader(fileToConvert));
        //jeśli plik ma następną linię
        while (conversionReader.hasNextLine()) {
            String line = conversionReader.nextLine();
            //pętla idzie po lini i dodaje znaki do Listy, jeśli się tam nie znajduje
            for (int i = 0; i < line.length(); i++) {
                if (!dictionary.contains(String.valueOf(line.charAt(i)))) {
                    dictionary.add(String.valueOf(line.charAt(i)));
                }
            }
        }
        //zwraca biblioteke
        return dictionary;
    }

    //zapisuje bibliotekę do bliku
    default void saveDictionaryToFile(File dictionaryFile, List<String> dictionary) throws IOException {
        BufferedWriter dictionaryWriter = new BufferedWriter(new FileWriter(dictionaryFile));
        //foreach
        for (String c : dictionary) {
            dictionaryWriter.write(c);
        }
    }
}
