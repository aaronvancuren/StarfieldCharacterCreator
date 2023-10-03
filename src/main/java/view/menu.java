package view;

import javafx.application.Application;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
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
import java.util.LinkedList;
import java.util.Optional;

// TODO: Add documentation
// TODO: Update test files
// TODO: Finish populating database
public class menu extends Application
{
    private StarfieldCharacter character;
    private LinkedList<StarfieldCharacter> characters;
    private TextField tfCharacterName;
    private TextField tfCharacterLevel;
    private ProgressBar pgCharacterExperience;
    private TextField tfCharacterSkillPoints;
    private TextArea taCharacterDescription;
    private ListView<Skill> lvCharacterSkills;
    private ListView<Stat> lvCharacterStats;

    @Override
    public void start(Stage stage) throws IOException
    {
        HBox crudButtons = getCrudButtons();
        GridPane gridForm = getGridForm();

        VBox root = new VBox();
        root.setFillWidth(true);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(crudButtons, gridForm);

        stage.setTitle("Starfield Character Creator");
        stage.getIcons().add(new Image("file:src/main/images/starfield.png"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    private HBox getCrudButtons()
    {
        Button btnCreateCharacter = new Button("Create Character");
        btnCreateCharacter.setOnAction(e -> createCharacter());

        Button btnViewCharacters = new Button("View Characters");
        btnViewCharacters.setOnAction(e -> viewCharacter());

        Button btnUpdateCharacters = new Button("Update Characters");
        btnUpdateCharacters.setOnAction(e -> updateCharacter());

        Button btnDeleteCharacters = new Button("Delete Characters");
        btnDeleteCharacters.setOnAction(e -> deleteCharacter());

        HBox crudButtons = new HBox(10, btnCreateCharacter, btnViewCharacters, btnUpdateCharacters,
                                    btnDeleteCharacters);
        crudButtons.setPadding(new Insets(10));
        crudButtons.setAlignment(Pos.BASELINE_CENTER);
        return crudButtons;
    }

    private GridPane getGridForm()
    {
        tfCharacterName = new TextField();
        tfCharacterName.setMaxWidth(255);
        Label lblCharacterName = new Label("Name: ");
        lblCharacterName.setLabelFor(tfCharacterName);
        lblCharacterName.setContentDisplay(ContentDisplay.RIGHT);

        tfCharacterLevel = new TextField("1");
        tfCharacterLevel.setEditable(false);
        tfCharacterLevel.setMaxWidth(25);
        Label lblCharacterLevel = new Label("Level: ");
        lblCharacterLevel.setLabelFor(tfCharacterLevel);
        lblCharacterLevel.setContentDisplay(ContentDisplay.RIGHT);

        pgCharacterExperience = new ProgressBar(0);
        Label lblCharacterExperience = new Label("Experience: ");
        lblCharacterExperience.setLabelFor(pgCharacterExperience);
        lblCharacterExperience.setContentDisplay(ContentDisplay.RIGHT);
        lblCharacterExperience.setTooltip(new Tooltip("0 / 1000 exp points"));

        tfCharacterSkillPoints = new TextField("3");
        tfCharacterSkillPoints.setEditable(false);
        tfCharacterSkillPoints.setMaxWidth(25);
        Label lblCharacterSkillPoints = new Label("Skill Points: ");
        lblCharacterSkillPoints.setLabelFor(tfCharacterSkillPoints);
        lblCharacterSkillPoints.setContentDisplay(ContentDisplay.RIGHT);


        taCharacterDescription = new TextArea();
        taCharacterDescription.setWrapText(true);
        taCharacterDescription.setMaxWidth(255);
        Label lblCharacterDescription = new Label("Description: ");
        lblCharacterDescription.setLabelFor(taCharacterDescription);
        lblCharacterDescription.setContentDisplay(ContentDisplay.RIGHT);


        // TODO: Create List/Table View
        lvCharacterSkills = new ListView<>(Skill.viewAllSkills());
        lvCharacterSkills.setMaxWidth(255);
        lvCharacterSkills.setMaxHeight(255);
        lvCharacterSkills.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Label lblCharacterSkills = new Label("Skills", lvCharacterSkills);
        lblCharacterSkills.setContentDisplay(ContentDisplay.BOTTOM);

        // TODO: Create List/Table View
        lvCharacterStats = new ListView<>(Stat.viewAllStats());
        lvCharacterStats.setMaxWidth(255);
        lvCharacterStats.setMaxHeight(255);
        Label lblCharacterStats = new Label("Stats", lvCharacterStats);
        lblCharacterStats.setLabelFor(lvCharacterStats);
        lblCharacterStats.setContentDisplay(ContentDisplay.BOTTOM);

        GridPane gpForm = new GridPane();
        gpForm.setPadding(new Insets(10));
        gpForm.setHgap(10);
        gpForm.setVgap(10);
        gpForm.addRow(1, lblCharacterName, tfCharacterName, lblCharacterLevel, tfCharacterLevel, lblCharacterExperience,
                      pgCharacterExperience, lblCharacterSkillPoints, tfCharacterSkillPoints);
        gpForm.addRow(2, lblCharacterDescription, taCharacterDescription);
        gpForm.add(lblCharacterSkills, 1, 3);
        gpForm.add(lblCharacterStats, 2, 3, 6, 1);
        return gpForm;
    }

    private void createCharacter()
    {
        if (tfCharacterName.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Character name is required.");
            alert.show();
            return;
        }

        if (taCharacterDescription.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to give your character a description?");
            alert.getButtonTypes().clear();
            alert.getButtonTypes().add(new ButtonType("Yes", ButtonBar.ButtonData.YES));
            alert.getButtonTypes().add(new ButtonType("No", ButtonBar.ButtonData.NO));
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get().getButtonData() == ButtonBar.ButtonData.YES)
            {
                return;
            }
        }

        ObservableList<Skill> skills = lvCharacterSkills.getSelectionModel().getSelectedItems();
        if (skills.isEmpty() || Integer.parseInt(tfCharacterSkillPoints.textProperty().get()) > 0)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                                    "Must select three (3) new skills for your character. Only " + tfCharacterSkillPoints.textProperty()
                                                                                                                         .get() + " have been selected.");
            alert.show();
            return;
        }

        // TODO: Need method to create default stat values.

        character = new StarfieldCharacter(tfCharacterName.getText(), taCharacterDescription.getText(), skills,
                                           new SimpleListProperty<>());
        StarfieldCharacter.createCharacter(character);
    }

    private void viewAllCharacter()
    {
        characters = StarfieldCharacter.viewAllCharacter();
        CharacterDialog test = new CharacterDialog(characters);
    }

    private void viewCharacter()
    {
        StarfieldCharacter.viewCharacter(character.getCharacterId());
    }

    private void updateCharacter()
    {
        StarfieldCharacter.updateCharacter(character);
    }

    private void deleteCharacter()
    {
        StarfieldCharacter.deleteCharacter(character.getCharacterId());
    }
}