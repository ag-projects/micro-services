package com.agharibi.beerservice.web.mappers;

import com.agharibi.beerservice.domain.Beer;
import com.agharibi.beerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto dto);
}
