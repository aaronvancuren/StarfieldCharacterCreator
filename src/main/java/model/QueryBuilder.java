package model;

public class QueryBuilder
{
    /**
     * Query for creating character base data
     *
     * @return Query string
     */
    //#region Character Queries
    public static String createCharacterQuery()
    {
        return " INSERT INTO `character` (name, description, level, experience, experienceNeeded, availableSkillPoints) VALUES ( ?, ?, 1, 0, 1000, 0 ) ";
    }

    /**
     * Query for retrieving all characters base data
     * @return Query string
     */
    public static String viewAllCharactersQuery()
    {
        return " SELECT * FROM `character` ";
    }

    /**
     * Query for retrieving all character base data
     * @return Query string
     */
    public static String viewCharacterQuery()
    {
        return " SELECT * FROM `character` WHERE characterId = ? ";
    }

    /**
     * Query for updating all character base data
     * @return Query string
     */
    public static String updateCharacterQuery()
    {
        return " UPDATE `character` (characterId, name, description, level, experience, experienceNeeded, availableSkillPoints) VALUES ( ?, ?, ?, ?, ?, ? ) WHERE characterId = ? ";
    }

    /**
     * Query for deleting all character base data
     * @return Query string
     */
    public static String deleteCharacterQuery()
    {
        return " DELETE FROM `character` WHERE characterId = ? ";
    }
    //#endregion

    /**
     * Query for creating character skills
     *
     * @return Query string
     */
    //#region Character Skill Queries
    public static String createCharacterSkillsQuery()
    {
        return " INSERT INTO character_skill (characterId, skillId, skillRank, rankProgress, nextRankAvailable) VALUES (?, ?, ?, 0, 0) ";
    }

    /**
     * Query for retrieving character skills
     * @return Query string
     */
    public static String viewCharacterSkillsQuery()
    {
        return " SELECT sk.skillId AS skillId, sk.name AS skillName, sk.category AS skillCategory, sk.tier AS " + " skillTier, cs.skillRank AS `rank` FROM character_skill cs JOIN skill sk ON cs.skillId = sk.skillId " + " WHERE cs.characterId = ? ";
    }

    /**
     * Query for updating character skills
     * @return Query string
     */
    public static String updateCharacterSkillsQuery()
    {
        return " UPDATE character_skill SET skillRank = ?, rankProgress = ?, nextRankAvailable = ? WHERE characterId = ? AND skillId = ? ";
    }

    /**
     * Query for deleting all character skills
     * @return Query string
     */
    public static String deleteCharacterSkillsQuery()
    {
        return " DELETE FROM character_skill WHERE characterId = ? ";
    }
    //#endregion

    /**
     * Query for creating character stats
     * @return Query string
     */
    //#region Character Stat Queries
    public static String createCharacterStatsQuery()
    {
        return "INSERT INTO character_stat (characterId, statId) VALUES (?, ?)";
    }

    /**
     * Query for retrieving all character stats
     * @return Query string
     */
    public static String viewCharacterStatsQuery()
    {
        return " SELECT st.statId AS statId, st.name AS name, st.effect AS effect, st.description AS description" + " FROM character_stat cst JOIN stat st ON cst.statId = st.statId WHERE cst.characterId = ? ";
    }

    /**
     * Query for deleting all character stats
     *
     * @return Query string
     */
    public static String deleteCharacterStatsQuery()
    {
        return " DELETE FROM character_stat WHERE characterId = ? ";
    }

    public static String deleteCharacterStatByIdQuery()
    {
        return " DELETE FROM stat WHERE statId = ? ";
    }
    //#endregion

    /**
     * Query for viewing all skills
     * @return Query string
     */
    //#region ReadOnly
    public static String viewAllSkillsQuery()
    {
        return " SELECT * FROM skill sk" + " JOIN `rank` rk ON rk.skillId = sk.skillId" + " JOIN stat st ON rk.statId = st.statId ";
    }

    /**
     * Query for viewing all stats
     * @return Query string
     */
    public static String viewAllStatsQuery()
    {
        return " SELECT * FROM stat ";
    }
    //#endregion
}
