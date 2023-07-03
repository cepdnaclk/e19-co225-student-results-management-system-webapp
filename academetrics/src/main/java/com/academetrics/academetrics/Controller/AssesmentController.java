package com.academetrics.academetrics.Controller;

import com.academetrics.academetrics.DTO.AssesmentDTO;
import com.academetrics.academetrics.Entity.Assesment;
import com.academetrics.academetrics.Service.AssesmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/assesment")
@CrossOrigin
public class AssesmentController {

    @Autowired
    private AssesmentService assesmentService;

    // Insert new Assesment
    @PostMapping("/") // Map ONLY POST Requests
    public String addNewAssesment(@RequestBody AssesmentDTO assesmentDTO) {
        assesmentService.saveAssesment(assesmentDTO);
        return "Assesment Saved";
    }


    //  Show All Assesments
    @GetMapping("/") // Map only GET Requests
    public @ResponseBody Iterable<Assesment> getAllAssesments() {
        // Returns a JSON or XML with the assesments
        return assesmentService.getAllAssesments();
    }

    //  Update an Assesment
    @PutMapping("/") // Map only PUT Requests
    public String updateAssesment(@RequestBody AssesmentDTO assesmentDTO) {
        // Returns a JSON or XML with the assesments
        assesmentService.updateAssesment(assesmentDTO.getAssesId(), assesmentDTO);
        return "Assesment Updated";
    }

    // Delete an Assesment
    @DeleteMapping("/")
    public String deleteAssesment(@RequestParam Integer id) {
        assesmentService.deleteAssesment(id);
        return "Assesment Deleted Successfully";
    }
}
