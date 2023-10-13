package model;

public class QueryBuilder
{
    public static String createCharacterQuery()
    {
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
        return " UPDATE `character` (characterId, name, experienceNeeded, availableSkillPoints, description, level, experience) VALUES ( ?, ?, ?, ?, ?, ? )" + " WHERE characterId = ? ";
    }

    public static String deleteCharacterQuery()
    {
        return " DELETE FROM `character` WHERE characterId = ? ";
    }

    public static String viewAllSkillsQuery()
    {
        return " SELECT * FROM skill sk" + " JOIN `rank` rk ON rk.skillId = sk.skillId" + " JOIN stat st ON rk.statId = st.statId ";
    }

    public static String viewCharacterSkillsQuery()
    {
        return " SELECT sk.skillId AS skillId, sk.name AS skillName, sk.category AS skillCategory," + " sk.tier AS skillTier, cs.skillRank AS `rank` from character_skill cs" + "join skill sk on cs.skillId = sk.skillId" + " where cs.characterId = ? ";
    }

    public static String viewAllStatsQuery()
    {
        return "SELECT * FROM stat";
    }

    public static String viewCharacterStatsQuery()
    {
        return " SELECT st.statId AS statId, st.name AS name, st.effect AS effect, st.description AS description" + " FROM character_stat cst JOIN stat st ON cst.statId = st.statId WHERE cst.characterId = ? ";
    }
}
