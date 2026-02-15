package com.mrando.azucardj.service;

import java.util.List;
import com.mrando.azucardj.model.Item;
import org.springframework.stereotype.Service;

@Service
public interface IItemsServices {
    List<Item> fetch();
    void save(Item item);
    Item searchById(Integer idItem);
    List<Item> searchByOwner(Integer idOwner);
    List<Item> searchByGenre(Integer idGenre);
    List<Item> searchByTheme(Integer idThdeme);
}