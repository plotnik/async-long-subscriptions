package com.example.subscriptionservice.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SubscriptionService {
    private static final boolean USE_LOCKING = true; // Toggle locking behavior
    private final Object lock = new Object();
    private boolean isProcessing = false;

    public void subscribePlan(int nMonths) {
        if (USE_LOCKING) {
            synchronized (lock) {
                processSubscribe(nMonths);
            }
        } else {
            processSubscribe(nMonths);
        }
    }

    public void unsubscribePlan(int nMonths) {
        if (USE_LOCKING) {
            synchronized (lock) {
                processUnsubscribe(nMonths);
            }
        } else {
            processUnsubscribe(nMonths);
        }
    }

    private void processSubscribe(int nMonths) {
        if (USE_LOCKING) {
            while (isProcessing) {
                try {
                    log.info("Waiting for previous operation to complete...");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Subscription interrupted", e);
                }
            }
        }
        
        try {
            isProcessing = true;
            log.info("Subscribe for {} months", nMonths);
            Thread.sleep(nMonths * 1000L); // Simulate processing time
            log.info("Subscribe for {} months -- Done", nMonths);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Subscription interrupted", e);
        } finally {
            isProcessing = false;
            if (USE_LOCKING) {
                lock.notifyAll();
            }
        }
    }

    private void processUnsubscribe(int nMonths) {
        if (USE_LOCKING) {
            while (isProcessing) {
                try {
                    log.info("Waiting for previous operation to complete...");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Unsubscription interrupted", e);
                }
            }
        }
        
        try {
            isProcessing = true;
            log.info("Unsubscribe for {} months", nMonths);
            Thread.sleep(nMonths * 1000L); // Simulate processing time
            log.info("Unsubscribe for {} months -- Done", nMonths);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Unsubscription interrupted", e);
        } finally {
            isProcessing = false;
            if (USE_LOCKING) {
                lock.notifyAll();
            }
        }
    }
}