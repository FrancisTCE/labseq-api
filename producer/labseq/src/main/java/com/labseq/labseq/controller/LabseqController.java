package com.labseq.labseq.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.labseq.labseq.services.LabseqService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping(value = "labseq", produces = {"application/json"})
@Tag(name = "Labseq Controller")
public class LabseqController {

   
    @Operation(summary = "Calculates labseq to a given N", description = "Returns labseq value. n < 4 : if(n <= 3) return (n % 2 == 0) ? 0 : 1 else recurs labSeq(n - 4) + labSeq(n - 3) ")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully calculated"), 
        @ApiResponse(responseCode = "400", description = "N is an invalid Integer"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error returning the calculated value"),
    })
    @GetMapping(value = "{n}")
    @ResponseBody
    public ResponseEntity<String> labseq(
                                        @PathVariable int n
                                        ){
    
        HashMap<String, Object> res = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        if(n < 0 ){
            return new ResponseEntity<String>("Invalid value for labseq.", HttpStatus.resolve(400));
        }
        
        try {
            LabseqService labseqService = new LabseqService();
            long startTime = System.nanoTime();
            res.put("N", labseqService.labSeq(n));
            long endTime   = System.nanoTime();
            res.put("processingTime (ns)", endTime - startTime);
            return new ResponseEntity<String>(
                mapper.writeValueAsString(res), 
                HttpStatus.resolve(200)
                );

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Probably log this...");
            return new ResponseEntity<String>(
                "Ops something went wrong...",
                HttpStatus.resolve(500));
        }
    }
    
    
}
