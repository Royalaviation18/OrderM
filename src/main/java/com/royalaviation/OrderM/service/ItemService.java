package com.royalaviation.OrderM.service;

import com.royalaviation.OrderM.entity.Customer;
import com.royalaviation.OrderM.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    String createItem(Item item);

    List<Item> readItems();

    boolean deleteItem(Long id);

    String updateItem(Long id, Item item);
}
