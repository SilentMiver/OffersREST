package com.example.springdataforum.conf;


import com.example.springdataforum.Constans.CategoryOfVehicles;
import com.example.springdataforum.Constans.TypesOFTransmission;
import com.example.springdataforum.Constans.TypesOfGas;
import com.example.springdataforum.Constans.TypesOfRoles;
import com.example.springdataforum.dto.*;
import com.example.springdataforum.models.UserRole;
import com.example.springdataforum.models.Users;
import com.example.springdataforum.repositories.BrandsRepository;
import com.example.springdataforum.repositories.UserRoleRepository;
import com.example.springdataforum.repositories.UsersRepository;
import com.example.springdataforum.services.impl.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRolesService roleService;
    private final BrandsService brandService;
    private final ModelsService modelService;
    private final UsersService usersService;
    private final OffersService offerService;
    private final UserRolesService userRolesService;
    private final BrandsRepository brandsRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository roleRepository;
    private final String defaultPassword;
    private final UsersRepository usersRepository;

    public DataInitializer(UserRolesService roleService, BrandsService brandService, ModelsService modelService, UsersService usersService, OffersService offerService, UserRolesService userRolesService, BrandsRepository brandsRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository, @Value("password") String defaultPassword, UsersRepository usersRepository) {
        this.roleService = roleService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.usersService = usersService;
        this.offerService = offerService;
        this.userRolesService = userRolesService;
        this.brandsRepository = brandsRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = userRoleRepository;
        this.defaultPassword = defaultPassword;
        this.usersRepository = usersRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() {
        initRoles();
        initUsers();
        var date = new Date();
        AddUserRoleDto userRole1;
        AddUserRoleDto userRole2;
        userRole1 = new AddUserRoleDto();
        userRole2 = new AddUserRoleDto();
        userRole1.setRole(TypesOfRoles.USER);
        userRole2.setRole(TypesOfRoles.ADMIN);


        var user1 = new AddUsersDto();
        user1.setRoleId(roleService.getAll().get(0).getId().toString());
        user1.setUserName("User");
        user1.setPassword("123456");
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setImageURL("yandex.ru");
        user1.setCreated(date);
        user1.setModified(date);
        usersService.addUser(user1);
        var brand1 = new AddBrandDto();
        brand1.setName("Brand");
        brand1.setCreated(date);
        brand1.setModified(date);
        brandService.addBrand(brand1);
        var brand2 = new AddBrandDto();
        brand2.setName("Tesla");
        brand2.setCreated(date);
        brand2.setModified(date);
        brandService.addBrand(brand2);
        var model1 = new AddModelDto();
        model1.setBrandId(brandService.findByName(brand1.name).get().getId().toString());
        model1.setName("Model");
        model1.setCategory(CategoryOfVehicles.Car);
        model1.setStartYear(1800);
        model1.setEndYear(1800);
        model1.setCreated(date);
        model1.setModified(date);
        modelService.addModel(model1);
        var model2 = new AddModelDto();
        model2.setBrandId(brandService.findByName(brand2.name).get().getId().toString());
        model2.setName("Model Y");
        model2.setCategory(CategoryOfVehicles.Car);
        model2.setStartYear(1800);
        model2.setEndYear(1800);
        model2.setCreated(date);
        model2.setModified(date);
        modelService.addModel(model2);
        var model3 = new AddModelDto();
        model3.setBrandId(brandService.findByName(brand2.name).get().getId().toString());
        model3.setName("Model X");
        model3.setCategory(CategoryOfVehicles.Car);
        model3.setStartYear(1800);
        model3.setEndYear(1800);
        model3.setCreated(date);
        model3.setModified(date);
        modelService.addModel(model3);
        var model4 = new AddModelDto();
        model4.setBrandId(brandService.findByName(brand2.name).get().getId().toString());
        model4.setName("Model X");
        model4.setCategory(CategoryOfVehicles.Car);
        model4.setStartYear(1800);
        model4.setEndYear(1800);
        model4.setCreated(date);
        model4.setModified(date);
        modelService.addModel(model4);
        var offer1 = new AddOfferDto();
        offer1.setDescription("12345678910");
        offer1.setUserId(usersService.userDetails(usersRepository.findByUsername("user").get().getUsername()).getId().toString());
        offer1.setModelId(modelService.modelDetails(model1.getName()).getId().toString());
        offer1.setImageURL("https://th.bing.com/th/id/R.5a1b28d96b00ab3aef745893f991d65b?rik=RhijviGBJog01g&pid=ImgRaw&r=0");
        offer1.setMileage(100000);
        offer1.setPrice(100000);
        offer1.setTransmission(TypesOFTransmission.AUTOMATIC);
        offer1.setEngine(TypesOfGas.ELECTRIC);
        offer1.setYear("1900");
        offer1.setCreated(date);
        offer1.setModified(date);
        offerService.addOffer(offer1);
        var offer2 = new AddOfferDto();
        offer2.setDescription("Super cood Car");
        offer2.setUserId(usersService.userDetails(usersRepository.findByUsername("user").get().getUsername()).getId().toString());
        offer2.setModelId(modelService.modelDetails(model2.getName()).getId().toString());
        offer2.setImageURL("https://th.bing.com/th/id/OIP.6o28edZ3hFG_EO7npm8OdAHaEK?rs=1&pid=ImgDetMain");
        offer2.setMileage(100000);
        offer2.setPrice(6000);
        offer2.setTransmission(TypesOFTransmission.AUTOMATIC);
        offer2.setEngine(TypesOfGas.ELECTRIC);
        offer2.setYear("1900");
        offer2.setCreated(date);
        offer2.setModified(date);
        offerService.addOffer(offer2);



//        System.out.println("Start test: \n");
//        ShowDetailedUserRolesInfoDto role1 = new ShowDetailedUserRolesInfoDto(UUID.randomUUID(), TypesOfRoles.USER);
//        ShowDetailedUserRolesInfoDto role2 = new ShowDetailedUserRolesInfoDto(UUID.randomUUID(), TypesOfRoles.ADMIN);
//        role1 = roleService.register(role1);
//        role2 = roleService.register(role2);
//
//        var role3 = new ShowDetailedUserRolesInfoDto(UUID.randomUUID(), TypesOfRoles.ADMIN);
//        roleService.addUserRolesWithValidation(role3);
//
//        System.out.println(role1);
//        System.out.println(role2);
//
//        var date = Date.now();
//
//        var brand1 = new AddBrandDto( "Lada", date, date);
//        var brand2 = new AddBrandDto( "Moscwich", date, date);
//
//        var brandWithValidationTest = new AddBrandDto( "I'm test", date, date);
//        brandService.addBrandWithValidation(brandWithValidationTest);
//        System.out.println(brandWithValidationTest);
//
//
//        brand1 = brandService.register(brand1);
//        brand2 = brandService.register(brand2);
//        System.out.println(brand1);
//        System.out.println(brand2);
//
//
////        ShowDetailedModelsInfoDto model1 = new ShowDetailedModelsInfoDto(UUID.randomUUID(), "Niva", CategoryOfVehicles.Car, "http://qwqwqwqw",
////                1999, 2023, date, date, brand1);
////        ShowDetailedModelsInfoDto model2 = new ShowDetailedModelsInfoDto(UUID.randomUUID(), "23", CategoryOfVehicles.Car, "http://kjkjkjkjk",
////                2022, 2023, date, date, brand2);
////        model1 = modelService.register(model1);
////        model2 = modelService.register(model2);
//
////        var model3 = new ShowDetailedModelsInfoDto(UUID.randomUUID(), "Test", CategoryOfVehicles.Car, "http://kjkjkjkjk",
////                2022, 2023, date, date, brand2);
////        modelService.addModelWithValidation(model3);
////
////
////        System.out.println(model1);
////        System.out.println(model2);
//
//        ShowDetailedUsersInfoDto user1 = new ShowDetailedUsersInfoDto(UUID.randomUUID(), role1, "Kisa17", "555555", "Zlata",
//                "Kikimora", true, "http://jjejfbejbf", date, date);
//        ShowDetailedUsersInfoDto user2 = new ShowDetailedUsersInfoDto(UUID.randomUUID(), role2, "Gora", "6666666", "Morgan",
//                "Freeman", true, "http://bebfebufbe", date, date);
//        user1 = usersService.register(user1);
//        user2 = usersService.register(user2);
//
//
//        var user3 = new ShowDetailedUsersInfoDto(UUID.randomUUID(), role1, "Kisa17", "555555", "Zlata",
//                "Test", true, "http://jjejfbejbf", date, date);
//        usersService.addUserWithValidation(user3);
//
//
//        System.out.println(user1);
//        System.out.println(user2);
//
//        var price1 = 100_000;
//        var price2 = 3_000_000;
//
////        ShowDetailedOffersInfoDto offer1 = new ShowDetailedOffersInfoDto(UUID.randomUUID(), "Top in 1999", TypesOfGas.ELECTRIC,
////                "http://ya.ru", 20, price1, TypesOFTransmission.AUTOMATIC, 2022, date, date, model1, user2);
////        ShowDetailedOffersInfoDto offer2 = new ShowDetailedOffersInfoDto(UUID.randomUUID(), "Too much", TypesOfGas.GASOLINE,
////                "http://d", 2, price2, TypesOFTransmission.AUTOMATIC, 2022, date, date, model2, user2);
////        offerService.register(offer1);
////        offerService.register(offer2);
////
////        var offer3 = new ShowDetailedOffersInfoDto(UUID.randomUUID(), "Test", TypesOfGas.ELECTRIC,
////                "http://ya.ru", 20, price1, TypesOFTransmission.AUTOMATIC, 2022, date, date, model1, user2);
//
////        offerService.addOfferWithValidation(offer3);
////
////
////        System.out.println(offer1);
////        System.out.println(offer2);
//        // roleService.delete(1L);
//        //usersService.delete(1L);
//        //offerService.delete(1L);
//        // brandService.delete(brand1.getId());

    }
    private void initRoles() {
        if (roleRepository.count() == 0) {
            var adminRole = new UserRole(TypesOfRoles.ADMIN);
            var normalUserRole = new UserRole(TypesOfRoles.USER);

            roleRepository.save(adminRole);
            roleRepository.save(normalUserRole);
        }
    }
    private void initAdmin(){
        var adminRole = roleRepository.findByRole(TypesOfRoles.ADMIN).orElseThrow();

        var adminUser = new Users("admin", passwordEncoder.encode(defaultPassword), "admin@example.com");
        adminUser.setRole(adminRole);

        usersRepository.save(adminUser);
    }
    private void initNormalUser(){
        var userRole = roleRepository.findByRole(TypesOfRoles.USER).orElseThrow();

        var normalUser = new Users("user", passwordEncoder.encode(defaultPassword), "user@example.com");
        normalUser.setRole(userRole);
        normalUser.setCreated(new Date());
        normalUser.setModified(new Date());

        usersRepository.save(normalUser);
    }
    private void initUsers() {
        if (usersRepository.count() == 0) {
            initAdmin();
            initNormalUser();
        }
    }
}
