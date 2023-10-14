package helpers;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * Allows overriding the CellView for a ListView component
 */
public final class CellFactoryHelper
{
    /**
     * Returns the new CellView for the ListView
     *
     * @param <T> Object type
     *
     * @return CellView Callback
     */
    public static <T extends CellView> Callback<ListView<T>, ListCell<T>> cellCallback()
    {
        return listView -> listCell();
    }

    /**
     * Returns the custom CellView
     * @param <T> Object type
     * @return Custom CellView
     */
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
