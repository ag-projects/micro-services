package com.agharibi.brewery.web.mappers;

import com.agharibi.brewery.domain.Beer;
import com.agharibi.brewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeeDto(Beer beer);
    Beer beerDtoTOBeer(BeerDto dto);
}
