package model;

public class QueryBuilder
{
    public static String createCharacterQuery()
    {
        // TODO: Need to account for any linked tables
        return " INSERT INTO `character` (name, description, level, experience, experienceNeeded, availableSkillPoints) VALUES ( ?, ?, 1, 0, 1000, 0 ) ";
    }

    public static String viewAllCharactersQuery()
    {
        return " SELECT * FROM `character` ";
    }

    public static String viewCharacterQuery()
    {
        return " SELECT * FROM `character` WHERE characterId = ? ";
    }

    public static String updateCharacterQuery()
    {
        // TODO: Need to account for any linked tables
        return " UPDATE `character` (characterId, name, experienceNeeded, availableSkillPoints, description, level, experience) VALUES ( ?, ?, ?, ?, ?, ? )" + " WHERE characterId = ? ";
    }

    public static String deleteCharacterQuery()
    {
        // TODO: Need to account for any linked tables
        return " DELETE FROM `character` WHERE characterId = ? ";
    }

    public static String viewAllSkillsQuery()
    {
        return " SELECT * FROM skill sk JOIN `rank` rk ON rk.skillId = sk.skillId JOIN stat st ON rk.statId = st.statId ";
    }

    public static String viewAllCharacterSkillsQuery()
    {
        return " select" + " sk.skillId as skillId," + " sk.name as skillName," + " sk.category as skillCategory," + " sk.tier as skillTier," + " cs.skillRank as `rank`" + " from character_skill cs" + " join skill sk on cs.skillId = sk.skillId" + " where cs.characterId = ? ";
    }

    public static String viewAllStatsQuery()
    {
        // TODO: Need to figure out how to store default values that can be retrieved.
        return "SELECT * FROM stat";
    }
}
