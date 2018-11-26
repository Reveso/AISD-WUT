package base.compression;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class LZWDecoder implements DictionaryManager {

    public void decodeFile(File fileToDecode, File decodedFile, File dictionaryFile) throws IOException {
        //populuje biblioteke (metoda z interfejsu DictionaryManager)
        List<String> dictionary = populateDictionaryList(dictionaryFile);

        performDecoding(fileToDecode, decodedFile, dictionary);
    }

    private void performDecoding(File fileToDecode, File decodedFile, List<String> dictionary) throws IOException {
        BufferedWriter decodingWriter = new BufferedWriter(new FileWriter(decodedFile));
        Scanner decodingReader = new Scanner(new FileReader(fileToDecode));

        Integer cW, pW;
        String p, c, pc;
        if (decodingReader.hasNextInt()) {
            //cW = pierwsza cyfra z pliku do dekompresji
            cW = decodingReader.nextInt();
            //ciąg o indeksie zapisz cW do pliku po dekompresji
            decodingWriter.write(dictionary.get(cW));
            pW = cW;
        } else throw new IOException("Wrong file");

        while (decodingReader.hasNextInt()) {
            //cW = pierwsza cyfra z pliku do dekompresji
            cW = decodingReader.nextInt();
            //czy biblioteka ma w sobie index równy cW
            if(dictionary.size() > cW) {
                //jeśli tak:
                //ciąg o indeksie cW zapisz do pliku do dekompresji
                decodingWriter.write(dictionary.get(cW));
                //p = ciąg o indeksie pW
                p = dictionary.get(pW);
                //c = pierwszy charakter ciągu o indeksie cW
                c = String.valueOf(dictionary.get(cW).charAt(0));
            } else {
                //jeśli nie:
                //p = ciąg o indeksie pW
                p = dictionary.get(pW);
                //c = pierwszy charakter ciągu o indeksie pW
                c = String.valueOf(dictionary.get(pW).charAt(0));
                //zapisz p+c do pliku
                decodingWriter.write(p+c);
                //dodaj p+c do biblioteki
                dictionary.add(p+c);
            }
            //dodaj p+c do biblioteki
            dictionary.add(p+c);
            pW = cW;
        }
    }
}
