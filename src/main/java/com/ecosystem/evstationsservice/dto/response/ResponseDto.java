package com.ecosystem.evstationsservice.dto.response;

import com.ecosystem.evstationsservice.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDto {

    private Status success;

    private Object payload;
    private  String statusMessage;

}
