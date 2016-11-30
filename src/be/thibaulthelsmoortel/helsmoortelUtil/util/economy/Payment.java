/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.economy;

import java.util.Date;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class representing a payment.
 */
public class Payment {
    public enum PaymentType {CASH, BANK_TRANSFER, PAYPAL, PAYZA}

    private PaymentType paymentType;
    private double amount;
    private Date date;

    /**
     * Constructor setting type and amount.
     * @param paymentType the PaymentType
     * @param amount the amount
     */
    public Payment(PaymentType paymentType, double amount) {
        this.paymentType = paymentType;
        this.amount = amount;
        this.date = new Date();
    }

    /**
     * Constructor setting type, amount and date.
     * @param paymentType the PaymentType
     * @param amount the amount
     * @param date the date
     */
    public Payment(PaymentType paymentType, double amount, Date date) {
        this.paymentType = paymentType;
        this.amount = amount;
        this.date = date;
    }

    /**
     * Returns the payment's type.
     * @return the PaymentType of the payment
     */
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     * Returns the amount of the payment.
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the date of the payment.
     * @return the date
     */
    public Date getDate() {
        return date;
    }
}
