package task04;

public final class Test01 {
    public static void main(String[] args) {
        Test01 main = new Test01();

        String firstSentence = "АРГЕНТИНА МАНИТ НЕГРА";
        String secondSentence = "ПОТ КАК ПОТОП";
        String thirdSentence = "А РОЗА УПАЛА НА ЛАПУ АЗОРА";

        System.out.println(main.isFlipFlop(firstSentence));
        System.out.println(main.isFlipFlop(secondSentence));
        System.out.println(main.isFlipFlop(thirdSentence));
    }

    public final boolean isFlipFlop(final String sentence) {
        String sentenceContinious = sentence.replaceAll(" ", "");
        char[] sentenceArray = sentenceContinious.toCharArray();

        for (int i = 0; i < sentenceArray.length; i++) {
            if (sentenceArray[i] != sentenceArray[sentenceArray.length - 1 - i])
                return false;
        }
        return true;
    }
}
