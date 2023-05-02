package service.fileManager.impl;

import model.Toy;
import service.fileManager.FileManager;

import java.io.File;
import java.util.List;

public class CsvFileManager implements FileManager {
    private File file;
    private CsvFileWriter csvFileWriter;
    private CsvFileReader csvFileReader;

    public CsvFileManager(File file) {
        this.file = file;
        this.csvFileWriter = new CsvFileWriter();
        this.csvFileReader = new CsvFileReader();
    }


    @Override
    public void writeToyToFile(Toy toy) {
        csvFileWriter.writeFile(file, toy);
    }

    @Override
    public void clearFile() {
        csvFileWriter.clearFile(file);
    }

    @Override
    public List<Toy> readFile() {
        return csvFileReader.readFile(file);
    }
}
