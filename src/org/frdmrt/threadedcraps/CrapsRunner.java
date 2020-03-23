package org.frdmrt.threadedcraps;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CrapsRunner {
    static final List<Integer> naturalWin = Arrays.asList(7,11);
    static final List<Integer> crapsLose = Arrays.asList(2,3,12);
    static final List<Integer> keepPlaying = Arrays.asList(4,5,6,8,9,10);

    Integer rollDice () {
        return ThreadLocalRandom.current().nextInt(1,7) + ThreadLocalRandom.current().nextInt(1,7);
    }

    public CrapsRoundResult runCrapsRound() {
        CrapsRoundResult crresult = new CrapsRoundResult();
        StringBuilder gameLog = new StringBuilder();

        Integer comeOutRoll = rollDice();
        gameLog.append(comeOutRoll);
        if (naturalWin.contains(comeOutRoll)) {
            crresult.setGameLog(gameLog.toString());
            crresult.setWin(Boolean.TRUE);
            return crresult;
        }
        if (crapsLose.contains(comeOutRoll)) {
            crresult.setGameLog(gameLog.toString());
            crresult.setWin(Boolean.FALSE);
            return crresult;
        }
        Integer point = comeOutRoll;
        Integer currentRoll;
        while (true) {
            currentRoll = rollDice();
            gameLog.append(", " + currentRoll);
            if (currentRoll == point) {
                crresult.setGameLog(gameLog.toString());
                crresult.setWin(Boolean.TRUE);
                return crresult;
            }
            if (currentRoll == 7) {
                crresult.setGameLog(gameLog.toString());
                crresult.setWin(Boolean.FALSE);
                return crresult;
            }
        }
    }
}
