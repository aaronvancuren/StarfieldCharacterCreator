import java.util.List;

public class Character
{
    private String name;
    private String description;
    private List<Skill> skills;
    private List<Stat> stats;

    private int level;
    private int availableSkillPoints;
    private int experience;
    private int experienceNeeded;


    public Character(String name, String description)
    {
        this.name = name;
        this.description = description;
        level = 1;
        experience = 0;
        experienceNeeded = 1000;
        availableSkillPoints = 1;
        // load basic stats
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
            if (skillIndex == -1)
            {
                skills.add(skill);
            }
            else
            {
                List<Stat> statBonuses = skills.get(skillIndex).increaseRank();
                modifyStats(statBonuses);
            }
            availableSkillPoints--;
        }
    }

    public List<Stat> getStats()
    {
        return stats;
    }

    public Stat getStat(Stat stat)
    {
        return stats.get(stats.indexOf(stat));
    }

    private void modifyStats(List<Stat> stats)
    {
        // modify stats
    }

    public int getLevel()
    {
        return level;
    }

    public void addExperience(int experienceEarned)
    {
        experience += experienceEarned;
        if (experience > experienceNeeded)
        {
            levelUp();
        }

        // prompt user
    }

    private void levelUp()
    {
        level++;
        experience -= experienceNeeded;
        experienceNeeded *= 1.1;
        availableSkillPoints++;
    }

    public int getAvailableSkillPoints()
    {
        return availableSkillPoints;
    }

    public int getExperience()
    {
        return experience;
    }

    public int getExperienceNeeded()
    {
        return experienceNeeded;
    }
}
