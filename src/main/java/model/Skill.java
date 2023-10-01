package model;

public class Skill
{
    private final String name;
    private final Category category;
    private final Tier tier;
    private int currentRank = 1; // 1 - 4
    private final Rank[] ranks;

    public Skill(String name, Category category, Tier tier, Rank[] ranks)
    {
        this.name = name;
        this.category = category;
        this.tier = tier;
        this.ranks = ranks; // Will populate ranks from an Excel file.
    }

    public String getName()
    {
        return name;
    }

    public Category getCategory()
    {
        return category;
    }

    public Tier getTier()
    {
        return tier;
    }

    public Rank getCurrentRank()
    {
        return ranks[currentRank];
    }

    public Rank[] getRanks()
    {
        return ranks;
    }

    public Rank increaseRank() throws Exception
    {
        if (getCurrentRank().isNextRankAvailable())
        {
            currentRank++;
            return getCurrentRank();
        }
        else
        {
            throw new Exception("Failed to increase skill rank. Main.Rank challenge has not been completed.");
        }
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
