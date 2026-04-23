package com.mrando.azucardj.service;

import com.mrando.azucardj.repository.ItemsRepository;
import java.util.List;
import com.mrando.azucardj.model.Item;
import com.mrando.azucardj.service.Interfaces.IItemsService;

import org.springframework.stereotype.Service;

@Service
public class ItemsService implements IItemsService {

    private final ItemsRepository itemsRepository;
    ItemsService(ItemsRepository itemsRepository) {
      this.itemsRepository = itemsRepository;
    }

    // private List<Item> itemsMocka = null;
    // public ItemsService() {
    //     itemsMocka = new LinkedList<Item>();
    //     itemsMocka.add(
    //         new Item(3010, 0, 100, 0, 301)
    //     );
    //     itemsMocka.add(
    //         new Item(3020, 0, 100, 0, 302)
    //     );
    //     itemsMocka.add(
    //         new Item(3030, 0, 100, 0, 303)
    //     );
    //     itemsMocka.add(
    //         new Item(3040, 0, 100, 0, 304)
    //     );
    //     itemsMocka.add(
    //         new Item(3050, 0, 100, 0, 305)
    //     );
    //     itemsMocka.add(
    //         new Item(3060, 0, 100, 0, 306)
    //     );
    //     itemsMocka.add(
    //         new Item(3070, 0, 100, 0, 307)
    //     );
    //     itemsMocka.add(
    //         new Item(3080, 0, 100, 0, 308)
    //     );
    //     itemsMocka.add(
    //         new Item(3090, 0, 100, 0, 309)
    //     );
    //     itemsMocka.add(
    //         new Item(3100, 0, 100, 0, 310)
    //     );
    //     itemsMocka.add(
    //         new Item(3110, 0, 200, 0, 301)
    //     );
    //     itemsMocka.add(
    //         new Item(3120, 0, 200, 0, 302)
    //     );
    //     itemsMocka.add(
    //         new Item(3130, 0, 200, 0, 303)
    //     );
    //     itemsMocka.add(
    //         new Item(3140, 0, 200, 0, 305)
    //     );
    //     itemsMocka.add(
    //         new Item(3150, 0, 200, 0, 306)
    //     );
    //     itemsMocka.add(
    //         new Item(3160, 0, 200, 0, 304)
    //     );
    //     itemsMocka.add(
    //         new Item(3170, 0, 300, 0, 308)
    //     );
    //     itemsMocka.add(
    //         new Item(3180, 0, 500, 0, 309)
    //     );
    //     itemsMocka.add(
    //         new Item(3190, 0, 100, 0, 310)
    //     );
    //     itemsMocka.add(
    //         new Item(3200, 0, 400, 0, 306)
    //     );
    // };

    @Override
    public List<Item> fetch() {
        return itemsRepository.findAll();
    }

    @Override
    public void save(Item item) {
        itemsRepository.save(item);
    }

    @Override
    public Item findById(Integer idItem) {
        return itemsRepository.findById(idItem).orElse(null);
    }

    @Override
    public List<Item> findByOwner(Integer idOwner) {
        return itemsRepository.findAll();
        // return itemsRepository.findByOwner(idOwner);
    }

    @Override
    public List<Item> findByGenre(Integer idGenre) {
        return itemsRepository.findAll();
        // return itemsRepository.findByGenre(idGenre);
    }

    @Override
    public List<Item> findByTheme(Integer idTheme) {
        return itemsRepository.findAll();
        // return itemsRepository.findByThemeId(idTheme);
    }
}