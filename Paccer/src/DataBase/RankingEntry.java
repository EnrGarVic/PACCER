package DataBase;

public class RankingEntry {
    private String winner;
    private int wins;

    public RankingEntry(String winner, int wins) {
        this.winner = winner;
        this.wins = wins;
    }

    public String getWinner() {
        return winner;
    }

    public int getWins() {
        return wins;
    }

    @Override
    public String toString() {
        return "Winner: " + winner + ", Wins: " + wins;
    }
}
