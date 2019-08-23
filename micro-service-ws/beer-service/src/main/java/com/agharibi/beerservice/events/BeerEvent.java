package com.agharibi.beerservice.events;

import com.agharibi.beerservice.web.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
//@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = -8116783419776981931L;

    private final BeerDto beerDto;

    public BeerEvent(BeerDto beerDto) {
        this.beerDto = beerDto;
    }
}
