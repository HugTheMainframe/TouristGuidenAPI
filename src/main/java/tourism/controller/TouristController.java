package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

@Controller
@RequestMapping("/attractions")
    public class TouristController {
    private TouristService touristService;

    public TouristController(TouristService touristService){
        this.touristService = touristService;
    }

    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAllAttractions(){
        List<TouristAttraction> attraction = touristService.getAllAttrractions();
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getTouristByName(@PathVariable String name){
        TouristAttraction attraction = touristService.findAttraction(name);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction attraction = touristService.addAttraction(touristAttraction);
        return new ResponseEntity<>(attraction, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction attraction = touristService.updateAttraction(touristAttraction);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name){
        TouristAttraction attraction = touristService.deleteAttraction(name);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

}
