import java.util.List;

public class Skill
{
    private final Category category;
    private int rank; // 1 - 4
    private final Tier tier;
    private final String name;
    private final String challengeDescription;
    private int challengeProgress = 0;
    private final int challengeGoal;
    private boolean nextRankAvailable = false;
    private final List<Stat> statBonuses;

    public Skill(Category category, int rank, Tier tier, String name, String challengeDescription, int challengeGoal,
                 List<Stat> statBonuses)
    {
        this.category = category;
        this.rank = rank;
        this.tier = tier;
        this.name = name;
        this.challengeDescription = challengeDescription;
        this.challengeGoal = challengeGoal;
        this.statBonuses = statBonuses;
    }

    public void addChallengeProgress()
    {
        challengeProgress++;
        if (challengeProgress > challengeGoal)
        {
            nextRankAvailable = true;
        }
    }

    public void addChallengeProgress(int progressAmount)
    {
        challengeProgress += progressAmount;
        if (challengeProgress > challengeGoal)
        {
            nextRankAvailable = true;
        }
    }

    public List<Stat> increaseRank() throws Exception
    {
        if (!nextRankAvailable)
        {
            throw new Exception("Unable to increase rank because the skill challenge has not been completed.");
        }

        rank++;
        return getStatBonuses();
    }

    public Category getCategory()
    {
        return category;
    }

    public int getRank()
    {
        return rank;
    }

    public Tier getTier()
    {
        return tier;
    }

    public String getName()
    {
        return name;
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

    public List<Stat> getStatBonuses()
    {
        return statBonuses;
    }

    public enum Category
    {
        Physical,
        Social,
        Combat,
        Science,
        Tech
    }

    public enum Tier
    {
        Novice,
        Advanced,
        Expert,
        Master
    }
}
