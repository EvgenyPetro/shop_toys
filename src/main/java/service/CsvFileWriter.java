package service;

import model.Toy;
import utils.ToyMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriter {


    public void writeFile(File file, List<Toy> toyList) {
        try (FileWriter fw = new FileWriter(file,true)) {

            toyList.forEach(toy -> {
                try {
                    fw.append(ToyMapper.toyToString(toy));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
