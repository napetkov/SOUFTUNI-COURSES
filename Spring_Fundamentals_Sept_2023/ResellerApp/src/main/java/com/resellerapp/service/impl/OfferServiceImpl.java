package com.resellerapp.service.impl;

import com.resellerapp.model.BoughtOffersDTO;
import com.resellerapp.model.MyOffersDTO;
import com.resellerapp.model.OfferHomeDTO;
import com.resellerapp.model.OtherOffersDTO;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.service.LoggedUser;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final LoggedUser loggedUser;

    public OfferServiceImpl(OfferRepository offerRepository, LoggedUser loggedUser) {
        this.offerRepository = offerRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public OfferHomeDTO getOffersForHomePage() {
        List<Offer> offers = offerRepository.findAll();
        List<MyOffersDTO> myOffers = new ArrayList<>();
        List<BoughtOffersDTO> boughtOffers = new ArrayList<>();
        List<OtherOffersDTO> allOtherOffer = new ArrayList<>();


        for (Offer offer : offers) {
            String loggedUsername = loggedUser.getUsername();

            if(offer.getCreatedBy().getUsername().equals(loggedUsername)){
                myOffers.add(new MyOffersDTO(offer));
            }else if(offer.getBoughtBy().getUsername().equals(loggedUsername)){
                boughtOffers.add(new BoughtOffersDTO(offer));
            }else{
                allOtherOffer.add(new OtherOffersDTO(offer));
            }
        }


        return new OfferHomeDTO(myOffers,boughtOffers,allOtherOffer);
    }
}
