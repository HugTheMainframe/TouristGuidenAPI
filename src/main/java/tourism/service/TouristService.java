package tourism.service;

import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {
    private TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository){
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllAttrractions(){
        return touristRepository.getTouristAttractions();
    }

    public TouristAttraction findAttraction(String name){
        return touristRepository.findAttraction(name);
    }

    public TouristAttraction addAttraction(TouristAttraction attraction){
        return touristRepository.addTouristAttraction(attraction);
    }

    public TouristAttraction updateAttraction(TouristAttraction attraction){
        return touristRepository.updateEvent(attraction);
    }

    public TouristAttraction deleteAttraction(String name){
        return touristRepository.deleteEvent(name);
    }
}
