package com.mrando.azucardj.service;

import java.util.List;
import com.mrando.azucardj.model.Item;

public interface IItemsServices {
    List<Item> fetch();
    void save(Item item);
    Item searchById(Integer idItem);
    List<Item> searchByAuthor(Integer idAuthor);
    List<Item> searchByGenre(Integer idGenre);
    List<Item> searchByArtist(Integer idArtist);
}