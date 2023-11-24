package com.example.springdataforum.conf;


import com.example.springdataforum.Constans.CategoryOfVehicles;
import com.example.springdataforum.Constans.TypesOFTransmission;
import com.example.springdataforum.Constans.TypesOfGas;
import com.example.springdataforum.Constans.TypesOfRoles;
import com.example.springdataforum.dto.*;
import com.example.springdataforum.services.impl.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRolesService roleService;
    private final BrandsService brandService;
    private final ModelsService modelService;
    private final UsersService usersService;
    private final OffersService offerService;

    public DataInitializer(UserRolesService roleService, BrandsService brandService, ModelsService modelService, UsersService usersService, OffersService offerService) {
        this.roleService = roleService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.usersService = usersService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() {
        System.out.println("Start test: \n");
        UserRolesDto role1 = new UserRolesDto(UUID.randomUUID(), TypesOfRoles.USER);
        UserRolesDto role2 = new UserRolesDto(UUID.randomUUID(), TypesOfRoles.ADMIN);
        role1 = roleService.register(role1);
        role2 = roleService.register(role2);

        var role3 = new UserRolesDto(UUID.randomUUID(), TypesOfRoles.ADMIN);
        roleService.addUserRolesWithValidation(role3);

        System.out.println(role1);
        System.out.println(role2);

        var date = LocalDateTime.now();

        BrandsDto brand1 = new BrandsDto(UUID.randomUUID(), "Lada", date, date);
        BrandsDto brand2 = new BrandsDto(UUID.randomUUID(), "Moscwich", date, date);

        var brandWithValidationTest = new BrandsDto(UUID.randomUUID(), "I'm test", date, date);
        brandService.addBrandWithValidation(brandWithValidationTest);

        System.out.println(brand1.getId().equals(brand2.getId()));
        brand1 = brandService.register(brand1);
        brand2 = brandService.register(brand2);
        System.out.println(brand1);
        System.out.println(brand2);


        ModelsDto model1 = new ModelsDto(UUID.randomUUID(), "Niva", CategoryOfVehicles.Car, "http://qwqwqwqw",
                1999, 2023, date, date, brand1);
        ModelsDto model2 = new ModelsDto(UUID.randomUUID(), "23", CategoryOfVehicles.Car, "http://kjkjkjkjk",
                2022, 2023, date, date, brand2);
        model1 = modelService.register(model1);
        model2 = modelService.register(model2);

        var model3 = new ModelsDto(UUID.randomUUID(), "Test", CategoryOfVehicles.Car, "http://kjkjkjkjk",
                2022, 2023, date, date, brand2);
        modelService.addModelWithValidation(model3);


        System.out.println(model1);
        System.out.println(model2);

        UsersDto user1 = new UsersDto(UUID.randomUUID(), role1, "Kisa17", "555555", "Zlata",
                "Kikimora", true, "http://jjejfbejbf", date, date);
        UsersDto user2 = new UsersDto(UUID.randomUUID(), role2, "Gora", "6666666", "Morgan",
                "Freeman", true, "http://bebfebufbe", date, date);
        user1 = usersService.register(user1);
        user2 = usersService.register(user2);


        var user3 = new UsersDto(UUID.randomUUID(), role1, "Kisa17", "555555", "Zlata",
                "Test", true, "http://jjejfbejbf", date, date);
        usersService.addUserWithValidation(user3);


        System.out.println(user1);
        System.out.println(user2);

        var price1 = 100_000;
        var price2 = 3_000_000;

        OffersDto offer1 = new OffersDto(UUID.randomUUID(), "Top in 1999", TypesOfGas.ELECTRIC,
                "http://ya.ru", 20, price1, TypesOFTransmission.AUTOMATIC, 2022, date, date, model1, user2);
        OffersDto offer2 = new OffersDto(UUID.randomUUID(), "Too much", TypesOfGas.GASOLINE,
                "http://d", 2, price2, TypesOFTransmission.AUTOMATIC, 2022, date, date, model2, user2);
        offerService.register(offer1);
        offerService.register(offer2);

        var offer3 = new OffersDto(UUID.randomUUID(), "Test", TypesOfGas.ELECTRIC,
                "http://ya.ru", 20, price1, TypesOFTransmission.AUTOMATIC, 2022, date, date, model1, user2);

        offerService.addOfferWithValidation(offer3);


        System.out.println(offer1);
        System.out.println(offer2);
        // roleService.delete(1L);
        //usersService.delete(1L);
        //offerService.delete(1L);
        // brandService.delete(brand1.getId());

    }
}
