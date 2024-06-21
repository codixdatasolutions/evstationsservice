package com.ecosystem.evstationsservice.utility;

import com.ecosystem.evstationsservice.dto.request.CitiesDto;
import lombok.Data;

import java.util.List;
import java.util.Random;

public class RandomSequenceGenerator {

  /*  private static final String[] STATES = {
            "TEX", "ILL", "CAL", "FLA", "NYK", "OH", "PA", "GA", "NC", "MI",
            "WA", "CO", "AZ", "NV", "UT", "NM", "OR", "AL", "SC", "VA",
            "TN", "MO", "WI", "MN", "IN", "MA", "LA", "KY", "OK", "KS",
            "MD", "AR", "MS", "IA", "CT", "NV", "UT", "AK", "HI", "WV",
            "ID", "ME", "NH", "RI", "MT", "SD", "ND", "WY", "DE", "VT"
    };

    private static final String[] CITIES = {
            "DALL", "CHIC", "LOSA", "MIAM", "NYC", "CLE", "PHI", "ATL", "CHAR", "DET",
            "SEAT", "DEN", "PHX", "LVG", "SLC", "ABQ", "PDX", "BHM", "COLA", "RICH",
            "NAS", "STL", "MIL", "MSP", "IND", "BOS", "NO", "LEX", "OKC", "ICT",
            "BAL", "LIT", "JAC", "DSM", "HRT", "REN", "SLC", "ANC", "HNL", "CRW",
            "BOI", "POR", "MHT", "PRO", "BIL", "SUX", "FAR", "CPR", "DOV", "BTV"
    };
*/
    private  static String state;
    private  static String city;
    private static  String codeGeneration;
    private static final Random RANDOM = new Random();
/*
        public static String generateCode(int index) {
            state = STATES[RANDOM.nextInt(STATES.length)];
            city = CITIES[RANDOM.nextInt(CITIES.length)];
            codeGeneration=String.format("US%s%sBLDG%04d", state, city, index + 1);
            return String.format("US%s%sBLDG%04d", state, city, index + 1);
        }*/

    public static String generateRandomSequence(int length) {
        int max = (int) Math.pow(10, length);
        int randomNum = RANDOM.nextInt(max);
        return String.format("%0" + length + "d", randomNum);
    }

       /* public static  void generateRandomCity(){
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<StateDto>> typeReference = new TypeReference<List<StateDto>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/files/statecity.json");
            try {
                List<User> users = mapper.readValue(inputStream,typeReference);
                userService.save(users);
                System.out.println("Users Saved!");
            } catch (IOException e){
                System.out.println("Unable to save users: " + e.getMessage());
            }

            JSONArray jsonArray = .getAsJsonArray();
            // Randomly select a state
            Random random = new Random();
            int stateIndex = random.nextInt(jsonArray.size());
            JSONObject stateObject = jsonArray.get(stateIndex).getAsJsonObject();
            Map.Entry<String, JsonElement> stateEntry = stateObject.entrySet().iterator().next();
            String stateName = stateEntry.getKey();
            JSONObject citiesObject = stateObject.getAsJsonObject("cities");

            // Randomly select a city from the selected state
            List<Map.Entry<String, JsonElement>> cities = gson.fromJson(citiesObject, Map.class).entrySet().stream().toList();
            int cityIndex = random.nextInt(cities.size());
            String cityName = cities.get(cityIndex).getKey();
            String cityCode = cities.get(cityIndex).getValue().getAsString();

            // Print the randomly selected state, city, and their code
            System.out.println("Randomly selected state: " + stateName);
            System.out.println("Randomly selected city: " + cityName);
            System.out.println("City code: " + cityCode);
        }
        }*/

    @Data
    public static class StateDto {

        private List<CitiesDto> cities;
    }
}
