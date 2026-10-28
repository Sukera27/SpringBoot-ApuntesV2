package com.vedrunasevilla.tienda.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vedrunasevilla.tienda.exception.BadRequestException;
import com.vedrunasevilla.tienda.exception.NotFoundException;
import com.vedrunasevilla.tienda.persistance.model.Account;
import com.vedrunasevilla.tienda.persistance.model.Order;
import com.vedrunasevilla.tienda.persistance.model.OrderItem;
import com.vedrunasevilla.tienda.persistance.model.Product;
import com.vedrunasevilla.tienda.persistance.model.enumlist.OrderStatus;
import com.vedrunasevilla.tienda.persistance.repository.AccountRepository;
import com.vedrunasevilla.tienda.persistance.repository.OrderItemRepository;
import com.vedrunasevilla.tienda.persistance.repository.OrderRepository;
import com.vedrunasevilla.tienda.persistance.repository.ProductRepository;
import com.vedrunasevilla.tienda.service.OrderService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;

    AccountRepository accountRepository;

    OrderItemRepository orderItemRepository;

    ProductRepository productRepository;

    @Override
    public List<Order> getAllOrders() {
      return orderRepository.findAll();
    }

    @Override
    @Transactional 
    public Order placeOrder(Long accountId, List<OrderItem> orderItems) {
      // 1. Validaciones: un pedido necesita al menos una línea
      if (orderItems == null || orderItems.isEmpty()) {
        throw new BadRequestException("El pedido necesita al menos una línea");
      }
      Account account = accountRepository.findById(accountId)
          .orElseThrow(() -> new NotFoundException("Cuenta " + accountId + " no encontrada"));

      // 2. Se crea el pedido
      Order order = new Order();
      order.setAccount(account);
      order.setOrderDate(LocalDate.now());
      order.setStatus(OrderStatus.PENDING);
      orderRepository.save(order);

      // 3. Se crean las líneas
      for (OrderItem oi : orderItems){
        if (oi.getProduct() == null || oi.getProduct().getProductId() == null
            || oi.getQuantity() == null || oi.getQuantity() <= 0) {
          throw new BadRequestException("Línea no válida: falta el producto o la cantidad es menor que 1");
        }
        Long productId = oi.getProduct().getProductId();
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new NotFoundException("Producto " + productId + " no encontrado"));
        oi.setOrderItemId(null);                       // siempre se crea una línea nueva
        oi.setOrder(order);
        oi.setProduct(product);                        // el producto real de la base de datos
        oi.setUnitPrice(product.getProductPrice());    // precio congelado en el momento de la compra
        orderItemRepository.save(oi);
      }
      return order;
    }

    @Override
    public List<OrderItem> getOrderItems(Long orderId) {
      // Pedido que no existe -> 404. Pedido sin líneas -> lista vacía.
      if (!orderRepository.existsById(orderId)) {
        throw new NotFoundException("Pedido " + orderId + " no encontrado");
      }
      return orderItemRepository.findByOrderId(orderId);
    }

    @Override
    public Order getOrder(Long id) {
      return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido " + id + " no encontrado"));
    }

    @Override
    @Transactional 
    public Order changeStatus(Long id, OrderStatus newStatus) {
      Order order = orderRepository.findById(id).orElseThrow(()-> new NotFoundException("No se ha encontrado ese id en la base de datos"));
      if(!order.getStatus().canChangeTo(newStatus)){
          throw new BadRequestException("No se puede pasar de " + order.getStatus() + " a " + newStatus);
      }
      order.setStatus(newStatus);
      return orderRepository.save(order);
    }
}
