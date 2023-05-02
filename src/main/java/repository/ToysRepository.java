package repository;

import model.Toy;
import service.fileManager.FileManager;

import java.util.List;

public class ToysRepository {

    private final FileManager fileManager;

    private List<Toy> toys;

    public ToysRepository(FileManager fileManager) {
        this.fileManager = fileManager;
        toys = fileManager.readFile();
    }

    public Toy getToy(int id) {
        return toys.stream().filter(toy -> toy.getId() == id).findFirst().orElseThrow(RuntimeException::new);
    }

    public List<Toy> getAllToys() {
        return toys;
    }

    public String saveToy(Toy toy) {
        toys.add(toy);
        fileManager.writeToyToFile(toy);
        return "Save";
    }

    public String deleteToy(int id) {
        toys.remove(getToy(id));
        fileManager.clearFile();
        toys.forEach(fileManager::writeToyToFile);
        return "Deleted";
    }

    public Toy updateToy(int id, Toy toy){
        Toy updatedToy = getToy(id);
        updatedToy.setName(toy.getName());
        updatedToy.setCount(toy.getCount());
        updatedToy.setChanceOfWinning(toy.getChanceOfWinning());
        toys.remove(toy);
        toys.add(updatedToy);
        fileManager.clearFile();
        toys.forEach(fileManager::writeToyToFile);
        return updatedToy;

    }
}
