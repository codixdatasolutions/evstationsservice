package com.ecosystem.evstationsservice.constants;

import com.ecosystem.evstationsservice.dto.request.BaseLineDto;
import com.ecosystem.evstationsservice.model.Baseline;

import com.ecosystem.evstationsservice.model.Batterylogs;
import com.ecosystem.evstationsservice.model.History;
import com.ecosystem.evstationsservice.repository.BatteryLogRepository;
import com.ecosystem.evstationsservice.repository.HistoryRepository;
import com.ecosystem.evstationsservice.rescontroller.VechileRestController;
import com.ecosystem.evstationsservice.service.BaseLineService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class Scheduler {

    @Autowired
    private BaseLineService baseLineService;

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private BatteryLogRepository batteryLogRepository;


    @Scheduled(cron = "0 0 7 * * ?")
    @Transactional
    public void ScheduledTask(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        String startDate = dateFormat.format(new Date());
        System.out.println("Cron Job Scheduler: Job running at - "+startDate);
        Date d = new Date();


       //Step1 Fetch Data from history table bases on added_on column desc
        //Step 2 value set on History Object
        //step 3 save HIstory object (id must null)
        //setp 4 repeat step 1 2 3 for battery_log table

       List<History> history =  historyRepository.findAllOrderByAddedOnDesc();

       if (!history.isEmpty()){
           History lastHistory = history.get(0);
           System.out.println("Last added date: " + lastHistory.getAddedon());

           History h = lastHistory;
           h.setName("dsaddasf");
           h.setGridPower(23.2);
           h.setFuelPower(0.0);
           h.setGreenPower(12.4);
           h.setDistance(321.3);
           h.setAddedon(new Date());
           historyRepository.save(h);

           System.out.println("Added Data: "+ h);
       }else{
           System.out.println("No history recrds found.");
       }

//fetching a history records in descending order
        List<Batterylogs> batteryLogsList =  batteryLogRepository.findAllOrderBYSwappedTimeDesc();

        if(!batteryLogsList.isEmpty()){
            //get first row
            Batterylogs batteryLogs1 = batteryLogsList.get(0);
            System.out.println("Last History added date: " + batteryLogs1.getSwappedTime());

            //set value in batterylog object
            Batterylogs batteryLogs = batteryLogs1;
           /* batteryLogs.setName("dsdsafd");
            batteryLogs.setChargeCycle(3);
            batteryLogs.setPower(23.43);
            batteryLogs.setHealth(32);
            batteryLogs.setVoltage(54);
            batteryLogs.setCharge(32.43);
            batteryLogs.setTimestamp("42123132");
            batteryLogs.setVechile("dsgfdfcs");
            batteryLogs.setBatterySocIn(65.43);
            batteryLogs.setBatterySocOut(32.54);
            batteryLogs.setBatteryVoltageIn(76.43);
            batteryLogs.setBatteryVoltageOut(42.54);
            batteryLogs.setDuration(3);
            batteryLogs.setSlot(4);
            batteryLogs.setSwappedTime(new Date());*/
            batteryLogRepository.save(batteryLogs);

            System.out.println("Added BatteryLog Data:" + batteryLogs);

        }else{
            System.out.println("No BatteryLogs records found.");
        }

    }

}
