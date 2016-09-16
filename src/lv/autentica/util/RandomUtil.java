package lv.autentica.util;

public class RandomUtil
{

    public static String getRandomStringFromArray(String[] array) {
        int idx = new java.util.Random().nextInt(array.length);
        return (array[idx]);
    }

    private static int randInt(int min, int max) {
        java.util.Random rand = new java.util.Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }


}
