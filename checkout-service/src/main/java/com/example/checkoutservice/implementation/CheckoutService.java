package com.example.checkoutservice.implementation;

import com.example.checkoutservice.model.Checkout;
import com.example.checkoutservice.model.dto.Product;
import com.example.checkoutservice.service.ICheckoutService;
import com.example.checkoutservice.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService implements ICheckoutService {
    private IProductService productService;

    public CheckoutService(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public Checkout buildCheckout(List<String> productsIds) {
        Double total = 0.0;
        for(String id : productsIds) {
            Product product = productService.getProduct(id);
            total += product.getPrice();
        }
        Checkout checkout = new Checkout("234", "www.example.com", total.toString(), List.of("credit_card"));

        return checkout;
    }
}
