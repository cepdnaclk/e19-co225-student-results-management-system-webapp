package com.academetrics.academetrics.Service;

import com.academetrics.academetrics.DTO.UserRegistrationDTO;
import com.academetrics.academetrics.Entity.Department;
import com.academetrics.academetrics.Entity.User;
import com.academetrics.academetrics.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academetrics.academetrics.DTO.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    public void saveUser(UserRegistrationDTO userRegistrationDTO) {
        // relations should be explicitly mapped or we get null values refer resource below
        // https://amydegregorio.com/2018/08/02/deep-mapping-with-modelmapper/
//        PropertyMap<UserRegistrationDTO, User> departmentIdMapping = new PropertyMap<UserRegistrationDTO, User>() {
//            protected void configure() {
//                map().getDepartment().setId(source.getDeptId());
//            }
//        };
//        TypeMap<UserRegistrationDTO, User> typeMap = modelMapper.getTypeMap(UserRegistrationDTO.class, User.class);
//        if (typeMap == null) { // if not already added
//            this.modelMapper.addMappings(departmentIdMapping);
//        }
        userRepository.save(userRegistrationDTOToEntity(userRegistrationDTO));
//        return userRegistrationDTO;
    }

    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();

        for (User user: userList) {
            userDTOList.add(userEntityToDTO(user));
        }

        return userDTOList;
    }

    public UserDTO getUser(String userName) {
        User user = new User();
        user = userRepository.findById(userName).orElse(null);
        return userEntityToDTO(user);
    }

    public UserRegistrationDTO getUserRegistration(String userName){
        User user = new User();
        user = userRepository.findById(userName).orElse(null);
        return userEntityToRegistrationDTO(user);
    }

    public UserDTO userEntityToDTO(User user){
        if (user == null) return null;

        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setMail(user.getMail());
        userDTO.setHonorific(user.getHonorific());
        userDTO.setInitials(user.getInitials());
        userDTO.setLastName(user.getLastName());
        userDTO.setRole(user.getRole());
        userDTO.setContact(user.getContact());
        if (user.getDepartment() == null){
            userDTO.setDeptId("");
            userDTO.setDeptName("");
        }else {
            userDTO.setDeptId(user.getDepartment().getId());
            userDTO.setDeptName(user.getDepartment().getName());
        }
        userDTO.setProfilePicture(user.getProfilePicture());
        return userDTO;
    }

    public UserRegistrationDTO userEntityToRegistrationDTO(User user){
        if (user == null) return null;

        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        userRegistrationDTO.setUserName(user.getUserName());
        userRegistrationDTO.setPassword(user.getPassword());
        userRegistrationDTO.setMail(user.getMail());
        userRegistrationDTO.setHonorific(user.getHonorific());
        userRegistrationDTO.setInitials(user.getInitials());
        userRegistrationDTO.setLastName(user.getLastName());
        userRegistrationDTO.setRole(user.getRole());
        userRegistrationDTO.setContact(user.getContact());
        if (user.getDepartment() == null){
            userRegistrationDTO.setDeptId("");
            userRegistrationDTO.setDeptName("");
        }else {
            userRegistrationDTO.setDeptId(user.getDepartment().getId());
            userRegistrationDTO.setDeptName(user.getDepartment().getName());
        }
        userRegistrationDTO.setProfilePicture(user.getProfilePicture());
        return userRegistrationDTO;
    }

    public User userRegistrationDTOToEntity(UserRegistrationDTO userRegistrationDTO){
        User user = new User();
        user.setUserName(userRegistrationDTO.getUserName());
        user.setPassword(userRegistrationDTO.getPassword());
        user.setMail(userRegistrationDTO.getMail());
        user.setHonorific(userRegistrationDTO.getHonorific());
        user.setInitials(userRegistrationDTO.getInitials());
        user.setLastName(userRegistrationDTO.getLastName());
        user.setRole(userRegistrationDTO.getRole());
        user.setContact(userRegistrationDTO.getContact());
        if (!userRegistrationDTO.getDeptId().equals("")){
            Department department = new Department();
            department.setId(userRegistrationDTO.getDeptId());
            department.setName(userRegistrationDTO.getDeptName());
        }
        userRegistrationDTO.setProfilePicture(user.getProfilePicture());
        return user;
    }

    public boolean deleteUser(String id){
        userRepository.deleteById(id);
        return true;
    }

//    public UserRegistrationDTO getUserFromUserName(String userName){
//        List<User> users = userRepository.getUserFromUserName(userName);
//
//        if (users.isEmpty()) return null;
//
//        // setup
//        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
//
//        return modelMapper.map(users.get(0), UserRegistrationDTO.class);
//    }
}
