package model;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.exceptions.SkillPointException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StarfieldCharacter
{
    private static final Connection connection = MariaProvider.getConnection();
    private IntegerProperty characterId = new SimpleIntegerProperty(-1);
    private StringProperty nameProperty = new SimpleStringProperty();
    private StringProperty descriptionProperty = new SimpleStringProperty();
    private Property<ObservableList<Skill>> skillsProperty = new SimpleListProperty<>();
    private Property<ObservableList<Stat>> statsProperty = new SimpleListProperty<>();
    private IntegerProperty levelProperty = new SimpleIntegerProperty(1);
    private IntegerProperty experienceProperty = new SimpleIntegerProperty(0);
    private IntegerProperty experienceNeededProperty = new SimpleIntegerProperty(1000);
    private IntegerProperty availableSkillPointsProperty = new SimpleIntegerProperty(3);

    //region Constructors
    public StarfieldCharacter(int characterId, String name, String description, ObservableList<Skill> skills,
                              ObservableList<Stat> stats, int level, int experience, int experienceNeeded,
                              int availableSkillPoints)
    {
        this.characterId = new SimpleIntegerProperty(characterId);
        this.nameProperty = new SimpleStringProperty(name);
        this.descriptionProperty = new SimpleStringProperty(description);
        this.skillsProperty = new SimpleListProperty<>(skills);
        this.statsProperty = new SimpleListProperty<>(stats);
        this.levelProperty = new SimpleIntegerProperty(level);
        this.experienceProperty = new SimpleIntegerProperty(experience);
        this.experienceNeededProperty = new SimpleIntegerProperty(experienceNeeded);
        this.availableSkillPointsProperty = new SimpleIntegerProperty(availableSkillPoints);
    }

    public StarfieldCharacter(String name, String description, ObservableList<Skill> skills, ObservableList<Stat> stats)
    {
        this.nameProperty = new SimpleStringProperty(name);
        this.descriptionProperty = new SimpleStringProperty(description);
        this.skillsProperty = new SimpleListProperty<>(skills);
        this.statsProperty = new SimpleListProperty<>(stats);
    }

    public StarfieldCharacter(StarfieldCharacter character)
    {
        this.characterId = new SimpleIntegerProperty(character.getCharacterId());
        this.nameProperty = new SimpleStringProperty(character.getName());
        this.descriptionProperty = new SimpleStringProperty(character.getDescription());
        this.skillsProperty = new SimpleListProperty<>(character.getSkills());
        this.statsProperty = new SimpleListProperty<>(character.getStats());
        this.levelProperty = new SimpleIntegerProperty(character.getLevel());
        this.experienceProperty = new SimpleIntegerProperty(getExperience());
        this.experienceNeededProperty = new SimpleIntegerProperty(character.getExperienceNeeded());
        this.availableSkillPointsProperty = new SimpleIntegerProperty(character.getAvailableSkillPoints());
    }
    //endregion

    public IntegerProperty getCharacterIdProperty()
    {
        return characterId;
    }

    public int getCharacterId()
    {
        return characterId.get();
    }

    public StringProperty getNameProperty()
    {
        return nameProperty;
    }

    public String getName()
    {
        return nameProperty.get();
    }

    public void setNameProperty(String nameProperty)
    {
        this.nameProperty = new SimpleStringProperty(nameProperty);
    }

    public StringProperty getDescriptionProperty()
    {
        return descriptionProperty;
    }

    public String getDescription()
    {
        return descriptionProperty.get();
    }

    public void setDescriptionProperty(String descriptionProperty)
    {
        this.descriptionProperty = new SimpleStringProperty(descriptionProperty);
    }

    public Property<ObservableList<Skill>> getSkillsProperty()
    {
        return skillsProperty;
    }

    public ObservableList<Skill> getSkills()
    {
        ObservableList<Skill> test = skillsProperty.getValue();
        if (test == null)
        {
            return new SimpleListProperty<>();
        }
        return skillsProperty.getValue();
    }

    public Skill getSkill(Skill skill)
    {
        try
        {
            ObservableList<Skill> skills = getSkills();
            int index = skills.indexOf(skill);
            if (index == -1)
            {
                throw new NoSuchElementException();
            }

            return skills.get(index);
        }
        catch (Exception ignored)
        {
            return new Skill();
        }
    }

    public void addSkill(Skill skill) throws Exception
    {
        if (availableSkillPointsProperty.get() > 0)
        {
            ObservableList<Skill> skills = getSkills();
            if (skills.contains(skill))
            {
                getSkill(skill).increaseRank();
            }
            else
            {
                skills.add(skill);
            }

            availableSkillPointsProperty.set(getAvailableSkillPoints() - 1);
        }
        else
        {
            throw new SkillPointException("No available skill points.");
        }
    }

    public void removeSkill(Skill skill)
    {
        getSkills().remove(skill);
        availableSkillPointsProperty.set(getAvailableSkillPoints() + 1);
    }

    public Property<ObservableList<Stat>> getStatsProperty()
    {
        return statsProperty;
    }

    public ObservableList<Stat> getStats()
    {
        return statsProperty.getValue();
    }

    public IntegerProperty getLevelProperty()
    {
        return levelProperty;
    }

    public int getLevel()
    {
        return levelProperty.get();
    }

    public IntegerProperty getExperienceProperty()
    {
        return experienceProperty;
    }

    public int getExperience()
    {
        return experienceProperty.get();
    }

    public void addExperience(int experienceEarned)
    {
        experienceProperty.set(experienceProperty.get() + experienceEarned);
        if (shouldLevelUp())
        {
            levelUp();
        }
    }

    private boolean shouldLevelUp()
    {
        return experienceProperty.get() > experienceNeededProperty.get();
    }

    public IntegerProperty getExperienceNeededProperty()
    {
        return experienceNeededProperty;
    }

    public int getExperienceNeeded()
    {
        return experienceNeededProperty.get();
    }

    private void setExperienceNeeded()
    {
        experienceNeededProperty.set(
                (int) (experienceNeededProperty.get() * (1 + ((1 - Math.exp(-0.05 * levelProperty.get())) * 0.5))));
    }

    public IntegerProperty getAvailableSkillPointsProperty()
    {
        return availableSkillPointsProperty;
    }

    public int getAvailableSkillPoints()
    {
        return availableSkillPointsProperty.get();
    }

    private void levelUp()
    {
        levelProperty.set(getLevel() + 1);
        int experienceExcess = getExperience() - getExperienceNeeded();
        experienceProperty.set(0); // Resets experience
        setExperienceNeeded(); // Sets experience needed for the new level
        availableSkillPointsProperty.set(getAvailableSkillPoints() + 1);
        addExperience(experienceExcess); // Captures potential multiple level ups given the experience obtained.
    }

    public static StarfieldCharacter createCharacter(StarfieldCharacter character) throws SQLException
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.createCharacterQuery());
            ps.setString(1, character.getName());
            ps.setString(2, character.getDescription());
            ps.execute();
            
            ps.clearParameters();

            for(Skill skill : character.getSkills())
            {
                ps = connection.prepareStatement(QueryBuilder.createCharacterSkillsQuery());
                ps.setInt(1, character.getCharacterId());
                ps.setInt(2, skill.getSkillId());
                ps.setInt(3, 1); // Will always start at rank 1 when character is first created.
                ps.execute();
                
                ps.clearParameters();
            }

            for(Stat stat : character.getStats())
            {
                ps = connection.prepareStatement(QueryBuilder.createCharacterStatsQuery());
                ps.setInt(1, character.getCharacterId());
                ps.setInt(2, stat.getStatId());
                ps.execute();
            }
            
            connection.commit();
        }
        catch (SQLException e)
        {
            System.out.println("Failed to retrieve character. Error: " + new RuntimeException(e).getMessage());
            connection.rollback();
        }
        catch (Exception e)
        {
            System.out.println("Failed to create character. Error: " + e.getMessage());
            connection.rollback();
        }

        return new StarfieldCharacter(character);
    }

    public static LinkedList<StarfieldCharacter> viewAllCharacters()
    {
        LinkedList<StarfieldCharacter> characters = new LinkedList<>();
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.viewAllCharactersQuery());
            ResultSet result = ps.executeQuery();
            while (result.next())
            {
                int characterId = result.getInt(1);
                String name = result.getString(2);
                String description = result.getString(3);
                int level = result.getInt(4);
                int experience = result.getInt(5);
                int experienceNeeded = result.getInt(6);
                int availableSkillPoints = result.getInt(7);

                ObservableList<Skill> skills = Skill.viewCharacterSkills(characterId);
                ObservableList<Stat> stats = Stat.viewCharacterStats(characterId);

                characters.add(new StarfieldCharacter(characterId, name, description, skills, stats, level, experience,
                                                      experienceNeeded, availableSkillPoints));
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

    public static StarfieldCharacter updateCharacter(StarfieldCharacter character) throws SQLException
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.updateCharacterQuery());
            ps.setInt(1, character.getCharacterId());
            ps.setString(2, character.getName());
            ps.setString(3, character.getDescription());
            ps.setInt(4, character.getLevel());
            ps.setInt(5, character.getExperience());
            ps.setInt(6, character.getExperienceNeeded());
            ps.setInt(7, character.getAvailableSkillPoints());
            ps.executeUpdate();

            ps.clearParameters();

            // TODO: only if skills were updated
            for(Skill skill : character.getSkills())
            {
                // TODO: need to know if we increasing rank on a skill
                if (skill.getRank().isNextRankAvailable())
                {

                }

                ps = connection.prepareStatement(QueryBuilder.createCharacterSkillsQuery());
                ps.setInt(1, character.getCharacterId());
                ps.setInt(2, skill.getSkillId());
                ps.setInt(3, skill.getCurrentRank());
                ps.execute();
                
                ps.clearParameters();
            }

            // TODO: only if stats were changed based on skill changes
            for(Stat stat : character.getStats())
            {
                ps = connection.prepareStatement(QueryBuilder.createCharacterStatsQuery());
                ps.setInt(1, character.getCharacterId());
                ps.setInt(2, stat.getStatId());
                ps.execute();
            }

            connection.commit();
        }
        catch (SQLException e)
        {
            System.out.println("Failed to retrieve character. Error: " + new RuntimeException(e).getMessage());
            connection.rollback();
        }
        catch (Exception e)
        {
            System.out.println("Failed to update character. Error: " + e.getMessage());
            connection.rollback();
        }

        return null;
    }

    public static boolean deleteCharacter(int characterId) throws SQLException
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.deleteCharacterQuery());
            ps.setInt(1, characterId);
            ps.execute();

            ps.clearParameters();

            ps = connection.prepareStatement(QueryBuilder.deleteCharacterSkillsQuery());
            ps.setInt(1, characterId);
            ps.execute();

            ps.clearParameters();

            ps = connection.prepareStatement(QueryBuilder.deleteCharacterStatsQuery());
            ps.setInt(1, characterId);
            ps.execute();

            connection.commit();
            return true;
        }
        catch (SQLException e)
        {
            System.out.println("Failed to retrieve character. Error: " + new RuntimeException(e).getMessage());
            connection.rollback();
        }
        catch (Exception e)
        {
            System.out.println("Failed to delete character. Error: " + e.getMessage());
            connection.rollback();
        }

        return false;
    }

    public static TableView<StarfieldCharacter> getTableView()
    {
        TableView<StarfieldCharacter> tableView = new TableView<>();
        TableColumn<StarfieldCharacter, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<StarfieldCharacter, String> description = new TableColumn<>("Description");
        description.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<StarfieldCharacter, Integer> level = new TableColumn<>("Level");
        level.setCellValueFactory(new PropertyValueFactory<>("level"));

        TableColumn<StarfieldCharacter, Integer> experience = new TableColumn<>("Experience");
        experience.setCellValueFactory(new PropertyValueFactory<>("experience"));

        TableColumn<StarfieldCharacter, Integer> experienceNeeded = new TableColumn<>("Experience Required");
        experience.setCellValueFactory(new PropertyValueFactory<>("experienceNeeded"));

        TableColumn<StarfieldCharacter, Integer> availableSkillPoints = new TableColumn<>("Skill Points");
        availableSkillPoints.setCellValueFactory(new PropertyValueFactory<>("availableSkillPoints"));

        tableView.getColumns().add(name);
        tableView.getColumns().add(description);
        tableView.getColumns().add(level);
        tableView.getColumns().add(experience);
        tableView.getColumns().add(experienceNeeded);
        tableView.getColumns().add(availableSkillPoints);
        tableView.getItems().addAll(StarfieldCharacter.viewAllCharacters());
        return tableView;
    }
}
