package model.test;

import model.Skill;
import model.StarfieldCharacter;

import java.util.LinkedList;

public class StarfieldCharacterTest
{
    public static void main(String[] args)
    {
        StarfieldCharacter character = CreateCharacter();
        ShowCharacterDetails(character);

        ChangeName(character);
        ShowCharacterDetails(character);

        ChangeDescription(character);
        ShowCharacterDetails(character);

        // No Level Up
        CompleteMission(character, 500);
        ShowCharacterDetails(character);

        // Level Up
        CompleteMission(character, 600);
        ShowCharacterDetails(character);

        // Multiple Level Ups
        CompleteMission(character, 5000);
        ShowCharacterDetails(character);
    }

    public static StarfieldCharacter CreateCharacter()
    {
        try
        {
            StarfieldCharacter character = new StarfieldCharacter("John", "I'm a space cowboy",
                                                                  new LinkedList<Skill>());
            if (!character.getName().equals("John"))
            {
                throw new Exception("Failed to save characters name");
            }

            if (!character.getDescription().equals("I'm a space cowboy"))
            {
                throw new Exception("Failed to save characters description");
            }

            // TODO: Should add skills once the skill data is created.
            if (character.getSkills().size() != 0)
            {
                throw new Exception("Failure creating character skills");
            }

            // TODO: Validate Character Stats once base stat data is created.
            // Ensure character stat data was populated and spot check the stats changed by skills.

            if (character.getLevel() != 1)
            {
                throw new Exception("Failed to set character level to 1");
            }

            if (character.getExperience() != 0)
            {
                throw new Exception("Failed to set character experience to 0");
            }

            if (character.getExperienceNeeded() != 1000)
            {
                throw new Exception("Failed to set character experience needed to level up to 1000");
            }

            if (character.getAvailableSkillPoints() != 3)
            {
                throw new Exception("Failed to set character available skill points to 3");
            }

            System.out.println("Character was created.");
            return character;
        }
        catch (Exception e)
        {
            System.out.println("Failed to create character. Error: " + e.getMessage());
            System.exit(e.hashCode());
        }

        return null;
    }

    public static void ShowCharacterDetails(StarfieldCharacter character)
    {
        try
        {
            System.out.println("Character name: " + character.getName());
            System.out.println("Character description: " + character.getDescription());
            System.out.println("Character has " + character.getSkills().size() + " skills.");
            System.out.println("Character is level " + character.getLevel() + ".");
            System.out.println("Character has " + character.getExperience() + " experience points.");
            System.out.println(
                    "Character needs " + character.getExperienceNeeded() + " experience points to reach the next level.");
            System.out.println("Character has " + character.getAvailableSkillPoints() + " skill points available.");
            System.out.println();
        }
        catch (Exception e)
        {
            System.out.println("Failed to show character details. Error:" + e.getMessage());
            System.exit(e.hashCode());
        }
    }

    public static void ChangeName(StarfieldCharacter character)
    {
        try
        {
            character.setName("Johnny");
            if (!character.getName().equals("Johnny"))
            {
                throw new Exception("Failed to save characters name");
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to change character name. Error:" + e.getMessage());
            System.exit(e.hashCode());
        }
    }

    public static void ChangeDescription(StarfieldCharacter character)
    {
        try
        {
            character.setDescription("I live amongst the stars.");
            if (!character.getDescription().equals("I live amongst the stars."))
            {
                throw new Exception("Failed to save characters description");
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to change character name. Error:" + e.getMessage());
            System.exit(e.hashCode());
        }
    }

    // TODO: Need to test getSkill once Skill data is created

    // TODO: Need to test addSkill once Skill data is created

    // TODO: Need to test addStats once Stat data is created

    // TODO: Need to test getStatValue once Stat data is created

    public static void CompleteMission(StarfieldCharacter character, int experienceGained)
    {
        try
        {
            int currentCharacterLevel = character.getLevel();
            int currentAvailableSkillPoints = character.getAvailableSkillPoints();
            character.addExperience(experienceGained);
            if (experienceGained > character.getExperienceNeeded())
            {
                // TODO: Test should know the level.
                if (character.getLevel() == currentCharacterLevel)
                {
                    throw new Exception("Failed to level up character.");
                }

                // TODO: Test should know the number of available skill points based on the previous check.
                if (character.getAvailableSkillPoints() == currentAvailableSkillPoints)
                {
                    throw new Exception("Failed to increase the characters available skill points.");
                }

                if (character.getAvailableSkillPoints() != (currentAvailableSkillPoints + (character.getLevel() - currentCharacterLevel)))
                {
                    throw new Exception(
                            "Failed to increase the characters available skill points to the correct amount.");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to add experience to character. Error:" + e.getMessage());
            System.exit(e.hashCode());
        }
    }
}
