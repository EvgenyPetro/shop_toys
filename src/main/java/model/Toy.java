package model;

import java.util.Objects;

public class Toy {
    private int id;
    private String name;
    private int count;
    private int chanceOfWinning;

    public Toy(int id, String name, int count, int chanceOfWinning) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.chanceOfWinning = chanceOfWinning;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count > 0) {
            this.count = count;
        } else {
            System.out.println("Отрицательное количество игрушек невозможно");
        }

    }

    public int getChanceOfWinning() {
        return chanceOfWinning;
    }

    public void setChanceOfWinning(int chanceOfWinning) {
        if (0 < chanceOfWinning && chanceOfWinning < 100) {
            this.chanceOfWinning = chanceOfWinning;
        } else {
            System.out.println("Неправильный шанс выигрыша, установлено минимальное значение");
            this.chanceOfWinning = 10;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return count == toy.count && Double.compare(toy.chanceOfWinning, chanceOfWinning) == 0 && Objects.equals(name, toy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count, chanceOfWinning);
    }

    @Override
    public String toString() {
        return "Toys{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", chanceOfWinning=" + chanceOfWinning +
                '}';
    }
}
