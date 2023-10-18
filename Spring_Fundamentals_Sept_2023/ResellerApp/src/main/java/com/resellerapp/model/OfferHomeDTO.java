package com.resellerapp.model;

import java.util.List;

public class OfferHomeDTO {

    private List<MyOffersDTO> myOffers;
    private List<BoughtOffersDTO> boughtOffers;

    private List<OtherOffersDTO> allOtherOffers;

    private int totalOffers;

    public OfferHomeDTO(List<MyOffersDTO> myOffers, List<BoughtOffersDTO> boughtOffers, List<OtherOffersDTO> allOtherOffers) {
        this.myOffers = myOffers;
        this.boughtOffers = boughtOffers;
        this.allOtherOffers = allOtherOffers;
        this.totalOffers = allOtherOffers.size();
    }

    public List<MyOffersDTO> getMyOffers() {
        return myOffers;
    }

    public OfferHomeDTO setMyOffers(List<MyOffersDTO> myOffers) {
        this.myOffers = myOffers;
        return this;
    }

    public List<BoughtOffersDTO> getBoughtOffers() {
        return boughtOffers;
    }

    public OfferHomeDTO setBoughtOffers(List<BoughtOffersDTO> boughtOffers) {
        this.boughtOffers = boughtOffers;
        return this;
    }

    public List<OtherOffersDTO> getAllOtherOffers() {
        return allOtherOffers;
    }

    public OfferHomeDTO setAllOtherOffers(List<OtherOffersDTO> allOtherOffers) {
        this.allOtherOffers = allOtherOffers;
        return this;
    }

    public int getTotalOffers() {
        return totalOffers;
    }

    public OfferHomeDTO setTotalOffers(int totalOffers) {
        this.totalOffers = totalOffers;
        return this;
    }
}
