package repository;

import model.Toy;
import service.fileManager.FileManager;

import java.util.List;

public class PrizeRepository {

    private final FileManager fileManager;

    public PrizeRepository(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public String saveToy(Toy toy) {
        fileManager.writeToyToFile(toy);
        return "Save";
    }

}
