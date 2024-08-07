package io.github.Ital023.dscommerce.services;

import io.github.Ital023.dscommerce.dto.OrderDTO;
import io.github.Ital023.dscommerce.dto.ProductDTO;
import io.github.Ital023.dscommerce.entities.Order;
import io.github.Ital023.dscommerce.entities.Product;
import io.github.Ital023.dscommerce.repositories.OrderRepository;
import io.github.Ital023.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

        return new OrderDTO(order);
    }

}