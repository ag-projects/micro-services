package com.agharibi.beerservice.events;

import com.agharibi.beerservice.web.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
//@RequiredArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = -8116783419776981931L;

    private  BeerDto beerDto;

    public BeerEvent(BeerDto beerDto) {
        this.beerDto = beerDto;
    }
}
