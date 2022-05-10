package fr.univrouen.rss22project.services;

import fr.univrouen.rss22project.dtos.ItemDto;
import fr.univrouen.rss22project.entities.Item;
import fr.univrouen.rss22project.entities.Items;
import fr.univrouen.rss22project.repositories.AuteurRepository;
import fr.univrouen.rss22project.repositories.CategorieRepository;
import fr.univrouen.rss22project.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    ItemRepository itemRepository;
    CategorieRepository categorieRepository;
    AuteurRepository auteurRepository;

    @Override
    public Item createItem(Item item) {
        Optional<Item> itemByPubOuMajAndTitre =
                itemRepository.findByPubOuMajAndTitre(item.getPubOuMaj(), item.getTitre());
        if (itemByPubOuMajAndTitre.isPresent())
            throw new RuntimeException("L'article avec le titre: " + item.getTitre() + " et la date: " + item.getPubOuMaj() + " existe déja.");
        item.setGuid(UUID.randomUUID());
        Item createdItem = itemRepository.save(item);
        createdItem.getCategorieListe().forEach(categorie -> {
            categorie.setItem(createdItem);
            categorieRepository.save(categorie);
        });
        createdItem.getAuteurOuContributeur().forEach(auteur -> {
            auteur.setItem(createdItem);
            auteurRepository.save(auteur);
        });

        return createdItem;
    }

    @Override
    public Items getAllItems() {
        ModelMapper mapper = new ModelMapper();
        List<ItemDto> itemDtos = itemRepository.findAll().stream()
                .map(item -> mapper.map(item, ItemDto.class))
                .collect(Collectors.toList());
        Items itemsList = new Items();
        itemsList.getItems().addAll(itemDtos);

        return itemsList;
    }


    @Override
    public Item getItemById(UUID guid) {
        return itemRepository.findById(guid)
                .orElseThrow(()
                        -> new RuntimeException("L'article avec guid " + guid + " n'existe pas"));
    }


    @Override
    public Item deleteItem(UUID guid) {
        if (guid == null)
            throw new RuntimeException("Le guid ne paut pas être null.");
        Optional<Item> item = itemRepository.findById(guid);
        if (item.isEmpty())
            throw new RuntimeException("L'article avec le guid: " + guid + " n'existe pas.");
        Item deletedItem = item.get();
        itemRepository.deleteById(guid);
        return deletedItem;
    }

    @Override
    public List<ItemDto> findItemList() {
        ModelMapper mapper = new ModelMapper();
        return itemRepository.findAll().stream()
                .map(item -> mapper.map(item, ItemDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Item findItemByGuid(UUID guid) {
        return itemRepository.findById(guid)
                .orElseThrow(() -> new RuntimeException("L'article avec guid" + guid + "n'existe pas"));
    }


}
