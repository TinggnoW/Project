package com.fsse2401.Project.api;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stripe.model.checkout.Session;


@RestController
public class CheckoutApi {

    @PostMapping("/public/checkout")
    public String checkout()throws StripeException {
        String YOUR_DOMAIN = "http://localhost:5173";
        Stripe.apiKey = "sk_test_51PBpcYJwThzrIk7CTfp92ddKculp0Lxif8kXHcboWTOCuvXrU856QXjX0kNWPLf6iZfbUQpVloAxQM6iENhxPxu000WisXy8ZV";
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(YOUR_DOMAIN + "/thankyou")
                        .setCancelUrl(YOUR_DOMAIN + "/error")
                        .addLineItem(
                                SessionCreateParams.LineItem.builder()
                                        .setQuantity(1L)
                                        // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
                                        .setPrice("price_1PBqgAJwThzrIk7Ct8i9gvBb")
                                        .build())
                        .build();
        Session session = Session.create(params);
        System.out.println(session.getId());
        System.out.println(session.getUrl());
        return session.getUrl();
    }
}
