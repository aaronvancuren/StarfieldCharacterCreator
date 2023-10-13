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

import java.io.IOException;
import java.util.Optional;

// TODO: Add documentation
// TODO: Update test files
// TODO: Finish populating database
public class menu extends Application
{
    private StarfieldCharacter character;
    private TableView<StarfieldCharacter> tvCharacters = new TableView<>();
    private TableView<Skill> tvCharacterSkills = new TableView<>();
    private TableView<Stat> tvCharacterStats = new TableView<>();

    @Override
    public void start(Stage stage) throws IOException
    {
        stage.setTitle("Starfield Character Creator");
        stage.getIcons().add(new Image("file:src/main/images/starfield.png"));
        stage.setScene(new Scene(getContent()));
        stage.setMinWidth(510);
        stage.show();
    }

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

    private void createCharacter()
    {
        try
        {
            Dialog<StarfieldCharacter> dialog = new CharacterDialog();
            Optional<StarfieldCharacter> result = dialog.showAndWait();
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

    private void updateCharacter()
    {
        try
        {
            StarfieldCharacter selectedCharacter = tvCharacters.getSelectionModel().getSelectedItem();
            if (selectedCharacter == null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Must select a character.");
                alert.show();
                return;
            }

            Dialog<StarfieldCharacter> dialog = new CharacterDialog(selectedCharacter);
            Optional<StarfieldCharacter> result = dialog.showAndWait();
            if (result.isPresent())
            {
                character = result.get();
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

    private void deleteCharacter()
    {
        StarfieldCharacter selectedCharacter = tvCharacters.getSelectionModel().getSelectedItem();
        if (selectedCharacter == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Must select a character.");
            alert.show();
            return;
        }

        StarfieldCharacter.deleteCharacter(selectedCharacter.getCharacterId());
    }
}