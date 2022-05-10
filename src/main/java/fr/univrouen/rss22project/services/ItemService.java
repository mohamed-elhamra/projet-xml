package fr.univrouen.rss22project.services;

import fr.univrouen.rss22project.dtos.ItemDto;
import fr.univrouen.rss22project.entities.Item;
import fr.univrouen.rss22project.entities.Items;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    Items getAllItems();

    Item getItemById(UUID id);

    Item createItem(Item item);

    Item deleteItem(UUID guid);

    List<ItemDto> findItemList();

    Item findItemByGuid(UUID guid);


}
