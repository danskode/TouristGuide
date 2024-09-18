package com.kea.touristguide.controller;

import com.kea.touristguide.model.TouristAttraction;
import com.kea.touristguide.service.TouristGuideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristGuideController {
    private final TouristGuideService touristGuideService;

    public TouristGuideController(TouristGuideService touristGuideService) {
        this.touristGuideService = touristGuideService;
    }

//    // get all ...
//    @GetMapping("")
//    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
//        List<TouristAttraction> allTouristAttractions = touristGuideService.getAllTouristAttractions();
//        return new ResponseEntity<>(allTouristAttractions, HttpStatus.OK);
//    }

    // get all test with Thymeleaf ...
    @GetMapping("")
    public String getAllAttractions(Model model) {
        List<TouristAttraction> allTouristAttractions = touristGuideService.getAllTouristAttractions();
        model.addAttribute("turistattraktioner", allTouristAttractions);
        return "attractionList";
    }

    // get one specific TouristAttraction instance by name ...
    @GetMapping("{name}")
    public ResponseEntity<TouristAttraction> getTouristAttractionByName(@PathVariable String name){
        String nameStriped = name.toLowerCase().replaceAll("\\s", "");
        TouristAttraction attraction = touristGuideService.getTouristAttractionByName(nameStriped);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    // show all tags for one specific TouristAttraction instance ... In process ...
    @GetMapping("/{name}/tags")
    public ResponseEntity<List<TouristAttraction>> getOneTouristAttractionsTags(@PathVariable String name){
        String nameStriped = name.toLowerCase().replaceAll("\\s", "");
        return null;
    }
}
