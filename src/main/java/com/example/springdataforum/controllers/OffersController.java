package com.example.springdataforum.controllers;

import com.example.springdataforum.dto.AddOfferDto;
import com.example.springdataforum.dto.ShowDetailedOffersInfoDto;
import com.example.springdataforum.dto.ShowOffersInfoDto;
import com.example.springdataforum.services.impl.ModelsService;
import com.example.springdataforum.services.impl.OffersService;
import com.example.springdataforum.services.impl.UsersService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OffersService offersService;
    private final UsersService usersService;
    private final ModelsService modelService;
    private final ModelMapper modelMapper;

    @Autowired
    public OffersController(OffersService offersService, UsersService usersService, ModelsService modelService, ModelMapper modelMapper) {
        this.offersService = offersService;
        this.usersService = usersService;
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/add")
    public String showAddOfferForm(Model model) {
        model.addAttribute("addOfferDto", new AddOfferDto());
        model.addAttribute("allUsersX", usersService.getAll());
        model.addAttribute("allModelsX", modelService.getAll());
        return "addOffers";
    }

    @PostMapping("/add")
    public String addOffer(@ModelAttribute("addOfferDto") @Valid AddOfferDto addOfferDto, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("\n" + result);
            return "addOffers";
        }
        addOfferDto.setCreated(LocalDateTime.now());
        addOfferDto.setModified(LocalDateTime.now());
        offersService.addOffer(addOfferDto);
        return "redirect:/offers/all";
    }

    @GetMapping("/all")
    public String getAllOffers(Model model) {
        List<ShowOffersInfoDto> offers = offersService.getAllOffers();
        model.addAttribute("offers", offers);
        return "getAllOffers";
    }

    @GetMapping("/details/{offerId}")
    public String getOfferDetails(@PathVariable String offerId, Model model) {
        ShowDetailedOffersInfoDto offerDetails = offersService.offerDetails(offerId);
        model.addAttribute("offerDetails", offerDetails);
        return "getOfferDetails";
    }


    @GetMapping("/remove/{offerDescription}")
    public String deleteOffer(@PathVariable("offerDescription") String offerDescription) {
        offersService.removeOffer(offerDescription);
        return "redirect:/offers/all";
    }

}















//@RestController
//@RequestMapping("/offers")
//public class OffersController {
//    // add setter injection
//    private  OffersService offersService;
//
//    @Autowired
//    public void setOffersService(OffersService offersService) {
//        this.offersService = offersService;
//    }
//    @GetMapping()
//    Iterable<ShowDetailedOffersInfoDto> all() {
//        return offersService.getAll();
//    }
//    @GetMapping("/{id}")
//    ShowDetailedOffersInfoDto get(@PathVariable UUID id) {
//        return offersService.get(id).get();
//    }
//    @DeleteMapping("/{id}")
//    void deleteBrand(@PathVariable UUID id) {
//        offersService.delete(id);
//    }
//    @PostMapping()
//    ShowDetailedOffersInfoDto update(@RequestBody ShowDetailedOffersInfoDto showDetailedOffersInfoDto) {
//        return offersService.update(showDetailedOffersInfoDto);
//    }
//}
