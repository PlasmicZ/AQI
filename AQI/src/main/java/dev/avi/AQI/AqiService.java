package dev.avi.AQI;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

class AqiData {
    private String city;
    private String state;
    private String lastUpdate;
    private String pollutantMin;
    private String pollutantAvg;
    private String pollutantMax;

    public AqiData() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getPollutantMin() {
        return pollutantMin;
    }

    public void setPollutantMin(String pollutantMin) {
        this.pollutantMin = pollutantMin;
    }

    public String getPollutantAvg() {
        return pollutantAvg;
    }

    public void setPollutantAvg(String pollutantAvg) {
        this.pollutantAvg = pollutantAvg;
    }

    public String getPollutantMax() {
        return pollutantMax;
    }

    public void setPollutantMax(String pollutantMax) {
        this.pollutantMax = pollutantMax;
    }
}



@Service
public class AqiService {

    private static final String API_KEY = "579b464db66" +
            "ec23bdd000001cdd3946e44ce4aad7209ff7b23ac571b";
    private static final String BASE_URL = "https://api.data.gov.in/resource/3b01bcb8-0b14-4abf-b6f2-c1bfd384ba69?api-key="
            + API_KEY + "&format=json&offset=0";
    public AqiData getAqiData(String city) {

        // TODO: set URL
        String url = BASE_URL +"&filters[city]="+city;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // fetching response
        JSONObject jsonObject = new JSONObject(response.getBody());

        AqiData aqiData = new AqiData();
        aqiData.setCity(jsonObject.getString("city"));
        aqiData.setState(jsonObject.getString("state"));
        aqiData.setLastUpdate(jsonObject.getString("last_update"));
        aqiData.setPollutantAvg(jsonObject.getString("pollutant_avg"));
        aqiData.setPollutantMin(jsonObject.getString("pollutant_min"));
        aqiData.setPollutantMax(jsonObject.getString("pollutant_max"));

        // parse more fields as needed
        return aqiData;
    }
}


