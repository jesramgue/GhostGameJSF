package es.jesramgue.ghost.ghostwebgame.pojos;

import org.junit.*;

/**
 *
 * @author Birdi_Jesus
 */
public class GameTest {

    @Test
    public void testGame() {
        Game lgGame = new Game();
        System.out.println("@Test - dictionary:" + lgGame.toString());
        Assert.assertNotNull(lgGame);
    }
}
