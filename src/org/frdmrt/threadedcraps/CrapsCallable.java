package org.frdmrt.threadedcraps;

import java.util.concurrent.Callable;

public class CrapsCallable implements Callable<CrapsRoundResult> {
    private static CrapsRunner cRunner = new CrapsRunner();

    @Override
    public CrapsRoundResult call() throws Exception {
        return cRunner.runCrapsRound();
    }
}
