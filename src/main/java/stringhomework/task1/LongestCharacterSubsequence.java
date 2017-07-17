package stringhomework.task1;

public final class LongestCharacterSubsequence {
    public final Character character;
    public final int length;

    public LongestCharacterSubsequence(final Character character, final int length) {
        this.character = character;
        this.length    = length;
    }

    @Override
    public String toString() {
        return "Character " + character + " occurs " + length + " times in a row";
    }
}
