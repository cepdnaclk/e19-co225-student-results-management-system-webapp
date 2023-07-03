package com.academetrics.academetrics.Controller;

import  com.academetrics.academetrics.Service.ResultService;
import com.academetrics.academetrics.DTO.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ResultController {
    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/results")
    public ResponseEntity saveResultsFromCSV(@RequestParam MultipartFile file) {
        try{
            resultService.saveResultsFromCSV(file);
            return new ResponseEntity("Done", HttpStatus.OK);
        }
        catch(Exception exp){
            return new ResponseEntity("Error with file", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
    }
}
