package dev.avi.AQI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AQIController
{
    @GetMapping("/aqi/{city}")
    public ResponseEntity<String> getWords(@PathVariable String city)
    {
        AqiData result = aqiService.getAqiData(city);
        return ResponseEntity.ok(result.toString())    ;
    }

    @Autowired
    private AqiService aqiService;
}

