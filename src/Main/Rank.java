package Main;

import java.util.Map;
import java.util.Set;

public class Rank
{
    private final int rank;
    private final Map<String, Double> statEffects;
    private final Map<String, String> statEffectDescriptions;
    private final String challengeDescription;
    private int challengeProgress = 0;
    private final int challengeGoal;
    private boolean nextRankAvailable = false;

    public Rank(int rank, Map<String, Double> statEffects, Map<String, String> statEffectDescriptions,
                String challengeDescription, int challengeGoal)
    {
        this.rank = rank;
        this.statEffects = statEffects;
        this.statEffectDescriptions = statEffectDescriptions;
        this.challengeDescription = challengeDescription;
        this.challengeGoal = challengeGoal;
    }

    public int getRank()
    {
        return rank;
    }

    public Map<String, Double> getStatEffects()
    {
        return statEffects;
    }

    public Set<String> getStatsEffected()
    {
        return statEffects.keySet();
    }

    public double getStatEffectValue(String statEffect)
    {
        return statEffects.get(statEffect);
    }

    public String getStatEffectDescription(String statEffect)
    {
        return statEffectDescriptions.get(statEffect);
    }

    public String getChallengeDescription()
    {
        return challengeDescription;
    }

    public int getChallengeProgress()
    {
        return challengeProgress;
    }

    public int getChallengeGoal()
    {
        return challengeGoal;
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

    public boolean isNextRankAvailable()
    {
        return nextRankAvailable;
    }
}
