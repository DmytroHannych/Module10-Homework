package module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

public class JsonTask2 {

    public void userGsonReader() {

        File file = new File("file1.txt");
        List<UserDto> list = new ArrayList<>();
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    String line = scanner.nextLine() + " ";
                    if (!line.contains("name")) {
                        String[] array = line.split(" ");
                        UserDto userDto = new UserDto(array[0], array[1]);
                        list.add(userDto);
                    }
                }
                FileWriter fileWriter = new FileWriter("user.json", true);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                fileWriter.write(gson.toJson(list));
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
