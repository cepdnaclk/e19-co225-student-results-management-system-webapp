package com.academetrics.academetrics.Service;

import com.academetrics.academetrics.DTO.UserRegistrationDTO;
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
        PropertyMap<UserRegistrationDTO, User> departmentIdMapping = new PropertyMap<UserRegistrationDTO, User>() {
            protected void configure() {
                map().getDepartment().setId(source.getDeptId());
            }
        };
        TypeMap<UserRegistrationDTO, User> typeMap = modelMapper.getTypeMap(UserRegistrationDTO.class, User.class);
        if (typeMap == null) { // if not already added
            this.modelMapper.addMappings(departmentIdMapping);
        }
        userRepository.save(modelMapper.map(userRegistrationDTO, User.class));
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

    public UserDTO getUser(int id) {
        User user = new User();
        user = userRepository.findById(id).orElse(null);
        return userEntityToDTO(user);
    }

    public UserDTO userEntityToDTO(User user){
        if (user == null) return null;

        // setup
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        UserDTO userDTO = new UserDTO();
        userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public boolean deleteUser(Integer id){
        userRepository.deleteById(id);
        return true;
    }

    public UserRegistrationDTO getUserFromUserName(String userName){
        List<User> users = userRepository.getUserFromUserName(userName);

        if (users.isEmpty()) return null;

        // setup
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        return modelMapper.map(users.get(0), UserRegistrationDTO.class);
    }
}
