package Tests;

import Main.Rank;
import Main.Skill;

public class SkillTest
{
    public static void main(String[] args)
    {
        // TODO: Will test with data from Excel file.
        Skill skill = CreateSkill();
        ShowSkillDetails(skill);
    }

    public static Skill CreateSkill()
    {
        try
        {
            Skill skill = new Skill("Astrodynamics", Skill.Category.Science, Skill.Tier.Novice, new Rank[]{});
            if (!skill.getName().equals("Astrodynamics"))
            {
                throw new Exception("Failed to save skill name.");
            }

            if (skill.getCategory() != Skill.Category.Science)
            {
                throw new Exception("Failed to set skill category.");
            }

            if (skill.getTier() != Skill.Tier.Novice)
            {
                throw new Exception("Failed to set skill tier.");
            }

            // TODO: Should be equal to 4. Will update once data is populated.
            if (skill.getRanks().length != 0)
            {
                throw new Exception("Failed to set skill ranks.");
            }

            return skill;
        }
        catch (Exception e)
        {
            System.out.println("Failed to create skill. Error: " + e.getMessage());
            System.exit(e.hashCode());
        }

        return null;
    }

    public static void ShowSkillDetails(Skill skill)
    {
        try
        {
            System.out.println("Skill name: " + skill.getName());
            System.out.println("Skill category: " + skill.getCategory());
            System.out.println("Skill tier: " + skill.getTier());
            System.out.println("Skill rank: " + skill.getCurrentRank());
        }
        catch (Exception e)
        {
            System.out.println("Failed to show skill details. Error:" + e.getMessage());
            System.exit(e.hashCode());
        }
    }

    // TODO: Implement once Skill and Rank data created.
    public static void IncreaseRank(Skill skill)
    {
        try
        {
            skill.increaseRank();
        }
        catch (Exception e)
        {

        }
    }
}
