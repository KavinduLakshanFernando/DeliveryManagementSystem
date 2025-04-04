package org.example.delivermanagementsystem.service.impl;

import org.example.delivermanagementsystem.dto.DriverDTO;
import org.example.delivermanagementsystem.dto.VehicleDTO;
import org.example.delivermanagementsystem.dto.WrapperDTO;
import org.example.delivermanagementsystem.entity.Driver;
import org.example.delivermanagementsystem.entity.Request;
import org.example.delivermanagementsystem.entity.User;
import org.example.delivermanagementsystem.entity.Vehicle;
import org.example.delivermanagementsystem.repo.DriverRepository;
import org.example.delivermanagementsystem.repo.RequestRepository;
import org.example.delivermanagementsystem.repo.UserRepository;
import org.example.delivermanagementsystem.repo.VehicleRepository;
import org.example.delivermanagementsystem.service.DriverService;
import org.example.delivermanagementsystem.utill.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public int saveDriver(WrapperDTO wrapperDTO) {
        System.out.println(wrapperDTO.getEmail());
        DriverDTO driverDTO = wrapperDTO.getDriver();
        User user = userRepository.findByEmail(wrapperDTO.getEmail());
        Driver driver = new Driver(driverDTO.getLicencenumber(),
                driverDTO.getExpirydate(),
                driverDTO.getLicenceimg(),
                "pending",
                user
        );
        driverRepository.save(driver);

        VehicleDTO vehicleDTO = wrapperDTO.getVehicle();
        long id =driver.getDriverId();
        System.out.println(" driver ID : "+id);
        Driver driver1 = driverRepository.findById(id).orElse(null);
        Vehicle vehicle = new Vehicle(
                vehicleDTO.getVehicleModel(),
                vehicleDTO.getVehicleyear(),
                vehicleDTO.getVehicleNumber(),
                vehicleDTO.getInshuarnceCompany(),
                vehicleDTO.getVehicleimg(),
                "pending",
                driver1
        );
        vehicleRepository.save(vehicle);

        Request request = new Request(
                "pending",
                driver1
        );
        requestRepository.save(request);
        return VarList.Created;
    }


}
