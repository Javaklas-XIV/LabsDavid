package trainee.david.webshop.view;

import trainee.david.webshop.model.Catalog;
import trainee.david.webshop.model.Item;

import java.util.List;

public class BrowseView extends Interface {

    private final InputListener inputListener;
    private final List<Catalog> catalogs;

    public BrowseView(InputListener inputListener, List<Catalog> catalogs) {
        this.inputListener = inputListener;
        this.catalogs = catalogs;
    }

    @Override
    public void show() {
        printMenuHeader("Select catalog");
        for (int index = 0; index < catalogs.size(); index++) {
            printLine("[%d] %s".formatted(index, catalogs.get(index).toString()));
        }

        String input;
        int selectedCatalog;
        do {
            input = getUserInput("Select a catalog: ");
        } while ((selectedCatalog = validMenuInput(input, catalogs.size())) == -1);

        printMenuHeader("Browse");
        for (Item catalogItem : catalogs.get(selectedCatalog).articles()) {
            printLine(catalogItem.toString());
        }

        getUserInput("Press enter to return to the main menu");
        inputListener.onBrowseComplete();
    }
}
