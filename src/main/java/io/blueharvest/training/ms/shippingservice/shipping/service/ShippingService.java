package io.blueharvest.training.ms.shippingservice.shipping.service;

public interface ShippingService {

    void requestShipping(String reservationCode);

    void confirmShipping(String reservationCode);

}
