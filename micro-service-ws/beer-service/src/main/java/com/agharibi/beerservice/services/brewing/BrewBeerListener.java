package com.agharibi.beerservice.services.brewing;


import com.agharibi.beerservice.config.JmsConfig;
import com.agharibi.beerservice.domain.Beer;
import com.agharibi.beerservice.events.BrewBeerEvent;
import com.agharibi.beerservice.events.NewInventoryEvent;
import com.agharibi.beerservice.repositories.BeerRepository;
import com.agharibi.beerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.agharibi.beerservice.config.JmsConfig.NEW_INVENTORY_QUEUE;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event) {

        BeerDto beerDto = event.getBeerDto();
        Beer beer = beerRepository.getOne(beerDto.getId());
        beerDto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent inventoryEvent = new NewInventoryEvent(beerDto);
        log.debug("Brewed beer -> " + beer.getMinOnHand() + " : QOH: " + beerDto.getQuantityOnHand());
        jmsTemplate.convertAndSend(NEW_INVENTORY_QUEUE, inventoryEvent);
    }
}
