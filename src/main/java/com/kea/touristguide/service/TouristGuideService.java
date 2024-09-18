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

    // work in progress ...
    public void deleteTouristAttractionByName(String nameStriped) {
        touristGuideRepository.deleteTouristAttractionByName(nameStriped);
    }

    // work in progress ...
    public TouristAttraction addTouristAttraction(String name, String description, String image, int priceDkk, String city, List<String> tags) {
        return touristGuideRepository.addTouristAttraction(name, description, image, priceDkk, city, tags);
    }
}
