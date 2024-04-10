package com.royalaviation.OrderM.controller;


import com.royalaviation.OrderM.entity.Customer;
import com.royalaviation.OrderM.entity.Item;
import com.royalaviation.OrderM.service.CustomerService;
import com.royalaviation.OrderM.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("items")
    public List<Item> getAllItem(){
        return itemService.readItems();
    }

    @PostMapping("items")
    public String postMethodName(@RequestBody Item item){
        return itemService.createItem(item);
    }

    @DeleteMapping("items/{id}")
    public String deleteItem(@PathVariable Long id) {
        if (itemService.deleteItem(id))
            return "Deleted Successfully";
        return "Not found";
    }

    @PutMapping("items/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id,item );
    }
}
