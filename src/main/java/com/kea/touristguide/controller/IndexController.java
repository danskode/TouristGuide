package com.kea.touristguide.controller;

import com.kea.touristguide.model.TouristAttraction;
import com.kea.touristguide.service.TouristGuideService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class IndexController {
    private final TouristGuideService touristGuideService;

    public IndexController(TouristGuideService touristGuideService) {
        this.touristGuideService = touristGuideService;
    }

    @GetMapping("")
    public String getAllAttractions(Model model) {
        List<TouristAttraction> allTouristAttractions = touristGuideService.getAllTouristAttractions();
        model.addAttribute("attraktioner", allTouristAttractions);
        return "index";
    }


}
