package com.joaobertholino.springsecuritydemo.mapper;

import com.joaobertholino.springsecuritydemo.mapper.dto.ProductDto;
import com.joaobertholino.springsecuritydemo.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
	ProductDto entityToResponse(Product entity);

	@Mapping(target = "id", ignore = true)
	Product RequestToEntity(ProductDto request);
}
