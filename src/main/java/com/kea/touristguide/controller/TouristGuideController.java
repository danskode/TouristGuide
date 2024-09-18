package com.kea.touristguide.controller;

import com.kea.touristguide.model.TouristAttraction;
import com.kea.touristguide.service.TouristGuideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristGuideController {
    private final TouristGuideService touristGuideService;

    public TouristGuideController(TouristGuideService touristGuideService) {
        this.touristGuideService = touristGuideService;
    }

    // get all test with Thymeleaf ...
    @GetMapping("")
    public String getAllAttractions(Model model) {
        List<TouristAttraction> allTouristAttractions = touristGuideService.getAllTouristAttractions();
        model.addAttribute("turistattraktioner", allTouristAttractions);
        return "attractionList";
    }

    // get one specific TouristAttraction instance by name ...
    @GetMapping("{name}")
    public String getTouristAttractionByName(@PathVariable String name, Model model) {
        String nameStriped = name.toLowerCase().replaceAll("\\s", "");
        TouristAttraction attraction = touristGuideService.getTouristAttractionByName(nameStriped);
        model.addAttribute("attraktion", attraction);
        return "attraction";
    }

    // show all tags for one specific TouristAttraction instance ...
    @GetMapping("{name}/tags")
    public String getOneTouristAttractionsTags(@PathVariable String name, Model model){
        String nameStriped = name.toLowerCase().replaceAll("\\s", "");
        TouristAttraction attraction = touristGuideService.getTouristAttractionByName(nameStriped);
        model.addAttribute("attraktion", attraction);
        return "tags";
    }

    //delete one ...
    @PostMapping("/delete/{name}")
    public String deleteTouristAttractionByName(@PathVariable String name) {
        String nameStriped = name.toLowerCase().replaceAll("\\s", "");
        touristGuideService.deleteTouristAttractionByName(nameStriped);
        return "redirect:/attractions";
    }

    //add one ...
    @GetMapping("add")
    public String addNewAttraction() {
//        TouristAttraction attraktion = new TouristAttraction();
//        model.addAttribute("attraktion", attraktion);
//        model.addAttribute("allValues", Arrays.asList("Musik", "Sport", "Kultur", "Natur" ));
        return "add";
    }

    //save one ...
    @PostMapping("save")
    public String addTouristAttraction(String name, String description, String image, int priceDkk, String city, String tag1, String tag2, String tag3, String tag4, String tag5, String tag6, String tag7){
        List<String> tags = new ArrayList<>();
        if(tag1 != null) {tags.add(tag1);};
        if(tag2 != null) {tags.add(tag2);};
        if(tag3 != null) {tags.add(tag3);};
        if(tag4 != null) {tags.add(tag4);};
        if(tag5 != null) {tags.add(tag5);};
        if(tag6 != null) {tags.add(tag6);};
        if(tag7 != null) {tags.add(tag7);};
        touristGuideService.addTouristAttraction(name, description, image, priceDkk, city, tags);
        return "redirect:/attractions";
    }
}
