package model;

import java.sql.Connection;
import java.util.LinkedList;

public class Rank
{
    private static final Connection connection = MariaProvider.getConnection();
    private final int rankId;
    private final int rank;
    private final LinkedList<Stat> stats;
    private final String challengeDescription;
    private int challengeProgress = 0;
    private final int challengeGoal;
    private boolean nextRankAvailable = false;

    public Rank(int rankId, int rank, LinkedList<Stat> stats, String challengeDescription, int challengeProgress,
                int challengeGoal, boolean nextRankAvailable)
    {
        this.rankId = rankId;
        this.rank = rank;
        this.stats = stats;
        this.challengeDescription = challengeDescription;
        this.challengeProgress = challengeProgress;
        this.challengeGoal = challengeGoal;
        this.nextRankAvailable = nextRankAvailable;
    }

    public int getRankId()
    {
        return rankId;
    }

    public int getRank()
    {
        return rank;
    }

    public LinkedList<Stat> getStatEffects()
    {
        return stats;
    }

    public String getStatName(int index)
    {
        return stats.get(index).getName();
    }

    public String getStatName(Stat stat)
    {
        return stats.get(stats.indexOf(stat)).getName();
    }

    public double getStatEffect(int index)
    {
        return stats.get(index).getEffect();
    }

    public double getStatEffect(Stat stat)
    {
        return stats.get(stats.indexOf(stat)).getEffect();
    }

    public String getStatDescription(int index)
    {
        return stats.get(index).getDescription();
    }

    public String getStatDescription(Stat stat)
    {
        return stats.get(stats.indexOf(stat)).getDescription();
    }

    public String getChallengeDescription()
    {
        return challengeDescription;
    }

    public int getChallengeProgress()
    {
        return challengeProgress;
    }

    public void increaseChallengeProgress()
    {
        challengeProgress++;
        nextRankAvailable = challengeProgress > challengeGoal;
    }

    public void increaseChallengeProgress(int progressAmount)
    {
        challengeProgress += progressAmount;
        nextRankAvailable = challengeProgress > challengeGoal;
    }

    public int getChallengeGoal()
    {
        return challengeGoal;
    }

    public boolean isNextRankAvailable()
    {
        return nextRankAvailable;
    }
}
