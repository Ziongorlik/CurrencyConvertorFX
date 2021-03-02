package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static void write(List<Result> resultList, String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Result result : resultList) {
                out.writeObject(result);
            }
        }
    }

    public static List<Result> read(String fileName) throws IOException, ClassNotFoundException {
        List<Result> resultList = new ArrayList<>();
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream input = new ObjectInputStream(fis);

        Result result = null;
        boolean go = true;

        while (go) {
            if (fis.available() != 0) {
                result = (Result) input.readObject();
                resultList.add(result);
            } else {
                go = false;
            }
        }

        return resultList;
    }
}