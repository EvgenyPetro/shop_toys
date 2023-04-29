package service;

import model.Toy;

import java.io.File;
import java.util.List;

public interface FileManager {
    void writeFile(List<Toy> toyList);

    List<Toy> readFile();
}
