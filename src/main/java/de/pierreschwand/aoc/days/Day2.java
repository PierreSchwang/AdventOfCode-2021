package de.pierreschwand.aoc.days;

import de.pierreschwand.aoc.utility.HttpUtility;

import java.io.IOException;

public class Day2 {

    private static final String URL = "https://adventofcode.com/2021/day/2/input";

    public static void main(String[] args) throws IOException, InterruptedException {
        String[] input = HttpUtility.getBodyContent(URL).split("\n");
        first(input);
        second(input);
    }

    private static void first(String[] input) {
        int horizontal = 0;
        int depth = 0;
        for (String s : input) {
            String[] dat = s.split(" ");
            String action = dat[0];
            int amount = Integer.parseInt(dat[1]);
            switch (action) {
                case "forward" -> horizontal += amount;
                case "down" -> depth += amount;
                case "up" -> depth -= amount;
            }
        }
        System.out.println("1 -> " + (horizontal * depth));
    }

    private static void second(String[] input) {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (String s : input) {
            String[] dat = s.split(" ");
            String action = dat[0];
            int amount = Integer.parseInt(dat[1]);
            switch (action) {
                case "forward" -> {
                    horizontal += amount;
                    depth += (aim * amount);
                }
                case "down" -> aim += amount;
                case "up" -> aim -= amount;
            }
        }
        System.out.println("2 -> " + (horizontal * depth));
    }


}
