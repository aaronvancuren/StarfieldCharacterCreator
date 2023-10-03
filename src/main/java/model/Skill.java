package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Skill
{
    private static final Connection connection = MariaProvider.getConnection();
    private final int skillId;
    private final String name;
    private final Category category;
    private final Tier tier;
    private int currentRank = 1;
    private final Rank[] ranks;

    public Skill(int skillId, String name, Category category, Tier tier, Rank[] ranks)
    {
        this.skillId = skillId;
        this.name = name;
        this.category = category;
        this.tier = tier;
        this.ranks = ranks; // Will populate ranks from an Excel file.
    }

    public int getSkillId()
    {
        return skillId;
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

    public int getCurrentRank()
    {
        return currentRank;
    }

    public Rank getRank()
    {
        return ranks[currentRank];
    }

    public Rank[] getRanks()
    {
        return ranks;
    }

    public Rank increaseRank() throws Exception
    {
        if (getRank().isNextRankAvailable())
        {
            currentRank++;
            return getRank();
        }
        else
        {
            throw new Exception("Unable to increase skill rank until rank challenge has been completed.");
        }
    }

    public static ObservableList<Skill> viewAllSkills()
    {
        ObservableList<Skill> skills = FXCollections.observableArrayList();
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.viewAllSkillsQuery());
            ResultSet result = ps.executeQuery();
            while (result.next())
            {
                int skillId = result.getInt(1);
                String name = result.getString(2);
                Category category = Category.valueOf(result.getString(3));
                Tier tier = Tier.valueOf(result.getString(4));
                skills.add(new Skill(skillId, name, category, tier, null));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Failed to retrieve all skills. Error: " + new RuntimeException(e).getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Failed to retrieve all skills. Error: " + e.getMessage());
        }

        return skills;
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
