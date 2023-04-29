package utils;

import model.Toy;

public class ToyMapper {
    public static Toy stringToToy(String stringToy) {
        String[] split = stringToy.split(";");
        return new Toy(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]), Byte.parseByte(split[3]));
    }

    public static String toyToString(Toy toy) {
        return String.format("%d;%s;%d;%d\n", toy.getId(), toy.getName(), toy.getCount(), toy.getChanceOfWinning());
    }
}
