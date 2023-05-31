package com.datwashurtt.microservicesbrewery.bootstrap;


import com.datwashurtt.microservicesbrewery.domain.Beer;
import com.datwashurtt.microservicesbrewery.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class BeerLoader implements CommandLineRunner {
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                    .beerName("Stix Soos")
                    .beerStyle("IPA")
                    .quantitiyToBrew(300)
                    .minOnHand(15)
                    .upc(44601003323L)
                    .price(new BigDecimal("6.99"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Taz'dingo")
                    .beerStyle("PALE_ALE")
                    .quantitiyToBrew(300)
                    .minOnHand(15)
                    .upc(44601003324L)
                    .price(new BigDecimal("8.99"))
                    .build());
        }
    }
}
