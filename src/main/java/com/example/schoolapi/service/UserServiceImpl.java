package com.example.schoolapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.schoolapi.dto.LoginRequest;
import com.example.schoolapi.dto.RoleDto;
import com.example.schoolapi.dto.UserDto;
import com.example.schoolapi.model.Role;
import com.example.schoolapi.model.User;
import com.example.schoolapi.model.UserRole;
import com.example.schoolapi.repository.RoleRepository;
import com.example.schoolapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto signup(UserDto userDto) {

        Role userRole = roleRepository.findByRole(UserRole.STUDENT);;
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if (!user.isPresent()) {
            String role = userDto.getRoles().get(0).getRole();
            if (role.equals("PARENTS")) {
                userRole = roleRepository.findByRole(UserRole.PARENTS);
            } 
            if (role.equals("TEACHER")) {
                userRole = roleRepository.findByRole(UserRole.TEACHER);
            }

            User newuser = new User().setEmail(userDto.getEmail())
                    .setPassword(passwordEncoder.encode(userDto.getPassword()))
                    .setRoles(Arrays.asList(userRole)).setStatus("active");
            userRepository.save(newuser);
            userDto.setPassword("");

        }
        
        return userDto;
    }

    @Override
    public UserDto findUserByEmail(String email) {

        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email).get());
        if (user.isPresent()) {
            return modelMapper.map((user.get()), UserDto.class);

        }

        return null;

    }

    @Override
    public UserDto login(LoginRequest loginDto) {
        User user = userRepository.findByEmail(loginDto.getUsername()).get();
        UserDto userDto = new UserDto();
        if (user != null) {
            Boolean checkPass = passwordEncoder.matches(loginDto.getPassword(), user.getPassword());
            if (checkPass) {
                List<RoleDto> roles = new ArrayList<>();
                user.getRoles().forEach(role -> {
                    RoleDto roleDto = new RoleDto().setRole(role.getRole().toString());
                    roles.add(roleDto);

                });
                userDto.setEmail(user.getEmail())
                        .setRoles(roles);

                return userDto;
            }

        }

        return userDto;

    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

}
