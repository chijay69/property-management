package com.mycompany.propertymanagement.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PropertyDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String address;
}
