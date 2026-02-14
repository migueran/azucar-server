package com.mrando.azucardj.service;

import java.util.LinkedList;
import java.util.List;
import com.mrando.azucardj.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemsServices implements IItemsServices {

    private List<Item> itemsMocka = null;

    public ItemsServices() {
        itemsMocka = new LinkedList<Item>();
        itemsMocka.add(
            new Item(3010, 0, 100, 0, 301)
        );
        itemsMocka.add(
            new Item(3020, 0, 100, 0, 302)
        );
        itemsMocka.add(
            new Item(3030, 0, 100, 0, 303)
        );
        itemsMocka.add(
            new Item(3040, 0, 100, 0, 304)
        );
        itemsMocka.add(
            new Item(3050, 0, 100, 0, 305)
        );
        itemsMocka.add(
            new Item(3060, 0, 100, 0, 306)
        );
        itemsMocka.add(
            new Item(3070, 0, 100, 0, 307)
        );
        itemsMocka.add(
            new Item(3080, 0, 100, 0, 308)
        );
        itemsMocka.add(
            new Item(3090, 0, 100, 0, 309)
        );
        itemsMocka.add(
            new Item(3100, 0, 100, 0, 310)
        );
        itemsMocka.add(
            new Item(3110, 0, 200, 0, 301)
        );
        itemsMocka.add(
            new Item(3120, 0, 200, 0, 302)
        );
        itemsMocka.add(
            new Item(3130, 0, 200, 0, 303)
        );
        itemsMocka.add(
            new Item(3140, 0, 200, 0, 305)
        );
        itemsMocka.add(
            new Item(3150, 0, 200, 0, 306)
        );
        itemsMocka.add(
            new Item(3160, 0, 200, 0, 304)
        );
        itemsMocka.add(
            new Item(3170, 0, 300, 0, 308)
        );
        itemsMocka.add(
            new Item(3180, 0, 500, 0, 309)
        );
        itemsMocka.add(
            new Item(3190, 0, 100, 0, 310)
        );
        itemsMocka.add(
            new Item(3200, 0, 400, 0, 306)
        );
    };

    @Override
    public List<Item> fetch() {
        return itemsMocka;
    }

    @Override
    public void save(Item item) {
        itemsMocka.add(item);
    }

    @Override
    public Item searchById(Integer idItem) {
        for (Item item : itemsMocka) {
            if (item.getId() == idItem.intValue()) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Item> searchByOwner(Integer idOwner) {
        List<Item> itemsByOwner = new LinkedList<Item>();
        for (Item item : itemsMocka) {
            if (item.getIdOwner() == idOwner.intValue()) {
                itemsByOwner.add(item);
            }
        }
        return itemsByOwner;
    }

    @Override
    public List<Item> searchByGenre(Integer idGenre) {
        List<Item> itemsByGenre = new LinkedList<Item>();
        for (Item item : itemsMocka) {
            if (item.getIdTheme() == idGenre.intValue()) {
                itemsByGenre.add(item);
            }
        }
        return itemsByGenre;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'searchByGenre'");
    }

    @Override
    public List<Item> searchByArtist(Integer idArtist) {
        List<Item> itemsByArtist = new LinkedList<Item>();
        for (Item item : itemsMocka) {
            // if (item.getIdArtist() == idArtist.intValue()) {
            //    itemsByArtist.add(item);
            // }
            System.out.println("guardar vacante: " + item);
        }
        return itemsByArtist;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'searchByArtist'");
    }
}