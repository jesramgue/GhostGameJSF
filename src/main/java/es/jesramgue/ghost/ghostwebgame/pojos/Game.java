package es.jesramgue.ghost.ghostwebgame.pojos;

import es.jesramgue.ghost.ghostwebgame.business.entities.Dictionary;
import es.jesramgue.ghost.ghostwebgame.business.interfaces.Player;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.ActionEvent;

public class Game implements Serializable {

    private final Logger logger_ = Logger.getLogger(Game.class.getName());
    private Dictionary ldDictionary = null;
    private Player[] lgTeam = new Player[2];
    private int liCurrentPlayerFlag = 0;
    private StringBuffer lsbActualWord = new StringBuffer();
    private boolean lbGameOver = false;
    private Player lgWinner = null;
    private String isHumanWord = "";
    private String isComputerWord = "";
    private String isCommandButtonName = "Add letter";
    private String isDisabledInput = "false";
    private String isWinner = "";

    /**
     * A test harness for the Game class.
     *
     * @param args The command line arguments passed in.
     */
    public Game() {
        try {
            Initialize("word.lst");
        } catch (Exception e) {
            logger_.log(Level.SEVERE, "Unable to initialize Game:  {0}", e.toString());
        }
    }

    public void resetGame(ActionEvent actionEvent) {
        Initialize("word.lst");
        isCommandButtonName = "Add letter";
        isDisabledInput = "false";
        isWinner = "";
        isComputerWord = "";
        isHumanWord = "";
    }

    /**
     * @return the lsbActualWord
     */
    public StringBuffer getLsbActualWord() {
        return lsbActualWord;
    }

    /**
     * @param aLsbActualWord the lsbActualWord to set
     */
    public void setLsbActualWord(StringBuffer aLsbActualWord) {
        lsbActualWord = aLsbActualWord;
    }

    /**
     * @return the liCurrentPlayerFlag
     */
    public int getLiCurrentPlayerFlag() {
        return liCurrentPlayerFlag;
    }

    /**
     * @param aLiCurrentPlayerFlag the liCurrentPlayerFlag to set
     */
    public void setLiCurrentPlayerFlag(int aLiCurrentPlayerFlag) {
        liCurrentPlayerFlag = aLiCurrentPlayerFlag;
    }

    /**
     * The full constructor for the Game class.
     *
     * @param fileName The name of the dictionary file. This file is assumed to
     * be sorted in alphabetical order.
     * @param playerOne A reference to the first player.
     * @param playerTwo A reference to the second player.
     */
    public void Initialize(String fileName) {
        /**
         * Initialize team.
         */
        Player playerOne = new WebPlayer();
        Player playerTwo = new Ghost();
        lgTeam[0] = playerOne;
        lgTeam[1] = playerTwo;

        /**
         * Read the dictionary to store it in memory.
         */
        ldDictionary = new Dictionary(fileName);
        if (ldDictionary.size() == 0) {
            throw new RuntimeException("Unable to load dictionary from "
                    + fileName
                    + ".");
        }
        /**
         * Initialize word in selectChar.
         */
        setLsbActualWord(new StringBuffer(""));
        /**
         * Reset the winner.
         */
        lgWinner = null;
    }

    /**
     * Switch the current player.
     *
     * @return The updated current player index.
     */
    private int switchPlayer() {
        return (liCurrentPlayerFlag = ++liCurrentPlayerFlag % 2);
    }

    /**
     * Add a letter to the word in selectChar.
     */
    private void addLetter(char letter) {
        getLsbActualWord().append(letter);
        ldDictionary = ldDictionary.subSetDictionary(ldDictionary, getLsbActualWord().toString());

        if (ldDictionary.size() == 0) {
            lbGameOver = true;
            lgWinner = lgTeam[switchPlayer()];
        } else if ((ldDictionary.size() == 1)
                && ldDictionary.firstWord().equals(getLsbActualWord().toString())) {
            lbGameOver = true;
            lgWinner = lgTeam[getLiCurrentPlayerFlag()];
        }
    }

    public Player addChar(char asChar) {
        addLetter(asChar);
        switchPlayer();
        if (lbGameOver) {
            return lgWinner;
        }
        return null;
    }

    public Player addCharComputer() {
        char lcSelectedCharByComputer = lgTeam[1].selectChar(getLsbActualWord().toString());
        isComputerWord = "The ghost has select the letter: " + lcSelectedCharByComputer;
        addLetter(lcSelectedCharByComputer);
        switchPlayer();
        if (lbGameOver) {
            return lgWinner;
        }
        return null;
    }

    /**
     * Return the word in selectChar.
     */
    public String getWordInPlay() {
        return getLsbActualWord().toString();
    }

    public void changeTurn(ActionEvent actionEvent) {
        if (isWinner.equals("")) {
            if (getLiCurrentPlayerFlag() == 0) {
                if (getLsHumanWord() != null && !getLsHumanWord().equals("")) {
                    lgWinner = addChar(getLsHumanWord().charAt(0));
                    isCommandButtonName = "Turn of the ghost";
                    isDisabledInput = "true";
                    setLsHumanWord("");
                }
            } else {
                lgWinner = addCharComputer();
                isCommandButtonName = "Add letter";
                isDisabledInput = "false";
            }
            if (lgWinner != null) {
                isWinner = "There is a winner: " + lgWinner.name() + "!!!";
            }
        }
    }

    /**
     * @return the lsHumanWord
     */
    public String getLsHumanWord() {
        return isHumanWord;
    }

    /**
     * @param lsHumanWord the lsHumanWord to set
     */
    public void setLsHumanWord(String lsHumanWord) {
        this.isHumanWord = lsHumanWord;
    }

    /**
     * @return the computerWord
     */
    public String getComputerWord() {
        return isComputerWord;
    }

    /**
     * @param computerWord the computerWord to set
     */
    public void setComputerWord(String computerWord) {
        this.isComputerWord = computerWord;
    }

    /**
     * @return the isCommandButtonName
     */
    public String getCommandButtonName() {
        return isCommandButtonName;
    }

    /**
     * @return the isDisabledInput
     */
    public String getDisabledInput() {
        return isDisabledInput;
    }

    /**
     * @return the isWinner
     */
    public String getIsWinner() {
        return isWinner;
    }
}  // end Game

