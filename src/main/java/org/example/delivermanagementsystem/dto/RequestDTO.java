package org.example.delivermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDTO {
    private Long reqId;
    private String status;
    private String username;

}
