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

/**
 * Starfield character data
 */
public final class StarfieldCharacter
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
        return skillsProperty.getValue();
    }

    /**
     * Retrieves a skill from character skills
     *
     * @param skill Skill to retrieve
     *
     * @return Character skill
     */
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

    /**
     * Will either add a new skill or increase the rank of an existing skill
     * @param skill Skill to add
     * @throws SkillPointException Character must have available skill points
     */
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

    /**
     * Removes a skill from character skills
     * @param skill Skill to remove
     */
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

    /**
     * Will increase the current experience amount
     * @param experienceEarned Amount by which to increase experience
     */
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

    /**
     * Handles increasing the character level and available skill points then adjusts the experience and
     * experience needed for the next level
     */
    private void levelUp()
    {
        levelProperty.set(getLevel() + 1);
        int experienceExcess = getExperience() - getExperienceNeeded();
        experienceProperty.set(0); // Resets experience
        setExperienceNeeded(); // Sets experience needed for the new level
        availableSkillPointsProperty.set(getAvailableSkillPoints() + 1);
        addExperience(experienceExcess); // Captures potential multiple level ups given the experience obtained.
    }

    /**
     * Creates a new character
     * @param character Character to create
     * @return The newly created character
     * @throws SQLException Failed to create character
     */
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

    /**
     * Retrieves all characters
     * @return List of characters
     */
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

    /**
     * Retrieves a character
     * @param characterId Character id for filtering
     * @return Character
     */
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

    /**
     * Updates an existing character
     * @param character Character to update
     * @return Updated Character
     * @throws SQLException Failed to update character
     */
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

    /**
     * Deletes a character
     * @param character Character used for filtering
     * @return True if character was deleted
     * @throws SQLException Failed to delete character
     */
    public static boolean deleteCharacter(StarfieldCharacter character) throws SQLException
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.deleteCharacterQuery());
            ps.setInt(1, character.getCharacterId());
            ps.execute();

            ps.clearParameters();

            ps = connection.prepareStatement(QueryBuilder.deleteCharacterSkillsQuery());
            ps.setInt(1, character.getCharacterId());
            ps.execute();

            ps.clearParameters();

            for (Stat stat : character.getStats())
            {
                ps = connection.prepareStatement(QueryBuilder.deleteCharacterStatByIdQuery());
                ps.setInt(1, stat.getStatId());
                ps.execute();
            }

            ps = connection.prepareStatement(QueryBuilder.deleteCharacterStatsQuery());
            ps.setInt(1, character.getCharacterId());
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

    /**
     * Creates a TableView for displaying character data
     * @return TableView of characters
     */
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

        // TODO: BUG: Will not display experience needed for an unknown reason.
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
