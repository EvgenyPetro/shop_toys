import model.Toy;
import repository.PrizeRepository;
import repository.ToysRepository;
import service.LotteryToy.LotteryToyService;
import service.LotteryToy.impl.LotteryToyServiceImpl;
import service.fileManager.FileManager;
import service.fileManager.impl.CsvFileManager;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        testToyRepository();

        testLoteryFunc();


    }

    private static void testLoteryFunc() {
        FileManager fileManager = new CsvFileManager(new File("src/main/resources/chop_toy.csv"));
        FileManager prizefileManager = new CsvFileManager(new File("src/main/resources/prize_list.csv"));
        ToysRepository repository = new ToysRepository(fileManager);
        PrizeRepository prizeRepository = new PrizeRepository(prizefileManager);
        LotteryToyService lotteryToyService = new LotteryToyServiceImpl(repository, prizeRepository);

        Toy toy = lotteryToyService.loteryToy(repository.getAllToys());
        System.out.println(toy);
    }

    private static void testToyRepository() {
        FileManager fileManager = new CsvFileManager(new File("src/main/resources/chop_toy.csv"));
        ToysRepository repository = new ToysRepository(fileManager);
        System.out.println(repository.getToy(1));
        repository.getAllToys().forEach(System.out::println);
        Toy toy1 = new Toy(2, "fly", 30, 15);
        System.out.println(repository.updateToy(2, toy1));
        Toy toy2 = new Toy(3, "horse", 40, 25);
        System.out.println(repository.saveToy(toy2));
        System.out.println(repository.deleteToy(1));
    }
}
