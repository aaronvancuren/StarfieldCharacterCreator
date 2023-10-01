package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StarfieldCharacter
{
    private String name;
    private String description;
    private final LinkedList<Skill> skills;
    private Map<String, Double> stats;
    private int level = 1;
    private int experience = 0;
    private int experienceNeeded = 1000;
    private int availableSkillPoints = 3;


    public StarfieldCharacter(String name, String description, LinkedList<Skill> skills)
    {
        this.name = name;
        this.description = description;
        setStats();
        this.skills = skills;
        updateStats(skills);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<Skill> getSkills()
    {
        return skills;
    }

    public Skill getSkill(Skill skill)
    {
        return skills.get(skills.indexOf(skill));
    }

    public void addSkill(Skill skill) throws Exception
    {
        if (availableSkillPoints > 0)
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
            availableSkillPoints--;
        }
        else
        {
            throw new Exception("No available skill points.");
        }
    }

    public Map<String, Double> getStats()
    {
        return stats;
    }

    private void setStats()
    {
        // sets default values from file
    }

    private void updateStat(Skill skill)
    {
        Rank rank = skill.getCurrentRank();
        Map<String, Double> statEffects = rank.getStatEffects();
        for (Map.Entry<String, Double> statEffect : statEffects.entrySet())
        {
            Double oldValue = stats.get(statEffect.getKey());
            stats.replace(statEffect.getKey(), oldValue, oldValue * (1 + statEffect.getValue()));
        }
    }

    private void updateStats(LinkedList<Skill> skills)
    {
        for (Skill skill : skills)
        {
            updateStat(skill);
        }
    }

    public Double getStatValue(String statKey)
    {
        return stats.get(statKey);
    }

    public int getLevel()
    {
        return level;
    }

    public int getExperience()
    {
        return experience;
    }

    public void addExperience(int experienceEarned)
    {
        experience += experienceEarned;
        if (shouldLevelUp())
        {
            levelUp();
        }
    }

    private boolean shouldLevelUp()
    {
        return experience > experienceNeeded;
    }

    public int getExperienceNeeded()
    {
        return experienceNeeded;
    }

    private void setExperienceNeeded()
    {
        experienceNeeded *= 1 + (1 - Math.exp(-0.05 * level)) * 0.5;
    }

    public int getAvailableSkillPoints()
    {
        return availableSkillPoints;
    }

    private void levelUp()
    {
        level++;
        int experienceExcess = experience - experienceNeeded;
        experience = 0; // Resets experience
        setExperienceNeeded(); // Sets experience needed for the new level
        availableSkillPoints++;
        addExperience(experienceExcess); // Captures potential multiple level ups given the experience obtained.
    }
}
