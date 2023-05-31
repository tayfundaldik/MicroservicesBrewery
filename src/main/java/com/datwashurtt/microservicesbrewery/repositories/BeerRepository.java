package com.datwashurtt.microservicesbrewery.repositories;

import com.datwashurtt.microservicesbrewery.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
