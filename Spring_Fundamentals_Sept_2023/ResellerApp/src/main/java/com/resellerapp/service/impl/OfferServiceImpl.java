package com.resellerapp.service.impl;

import com.resellerapp.model.BoughtOffersDTO;
import com.resellerapp.model.MyOffersDTO;
import com.resellerapp.model.OfferHomeDTO;
import com.resellerapp.model.OtherOffersDTO;
import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.LoggedUser;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ConditionRepository conditionRepository;
    private final LoggedUser loggedUser;

    public OfferServiceImpl(OfferRepository offerRepository, UserRepository userRepository, ConditionRepository conditionRepository, LoggedUser loggedUser) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.conditionRepository = conditionRepository;
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

            if (offer.getBoughtBy() == null && offer.getCreatedBy().getUsername().equals(loggedUsername)) {
                myOffers.add(new MyOffersDTO(offer));
            } else if (offer.getBoughtBy() != null && offer.getBoughtBy().getUsername().equals(loggedUsername)) {
                boughtOffers.add(new BoughtOffersDTO(offer));
            } else if (offer.getBoughtBy() == null) {
                allOtherOffer.add(new OtherOffersDTO(offer));
            }
        }


        return new OfferHomeDTO(myOffers, boughtOffers, allOtherOffer);
    }

    @Override
    public boolean createOffer(MyOffersDTO myOffersDTO) {
        Condition condition = conditionRepository.findByName(myOffersDTO.getCondition());
        User user = userRepository.findByUsername(loggedUser.getUsername());

        if (condition != null && user != null) {
            Offer offer = new Offer(myOffersDTO, condition, user);
            offerRepository.save(offer);
            return true;
        }
        return false;
    }

    @Override
    public void buy(UUID id) {
        Optional<Offer> offerToBuy = offerRepository.findById(id);

        if (offerToBuy.isPresent()) {

            User user = userRepository.findByUsername(loggedUser.getUsername());
            Offer offer = offerToBuy
                    .get()
                    .setBoughtBy(user);

            offerRepository.save(offer);
        }
    }

    @Override
    public void remove(UUID id) {
        Optional<Offer> offerToRemove = offerRepository.findById(id);

        if (offerToRemove.isPresent()) {
            Offer offer = offerToRemove.get();

            offerRepository.delete(offer);
        }
    }
}
