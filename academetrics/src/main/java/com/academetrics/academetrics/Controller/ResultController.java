package com.academetrics.academetrics.Controller;

import  com.academetrics.academetrics.Service.ResultService;
import com.academetrics.academetrics.DTO.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {
    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/results")
    public void saveResult(@RequestBody ResultDTO resultDTO) {
        resultService.saveResult(resultDTO);
    }
}
