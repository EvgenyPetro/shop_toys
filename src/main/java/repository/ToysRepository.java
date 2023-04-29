package repository;

import model.Toy;
import service.FileManager;

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
        return "Save";
    }

    public String deleteToy(int id) {
        toys.remove(getToy(id));
        return "Deleted";
    }

    public Toy updateToy(int id, Toy toy) throws IllegalAccessException {
        Toy updatedToy = getToy(id);
        updatedToy.setName(toy.getName());
        updatedToy.setCount(toy.getCount());
        updatedToy.setChanceOfWinning(toy.getChanceOfWinning());
        return updatedToy;

    }
}
