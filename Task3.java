package module10;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Task3 {
    public void countWords()  {
        Map<String, Integer> myMap = new HashMap<>();
        try (InputStream fis = new FileInputStream("words.txt");
             Scanner scanner = new Scanner(fis);) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split(" ");
                for (int i = 0; i < splitLine.length; i++) {
                    String words = splitLine[i];
                    if (myMap.containsKey(words)) {
                        int currentCont = myMap.get(words);
                        myMap.put(words, currentCont + 1);
                    } else {
                        myMap.put(words, 1);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int comp = myMap.get(o1).compareTo(
                        myMap.get(o2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        };
        Map<String, Integer> result = new TreeMap<>(comparator.reversed());
        result.putAll(myMap);
        System.out.println(result);
    }
}