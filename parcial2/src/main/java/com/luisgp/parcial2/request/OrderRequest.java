package com.luisgp.parcial2.request;

import java.util.List;
import lombok.Data;

@Data
public class OrderRequest {
    private int customerId;
    private List<ProductRequest> productList;
}
