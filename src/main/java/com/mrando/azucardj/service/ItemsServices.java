package com.mrando.azucardj.service;

import java.util.List;
import com.mrando.azucardj.model.Item;

public class ItemsServices implements IItemsServices {

    @Override
    public List<Item> fetch() {
        return null;
    }

    @Override
    public void save(Item item) {
    }

    @Override
    public Item searchById(Integer idItem) {
        return null;
    }

    @Override
    public List<Item> searchByAuthor(Integer idAuthor) {
        return null;
    }

    @Override
    public List<Item> searchByGenre(Integer idGenre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByGenre'");
    }

    @Override
    public List<Item> searchByArtist(Integer idArtist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByArtist'");
    }
}