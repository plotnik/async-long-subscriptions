package com.example.subscriptionservice.controller;

import com.example.subscriptionservice.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscribe/{months}")
    public ResponseEntity<String> subscribePlan(@PathVariable int months) {
        subscriptionService.subscribePlan(months);
        return ResponseEntity.ok("Subscribed for " + months + " months");
    }

    @PostMapping("/unsubscribe/{months}")
    public ResponseEntity<String> unsubscribePlan(@PathVariable int months) {
        subscriptionService.unsubscribePlan(months);
        return ResponseEntity.ok("Unsubscribed from " + months + " months plan");
    }
} 