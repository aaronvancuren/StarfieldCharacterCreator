package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import model.StarfieldCharacter;

import java.util.LinkedList;

public class CharacterDialog extends Dialog<StarfieldCharacter>
{
    private final ListView<StarfieldCharacter> lvCharacters = new ListView<>();
    private StarfieldCharacter selectedCharacter;

    public CharacterDialog(LinkedList<StarfieldCharacter> characters)
    {
        super();
        this.setTitle("Characters");
        this.lvCharacters.getItems().addAll(characters);

        VBox root = new VBox();
        root.setFillWidth(true);
        root.setPadding(new Insets(20));

        lvCharacters.setMaxWidth(255);
        lvCharacters.setMaxHeight(255);
        lvCharacters.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        root.getChildren().add(lvCharacters);

        ButtonType btSelectCharacter = new ButtonType("Select Character", ButtonBar.ButtonData.OK_DONE);
        ButtonType btCloseDialog = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(btSelectCharacter, btCloseDialog);
        getDialogPane().setContent(root);
        setPropertyBindings();
        setResultConverter();
    }

    private void setPropertyBindings()
    {
        selectedCharacter = lvCharacters.getSelectionModel().getSelectedItem();
        //selectedCharacter.getNameProperty().bindBidirectional(selectedCharacter.getNameProperty());
        //selectedCharacter.getDescriptionProperty().bindBidirectional(selectedCharacter.getDescriptionProperty());
    }

    private void setResultConverter()
    {
        Callback<ButtonType, StarfieldCharacter> starfieldCharacterCallback = buttonType -> {
            if (buttonType != ButtonType.CANCEL && buttonType != ButtonType.CLOSE && buttonType.getText()
                                                                                               .equals("Select Character"))
            {
                return selectedCharacter;
            }

            return null;
        };

        setResultConverter(starfieldCharacterCallback);
    }
}
