package view;

import helpers.CellFactoryHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import model.Skill;
import model.SkillComparator;
import model.StarfieldCharacter;

import java.sql.SQLException;
import java.util.Optional;

public class CharacterDialog extends Dialog<StarfieldCharacter>
{
    private final boolean isCreate;
    private StarfieldCharacter character = new StarfieldCharacter("", "", FXCollections.observableArrayList(),
                                                                  FXCollections.observableArrayList());
    private final ObservableList<Skill> skills;
    private final ObservableList<Skill> recentlyAddedSkills = FXCollections.observableArrayList();
    private final TextField tfCharacterName = new TextField();
    private final TextArea taCharacterDescription = new TextArea();
    private ComboBox<Skill> cbSkills = new ComboBox<>();
    private Label lblAvailableSkillPoints = new Label();
    private TableView<Skill> tvCharacterSkills = new TableView<>();

    /**
     * Displays the dialog for creating a character
     */
    public CharacterDialog()
    {
        super();
        this.setTitle("Create Character");
        isCreate = true;
        this.skills = Skill.viewAllSkills();
        this.skills.sort(new SkillComparator());

        setDialogButtons("Create");
        getDialogPane().setContent(getContent());
        setPropertyBindings();
        setResultConverter();
    }

    /**
     * Displays the dialog for updating character data
     *
     * @param character Used to populate the form
     */
    public CharacterDialog(StarfieldCharacter character)
    {
        super();
        this.setTitle("Edit Character");
        isCreate = false;
        this.character = character;
        this.skills = Skill.viewAllSkills();
        for (Skill skill : character.getSkills())
        {
            skills.remove(skill);
        }
        this.skills.sort(new SkillComparator());

        setDialogButtons("Update");
        getDialogPane().setContent(getContent());
        setPropertyBindings();
        setResultConverter();
    }

    /**
     * Builds the component that contains the buttons for interacting with the dialog
     */
    public void setDialogButtons(String applyButtonName)
    {
        ButtonType btApplyDialog = new ButtonType(applyButtonName, ButtonBar.ButtonData.APPLY);
        ButtonType btCloseDialog = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(btApplyDialog, btCloseDialog);
        Button btApply = (Button) getDialogPane().lookupButton(btApplyDialog);
        btApply.addEventFilter(ActionEvent.ACTION, actionEvent -> {
            if (!isValidForm())
            {
                actionEvent.consume();
            }
        });
    }


    /**
     * Builds the display for the dialog
     * @return Contains a VBox form of the required/editable data fields of a character
     */
    private VBox getContent()
    {
        tfCharacterName.setMaxWidth(255);
        Label lblCharacterName = new Label("Name: ");
        lblCharacterName.setLabelFor(tfCharacterName);
        lblCharacterName.setContentDisplay(ContentDisplay.RIGHT);

        taCharacterDescription.setWrapText(true);
        taCharacterDescription.setMaxWidth(255);
        Label lblCharacterDescription = new Label("Description: ");
        lblCharacterDescription.setLabelFor(taCharacterDescription);
        lblCharacterDescription.setContentDisplay(ContentDisplay.RIGHT);

        cbSkills = new ComboBox<>(skills);
        cbSkills.setButtonCell(CellFactoryHelper.listCell());
        cbSkills.setCellFactory(CellFactoryHelper.cellCallback());
        Label lblSkills = new Label("Select Skill: ");
        lblSkills.setLabelFor(cbSkills);
        lblSkills.setContentDisplay(ContentDisplay.RIGHT);

        Button btSkills = new Button("Increase Skill");
        btSkills.setOnAction(e -> addSkill());

        HBox skillSelectionRow = new HBox();
        skillSelectionRow.getChildren().addAll(lblSkills, cbSkills, btSkills);

        lblAvailableSkillPoints = new Label("Skill points left: " + character.getAvailableSkillPoints());

        tvCharacterSkills = Skill.getTableViewWithRankAndStat();
        tvCharacterSkills.setMinWidth(500);
        tvCharacterSkills.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tvCharacterSkills.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getClickCount() > 1)
            {
                Skill selectedSkill = tvCharacterSkills.getSelectionModel().getSelectedItem();
                if (selectedSkill == null)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Must select a skill.");
                    alert.show();
                    return;
                }

