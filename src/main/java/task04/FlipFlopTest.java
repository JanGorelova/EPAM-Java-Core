package task04;

public final class FlipFlopTest {
    public static void main(String[] args) {
        FlipFlopTest flipFlopTest = new FlipFlopTest();

        String firstSentence = "АРГЕНТИНА МАНИТ НЕГРА";
        String secondSentence = "ПОТ КАК ПОТОП";
        String thirdSentence = "А РОЗА УПАЛА НА ЛАПУ АЗОРА";

        System.out.println(flipFlopTest.isFlipFlop(firstSentence));
        System.out.println(flipFlopTest.isFlipFlop(secondSentence));
        System.out.println(flipFlopTest.isFlipFlop(thirdSentence));
    }

    /**
     * checks if the specified sentence is flip-flopper
     *
     * @param sentence to be analyzed
     * @return true of false value if the sentence is flip-flopper
     */
    public final boolean isFlipFlop(final String sentence) {
        String sentenceContinuous = sentence.replaceAll(" ", "");
        char[] sentenceArray = sentenceContinuous.toCharArray();

        for (int i = 0; i < sentenceArray.length; i++) {
            if (sentenceArray[i] != sentenceArray[sentenceArray.length - 1 - i])
                return false;
        }
        return true;
    }
}
