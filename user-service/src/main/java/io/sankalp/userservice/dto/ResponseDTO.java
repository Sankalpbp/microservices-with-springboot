package io.sankalp.userservice.dto;

import io.sankalp.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private User user;

    private DepartmentDTO department;
}
