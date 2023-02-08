package module10;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    public void numberValidator() {
        File file = new File("file.txt");
        String result = "";
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    result = scanner.nextLine();
                    boolean isMatch = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[-.]?\\d{4}$")
                            .matcher(result)
                            .find();
                    if (isMatch == true) {
                        System.out.println(result);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}







