package lv.autentica.util;

import java.util.List;

public class RandomUtil
{

    public static String concatenateRandomStrings(List<String[]> list)
    {
        StringBuilder sb = new StringBuilder();
        for (int o = 0; o < list.size(); o++) {
            if (o != 0) {
                sb.append(" "); // add whitespace to separate
            }
            sb.append(RandomUtil.getRandomStringFromArray(list.get(o)));
        }

        return sb.toString();
    }

    public static String getRandomStringFromArray(String[] array) {
        int idx = new java.util.Random().nextInt(array.length);
        return (array[idx]);
    }

    public static int randInt(int min, int max) {
        java.util.Random rand = new java.util.Random();
        return rand.nextInt((max - min) + 1) + min;
    }


}
