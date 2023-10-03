package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Stat
{
    private static final Connection connection = MariaProvider.getConnection();
    private int statId;
    private final String name;
    private int effect;
    private final String description;

    public Stat(String name, int effect, String description)
    {
        this.name = name;
        this.effect = effect;
        this.description = description;
    }

    public Stat(int statId, String name, int effect, String description)
    {
        this.statId = statId;
        this.name = name;
        this.effect = effect;
        this.description = description;
    }

    public int getStatId()
    {
        return statId;
    }

    public String getName()
    {
        return name;
    }

    public int getEffect()
    {
        return effect;
    }

    public void setEffect(int effect)
    {
        this.effect = effect;
    }

    public String getDescription()
    {
        return description;
    }

    public static ObservableList<Stat> viewAllStats()
    {
        ObservableList<Stat> stats = FXCollections.observableArrayList();
        try
        {
            PreparedStatement ps = connection.prepareStatement(QueryBuilder.viewAllStatsQuery());
            ResultSet result = ps.executeQuery();
            while (result.next())
            {
                int statId = result.getInt(1);
                String name = result.getString(2);
                int effect = result.getInt(1);
                String description = result.getString(2);
                stats.add(new Stat(statId, name, effect, description));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Failed to retrieve all skills. Error: " + new RuntimeException(e).getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Failed to retrieve all skills. Error: " + e.getMessage());
        }

        return stats;
    }
}
