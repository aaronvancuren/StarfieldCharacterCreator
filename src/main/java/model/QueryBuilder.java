package model;

public class QueryBuilder
{
    public static String createCharacterQuery()
    {
        // TODO: Need to account for any linked tables
        return " INSERT INTO character" + " (name, experienceNeeded, availableSkillPoints, description, level, experience)" + " VALUES" + " ( ?, ?, ?, ?, ?, ? ) ";
    }

    public static String viewAllCharactersQuery()
    {
        // TODO: Need to account for any linked tables
        return " SELECT * FROM character ";
    }

    public static String viewCharacterQuery()
    {
        // TODO: Need to account for any linked tables
        return " SELECT * FROM character WHERE characterId = ? ";
    }

    public static String updateCharacterQuery()
    {
        // TODO: Need to account for any linked tables
        return " UPDATE character" + " (characterId, name, experienceNeeded, availableSkillPoints, description, level, experience)" + " VALUES ( ?, ?, ?, ?, ?, ? )" + " WHERE characterId = ? ";
    }

    public static String deleteCharacterQuery()
    {
        // TODO: Need to account for any linked tables
        return " DELETE FROM character WHERE characterId = ? ";
    }

    public static String viewAllSkillsQuery()
    {
        return "SELECT * FROM skill";
    }

    public static String viewAllStatsQuery()
    {
        // TODO: Need to figure out how to store default values that can be retrieved.
        return "SELECT * FROM stat";
    }
}
