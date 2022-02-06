package com.techeer.svproject.domain.products.service;

import com.sun.istack.NotNull;
import com.techeer.svproject.domain.order.entity.Order;
import com.techeer.svproject.domain.order.repository.OrderRepository;
import com.techeer.svproject.domain.products.dto.ProductSaveDto;
import com.techeer.svproject.domain.products.entity.Product;
import com.techeer.svproject.domain.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
//    private final EntityManager em;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public Product save(ProductSaveDto productSaveDto){
        Product product = productSaveDto.toEntity();
        Order order = orderRepository.findById(productSaveDto.getOrderId()).get();
        product.setOrder(order);
        return productRepository.save(product);
    }

    /*
    public List<Product> findItems(){
        return em.createQuery("select i from Item i", Product.class).getResultList();
    }

    public Product findOne(Long productId){
        return findOne(productId);
        return em.find(Product.class, productId);
    }
    */
}
