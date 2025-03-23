package org.example.delivermanagementsystem.controller;

import org.example.delivermanagementsystem.dto.RequestDTO;
import org.example.delivermanagementsystem.service.impl.RequestServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:63342/")
@RestController
@RequestMapping("api/vi/request")
public class RequestController {
    private final RequestServiceImpl requestService;

    public RequestController(RequestServiceImpl requestService) {
        this.requestService = requestService;
    }

    @GetMapping("getRequest")
    public List<RequestDTO> getRequest(){
        RequestDTO requestDTO = new RequestDTO();
        System.out.println(requestDTO);
        List<Object[]> results = requestService.getRequest();
        return results.stream().map(row -> {
            String username = (String) row[0];   // username
            Long reqId = ((Number) row[1]).longValue(); // req_id (converted to Long)
            String status = (String) row[2];     // status

            return new RequestDTO(reqId, status, username);
        }).collect(Collectors.toList());

    }
}
