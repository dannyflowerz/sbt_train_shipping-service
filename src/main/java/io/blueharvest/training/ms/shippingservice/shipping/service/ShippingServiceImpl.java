package io.blueharvest.training.ms.shippingservice.shipping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
class ShippingServiceImpl implements ShippingService {

    private final InventoryServiceClient inventoryServiceClient;

    @Autowired
    public ShippingServiceImpl(InventoryServiceClient inventoryServiceClient) {
        this.inventoryServiceClient = inventoryServiceClient;
    }

    @Override
    public void requestShipping(String reservationCode) {
        log.info("Shipping request received for reservation code: {}", reservationCode);
    }

    @Override
    public void confirmShipping(String reservationCode) {
        inventoryServiceClient.dispense(reservationCode);
    }

}
