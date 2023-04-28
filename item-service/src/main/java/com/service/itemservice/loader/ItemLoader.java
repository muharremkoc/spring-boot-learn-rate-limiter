package com.service.itemservice.loader;

import com.service.itemservice.domain.Item;
import com.service.itemservice.enums.ItemName;
import com.service.itemservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ItemLoader implements ApplicationRunner {



    @Autowired
    ItemRepository itemRepository;

    @Override
    public void run(ApplicationArguments args){


        if (itemRepository.count() == 0) {

            itemRepository.save(new Item(ItemName.COMPUTER,100));
            itemRepository.save(new Item(ItemName.PHONE,100));
            itemRepository.save(new Item(ItemName.WATCH,100));
            itemRepository.save(new Item(ItemName.EARPHONE,100));
            itemRepository.save(new Item(ItemName.MOUSE,100));
            itemRepository.save(new Item(ItemName.KEYBOARD,100));

        }


    }
}
