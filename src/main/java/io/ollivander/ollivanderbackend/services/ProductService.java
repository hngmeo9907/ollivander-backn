package io.ollivander.ollivanderbackend.services;

import io.ollivander.ollivanderbackend.common.BaseException;
import io.ollivander.ollivanderbackend.model.dto.BaseListRequest;
import io.ollivander.ollivanderbackend.model.entities.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(Integer productId) throws BaseException;

    Object getAllProducts(BaseListRequest request);

    List<Product> search(BaseListRequest request);

}
