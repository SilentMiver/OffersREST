package com.example.springdataforum.controllers;


import com.example.springdataforum.Constans.CategoryOfVehicles;
import com.example.springdataforum.dto.AddModelDto;
import com.example.springdataforum.dto.ShowDetailedModelsInfoDto;
import com.example.springdataforum.dto.ShowModelsInfoDto;
import com.example.springdataforum.services.impl.BrandsService;
import com.example.springdataforum.services.impl.ModelsService;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/models")
public class ModelsController {

    private final ModelsService modelsService;
    private final BrandsService brandsService;


    @Autowired
    public ModelsController(ModelsService modelsService, BrandsService brandsService) {
        this.modelsService = modelsService;
        this.brandsService = brandsService;
    }

    @GetMapping("/add")
    public String showAddModelForm(Model model) {
        model.addAttribute("addModelDto", new AddModelDto());
        model.addAttribute("allBrands", brandsService.getAll());
        return "addModel";
    }

    @PostMapping("/add")
    public String addModel(@ModelAttribute @Valid AddModelDto modelDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("allBrands", brandsService.getAll());
            return "addModel";
        }
        modelDto.setCreated(new Date());
        modelDto.setModified(new Date());
        modelsService.addModel(modelDto);
        return "redirect:/models/all";
    }

    //    @GetMapping("/all")
//    public String getAllModels(Model model) {
//        List<ShowModelsInfoDto> models = modelsService.getAllModels();
//        model.addAttribute("models", models);
//        return "getAllModels";
//    }
    @GetMapping("/all")
    public String getAllModels(@RequestParam(name = "brandFilter", required = false) String brandFilter,
                               @RequestParam(name = "categoryFilter", required = false) String categoryFilter,
                               Model model) {

        List<ShowModelsInfoDto> models;

        if (StringUtils.isNotBlank(brandFilter) && StringUtils.isNotBlank(categoryFilter)) {
            models = modelsService.getAllModelsByBrandAndCategory(brandFilter, CategoryOfVehicles.valueOf(categoryFilter));
        } else if (StringUtils.isNotBlank(brandFilter)) {
            models = modelsService.getAllModelsByBrand(brandFilter);
        } else if (StringUtils.isNotBlank(categoryFilter)) {
            models = modelsService.getAllModelsByCategory(CategoryOfVehicles.valueOf(categoryFilter));
        } else {
            models = modelsService.getAllModels();
        }

        model.addAttribute("models", models);
        model.addAttribute("allBrands", brandsService.getAll());
        return "getAllModels";
    }

    @GetMapping("/details/{modelName}")
    public String getModelDetails(@PathVariable String modelName, Model model) {
        ShowDetailedModelsInfoDto modelDetails = modelsService.modelDetails(modelName);
        model.addAttribute("modelDetails", modelDetails);
        return "getModelDetails";
    }

    @GetMapping("/remove/{modelName}")
    public String deleteModel(@PathVariable String modelName) {
        modelsService.removeModel(modelName);
        return "redirect:/models/all";
    }

}


//@RestController
//@RequestMapping("/models")
//public class ModelsController {
//    // add setter injection
//    private ModelsService modelsService;
//
//    @Autowired
//    public void setModelsService(ModelsService modelsService) {
//        this.modelsService = modelsService;
//    }
//
//    @GetMapping()
//    Iterable<ShowDetailedModelsInfoDto> all() {
//        return modelsService.getAll();
//    }
//
//    @GetMapping("/{id}")
//    ShowDetailedModelsInfoDto get(@PathVariable UUID id) {
//        return modelsService.get(id).get();
//    }
//
//    @DeleteMapping("/{id}")
//    void deleteBrand(@PathVariable UUID id) {
//        modelsService.delete(id);
//    }
//
//    @PostMapping()
//    ShowDetailedModelsInfoDto update(@RequestBody ShowDetailedModelsInfoDto showDetailedModelsInfoDto) {
//        return modelsService.update(showDetailedModelsInfoDto);
//    }
//}
