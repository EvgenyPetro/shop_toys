package service;

import model.Toy;

import java.io.File;
import java.util.List;

public class CsvFileManager implements FileManager {
    private File file;
    private CsvFileWriter csvFileWriter;
    private CsvFileReader csvFileReader;

    public void writeFile(List<Toy> toyList) {
        csvFileWriter.writeFile(file, toyList);
    }

    public List<Toy> readFile() {
        return csvFileReader.readFile(file);
    }
}
