package com.resellerapp.service;

import com.resellerapp.model.MyOffersDTO;
import com.resellerapp.model.OfferHomeDTO;

import java.util.UUID;

public interface OfferService {

    OfferHomeDTO getOffersForHomePage();


    boolean createOffer(MyOffersDTO myOffersDTO);

    void buy(UUID id);

    void remove(UUID id);
}
