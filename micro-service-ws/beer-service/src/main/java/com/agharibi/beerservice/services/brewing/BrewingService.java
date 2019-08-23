package com.agharibi.beerservice.services.brewing;


import com.agharibi.beerservice.domain.Beer;
import com.agharibi.beerservice.events.BrewBeerEvent;
import com.agharibi.beerservice.repositories.BeerRepository;
import com.agharibi.beerservice.services.inventory.BeerInventoryService;
import com.agharibi.beerservice.web.mappers.BeerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.agharibi.beerservice.config.JmsConfig.BREWING_REQUEST_QUEUE;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000)
    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer inventoryqty = beerInventoryService.getOnhandInventory(beer.getId());
            log.debug("Min on hand is -> " + beer.getMinOnHand());
            log.debug("Inventory is -> " + inventoryqty);

            if (beer.getMinOnHand() >= inventoryqty) {
                jmsTemplate.convertAndSend(BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }
}
