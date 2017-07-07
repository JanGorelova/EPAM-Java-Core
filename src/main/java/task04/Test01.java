package task04;

public final class Test01 {
    public static void main(String[] args) {
        String firstSentence = "АРГЕНТИНА МАНИТ НЕГРА";
        String secondSentence = "ПОТ КАК ПОТОП";
        String thirdSentence = "А РОЗА УПАЛА НА ЛАПУ АЗОРА";

       firstSentence = firstSentence.replaceAll(" ","");
       secondSentence = secondSentence.replaceAll(" ","");
       thirdSentence = thirdSentence.replaceAll(" ","");

        char[] firstArr = firstSentence.toCharArray();
        char[] secondArr = secondSentence.toCharArray();
        char[] thirdArr = thirdSentence.toCharArray();

        System.out.println(isFlipFlop(firstArr));
        System.out.println(isFlipFlop(secondArr));
        System.out.println(isFlipFlop(thirdArr));
    }

    public static boolean isFlipFlop(final char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[array.length-1-i])
                return false;
        }
        return true;
    }
}
