package com.agharibi.beerservice.services;

import com.agharibi.beerservice.web.model.BeerDto;
import com.agharibi.beerservice.web.model.BeerPageList;
import com.agharibi.beerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {

    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPageList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);
}
