package com.luisgp.parcial2.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luisgp.parcial2.entities.Customer;
import com.luisgp.parcial2.entities.Order;
import com.luisgp.parcial2.entities.Product;
import com.luisgp.parcial2.events.EventType;
import com.luisgp.parcial2.events.Kafka;
import com.luisgp.parcial2.events.OrderEvent;
import com.luisgp.parcial2.events.OrderEventData;
import com.luisgp.parcial2.repository.CustomerRepository;
import com.luisgp.parcial2.repository.OrderRepository;
import com.luisgp.parcial2.repository.ProductRepository;
import com.luisgp.parcial2.request.ProductRequest;


@Service
public class OrderService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final Kafka kafka;

    @Autowired
    public OrderService(CustomerRepository customerRepository, ProductRepository productRepository, 
                        OrderRepository orderRepository, Kafka kafka) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.kafka = kafka;
    }

    @Transactional
    public void createOrder(Integer customerId, List<ProductRequest> productList) {
        // Validar si el cliente existe
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if (customerOpt.isEmpty()) {
            throw new RuntimeException("Error, cliente no existe en la base de datos");
        }
        Customer customer = customerOpt.get();

        // Calcular el costo total de los productos
        double totalAmount = 0;
        for (ProductRequest productRequest : productList) {
            Product product = productRepository.findById(productRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Error, producto no existe en la base de datos"));

            totalAmount += product.getPrice() * productRequest.getProductAmount();
        }

        Order order = new Order();
        order.setCustomer(customer);
        orderRepository.save(order);//para guardar orders en la database (espero que sirva)

        //Lamento muchisimo no haber ido a la clase pasada, por eso saque la solucion mas pendeja del mundo porque no le supe a kafka
        OrderEventData orderData = new OrderEventData(order.getIdCompra(), customer.getId(), productList, totalAmount);
        OrderEvent orderEvent = new OrderEvent(new Date(),EventType.ORDER_CREATED,orderData);
        

        // Enviar el evento a Kafka
        kafka.sendOrderEvent(orderEvent);
    }
}