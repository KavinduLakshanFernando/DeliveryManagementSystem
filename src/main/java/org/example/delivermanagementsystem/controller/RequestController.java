package org.example.delivermanagementsystem.controller;

import org.example.delivermanagementsystem.dto.RequestDTO;
import org.example.delivermanagementsystem.service.RequestService;
import org.example.delivermanagementsystem.service.impl.RequestServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:63342/")
@RestController
@RequestMapping("api/v1/request")
public class RequestController {
    private final RequestServiceImpl requestService;
    private final RequestService requestServices;
    public RequestController(RequestServiceImpl requestService, RequestService requestServices) {
        this.requestService = requestService;
        this.requestServices = requestServices;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("getRequest")
    public List<RequestDTO> getRequest(){
        RequestDTO requestDTO = new RequestDTO();
        System.out.println(requestDTO);
        List<Object[]> results = requestService.getRequest();
        return results.stream().map(row -> {
            String username = (String) row[0];
            Long reqId = ((Number) row[1]).longValue();
            String status = (String) row[2];

            return new RequestDTO(reqId, status, username);
        }).collect(Collectors.toList());

    }

    @PutMapping("/updateStatus")
    public ResponseEntity<String> updateStatus(@RequestParam Long reqId) {
        if (reqId == null) {
            return ResponseEntity.badRequest().body("Missing request parameter: reqId");
        }

        String response = requestService.updateReqStatus(reqId);
        return ResponseEntity.ok(response);


    }

}
