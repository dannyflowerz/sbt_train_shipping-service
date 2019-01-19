package io.blueharvest.training.ms.shippingservice.shipping.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.blueharvest.training.ms.shippingservice.shipping.domain.exception.ShippingException;

@FeignClient(value = "inventory-service", fallback = InventoryServiceClient.ProductDispensationFallback.class)
public interface InventoryServiceClient {

    @Component
    class ProductDispensationFallback implements InventoryServiceClient {

        @Override
        public void dispense(String reservationCode) {
            // needs exception handler to extract this message into the response
            throw new ShippingException("Dispensation of the product with reservation code " + reservationCode +
                    " is currently not possible. Please try again later.");
        }

    }

    @DeleteMapping("/products/reservations/{reservation-code}")
    void dispense(@PathVariable("reservation-code") String reservationCode);

}
