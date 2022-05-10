package fr.univrouen.rss22project.controllers;

import fr.univrouen.rss22project.dtos.ItemDto;
import fr.univrouen.rss22project.entities.Item;
import fr.univrouen.rss22project.entities.Items;
import fr.univrouen.rss22project.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rss22")
@AllArgsConstructor
public class ItemController {

    ItemService itemService;

    @GetMapping(value = "/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Items> getListOfItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping(value = "/resume/xml/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Item> getItemByGuid(@PathVariable("guid") UUID guid) {
        return ResponseEntity.ok(itemService.getItemById(guid));
    }

    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.createItem(item));
    }

    @DeleteMapping(value = "/delete/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Item> deleteItem(@PathVariable UUID guid) {
        return ResponseEntity.ok(itemService.deleteItem(guid));
    }

    @GetMapping(value = "/resume/html", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<ItemDto>> findItemList() {
        return ResponseEntity.ok(itemService.findItemList());
    }

    @GetMapping(value = "/resume/html/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Item> findItemByGuid(@PathVariable("guid") UUID guid) {
        return ResponseEntity.ok(itemService.findItemByGuid(guid));
    }

}
