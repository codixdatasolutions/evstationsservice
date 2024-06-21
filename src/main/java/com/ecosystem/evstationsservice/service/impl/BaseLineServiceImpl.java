package com.ecosystem.evstationsservice.service.impl;

import com.ecosystem.evstationsservice.dto.request.*;
import com.ecosystem.evstationsservice.enums.VehicleType;
import com.ecosystem.evstationsservice.model.*;
import com.ecosystem.evstationsservice.repository.*;
import com.ecosystem.evstationsservice.service.BaseLineService;
import com.ecosystem.evstationsservice.utility.RandomSequenceGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@Service
public class BaseLineServiceImpl implements BaseLineService {

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private BatteryLogRepository batteryLogRepository;

    @Autowired
    private BatteryReository batteryReository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private BaseLineRepository baseLineRepository;

    @Autowired
    private BuildingsRepository buildingsRepository;

    @Autowired
    private  HistoryRepository  historyRepository;

    private static    int counter = 1;

    @Override
    public void addProject(BaseLineDto dto) {
      Date baseLineStartDate = dto.getBaseLineStartDate();
        Date currentDate = new Date();

        System.out.println("Cron Job run: " + currentDate);

        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setTime(baseLineStartDate);

        Calendar eCalendar = Calendar.getInstance();
        eCalendar.setTime(currentDate);
        sCalendar.add(Calendar.DATE, 1);
        for(; !sCalendar.after(eCalendar); sCalendar.add(Calendar.DATE, 1)) {

            Date result = sCalendar.getTime();
            int v1,v2,v3=0;

            for (HubDto hubDto : dto.getHubDetails()) {
                Building buildingsModel = Building
                        .builder()
                        .name(hubDto.getHubName())
                        .code(buildingCode(dto, hubDto))
                        .country(dto.getCountry())
                        .city(dto.getCity())
                        .pincode(dto.getPinCode())
                        .category("EV")
                        .gridPower(0.0)
                        .fuelPower(0.0)
                        .projectname(dto.getProjectName())
                        .greenPower(0.0)
                        .occupancy(0)
                        .population(0)
                        .updatedOn(new Date())
                        .build();
                Building saveBuilding = this.buildingsRepository.save(buildingsModel);

                long buildingId = saveBuilding.getId();
                counter = 1;
                List<Floors> floorsList = new ArrayList<>();
                for (int i = 1; i <= hubDto.getNumberFleets(); i++) {
                    Floors floors = Floors.builder()
                            .buildingsId(buildingId)
                            .name(fleetCode(counter, saveBuilding, hubDto, dto))
                            .area(0l)
                            .build();
                    ++counter;
                    floorsList.add(floors);
                }
                List<Floors> saveFloors = this.floorRepository.saveAll(floorsList);

                counter = 1;
                List<Vehicles> vehiclesList = new ArrayList<>();
                for (int i = 1; i <= hubDto.getNumberVehicle(); i++) {
                    for (VehicleDto vehicleDto : hubDto.getVehicleList()) {

                        if(vehicleDto.getVehicleNo1()!=null)
                        {
                            v1=vehicleDto.getVehicleNo1();
                            if(v1>0) {
                                Vehicles vehicles = buildVechileModel(vehicleDto, dto, hubDto, saveBuilding, saveFloors, vehicleDto.getVehicleModelType1());
                                vehiclesList.add(vehicles);
                                v1--;
                                vehicleDto.setVehicleNo1(v1);
                            }
                        }
                        if (vehicleDto.getVehicleNo2()!=null) {
                            v2 = vehicleDto.getVehicleNo2();
                            if(v2>0){
                            Vehicles vehicles = buildVechileModel(vehicleDto, dto, hubDto, saveBuilding, saveFloors, vehicleDto.getVehicleModelType2());
                            vehiclesList.add(vehicles);
                            v2--;
                                vehicleDto.setVehicleNo2(v2);
                        }
                        }
                        if(vehicleDto.getVehicleNo3()!=null)
                        {
                            v3=vehicleDto.getVehicleNo3();
                            if(v3>0){
                                Vehicles vehicles= buildVechileModel(vehicleDto,dto,hubDto,saveBuilding,saveFloors,vehicleDto.getVehicleModelType3());
                                vehiclesList.add(vehicles);
                                v3--;
                                vehicleDto.setVehicleNo3(v3);
                            }
                        }
                    }
                }
                List<Vehicles> saveVehicles = this.vehicleRepository.saveAll(vehiclesList);

                counter = 1;
                List<Batteries> batteriesList = new ArrayList<>();
                for (int i = 1; i <= hubDto.getNumberBatteries(); i++) {
                    for (BatteryDto batteryDetails : hubDto.getBatteryDto()) {

                        Batteries batteryModel = Batteries.builder()
                                .cycles(batteryDetails.getBatteryCycle())
                                .health(batteryDetails.getBatteryHealth())
                                .name(batteriesName(counter, saveBuilding, batteryDetails, dto, hubDto))
                                .updatedon(new Date())
                                .build();
                        counter++;
                        batteriesList.add(batteryModel);
                    }
                }
                this.batteryReository.saveAll(batteriesList);

                counter = 1;
                List<Batterylogs> batterylogs = new ArrayList<>();
                List<History> historyList = new ArrayList<>();
                for (int i = 1; i <= hubDto.getNumberBatteries(); i++) {
                    for (BatteryDto batteryDetails : hubDto.getBatteryDto()) {
                        Batterylogs batteryLogsModel = Batterylogs.builder()
                                .batteryVoltageIn(Math.abs(randomFloat(40.0f, 50.0f)))
                                .batteryVoltageOut(Math.abs(randomFloat(60.0f, 70.0f)))
                                .batterySocOut(Math.abs(randomFloat(75.0f, 100.0f)))
                                .batterySocIn(Math.abs(randomFloat(50.0f, 75.0f)))
                                .health(batteryDetails.getBatteryHealth())
                                .name(batteriesList.get(Math.abs(randomNumber(0, hubDto.getBatteryDto().size()))).getName())
                                .chargeCycle(0)
                                .charge(Math.abs(randomFloat(50.0f, 100.00f)))
                                .duration(Math.abs(randomNumber(310, 600)))
                                .voltage(Math.abs(randomNumber(47000, 49000)))
                                .slot(Math.abs(randomNumber(1, 30)))
                                .swappedTime(result)
                                .vechile(saveVehicles.get(Math.abs(randomNumber(0, hubDto.getNumberVehicle()))).getName())
                                .timestamp(String.valueOf(new Date()))
                                .power(Math.abs(randomFloat(20.0f, 40.0f)))
                                .build();
                        History historyModel = History.builder()
                                .name(saveVehicles.get(Math.abs(randomNumber(0, hubDto.getNumberVehicle()))).getName().toUpperCase()) //add the random
                                .greenPower(calculateTenPercent(batteryDetails.getBatteryCapacityRatio(), batteryDetails.getBatterySwapTime()))
                                .gridPower(calculateNightyPercent(batteryDetails.getBatteryCapacityRatio(), batteryDetails.getBatterySwapTime()))
                                .fuelPower(0.0)
                                .addedon(result)
                                .distance(batteryDetails.getAvgTotalDistanceInDay())
                                .build();
                        ++counter;
                        batterylogs.add(batteryLogsModel);
                        historyList.add(historyModel);

                    }  //sCalendar.add(Calendar.DATE, 1);

                }
                this.batteryLogRepository.saveAll(batterylogs);
                this.historyRepository.saveAll(historyList);
            }
        }
    }

