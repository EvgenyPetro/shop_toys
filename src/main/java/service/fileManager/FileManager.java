package service.fileManager;

import model.Toy;

import java.util.List;

public interface FileManager {
    void clearFile();

    void writeToyToFile(Toy toyList);

    List<Toy> readFile();
}
