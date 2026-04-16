package com.antonintacchi.cards.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private int cardId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "total_limit")
    private int totalLimit;

    @Column(name = "amount_used")
    private int amountUsed;

    @Column(name = "available_amount")
    private int availableAmount;

    @Column(name = "create_dt")
    private Date createDt;

    public int getCardId() { return cardId; }
    public int getCustomerId() { return customerId; }
    public String getCardNumber() { return cardNumber; }
    public String getCardType() { return cardType; }
    public int getTotalLimit() { return totalLimit; }
    public int getAmountUsed() { return amountUsed; }
    public int getAvailableAmount() { return availableAmount; }
    public Date getCreateDt() { return createDt; }

    public void setCardId(int cardId) { this.cardId = cardId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public void setCardType(String cardType) { this.cardType = cardType; }
    public void setTotalLimit(int totalLimit) { this.totalLimit = totalLimit; }
    public void setAmountUsed(int amountUsed) { this.amountUsed = amountUsed; }
    public void setAvailableAmount(int availableAmount) { this.availableAmount = availableAmount; }
    public void setCreateDt(Date createDt) { this.createDt = createDt; }

}