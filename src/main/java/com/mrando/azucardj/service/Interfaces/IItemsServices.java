package com.mrando.azucardj.service.Interfaces;

import java.util.List;
import com.mrando.azucardj.model.Item;
import org.springframework.stereotype.Service;

@Service
public interface IItemsServices {
    List<Item> fetch();
    void save(Item item);
    Item findById(Integer idItem);
    List<Item> findByOwner(Integer idOwner);
    List<Item> findByGenre(Integer idGenre);
    List<Item> findByTheme(Integer idThdeme);
}