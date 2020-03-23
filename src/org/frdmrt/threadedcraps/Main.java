package org.frdmrt.threadedcraps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static int NUM_TRIALS = 1000000;
    private static int THREAD_POOL_SIZE = 1000;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Future<CrapsRoundResult>> crrList = new ArrayList<>();
        Callable<CrapsRoundResult> crrCallable = new CrapsCallable();
        int numWins = 0;

        // Submit tasks to thread pool and make a list of the results:
        for (int i=0;i<NUM_TRIALS;i++){
            Future<CrapsRoundResult> fcrr = executor.submit(crrCallable);
            crrList.add(fcrr);
        }
        // Now reap the results:
        for (Future<CrapsRoundResult> crr : crrList) {
            try {
                if (crr.get().getWin()) {
                    numWins++;
                }
            }
            catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println(numWins + " wins out of " + NUM_TRIALS + " trials.");
    }
}
