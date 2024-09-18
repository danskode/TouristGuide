package com.kea.touristguide.repository;

import com.kea.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristGuideRepository {
    private final List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristGuideRepository() {
        touristAttractions.add(new TouristAttraction("Parken", "Danmarks nationalstadion og FCK's hjemmebane.", "fck.jpg", 500, "København Ø", List.of("Sport", "Events", "Football", "Music")));
        touristAttractions.add(new TouristAttraction("Ørestad", "En ny og familievenlig bydel i København med moderne arkitektur omringet af natur.", "ørestad.jpg", 0, "København", List.of("Børnevenlig", "Arkitektur", "Natur")));
        touristAttractions.add(new TouristAttraction("Royal Arena", "Stor kulturarena med plads til 25.000 gæster i Ørestad, København. Her kan afholdes mange typer events: sportsbegivenheder, koncerter og store forestillinger.", "royalarena.jpg", 750, "København S", List.of("Musik", "Sport", "Kultur")));
        touristAttractions.add(new TouristAttraction("Ørestad Skøjtehal", "Hjemmebane for ishockeyholdet Copenhagen Falcons men også en skøjtehal, der byder på mulighed for, at offentligheden kan skøjte på den nye bane.", "ørestad-skøjtehal.jpg", 20, "København S", List.of("Sport")));
        touristAttractions.add(new TouristAttraction("Roskilde Festival", "Stor musikfestival i Roskilde, der har eksisteret i mere end 50 år. Startede som en rockfestival, men er i dag mere en festival for populærmusik fra Tik-Tok.", "rosfest.jpg", 2500, "Roskilde", List.of("Musik", "Kultur", "Festival", "Kunst", "Mad")));
    }

    //working ...
    public List<TouristAttraction> getAllTouristAttractions() {
        return touristAttractions;
    }

    //working ...
    public TouristAttraction getTouristAttractionByName(String nameStriped) {
        for(TouristAttraction touristAttraction : touristAttractions) {
            String getName = touristAttraction.getName().toLowerCase().replaceAll("\\s", "");
            if (getName.equals(nameStriped)) {
                return touristAttraction;
            }
        }
        return null;
    }

    //working ...
    public String deleteTouristAttractionByName(String nameStriped) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            String getName = touristAttraction.getName().toLowerCase().replaceAll("\\s", "");
            if (getName.equals(nameStriped)) {
                touristAttractions.remove(touristAttraction);
                return "done";
            }
        }
        return "done";
    }

    //work in progress ...
    public TouristAttraction addTouristAttraction(String name, String description, String image, int priceDkk, String city, List<String> tags) {
        TouristAttraction touristAttraction = new TouristAttraction(name, description, image, priceDkk, city, tags);
        this.touristAttractions.add(touristAttraction);
        return touristAttraction;
    }
}
