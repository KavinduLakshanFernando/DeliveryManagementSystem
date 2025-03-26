package org.example.delivermanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import org.example.delivermanagementsystem.dto.RequestDTO;
import org.example.delivermanagementsystem.entity.Driver;
import org.example.delivermanagementsystem.entity.Request;
import org.example.delivermanagementsystem.entity.User;
import org.example.delivermanagementsystem.repo.RequestRepository;
import org.example.delivermanagementsystem.repo.UserRepository;
import org.example.delivermanagementsystem.service.RequestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {


    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<Object[]>getRequest(){
        return modelMapper.map(requestRepository.findRequestsWithUsernames(),new TypeToken<List<Object[]>>(){}.getType());
    }

    public String updateReqStatus(Long reqId) {
        try {
            requestRepository.updateRequestStatus(reqId);

            Request request = requestRepository.findById(reqId)
                    .orElseThrow(() -> new RuntimeException("Request not found after update"));

            if ("approved".equalsIgnoreCase(request.getStatus())) {
                Driver driver = request.getDriver();
                if (driver != null) {
                    User user = driver.getUser();
                    if (user != null) {
                        user.setRole("Driver");
                        userRepository.save(user);
                    }
                }
            }
            return "Status updated successfully!";
        } catch (Exception e) {
            return "Failed to update status: " + e.getMessage();
        }
    }


}
