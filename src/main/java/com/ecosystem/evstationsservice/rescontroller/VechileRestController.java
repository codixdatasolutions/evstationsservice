package com.ecosystem.evstationsservice.rescontroller;

import com.ecosystem.evstationsservice.constants.Constants;
import com.ecosystem.evstationsservice.dto.request.BaseLineDto;
import com.ecosystem.evstationsservice.dto.response.ResponseDto;
import com.ecosystem.evstationsservice.enums.Status;
import com.ecosystem.evstationsservice.service.BaseLineService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
//@CrossOrigin(origins = {"https://dinput-dev.verdanahosting.net/"})
@RestController
@RequestMapping("/api/v1/vehicles")
@Slf4j
public class VechileRestController {

    @Autowired
    BaseLineService projectService;

    @PostMapping("/addProject")
    private ResponseEntity<ResponseDto>  addProject(@RequestBody @Valid BaseLineDto dto)
    {
        this.projectService.addProject(dto);
        return  ResponseEntity.ok(new ResponseDto(Status.SUCCESS,null, Constants.PROJECT_ADDED));
    }

    @GetMapping("/status")
    private ResponseEntity<ResponseDto>  status()
    {
        return  ResponseEntity.ok(new ResponseDto(Status.SUCCESS,null, Constants.STATUS));
    }

}


