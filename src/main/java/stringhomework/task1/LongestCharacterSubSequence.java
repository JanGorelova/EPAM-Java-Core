package stringhomework.task1;

public final class LongestCharacterSubSequence {
    private final Character character;
    private final int length;

    /**
     * encapsulates the value of the character and length of the sub sequence
     *
     * @param character the value of the character
     * @param length the length of the sub sequence
     */
    public LongestCharacterSubSequence(final Character character, final int length) {
        this.character = character;
        this.length    = length;
    }

    @Override
    public String toString() {
        return "Character " + character + " occurs " + length + " times in a row";
    }
}
