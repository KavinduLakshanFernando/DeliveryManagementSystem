package org.example.delivermanagementsystem.service.impl;

import org.example.delivermanagementsystem.dto.RequestDTO;
import org.example.delivermanagementsystem.repo.RequestRepository;
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
    private ModelMapper modelMapper;


    public List<Object[]>getRequest(){
        return modelMapper.map(requestRepository.findRequestsWithUsernames(),new TypeToken<List<Object[]>>(){}.getType());
    }

}
