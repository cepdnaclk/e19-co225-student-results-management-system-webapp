package com.academetrics.academetrics.Util;



import com.academetrics.academetrics.DTO.ResultDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static List<ResultDTO> parseCSV(MultipartFile file) throws IOException {
        List<ResultDTO> results = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 2) {
                ResultDTO resultDTO = new ResultDTO();
                resultDTO.setRegNo(data[0].trim());
                resultDTO.setGrade(data[1].trim());
                results.add(resultDTO);
            }
        }
        return results;
    }
}
