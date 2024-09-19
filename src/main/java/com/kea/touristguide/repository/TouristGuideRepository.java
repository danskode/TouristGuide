package com.kea.touristguide.repository;

import com.kea.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristGuideRepository {
    private final List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristGuideRepository() {
        touristAttractions.add(new TouristAttraction("Parken", "Danmarks nationalstadion og FCK's hjemmebane.", "https://www.fck.dk/sites/default/files/styles/article_full/public/images/2023-05/230518_aab-fck-1.jpg", 500, "København Ø", List.of("Sport", "Musik")));
        touristAttractions.add(new TouristAttraction("Ørestad", "En ny og familievenlig bydel i København med moderne arkitektur omringet af natur.", "https://www.visitcopenhagen.com/sites/visitcopenhagen.com/files/2019-06/kalvebod_faelled_orestad4%20(1).jpg", 0, "København", List.of("Børnevenlig", "Arkitektur", "Natur")));
        touristAttractions.add(new TouristAttraction("Royal Arena", "Stor kulturarena med plads til 25.000 gæster i Ørestad, København. Her kan afholdes mange typer events: sportsbegivenheder, koncerter og store forestillinger.", "https://files.guidedanmark.org/files/382/158397_Royal_Arena_PR_photo_Royal_Arena_and_3XN.jpg", 750, "København S", List.of("Musik", "Sport", "Kultur")));
        touristAttractions.add(new TouristAttraction("Ørestad Skøjtehal", "Hjemmebane for ishockeyholdet Copenhagen Falcons men også en skøjtehal, der byder på mulighed for, at offentligheden kan skøjte på den nye bane.", "https://kulturogfritids.kk.dk/sites/default/files/styles/hero_desktop/public/2021-12/%C3%98restadSk%C3%B8jtehalIMG_0577Hero.jpg?itok=PGp2q98F", 20, "København S", List.of("Sport")));
        touristAttractions.add(new TouristAttraction("Roskilde Festival", "Stor musikfestival i Roskilde, der har eksisteret i mere end 50 år. Startede som en rockfestival, men er i dag mere en festival for populærmusik fra Tik-Tok.", "https://destinationsmagazine.com/wp-content/uploads/2016/04/Destinationsmag_RoskildeFest_Orange_Simon_Fr%C3%B8sig_Christensen38.jpg", 2500, "Roskilde", List.of("Musik", "Kultur")));
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

    //working ...
    public String addTouristAttraction(String name, String description, String image, int priceDkk, String city, List<String> tags) {
        TouristAttraction touristAttraction = new TouristAttraction(name, description, image, priceDkk, city, tags);
        this.touristAttractions.add(touristAttraction);
        return "Done";
    }

    // work in progress ...
    public String updateTouristAttraction(String name, String description, String image, int priceDkk, String city, List<String> tags) {

        for(TouristAttraction touristAttraction : touristAttractions) {
            String getName = touristAttraction.getName().toLowerCase().replaceAll("\\s", "");
            if (getName.equals(name)) {
                touristAttraction.setDescription(description);
                touristAttraction.setImage(image);
                touristAttraction.setPriceDkk(priceDkk);
                touristAttraction.setCity(city);
                touristAttraction.setTags(tags);

                return "done";
            }
        }
        return "Done";
    }
}
