package es.jesramgue.ghost.ghostwebgame.business.interfaces;

public interface Player {

    /**
     * Player Nick
     */
    public String name();

    /**
     * Add a character to the word in selectChar.
     *
     * @param actualWord The word currently being played.
     */
    public char selectChar(String actualWord);
}
