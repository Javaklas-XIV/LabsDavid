package trainee.david.webshop.model.repo;

import trainee.david.webshop.model.Catalog;

import java.util.Optional;

public class CatalogRepo extends LocalRepository<Catalog> {

    public CatalogRepo(ItemRepo itemRepo){
        // TEMP
        Catalog catalog1 = new Catalog(2024);
        catalog1.addItem(itemRepo.get(0));
        catalog1.addItem(itemRepo.get(1));
        add(catalog1);

        Catalog catalog2 = new Catalog(2025);
        catalog2.addItem(itemRepo.get(2));
        add(catalog2);
    }

    public Optional<Catalog> find(int year) {
        return items.stream().filter(catalog -> catalog.getYear() == year).findFirst();
    }
}
