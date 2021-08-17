package com.learnjava.service;

import com.learnjava.domain.checkout.CheckoutResponse;
import com.learnjava.domain.checkout.CheckoutStatus;
import com.learnjava.util.CommonUtil;
import com.learnjava.util.DataSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutServiceTest {

    CheckoutService checkoutService;

    PriceValidatorService priceValidatorService;

    @BeforeEach
    void setUp() {
        checkoutService = new CheckoutService(new PriceValidatorService());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkOut() {
        CommonUtil.startTimer();
        CheckoutResponse checkoutResponse = checkoutService.checkOut(DataSet.createCart(6));
        assertEquals(CheckoutStatus.SUCCESS,checkoutResponse.getCheckoutStatus());
        CheckoutResponse checkoutResponse2 = checkoutService.checkOut(DataSet.createCart(11));
        assertEquals(CheckoutStatus.FAILURE,checkoutResponse2.getCheckoutStatus());
        CommonUtil.timeTaken();
    }
}