    private Vehicles buildVechileModel(VehicleDto vehicleDto, BaseLineDto dto, HubDto hubDto, Building saveBuilding, List<Floors> saveFloors,String vechileModelType) {
        String floorName=saveFloors.get(Math.abs(randomNumber(0, hubDto.getNumberFleets()))).getName();
        Vehicles vehicles = Vehicles.builder()
                .name(vehicalName(counter, saveBuilding, vehicleDto, dto, hubDto,exctractFloorID(floorName)))
                .vin("")
                .type(VehicleType.CAR)
                .model(vechileModelType)
                .country(dto.getCountry())
                .city(dto.getCity())
                .hub(hubDto.getHubName())
                .fleet(floorName)
                .status(1)
                .installationDate(new Date())
                .build();
        ++counter;
        return  vehicles;
    }


    private String   exctractFloorID(String floorName) {
        String regex = "F\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(floorName);
        String extractedValue =null;
        if (matcher.find()) {
            extractedValue = matcher.group();
        }
        return extractedValue;
    }
    private Double calculateNightyPercent(Double batteryCapacityRation, Integer batterySwapTime) {
        double energy=(90 * batteryCapacityRation * batterySwapTime)/100;
        return  Double.valueOf(energy);
    }
    private Double calculateTenPercent(Double batteryCapacityRation, Integer batterySwapTime) {
        double energy=(10 * batteryCapacityRation * batterySwapTime)/100;
        return  Double.valueOf(energy);
    }

