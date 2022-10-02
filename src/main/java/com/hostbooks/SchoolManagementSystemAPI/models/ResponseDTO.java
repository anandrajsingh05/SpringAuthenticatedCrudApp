package com.hostbooks.SchoolManagementSystemAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {
    private LocalDateTime timestamp;
    private Object data;
    private HttpStatus message;
    private Integer statusCode;
    private Object errors;

    public static ResponseDTO getResponseObj(Object obj, LocalDateTime time, HttpStatus message, Integer status,Object errors ){
            ResponseDTO rDTO= new ResponseDTO();
            rDTO.setTimestamp(time);
            rDTO.setData(obj);
            rDTO.setMessage(message);
            rDTO.setStatusCode(status);
            rDTO.setErrors(errors);
            return rDTO;
    }

}
