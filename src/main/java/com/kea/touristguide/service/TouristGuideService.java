package com.kea.touristguide.service;

import com.kea.touristguide.model.TouristAttraction;
import com.kea.touristguide.repository.TouristGuideRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TouristGuideService {
    private final TouristGuideRepository touristGuideRepository;

    public TouristGuideService(TouristGuideRepository touristGuideRepository) {
        this.touristGuideRepository = touristGuideRepository;
    }

    // working ...
    public List<TouristAttraction> getAllTouristAttractions() {
        return touristGuideRepository.getAllTouristAttractions();
    }

    // working ...
    public TouristAttraction getTouristAttractionByName(String nameStriped) {
        return touristGuideRepository.getTouristAttractionByName(nameStriped);
    }

    //working ...
    public String deleteTouristAttractionByName(String nameStriped) {
        touristGuideRepository.deleteTouristAttractionByName(nameStriped);
        return "done";
    }

    // work in progress ...
    public String addTouristAttraction(String name, String description, String image, int priceDkk, String city, List<String> tags) {
        touristGuideRepository.addTouristAttraction(name, description, image, priceDkk, city, tags);
        return "done";
    }
}
