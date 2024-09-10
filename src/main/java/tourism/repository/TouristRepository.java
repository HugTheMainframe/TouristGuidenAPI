package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository(){
        attractions();
    }

    public void attractions(){
        touristAttractions.add(new TouristAttraction("The little mermaid", "A statue of the princess of the sea." +
                "A novelty written by denmarks most famous author: H.C Andersen."));
        touristAttractions.add(new TouristAttraction("Amalienborg", "The home of the sitting monarch of Denmark." +
                "Right now his majesty King Frederik the 10 is the sovereignty of the kingdom."));
        touristAttractions.add(new TouristAttraction("Tivoli", "A good place to have fun, and enjoy amusements" +
                "and the roller coasters!"));
        touristAttractions.add(new TouristAttraction("Christansborg castle", "The old home of the kings of denmark." +
                "Now the central place for denmarks democratic. Here lies the \"Folketing\" and the sitting parliament."));
    }

    public List<TouristAttraction> getTouristAttractions(){
        return touristAttractions;
    }

    public TouristAttraction findAttraction(String name){
        TouristAttraction touristAttraction = null;
        for(TouristAttraction t : touristAttractions){
            if(t.getName().equalsIgnoreCase(name.toLowerCase())){
                touristAttraction = t;
            }
        }
        return touristAttraction;
    }

    public TouristAttraction addTouristAttraction(TouristAttraction attraction){
        touristAttractions.add(attraction);
        return attraction;
    }

    public TouristAttraction updateEvent(TouristAttraction attraction){
        TouristAttraction touristAttraction = null;
        for(TouristAttraction t : touristAttractions){
            if(t.getName().equalsIgnoreCase(attraction.getName())){
                touristAttraction = t;
                touristAttractions.set(touristAttractions.indexOf(t), attraction);
                break;
            }
        }
        return touristAttraction;
    }

    public TouristAttraction deleteEvent(String name){
        TouristAttraction touristAttraction = null;
        for(TouristAttraction t : touristAttractions){
            if(t.getName().equalsIgnoreCase(name)){
                touristAttraction = t;
                touristAttractions.remove(t);
                break;
            }
        }
        return touristAttraction;
    }
}
