package es.jesramgue.ghost.ghostwebgame.pojos;

import es.jesramgue.ghost.ghostwebgame.business.entities.Dictionary;
import es.jesramgue.ghost.ghostwebgame.business.entities.SimilarWordGroup;
import es.jesramgue.ghost.ghostwebgame.business.interfaces.Player;
import java.util.Collection;
import java.util.Iterator;

import java.util.logging.Logger;

public class Ghost implements Player {

    private static final String DEFAULT_DICTIONARY_FILE = "WORD.LST";
    private static Logger logger_ = Logger.getLogger(Ghost.class.getName());
    private String name_ = "Ghost (Computer)";
    private Dictionary dictionary_ = new Dictionary(DEFAULT_DICTIONARY_FILE);
    private SimilarWordGroup currentNode_ = null;
    private String longestLosingWord_ = null;

    public Ghost() {
    }

    /**
     * Player name.
     */
    public String name() {
        return getName();
    }

    /**
     * Get the node for the specified string.
     *
     * @param start The initial substring of a word.
     */
    private SimilarWordGroup wordNode(String start) {
        if (currentNode_ == null) {
            dictionary_ = dictionary_.subSetDictionary(dictionary_, start);
            currentNode_ = new SimilarWordGroup(start, dictionary_.listIterator());
        } else {
            currentNode_ = currentNode_.childNode(start);
        }

        return currentNode_;

    }

    /**
     * Compute the forced wins possible in the tree rooted at the specified
     * node.
     *
     * @param wordNode.
     */
    private void findForcedWins(SimilarWordGroup wordNode) {
        boolean forcedWin = false;
        Collection<SimilarWordGroup> childNodes = wordNode.childNodes();
        Iterator<SimilarWordGroup> children = childNodes.iterator();
        SimilarWordGroup child = null;

        while (children.hasNext()) {
            child = children.next();

            boolean childForcedWin = true;
            if (!child.isEndOfGroup()) {
                SimilarWordGroup grandchild = null;
                Iterator<SimilarWordGroup> grandchildren = child.childNodes().iterator();

                while (grandchildren.hasNext()) {
                    grandchild = grandchildren.next();

                    if (grandchild.isEndOfGroup()) {
                        grandchild.iMustWin(false);
                    } else {
                        findForcedWins(grandchild);
                    }

                    if (!grandchild.imGonnaWin()) {
                        childForcedWin = false;
                    }
                }
            }
            child.iMustWin(childForcedWin);

            if (child.imGonnaWin()) {
                forcedWin = true;
            }
        }

        wordNode.iMustWin(forcedWin);
    }

    /**
     * Choose the next word to selectChar.
     *
     * @param wordNode similar words that representing the root of the tree to
     * search.
     * @return A guaranteed winning word.
     */
    private String chooseWord(SimilarWordGroup wordNode) {
        if (wordNode.imGonnaWin() == null) {
            findForcedWins(wordNode);
        }

        return wordNode.imGonnaWin() ? wordNode.firstWinningWord()
                : wordNode.longestLosingWord();
    }

    /**
     * Get the player's next letter. This method is inherited from Player.
     *
     * @param wordInPlay The word currently being played.
     */
    public char selectChar(String wordInPlay) {
        SimilarWordGroup wordNode = wordNode(wordInPlay);

        if ((wordNode == null) || (wordNode.getChildCount() == 0)) {
            throw new RuntimeException("No matching word found.");
        }

        return chooseWord(wordNode).charAt(wordInPlay.length());
    }

    /**
     * @return the name_
     */
    public String getName() {
        return name_;
    }

    /**
     * @param name_ the name_ to set
     */
    public void setName(String name_) {
        this.name_ = name_;
    }
}  // end Ghost

