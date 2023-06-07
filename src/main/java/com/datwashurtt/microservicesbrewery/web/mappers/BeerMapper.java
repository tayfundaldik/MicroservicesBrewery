package com.datwashurtt.microservicesbrewery.web.mappers;

import com.datwashurtt.microservicesbrewery.domain.Beer;
import com.datwashurtt.microservicesbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    BeerDto BeertoBeerDTO(Beer beer);
    Beer BeerDtotoBeer(BeerDto dto);
}
