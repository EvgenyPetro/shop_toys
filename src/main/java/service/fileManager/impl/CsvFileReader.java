package service.fileManager.impl;

import model.Toy;
import utils.ToyMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvFileReader {
    public List<Toy> readFile(File file) {
        List<Toy> toyList = new ArrayList<>();

        try (FileReader fr = new FileReader(file)) {
            Scanner sc = new Scanner(fr);
            while (sc.hasNext()) {
                toyList.add(ToyMapper.stringToToy(sc.nextLine()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return toyList;
    }
}