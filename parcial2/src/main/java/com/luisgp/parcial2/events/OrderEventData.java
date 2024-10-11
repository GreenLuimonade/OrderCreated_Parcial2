package com.luisgp.parcial2.events;

import lombok.Data;
import java.util.List;
import com.luisgp.parcial2.request.ProductRequest;

@Data
public class OrderEventData {
    private Integer orderId;
    private Integer customerId;
    private List<ProductRequest> productList;
    private Double totalAmount;

    public OrderEventData(Integer orderId, Integer customerId, List<ProductRequest> productList, Double totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productList = productList;
        this.totalAmount = totalAmount;
    }
}
