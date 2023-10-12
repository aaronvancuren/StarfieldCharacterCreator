package helpers;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class CellFactoryHelper
{
    public static <T extends CellView> Callback<ListView<T>, ListCell<T>> cellCallback()
    {
        return listView -> listCell();
    }

    public static <T extends CellView> ListCell<T> listCell()
    {
        return new ListCell<T>()
        {
            @Override
            protected void updateItem(T item, boolean empty)
            {
                super.updateItem(item, empty);
                if (item == null || empty)
                {
                    setText(null);
                }
                else
                {
                    setText(item.cellView());
                }
            }
        };
    }
}
