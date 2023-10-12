package model;

import helpers.CellView;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.exceptions.MaxRankException;
import model.exceptions.RankChallengeException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Skill implements CellView
{
    private static final Connection connection = MariaProvider.getConnection();
    private int skillId = -1;
    private String name = "";
    private Category category = Category.Physical;
    private Tier tier = Tier.Novice;
    private int currentRank = 1;
    private ArrayList<Rank> ranks = new ArrayList<>();

    //region Constructors
    public Skill() {}

    public Skill(int skillId, String name, Category category, Tier tier, ArrayList<Rank> ranks)
    {
        this.skillId = skillId;
        this.name = name;
        this.category = category;
        this.tier = tier;
        this.ranks = ranks;
    }

    public Skill(int skillId, String name, Category category, Tier tier, int currentRank, ArrayList<Rank> ranks)
    {
        this.skillId = skillId;
        this.name = name;
        this.category = category;
        this.tier = tier;
        this.currentRank = currentRank;
        this.ranks = ranks;
    }
    //endregion

    //region Property Getters/Setters
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
        return ranks.get(currentRank - 1);
    }

    public ArrayList<Rank> getRanks()
    {
        return ranks;
    }
    //endregion

    public void increaseRank() throws Exception
    {
        // 4 is the maximum value. Ideally should never be above this value.
        if (currentRank >= 4)
        {
            throw new MaxRankException("Max rank has been reached.");
        }

        if (getRank().isNextRankAvailable())
        {
            currentRank++;
        }
        else
        {
            throw new RankChallengeException("Rank challenge has not been completed.");
        }
    }

    public static ObservableList<Skill> viewAllSkills()
    {
        ObservableList<Skill> skills = FXCollections.observableArrayList();
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.viewAllSkillsQuery());
            ResultSet result = ps.executeQuery();
            for (int i = 0; result.next(); i++)
            {
                int skillId = result.getInt(1);
                String name = result.getString(2);
                Category category = Category.valueOf(result.getString(3));
                Tier tier = Tier.valueOf(result.getString(4));

                int statId = result.getInt(11);
                String statName = result.getString(12);
                int statEffect = result.getInt(13);
                String statDescription = result.getString(14);
                Stat stat = new Stat(statId, statName, statEffect, statDescription);

                int rankId = result.getInt(5);
                int rank = result.getInt(6);
                String challengeDescription = result.getString(7);
                int challengeGoal = result.getInt(8);
                Rank newRank = new Rank(rankId, rank, stat, challengeDescription, challengeGoal);
                try
                {
                    Skill skill = skills.filtered(x -> x.getSkillId() == skillId).get(0);
                    skill.getRanks().add(newRank);
                }
                catch (IndexOutOfBoundsException e)
                {
                    ArrayList<Rank> ranks = new ArrayList<>();
                    ranks.add(newRank);
                    skills.add(new Skill(skillId, name, category, tier, ranks));
                }
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

    public static ObservableList<Skill> viewAllSkills(int characterId)
    {
        ObservableList<Skill> skills = FXCollections.observableArrayList();
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.viewAllCharacterSkillsQuery());
            ps.setInt(1, characterId);
            ResultSet result = ps.executeQuery();
            while (result.next())
            {
                int skillId = result.getInt(1);
                String name = result.getString(2);
                Category category = Category.valueOf(result.getString(3));
                Tier tier = Tier.valueOf(result.getString(4));
                int currentRank = result.getInt(5);
                skills.add(new Skill(skillId, name, category, tier, currentRank, null));
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

    public static TableView<Skill> getTableView()
    {
        TableView<Skill> tableView = new TableView<>();
        TableColumn<Skill, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Skill, Category> category = new TableColumn<>("Category");
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        TableColumn<Skill, Tier> tier = new TableColumn<>("Tier");
        tier.setCellValueFactory(new PropertyValueFactory<>("tier"));
        tableView.getColumns().add(name);
        tableView.getColumns().add(category);
        tableView.getColumns().add(tier);
        tableView.getItems().addAll(Skill.viewAllSkills());
        return tableView;
    }

    public static TableView<Skill> getTableViewWithRankAndStat()
    {
        TableView<Skill> tableView = getTableView();
        TableColumn<Skill, Integer> rank = new TableColumn<>("Rank");
        rank.setCellValueFactory(skill -> new ObservableValueBase<>()
        {
            @Override
            public Integer getValue()
            {
                return skill.getValue().getRank().getRank();
            }
        });

        TableColumn<Skill, String> challengeDescription = new TableColumn<>("Challenge Description");
        challengeDescription.setCellValueFactory(skill -> new ObservableValueBase<>()
        {
            @Override
            public String getValue()
            {
                return skill.getValue().getRank().getChallengeDescription();
            }
        });

        TableColumn<Skill, String> nextRankAvailable = new TableColumn<>("Next Rank Available");
        nextRankAvailable.setCellValueFactory(skill -> new ObservableValueBase<>()
        {
            @Override
            public String getValue()
            {
                if (skill.getValue().getRank().isNextRankAvailable())
                {
                    return "Yes";
                }

                return "No";
            }
        });

        TableColumn<Skill, String> stat = new TableColumn<>("Stat");
        stat.setCellValueFactory(skill -> new ObservableValueBase<>()
        {
            @Override
            public String getValue()
            {
                return skill.getValue().getRank().getStatName();
            }
        });

        TableColumn<Skill, String> statDescription = new TableColumn<>("Stat Description");
        statDescription.setCellValueFactory(skill -> new ObservableValueBase<>()
        {
            @Override
            public String getValue()
            {
                return skill.getValue().getRank().getStatDescription();
            }
        });

        TableColumn<Skill, Integer> statEffect = new TableColumn<>("Stat Effect");
        statEffect.setCellValueFactory(skill -> new ObservableValueBase<>()
        {
            @Override
            public Integer getValue()
            {
                return skill.getValue().getRank().getStatEffect();
            }
        });

        tableView.getColumns().add(rank);
        tableView.getColumns().add(challengeDescription);
        tableView.getColumns().add(nextRankAvailable);
        tableView.getColumns().add(stat);
        tableView.getColumns().add(statDescription);
        tableView.getColumns().add(statEffect);
        return tableView;
    }

    @Override
    public String cellView()
    {
        return getName();
    }
}