    private String batteriesName(int counter, Building saveBuilding, BatteryDto batteryDetails, BaseLineDto dto,HubDto hubDto) {
        int counters = 19; // Example counter value
        String randomSequence = RandomSequenceGenerator.generateRandomSequence(4);  // Generate 4-digit random sequence
        return (extractPrefix(saveBuilding.getCountry(),2) + extractPrefix(saveBuilding.getCity(),3) +dto.getProjectName()+hubDto.getHubName()+batteryDetails.getChargingStationName()+extractPrefix(batteryDetails.getBatteryName(),2)+sequence(counter) + BaseLineServiceImpl.counter).toUpperCase();
    }

    private int randomNumber(int min, int max) {
        Random random = new Random();
        int randomNumber = (random.nextInt(max - min) + min);
        return randomNumber;
    }
    private double randomFloat(float min, float max) {
        Random random = new Random();
        float randomNumber = random.nextFloat(max - min) + min;
        return randomNumber;
    }

    public static String extractPrefix(String input,Integer index) {
        if (input.length() >= index) {
            return input.substring(0, index);
        } else {
            return input; // If input is shorter than 3 characters, return the entire input
        }
    }
    private String buildingCode(BaseLineDto dto, HubDto hubDto) {
      /*  int counters = 19;
        String randomSequence = RandomSequenceGenerator.generateRandomSequence(3);*/
        return (extractPrefix(dto.getCountry(),2) + extractPrefix(dto.getCity(),3)+ dto.getProjectName()+hubDto.getHubName()+sequence(counter)+counter).toUpperCase();
    }

    private String vehicalName(int counter, Building building, VehicleDto vehicleDto, BaseLineDto dto, HubDto hubDto, String floorId){
      /*  int counters = 19; // Example counter value
        String randomSequence = RandomSequenceGenerator.generateRandomSequence(4); */ // Generate 4-digit random sequence
        return (extractPrefix(building.getCountry(),2) + extractPrefix(building.getCity(),3)+dto.getProjectName()+hubDto.getHubName()+floorId+vehicleDto.getName()+ sequence(BaseLineServiceImpl.counter)+counter).toUpperCase();
    }

    private String fleetCode(int counter, Building building, HubDto hubDto, BaseLineDto dto) {
        return (extractPrefix(building.getCountry(),2) + extractPrefix(building.getCity(),3)+dto.getProjectName()+hubDto.getHubName()+"F" + sequence(BaseLineServiceImpl.counter)+counter).toUpperCase();
    }

    private String sequence(int counter){
        counter++;
        if (counter < 10) {
            return "00";
        } else if (counter > 9 && counter < 1000) {
            return "0";
        } else {
            return "";
        }
    }

}
