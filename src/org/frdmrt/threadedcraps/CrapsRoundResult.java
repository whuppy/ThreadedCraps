package org.frdmrt.threadedcraps;

public class CrapsRoundResult {
    Boolean win = Boolean.FALSE;
    String gameLog = null;

    public void setWin(Boolean win) {
        this.win = win;
    }

    public void setGameLog(String gameLog) {
        this.gameLog = gameLog;
    }

    public Boolean getWin() {
        return win;
    }

    public String getGameLog() {
        return gameLog;
    }

    @Override
    public String toString() {
        String result = this.win.toString() + ": " + this.gameLog;
        return result;
    }
}
