package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaProvider
{
    /**
     * Creates the default MariaDB connection
     *
     * @return MariaDB Connection
     */
    public static Connection getConnection()
    {
        return getConnection(
                new DatabaseConnection("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost:3306/starfield", "root",
                                       ""));
    }

    /**
     * Creates a connection based on the parameters
     * @param jdbcDrive  Database Drive
     * @param databaseUrl Database Url
     * @param username Database Username
     * @param password Database Password
     * @return The specified database connection
     */
    public static Connection getConnection(String jdbcDrive, String databaseUrl, String username, String password)
    {
        return getConnection(new DatabaseConnection(jdbcDrive, databaseUrl, username, password));
    }

    /**
     * Creates a connection based on the parameter
     * @param databaseConnection Database connection data
     * @return The specified database connection
     */
    public static Connection getConnection(DatabaseConnection databaseConnection)
    {
        try
        {
            System.out.println("Loading driver...");
            Class.forName(databaseConnection.getJdbcDrive());
            System.out.println("Driver loaded!");

            System.out.println("Connecting to database...");
            StringBuilder sb = new StringBuilder();
            sb.append(databaseConnection.getDatabaseUrl());
            if (!(databaseConnection.getUsername().isBlank() && databaseConnection.getUsername().isEmpty()))
            {
                sb.append("?user=").append(databaseConnection.getUsername());
            }

            if (!(databaseConnection.getPassword().isBlank() && databaseConnection.getPassword().isEmpty()))
            {
                sb.append("?password=").append(databaseConnection.getPassword());
            }

            Connection connection = DriverManager.getConnection(sb.toString());
            connection.setAutoCommit(false);
            System.out.println("Database connected!");
            return connection;
        }
        catch (ClassNotFoundException e)
        {
            throw new IllegalStateException("Cannot find the driver for MariaDB.", e);
        }
        catch (SQLException e)
        {
            throw new IllegalStateException("Cannot connect to " + databaseConnection.getDatabaseUrl() + " database.",
                                            e);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
