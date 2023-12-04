package com.example.springdataforum.controllers;


import com.example.springdataforum.dto.AddModelDto;
import com.example.springdataforum.dto.ShowDetailedModelsInfoDto;
import com.example.springdataforum.dto.ShowModelsInfoDto;
import com.example.springdataforum.services.impl.ModelsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/models")
public class ModelsController {

    private final ModelsService modelsService;


    @Autowired
    public ModelsController(ModelsService modelsService) {
        this.modelsService = modelsService;
    }

    @GetMapping("/add")
    public String showAddModelForm(Model model) {
        model.addAttribute("addModelDto", new AddModelDto());
        return "addModel";
    }

    @PostMapping("/add")
    public String addModel(@ModelAttribute @Valid AddModelDto modelDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addModel";
        }
        modelDto.setCreated(LocalDateTime.now());
        modelDto.setModified(LocalDateTime.now());
        modelsService.addModel(modelDto);
        return "redirect:/models/all";
    }

    @GetMapping("/all")
    public String getAllModels(Model model) {
        List<ShowModelsInfoDto> models = modelsService.getAllModels();
        model.addAttribute("models", models);
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