                Alert alert = new Alert(Alert.AlertType.WARNING,
                                        "Would you like to remove the " + selectedSkill.getName() + " skill?");
                Optional<ButtonType> response = alert.showAndWait();
                if (response.isPresent() && response.get() == ButtonType.OK)
                {
                    if (recentlyAddedSkills.contains(selectedSkill))
                    {
                        removeSkill(selectedSkill);
                        return;
                    }

                    alert = new Alert(Alert.AlertType.ERROR, "Cannot remove skills that have already been saved.");
                    alert.show();
                }
            }
        });

        Label lblCharacterSkills = new Label("Skills", tvCharacterSkills);
        lblCharacterSkills.setContentDisplay(ContentDisplay.BOTTOM);

        VBox characterDetails = new VBox();
        characterDetails.getChildren()
                        .addAll(lblCharacterName, tfCharacterName, lblCharacterDescription, taCharacterDescription,
                                skillSelectionRow, lblAvailableSkillPoints, lblCharacterSkills);
        VBox root = new VBox();
        root.setFillWidth(true);
        root.setPadding(new Insets(20));
        root.getChildren().add(characterDetails);
        return root;
    }

    /**
     * Adds a skill to a character
     */
    private void addSkill()
    {
        try
        {
            if (cbSkills.getValue() != null)
            {
                character.addSkill(cbSkills.getValue());
                recentlyAddedSkills.add(cbSkills.getValue());
            }
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to add skill. Error: " + e.getMessage());
            alert.show();
        }
        finally
        {
            if (character.getSkill(cbSkills.getValue()) != null)
            {
                this.skills.remove(cbSkills.getValue());
                this.skills.sort(new SkillComparator());
            }

            lblAvailableSkillPoints.setText("Skill points left: " + character.getAvailableSkillPoints());
        }
    }

    /**
     * Removes a skill from a character
     * @param skill skill to be removed
     */
    private void removeSkill(Skill skill)
    {
        try
        {
            character.removeSkill(skill);
            recentlyAddedSkills.remove(skill);
            this.skills.add(skill);
            this.skills.sort(new SkillComparator());
            lblAvailableSkillPoints.setText("Skill points left: " + character.getAvailableSkillPoints());
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to remove skill. Error: " + e.getMessage());
            alert.show();
        }
    }

    /**
     * Sets two-way binding for character properties
     */
    private void setPropertyBindings()
    {
        tfCharacterName.textProperty().bindBidirectional(character.getNameProperty());
        taCharacterDescription.textProperty().bindBidirectional(character.getDescriptionProperty());
        tvCharacterSkills.itemsProperty().bindBidirectional(character.getSkillsProperty());
    }

    /**
     * Converts the dialog result into the desired return type
     */
    private void setResultConverter()
    {
        Callback<ButtonType, StarfieldCharacter> starfieldCharacterCallback = buttonType -> {
            if (buttonType != ButtonType.APPLY)
            {
                try
                {
                    if (isCreate)
                    {
                        StarfieldCharacter starfieldCharacter = StarfieldCharacter.createCharacter(character);
                    }
                    else
                    {
                        StarfieldCharacter.updateCharacter(character);
                    }
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }

                return character;
            }

            return null;
        };

        setResultConverter(starfieldCharacterCallback);
    }

    /**
     * Checks if the form inputs are valid for creating/updating a character
     * @return true if form parameters are valid inputs
     */
    public boolean isValidForm()
    {
        if (tfCharacterName.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Character name is required.");
            alert.show();
            return false;
        }

        if (taCharacterDescription.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                    "Character description is missing. Are you sure you want to continue?");
            alert.getButtonTypes().clear();
            alert.getButtonTypes().add(new ButtonType("Yes", ButtonBar.ButtonData.YES));
            alert.getButtonTypes().add(new ButtonType("No", ButtonBar.ButtonData.NO));
            Optional<ButtonType> result = alert.showAndWait();
            return result.isEmpty() || (result.get().getButtonData() != ButtonBar.ButtonData.NO);
        }

        return !isCreate || character.getAvailableSkillPoints() <= 0;
    }
}
