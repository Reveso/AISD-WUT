package base.compression;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class LZWEncoder implements DictionaryManager {

    public void encodeFile(File fileToencode, File encodedFile, File dictionaryFile) throws IOException {

        //populuje biblioteke
        //(metoda z interfejsu DictionaryManager)
        List<String> dictionary = populateDictionaryList(fileToencode);

        //zapisuje bibliotekę pojedynczych znakow do pliku do pliku
        //(metoda z interfejsu DictionaryManager)
        saveDictionaryToFile(dictionaryFile, dictionary);

        performEncoding(fileToencode, encodedFile, dictionary);

    }

    private void performEncoding(File fileToEncode, File encodedFile, List<String> dictionary) throws IOException {
        BufferedWriter encodingWriter = new BufferedWriter(new FileWriter(encodedFile));
        Scanner encodingReader = new Scanner(new FileReader(fileToEncode));
        String p = "";
        String c;
        //sprawdza czy jest nastepna linia w pliku do konwersji
        while (encodingReader.hasNextLine()) {
            String line = encodingReader.nextLine();
            for (int i = 0; i < line.length(); i++) {
                //c = następny symbol z pliku
                c = String.valueOf(line.charAt(i));
                String pc = p + c;
                //sprawdź czy p+c jest już w bibliotece
                if (dictionary.contains(pc)) {
                    //jeśli jest, p = p+c
                    p = pc;
                } else {
                    //jeśli nie:
                    //zapisz p do pliku (konwertowanego)
                    encodingWriter.write(dictionary.indexOf(p) + " ");
                    //dodaj pc do biblioteki
                    dictionary.add(pc);
                    //p = c
                    p = c;
                }
            }
        }
    }
}
