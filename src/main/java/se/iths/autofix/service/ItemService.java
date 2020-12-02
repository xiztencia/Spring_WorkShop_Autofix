package se.iths.autofix.service;

import org.springframework.stereotype.Service;
import se.iths.autofix.entity.Item;
import se.iths.autofix.repository.ItemRepository;

import java.util.Optional;

@Service
public class ItemService {


    private ItemRepository itemRepository;
    private UserService userService;


    public ItemService(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    public Item createItem(Item item) {
        item.setUser(userService.getAuthenticatedUser());
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        Optional<Item> foundItem = itemRepository.findById(id);
        itemRepository.deleteById(foundItem.get().getId());
    }

    public Optional<Item> findItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Iterable<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Iterable<Item> findItemsByUserId(Long id) {
        return itemRepository.findItemsByUserId(id);
    }

    public Iterable<Item> findAllByUser() {
        Iterable<Item> allItemsByUser = itemRepository.findAllByUser();
        return allItemsByUser;
    }

}