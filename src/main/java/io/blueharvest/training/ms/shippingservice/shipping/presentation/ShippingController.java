package io.blueharvest.training.ms.shippingservice.shipping.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.blueharvest.training.ms.shippingservice.shipping.domain.model.ShippingConfirmation;
import io.blueharvest.training.ms.shippingservice.shipping.domain.model.ShippingRequest;
import io.blueharvest.training.ms.shippingservice.shipping.service.ShippingService;

@RestController
public class ShippingController {

    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @PostMapping(path = "/confirmations")
    public void receiveConfirmation(@RequestBody ShippingConfirmation shippingConfirmation) {
        shippingService.confirmShipping(shippingConfirmation.getReservationCode());
    }

    @PostMapping(path = "/requests")
    public void requestShipping(@RequestBody ShippingRequest shippingRequest) {
        shippingService.requestShipping(shippingRequest.getReservationCode());
    }

}
