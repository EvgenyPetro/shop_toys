package service.LotteryToy.impl;

import model.Toy;
import repository.PrizeRepository;
import repository.ToysRepository;
import service.LotteryToy.LotteryToyService;
import service.fileManager.FileManager;

import java.util.List;
import java.util.Random;

public class LotteryToyServiceImpl implements LotteryToyService {

    private final ToysRepository toysRepository;
    private final PrizeRepository prizeRepository;

    private List<Toy> prizeListToy;

    public LotteryToyServiceImpl(ToysRepository toysRepository, PrizeRepository prizeRepository) {
        this.toysRepository = toysRepository;
        this.prizeRepository = prizeRepository;
    }

    private final Random random = new Random();

    @Override
    public Toy getPrizeToy() {
        Toy toy = prizeListToy.get(0);
        prizeListToy.remove(toy);
        return toy;
    }

    @Override
    public Toy loteryToy(List<Toy> toyList) {
        int prizeId = random.nextInt(0, toyList.size());
        Toy toy = toysRepository.getToy(prizeId);
        toy.setCount(toy.getCount() - 1);
        toysRepository.updateToy(toy.getId(), toy);
        toy.setCount(1);
        prizeRepository.saveToy(toy);
        return toy;
    }

    @Override
    public List<Toy> getPrizeListToy() {
        return prizeListToy;
    }

}
