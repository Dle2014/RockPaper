import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David Lopez on 17/02/2016.
 */
public class RockPaperScissorsTest {

    private static final int ROCK = 0;
    private static final int PAPER = 1;
    private static final int SCISSORS = 2;
    RockPaperScissors rockPaperScissors;

    @Before
    public void setUp() {
        rockPaperScissors = new RockPaperScissors();
    }

    @Test
    public void testGetRandomResult() throws Exception {
        int round = 0;
        while (round < 100) {
            round++;
            assertFalse(rockPaperScissors.getRandomResult() < ROCK);
            assertFalse(rockPaperScissors.getRandomResult() > SCISSORS);
        }
    }

    @Test
    public void testGetRock() throws Exception {
        assert rockPaperScissors.getRock() == ROCK;
    }

    @Test
    public void testIsUser1Winer() throws Exception {
        assert rockPaperScissors.isUser1Winer(ROCK, SCISSORS);
        assert rockPaperScissors.isUser1Winer(PAPER, ROCK);
        assert rockPaperScissors.isUser1Winer(SCISSORS, PAPER);
    }

    @Test
    public void testCheckResults() throws Exception {
        rockPaperScissors.checkResults(ROCK, SCISSORS);
        assert rockPaperScissors.getUser1Wins() == 1;
        rockPaperScissors.checkResults(ROCK, PAPER);
        assert rockPaperScissors.getUser2Wins() == 1;
        rockPaperScissors.checkResults(SCISSORS, SCISSORS);
        assert rockPaperScissors.getDraws() == 1;
        rockPaperScissors.checkResults(SCISSORS, SCISSORS);
        assert rockPaperScissors.getDraws() == 2;
        rockPaperScissors.checkResults(ROCK, SCISSORS);
        assert rockPaperScissors.getUser1Wins() == 2;
        rockPaperScissors.checkResults(ROCK, PAPER);
        assert rockPaperScissors.getUser2Wins() == 2;
    }

}