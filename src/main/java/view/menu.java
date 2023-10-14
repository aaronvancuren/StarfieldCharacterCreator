package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Skill;
import model.StarfieldCharacter;
import model.Stat;

import java.util.Optional;

public class menu extends Application
{
    private StarfieldCharacter character;
    private TableView<StarfieldCharacter> tvCharacters = new TableView<>();
    private TableView<Skill> tvCharacterSkills = new TableView<>();
    private TableView<Stat> tvCharacterStats = new TableView<>();

    /**
     * Launches the display for the application
     * @param stage setup component for display
     */
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Starfield Character Creator");
        stage.getIcons().add(new Image("file:src/main/images/starfield.png"));
        stage.setScene(new Scene(getContent()));
        stage.setMinWidth(510);
        stage.show();
    }

    /**
     * Builds the display for the main page of the application
     * @return VBox contains the buttons component and a GridPane with TableViews of character related data
     */
    private VBox getContent()
    {
        tvCharacters = StarfieldCharacter.getTableView();
        tvCharacters.setMinWidth(500);
        tvCharacters.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        Label lblCharacters = new Label("Characters", tvCharacters);
        lblCharacters.setContentDisplay(ContentDisplay.BOTTOM);

        tvCharacterSkills = Skill.getTableView();
        tvCharacterSkills.setMinWidth(500);
        tvCharacterSkills.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Label lblCharacterSkills = new Label("Skills", tvCharacterSkills);
        lblCharacterSkills.setContentDisplay(ContentDisplay.BOTTOM);

        tvCharacterStats = Stat.getTableView();
        tvCharacterStats.setMinWidth(500);
        Label lblCharacterStats = new Label("Stats", tvCharacterStats);
        lblCharacterStats.setLabelFor(tvCharacterStats);
        lblCharacterStats.setContentDisplay(ContentDisplay.BOTTOM);

        GridPane gpForm = new GridPane();
        gpForm.setPadding(new Insets(5));
        gpForm.setHgap(15);
        gpForm.setVgap(15);
        gpForm.add(lblCharacters, 0, 1);
        gpForm.add(getCrudButtons(), 1, 1);
        gpForm.add(lblCharacterSkills, 0, 2);
        gpForm.add(lblCharacterStats, 1, 2);

        VBox root = new VBox();
        root.setFillWidth(true);
        root.setPadding(new Insets(5));
        root.getChildren().addAll(gpForm);
        return root;
    }

    /**
     * Builds the component that contains the buttons for interacting with characters
     * @return HBox containing buttons
     */
    private HBox getCrudButtons()
    {
        Button btnCreateCharacter = new Button("Create Character");
        btnCreateCharacter.setOnAction(e -> createCharacter());

        Button btnUpdateCharacters = new Button("Update Character");
        btnUpdateCharacters.setOnAction(e -> updateCharacter());

        Button btnDeleteCharacters = new Button("Delete Character");
        btnDeleteCharacters.setOnAction(e -> deleteCharacter());

        HBox crudButtons = new HBox(5, btnCreateCharacter, btnUpdateCharacters,
                                    btnDeleteCharacters);

        crudButtons.setSpacing(30);
        crudButtons.setAlignment(Pos.BASELINE_CENTER);
        return crudButtons;
    }

    /**
     * Launches a dialog prompt for creating a character
     */
    private void createCharacter()
    {
        try
        {
            Dialog<StarfieldCharacter> dialog = new CharacterDialog();
            Optional<StarfieldCharacter> result = dialog.showAndWait();
            /* Ensures a character was created and alerts the user */
            if (result.isPresent())
            {
                character = result.get();
                if (character.getCharacterId() != -1)
                {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Character was created.");
                    alert.show();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Launches a dialog prompt for updating a character
     */
    private void updateCharacter()
    {
        try
        {
            StarfieldCharacter selectedCharacter = tvCharacters.getSelectionModel().getSelectedItem();
            /* Ensures a character is selected before opening dialog */
            if (selectedCharacter == null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Must select a character.");
                alert.show();
                return;
            }

            Dialog<StarfieldCharacter> dialog = new CharacterDialog(selectedCharacter);
            Optional<StarfieldCharacter> result = dialog.showAndWait();
            /* Ensures a character was updated and alerts the user */
            if (result.isPresent())
            {
                character = result.get();
                /* Only shows message if character was changed and updated */
                if (character.getCharacterId() != -1 && !selectedCharacter.equals(character))
                {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Character was updated.");
                    alert.show();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Deletes the selected character and any related data
     */
    private void deleteCharacter()
    {
        StarfieldCharacter selectedCharacter = tvCharacters.getSelectionModel().getSelectedItem();
        /* Ensures a character is selected before attempting to delete */
        if (selectedCharacter == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Must select a character.");
            alert.show();
            return;
        }

        StarfieldCharacter.deleteCharacter(selectedCharacter.getCharacterId());
    }
}