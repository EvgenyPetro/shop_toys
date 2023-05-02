package service.fileManager.impl;

import model.Toy;
import utils.ToyMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriter {


    public void writeFile(File file, Toy toy) {
        try (FileWriter fw = new FileWriter(file,true)) {

            try {
                fw.append(ToyMapper.toyToString(toy));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFile(File file){
        try (FileWriter fw = new FileWriter(file)) {

            try {
                fw.write("");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
