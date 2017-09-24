package models.entities;

import java.util.List;

public class Purchase {
    private Integer id;
    private Address deliveryAddress;
    private String status;
    private User user;
    private List<Product> productList;
    private Payment payment;
}
