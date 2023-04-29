package model;

import java.util.Objects;

public class Toys {
    private int id;
    private String name;
    private int count;
    private double chanceOfWinning;

    public Toys(int id, String name, int count, double chanceOfWinning) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.chanceOfWinning = chanceOfWinning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.count = count;
    }

    public double getChanceOfWinning() {
        return chanceOfWinning;
    }

    public void setChanceOfWinning(double chanceOfWinning) {
        this.chanceOfWinning = chanceOfWinning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toys toys = (Toys) o;
        return count == toys.count && Double.compare(toys.chanceOfWinning, chanceOfWinning) == 0 && Objects.equals(name, toys.name);
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
