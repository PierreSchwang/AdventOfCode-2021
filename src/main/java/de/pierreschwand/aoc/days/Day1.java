package de.pierreschwand.aoc.days;

import de.pierreschwand.aoc.utility.HttpUtility;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        String data = HttpUtility.getBodyContent("https://adventofcode.com/2021/day/1/input");

        int cnt = 0;
        int windowCnt = 0;

        int lastNum = 0;
        int lastWindowCnt = 0;

        List<Integer> nums = Arrays.stream(data.split("\n")).map(Integer::parseInt).toList();
        for (int i = 0; i < nums.size(); i++) {
            int nr = nums.get(i);
            if (i > 0 && lastNum < nr) {
                cnt++;
            }
            lastNum = nr;

            if (i < nums.size() - 2) {
                int currentWindowCount = nr + nums.get(i + 1) + nums.get(i + 2);
                if (i > 0 && lastWindowCnt < currentWindowCount) {
                    windowCnt++;
                }
                lastWindowCnt = currentWindowCount;
            }
        }

        System.out.println("1 -> " + cnt);
        System.out.println("2 -> " + windowCnt);
    }

}
