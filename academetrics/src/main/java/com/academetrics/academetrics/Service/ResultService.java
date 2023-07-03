package com.academetrics.academetrics.Service;

import com.academetrics.academetrics.DTO.ResultDTO;
import com.academetrics.academetrics.Entity.Result;
import com.academetrics.academetrics.Repository.ResultRepository;
import com.academetrics.academetrics.Util.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public void saveResultsFromCSV(MultipartFile csvFile) throws IOException {
        List<ResultDTO> resultDTOs = CSVParser.parseCSV(csvFile);
        List<Result> results = convertDTOsToEntities(resultDTOs);
        resultRepository.saveAll(results);
    }

    private List<Result> convertDTOsToEntities(List<ResultDTO> resultDTOs) {
        List<Result> results = new ArrayList<>();

        for (ResultDTO resultDTO : resultDTOs) {
            Result result = new Result();
            result.setRegNo(resultDTO.getRegNo());
//            result.setGrade(resultDTO.getGrade());


            results.add(result);
        }

        return results;
    }


    public void saveResult(ResultDTO resultDTO) {
        // Convert ResultDTO to Result entity
        Result result = convertDTOToEntity(resultDTO);

        // Save the Result entity using the repository
        resultRepository.save(result);
    }

    private Result convertDTOToEntity(ResultDTO resultDTO) {
        Result result = new Result();
        result.setRegNo(resultDTO.getRegNo());

        return result;
    }


}