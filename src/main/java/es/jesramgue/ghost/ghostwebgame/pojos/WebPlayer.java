package es.jesramgue.ghost.ghostwebgame.pojos;

import es.jesramgue.ghost.ghostwebgame.business.interfaces.Player;
import java.io.Serializable;

import java.util.logging.Logger;

public class WebPlayer implements Player, Serializable {

    private static Logger logger_ = Logger.getLogger(WebPlayer.class.getName());
    private String isPlayerName = "Human";

    /**
     * The default constructor for the WebPlayer class.
     */
    public WebPlayer() {
    }

    /**
     * The name of the player.
     */
    public String name() {
        return getName();
    }

    /**
     * @return the name_
     */
    public String getName() {
        return isPlayerName;
    }

    /**
     * @param name_ the name_ to set
     */
    public void setName(String name_) {
        this.isPlayerName = name_;
    }

    public char selectChar(String wordInPlay) {
        throw new UnsupportedOperationException("Not neccesary"); //To change body of generated methods, choose Tools | Templates.
    }
}  // end WebPlayer

