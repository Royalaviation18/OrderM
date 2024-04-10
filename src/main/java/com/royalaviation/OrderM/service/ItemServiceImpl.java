package com.royalaviation.OrderM.service;

import com.royalaviation.OrderM.entity.Customer;
import com.royalaviation.OrderM.entity.CustomerEntity;
import com.royalaviation.OrderM.entity.Item;
import com.royalaviation.OrderM.entity.ItemEntity;
import com.royalaviation.OrderM.repository.CustomerRepository;
import com.royalaviation.OrderM.repository.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;
    @Override
    public String createItem(Item item) {
        ItemEntity itemEntity = new ItemEntity();
        // from to
        BeanUtils.copyProperties(item,itemEntity);
        itemRepository.save(itemEntity);
        // orders.add(order);
        return "Saved Successfully";
    }

    @Override
    public List<Item> readItems() {
        List<ItemEntity> itemsList = itemRepository.findAll();
        List<Item> items = new ArrayList<>();
        for (ItemEntity itemEntity : itemsList) {
            Item item = new Item();
            item.setId(itemEntity.getId());
            item.setItemName(itemEntity.getItemName());
            items.add(item);
        }
        return items;
    }

    @Override
    public boolean deleteItem(Long id) {
        ItemEntity itm = itemRepository.findById(id).get();
        itemRepository.delete(itm);
        return true;
    }

    @Override
    public String updateItem(Long id, Item item) {
        ItemEntity existingItem = itemRepository.findById(id).get();
        existingItem.setItemName(item.getItemName());
        itemRepository.save(existingItem);
        return "Update Successfully";
    }
}
