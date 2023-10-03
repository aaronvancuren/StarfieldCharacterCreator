package model;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class StarfieldCharacter
{
    private static final Connection connection = MariaProvider.getConnection();
    private IntegerProperty characterId;
    private StringProperty name;
    private StringProperty description;
    private final SimpleListProperty<Skill> skills;
    private SimpleListProperty<Stat> stats;
    private IntegerProperty level;
    private IntegerProperty experience;
    private IntegerProperty experienceNeeded;
    private IntegerProperty availableSkillPoints;

    public StarfieldCharacter(String name, String description, ObservableList<Skill> skills, ObservableList<Stat> stats)
    {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        setStats();
        this.skills = new SimpleListProperty<>(skills);
        updateStats(skills);
    }

    public StarfieldCharacter(int characterId, String name, String description, ObservableList<Skill> skills,
                              ObservableList<Stat> stats, int level, int experience, int experienceNeeded,
                              int availableSkillPoints)
    {
        this.characterId = new SimpleIntegerProperty(characterId);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.skills = new SimpleListProperty<>(skills);
        this.stats = new SimpleListProperty<>(stats);
        this.level = new SimpleIntegerProperty(level);
        this.experience = new SimpleIntegerProperty(experience);
        this.experienceNeeded = new SimpleIntegerProperty(experienceNeeded);
        this.availableSkillPoints = new SimpleIntegerProperty(availableSkillPoints);
    }

    public StarfieldCharacter(StarfieldCharacter character)
    {
        this.characterId = new SimpleIntegerProperty(character.getCharacterId());
        this.name = new SimpleStringProperty(character.getName());
        this.description = new SimpleStringProperty(character.getDescription());
        this.skills = new SimpleListProperty<>(character.getSkills());
        this.stats = new SimpleListProperty<>(character.getStats());
        this.level = new SimpleIntegerProperty(character.getLevel());
        this.experience = new SimpleIntegerProperty(getExperience());
        this.experienceNeeded = new SimpleIntegerProperty(character.getExperienceNeeded());
        this.availableSkillPoints = new SimpleIntegerProperty(character.getAvailableSkillPoints());
    }

    public int getCharacterId()
    {
        return characterId.get();
    }

    public String getName()
    {
        return name.get();
    }

    public StringProperty getNameProperty()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = new SimpleStringProperty(name);
    }

    public StringProperty getDescriptionProperty()
    {
        return description;
    }

    public String getDescription()
    {
        return description.get();
    }

    public void setDescription(String description)
    {
        this.description = new SimpleStringProperty(description);
    }

    public SimpleListProperty<Skill> getSkillsProperty()
    {
        return skills;
    }

    public ObservableList<Skill> getSkills()
    {
        return skills.get();
    }

    public Skill getSkill(Skill skill)
    {
        return skills.get(skills.indexOf(skill));
    }

    public void addSkill(Skill skill) throws Exception
    {
        if (availableSkillPoints.get() > 0)
        {
            int skillIndex = skills.indexOf(skill);
            if (skillIndex == -1)   // Character does not currently have the skill.
            {
                skills.add(skill);
            }
            else                    // Character is increasing the rank of an existing skill.
            {
                skills.get(skillIndex).increaseRank();
            }

            updateStat(skill);
            availableSkillPoints.set(availableSkillPoints.get() - 1);
        }
        else
        {
            throw new Exception("No available skill points.");
        }
    }


    public SimpleListProperty<Stat> getStatsProperty()
    {
        return stats;
    }

    public ObservableList<Stat> getStats()
    {
        return stats.get();
    }

    public String getStatName(int index)
    {
        return stats.get().get(index).getName();
    }

    public String getStatName(Stat stat)
    {
        return stats.get().get(stats.indexOf(stat)).getName();
    }

    public double getStatEffect(int index)
    {
        return stats.get().get(index).getEffect();
    }

    public double getStatEffect(Stat stat)
    {
        return stats.get().get(stats.indexOf(stat)).getEffect();
    }

    public void setStatEffect(int index, int effect)
    {
        stats.get().get(index).setEffect(effect);
    }

    public void setStatEffect(Stat stat, int effect)
    {
        stats.get().get(stats.indexOf(stat)).setEffect(effect);
    }

    public String getStatDescription(int index)
    {
        return stats.get().get(index).getDescription();
    }

    public String getStatDescription(Stat stat)
    {
        return stats.get().get(stats.indexOf(stat)).getDescription();
    }

    private void setStats()
    {
        // sets default values from file
    }

    private void updateStat(Skill skill)
    {
        LinkedList<Stat> statEffects = skill.getRank().getStatEffects();
        for (Stat statEffect : statEffects)
        {
            setStatEffect(statEffect, statEffect.getEffect());
        }
    }

    private void updateStats(ObservableList<Skill> skills)
    {
        for (Skill skill : skills)
        {
            updateStat(skill);
        }
    }

    public IntegerProperty getLevelProperty()
    {
        return level;
    }

    public int getLevel()
    {
        return level.get();
    }

    public IntegerProperty getExperienceProperty()
    {
        return experience;
    }

    public int getExperience()
    {
        return experience.get();
    }

    public void addExperience(int experienceEarned)
    {
        experience.set(experience.get() + experienceEarned);
        if (shouldLevelUp())
        {
            levelUp();
        }
    }

    private boolean shouldLevelUp()
    {
        return experience.get() > experienceNeeded.get();
    }

    public IntegerProperty getExperienceNeededProperty()
    {
        return experienceNeeded;
    }

    public int getExperienceNeeded()
    {
        return experienceNeeded.get();
    }

    private void setExperienceNeeded()
    {
        experienceNeeded.set((int) (experienceNeeded.get() * (1 + ((1 - Math.exp(-0.05 * level.get())) * 0.5))));
    }

    public IntegerProperty getAvailableSkillPointsProperty()
    {
        return availableSkillPoints;
    }

    public int getAvailableSkillPoints()
    {
        return availableSkillPoints.get();
    }

    private void levelUp()
    {
        level.set(level.get() + 1);
        int experienceExcess = experience.get() - experienceNeeded.get();
        experience.set(0); // Resets experience
        setExperienceNeeded(); // Sets experience needed for the new level
        availableSkillPoints.set(availableSkillPoints.get() + 1);
        addExperience(experienceExcess); // Captures potential multiple level ups given the experience obtained.
    }

    public static StarfieldCharacter createCharacter(StarfieldCharacter character)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.createCharacterQuery());
            ps.setString(1, character.getName());
            ps.setInt(2, character.getExperienceNeeded());
            ps.setInt(3, character.getAvailableSkillPoints());
            ps.setString(4, character.getDescription());
            ps.setInt(5, character.getLevel());
            ps.setInt(6, character.getExperience());
            ps.execute();

        }
        catch (SQLException e)
        {
            System.out.println("Failed to retrieve character. Error: " + new RuntimeException(e).getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Failed to create character. Error: " + e.getMessage());
        }

        return new StarfieldCharacter(character);
    }

    public static LinkedList<StarfieldCharacter> viewAllCharacter()
    {
        LinkedList<StarfieldCharacter> characters = new LinkedList<>();
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.viewAllCharactersQuery());
            ResultSet result = ps.executeQuery();
            while (result.next())
            {
                characters.add(
                        new StarfieldCharacter(result.getInt(1), result.getString(2), result.getString(5), null, null,
                                               result.getInt(6), result.getInt(7), result.getInt(3), result.getInt(4)));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Failed to retrieve character. Error: " + new RuntimeException(e).getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Failed to retrieve all characters. Error: " + e.getMessage());
        }

        return characters;
    }

    public static StarfieldCharacter viewCharacter(int characterId)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.viewCharacterQuery());
            ps.setInt(1, characterId);

        }
        catch (SQLException e)
        {
            System.out.println("Failed to retrieve character. Error: " + new RuntimeException(e).getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Failed to retrieve character. Error: " + e.getMessage());
        }

        return null;
    }

    public static StarfieldCharacter updateCharacter(StarfieldCharacter character)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.updateCharacterQuery());
            ps.setString(1, character.getName());
            ps.setInt(2, character.getExperienceNeeded());
            ps.setInt(3, character.getAvailableSkillPoints());
            ps.setString(4, character.getDescription());
            ps.setInt(5, character.getLevel());
            ps.setInt(6, character.getExperience());
            ps.setInt(7, character.getCharacterId());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("Failed to retrieve character. Error: " + new RuntimeException(e).getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Failed to update character. Error: " + e.getMessage());
        }

        return null;
    }

    public static boolean deleteCharacter(int characterId)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.deleteCharacterQuery());
            ps.setInt(1, characterId);
            ps.execute();
            return true;
        }
        catch (SQLException e)
        {
            System.out.println("Failed to retrieve character. Error: " + new RuntimeException(e).getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Failed to delete character. Error: " + e.getMessage());
        }

        return false;
    }
}
