package org.example.delivermanagementsystem.repo;

import org.example.delivermanagementsystem.dto.RequestDTO;
import org.example.delivermanagementsystem.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query(value = "SELECT u.username, r.req_id , r.status FROM request r JOIN driver d ON r.driver_driver_id = d.driver_id JOIN user u ON d.user_uid = u.uid", nativeQuery = true)
    List<Object[]> findRequestsWithUsernames();
}
