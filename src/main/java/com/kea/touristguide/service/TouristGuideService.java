package com.kea.touristguide.service;

import com.kea.touristguide.model.TouristAttraction;
import com.kea.touristguide.repository.TouristGuideRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristGuideService {
    private final TouristGuideRepository touristGuideRepository;

    public TouristGuideService(TouristGuideRepository touristGuideRepository) {
        this.touristGuideRepository = touristGuideRepository;
    }

    public List<TouristAttraction> getAllTouristAttractions() {
        return touristGuideRepository.getAllTouristAttractions();
    }

    public TouristAttraction getTouristAttractionByName(String nameStriped) {
        return touristGuideRepository.getTouristAttractionByName(nameStriped);
    }
}
