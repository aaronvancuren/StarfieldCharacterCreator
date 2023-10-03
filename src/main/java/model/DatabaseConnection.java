package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DatabaseConnection
{
    private StringProperty jdbcDrive = new SimpleStringProperty();
    private StringProperty databaseUrl = new SimpleStringProperty();
    private StringProperty username = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();

    public DatabaseConnection() {}

    public DatabaseConnection(String jdbcDrive, String databaseUrl, String username, String password)
    {
        this.jdbcDrive = new SimpleStringProperty(jdbcDrive);
        this.databaseUrl = new SimpleStringProperty(databaseUrl);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    public StringProperty getJdbcDriveProperty()
    {
        return jdbcDrive;
    }

    public String getJdbcDrive()
    {
        return jdbcDrive.get();
    }

    public StringProperty getDatabaseUrlProperty()
    {
        return databaseUrl;
    }

    public String getDatabaseUrl()
    {
        return databaseUrl.get();
    }

    public StringProperty getUsernameProperty()
    {
        return username;
    }

    public String getUsername()
    {
        return username.get();
    }

    public StringProperty getPasswordProperty()
    {
        return password;
    }

    public String getPassword()
    {
        return password.get();
    }
}
