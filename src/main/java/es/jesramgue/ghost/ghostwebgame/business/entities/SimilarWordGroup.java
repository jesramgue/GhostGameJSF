/**
 * SimilarWordGroup is a group of words.
 */
package es.jesramgue.ghost.ghostwebgame.business.entities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;

import java.util.logging.Logger;

public class SimilarWordGroup {

    private static Logger ilLogger = Logger.getLogger(SimilarWordGroup.class.getName());
    private String isAuxString = null;
    private HashMap<String, SimilarWordGroup> ihmMap = new HashMap<String, SimilarWordGroup>();
    private Boolean ibMustWin = null;
    private String isLongestWord = null;

    /**
     * Add a new final word to the group.
     *
     * @param alToAdd letter to add.
     */
    private void addToEnd(SimilarWordGroup alToAdd) {
        if (alToAdd.isAuxString.length() == (isAuxString.length() + 1)) {
            ihmMap.put(alToAdd.isAuxString, alToAdd);
        } else {
            String lsTemp = alToAdd.isAuxString.substring(0, isAuxString.length() + 1);
            SimilarWordGroup llTempLetter = ihmMap.get(lsTemp);
            if (llTempLetter == null) {
                llTempLetter = new SimilarWordGroup(lsTemp);
                ihmMap.put(lsTemp, llTempLetter);
            }

            llTempLetter.addToEnd(alToAdd);
        }
    }

    /**
     * The full constructor for the SimilarWordGroup class.
     *
     * @param baseString base String of the group.
     * @param iterator An iterator for all words of the group.
     */
    public SimilarWordGroup(String baseString, ListIterator<String> iterator) {
        isAuxString = baseString;
        while (iterator.hasNext()) {
            addToEnd(new SimilarWordGroup(iterator.next()));
        }
    }

    /**
     * Constructor of a letter with a word.
     *
     * @param word The base string.
     */
    public SimilarWordGroup(String word) {
        isAuxString = word;
    }

    /**
     * Child count.
     */
    public long getChildCount() {
        return ihmMap.size();
    }

    /**
     * Return group of words similars to a base word.
     *
     * @param asBase base word.
     */
    public SimilarWordGroup childNode(String asBase) {
        SimilarWordGroup lswGroup = null;
        if (isAuxString.equals(asBase)) {
            lswGroup = this;
        } else if ((isAuxString.length() < asBase.length())
                && ((lswGroup = ihmMap.get(
                asBase.substring(0, isAuxString.length() + 1)))
                != null)) {
            lswGroup = lswGroup.childNode(asBase);
        }

        return lswGroup;
    }

    /**
     * Return the string that is the base for this node and all child nodes.
     */
    public String baseString() {
        return isAuxString;
    }

    /**
     * Return the children of this node.
     */
    public Collection<SimilarWordGroup> childNodes() {
        return ihmMap.values();
    }

    /**
     * Return a boolean indicating whether or not this is a terminal node.
     */
    public boolean isEndOfGroup() {
        return ihmMap.isEmpty();
    }

    /**
     * Flag whether or not the node is the root of a forced win.
     *
     * @param forced A boolean indicating if computer should win or not.
     */
    public void iMustWin(boolean forced) {
        ibMustWin = new Boolean(forced);
    }

    public Boolean imGonnaWin() {
        return ibMustWin;
    }

    /**
     * Return the word found in te group thats wins the game.
     */
    public String firstWinningWord() {
        String word = null;

        if (isEndOfGroup() && imGonnaWin()) {
            word = isAuxString;
        } else {
            Iterator<String> keyIterator = ihmMap.keySet().iterator();
            while ((word == null) && (keyIterator.hasNext())) {
                word = ihmMap.get(keyIterator.next()).firstWinningWord();
            }
        }

        return word;
    }

    /**
     * Return the longest losing word reachable from this node.
     */
    public String longestLosingWord() {
        if (isLongestWord == null) {
            isLongestWord = isAuxString;

            Iterator<String> keyIterator = ihmMap.keySet().iterator();
            SimilarWordGroup child = null;
            while (keyIterator.hasNext()) {
                child = ihmMap.get(keyIterator.next());
                if (!child.imGonnaWin()
                        && (child.longestLosingWord().length()
                        > isLongestWord.length())) {
                    isLongestWord = child.longestLosingWord();
                }
            }
        }

        return isLongestWord;
    }
}
