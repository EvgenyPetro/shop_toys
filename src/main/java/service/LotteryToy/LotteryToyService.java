package service.LotteryToy;

import model.Toy;

import java.util.List;

public interface LotteryToyService {
    Toy getPrizeToy();

    Toy loteryToy(List<Toy> toyList);

    List<Toy> getPrizeListToy();

}
