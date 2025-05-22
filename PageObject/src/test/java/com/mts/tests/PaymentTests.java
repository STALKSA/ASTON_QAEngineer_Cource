package com.mts.tests;


import org.testng.annotations.Test;
public class PaymentTests extends BaseTest {

    @Test(priority = 1)
    public void verifyPaymentBlockElements() {
        paymentPage.verifyPageTitle();
        paymentPage.verifyPaymentLogos();
    }


    @Test(priority = 2)
    public void testMobilePayment() {
        paymentPage.fillMobilePaymentForm("297777777", "10");
        paymentPage.submitPaymentForm();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        paymentPage.verifyPaymentModal("10.00 BYN", "3752977777777");
    }

    @Test(priority = 3)
    public void testDetailsLink() {
        paymentPage.openDetailsPage();
    }

    @Test(priority = 4)
    public void verifyServiceOptions() {
        paymentPage.verifyServiceOptions();
    }
}