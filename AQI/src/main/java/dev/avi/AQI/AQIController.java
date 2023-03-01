package dev.avi.AQI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AQIController {

    @Autowired
    private AqiService aqiService;

    @GetMapping("/aqi")
    public String getWeather(@RequestParam(name = "city") String city) {
        System.out.println(city);
        return aqiService.getAqiData(city).toString();
    }
}

