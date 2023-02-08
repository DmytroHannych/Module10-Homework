package module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonTask2 {

    public void userGsonReader()  {
        UserDto userDto = new UserDto();
        File file = new File("file1.txt");
        if (file.exists()) {

            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] array = line.split(" ");
                    userDto.setName(array[0]);
                    userDto.setAge(array[1]);
                    FileWriter fileWriter = new FileWriter("user.json", true);
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    fileWriter.write(gson.toJson(userDto));
                    fileWriter.close();
                }
            }  catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
