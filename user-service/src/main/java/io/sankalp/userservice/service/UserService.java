package io.sankalp.userservice.service;

import io.sankalp.userservice.dto.DepartmentDTO;
import io.sankalp.userservice.dto.ResponseDTO;
import io.sankalp.userservice.entity.User;
import io.sankalp.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final static String DEPARTMENT_SERVICE_URL = "http://DEPARTMENT-SERVICE/departments/";

    public User saveUser(User user) {
        log.info("Inside the saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseDTO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");
        ResponseDTO response = new ResponseDTO();

        User user = userRepository.findById(userId)
                                  .orElse(null);

        if (Objects.nonNull(user)) {
            DepartmentDTO department = restTemplate.getForObject(
                                        DEPARTMENT_SERVICE_URL + user.getDepartmentId(),
                                                DepartmentDTO.class);

            response.setDepartment(department);
            response.setUser(user);
        }

        return response;
    }
}
