package com.service.itemservice.controller;

import com.service.itemservice.domain.Item;
import com.service.itemservice.enums.ItemName;
import com.service.itemservice.service.ItemService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    final ItemService itemService;
    private static final String ITEM_SERVICE ="itemService" ;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PutMapping("/addStock")
    @RateLimiter(name = ITEM_SERVICE,fallbackMethod ="rateLimiterFallback" )
    public Item addStock(@RequestParam ItemName itemName,@RequestParam int stock){
        return itemService.addStock(itemName, stock);
    }

    @PostMapping("")
    @RateLimiter(name = ITEM_SERVICE,fallbackMethod ="rateLimiterFallback" )
    public String toOrder(@RequestParam ItemName itemName){
        return itemService.toOrder(itemName);
    }

    @GetMapping("/list")
    @RateLimiter(name=ITEM_SERVICE, fallbackMethod = "rateLimiterFallback")
    public ResponseEntity<List<Item>> getItems(){
        //return itemService.getItems();
        return new ResponseEntity<List<Item>>(itemService.getItems(), HttpStatus.OK);

    }
    public ResponseEntity<String> rateLimiterFallback(Exception e){
        return new ResponseEntity<String>(" Please Wait!!! Item Stocks are updating... ", HttpStatus.TOO_MANY_REQUESTS);
    }
}
