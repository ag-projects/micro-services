package com.agharibi.beerservice.bootstrap;

import com.agharibi.beerservice.domain.Beer;
import com.agharibi.beerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "06855411112";
    public static final String BEER_2_UPC = "06321111145";
    public static final String BEER_3_UPC = "06788541129";

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(BEER_1_UPC)
                    .minOnHand(12)
                    .price(new BigDecimal("12.99"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .upc(BEER_2_UPC)
                    .minOnHand(12)
                    .price(new BigDecimal("10.99"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Maya ALE")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(300)
                    .upc(BEER_3_UPC)
                    .minOnHand(16)
                    .price(new BigDecimal("8.99"))
                    .build());
        }
    }
}
