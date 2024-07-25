package com.prueba.nisum.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.nisum.entity.Phone;
import com.prueba.nisum.entity.User;
import com.prueba.nisum.model.PhoneDto;
import com.prueba.nisum.model.UserDto;
import com.prueba.nisum.model.UserResponseDto;
import com.prueba.nisum.repository.PhoneRepository;
import com.prueba.nisum.repository.UserRepository;
import com.prueba.nisum.service.IUser;

@Service
public class UserImpl implements IUser {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PhoneRepository phoneRepository;
	
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public UserResponseDto createUser(UserDto userDto) {
		UserResponseDto userResponse = new UserResponseDto();
		boolean mailValido = validateEmail(userDto.getEmail());
		
		if (mailValido != true) {
			userResponse.setMensaje("formato de correcto incorrecto.");
			return userResponse;
		}
		else {
			List<User> listaMailUsuarios = userRepository.findByEmail(userDto.getEmail());

			if (listaMailUsuarios.isEmpty()) {
				User user = MapperUser(userDto);
				userRepository.save(user);
				PersistPhones(userDto, user);
				return MapperUserResponse(user);
			} else {
				userResponse.setMensaje("El correo ya registrado.");
			}
		}
		
		List<User> listaUsuarios = userRepository.findAll();
		return userResponse;
	}

	private static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
	
	private User MapperUser(UserDto userDto) {
		User user = new User();

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setCreatedDate(new Date());
		user.setModifiedDate(new Date());
		user.setLastLogin(new Date());
		user.setIsactive(true);
		user.setToken(userDto.getToken());

		return user;
	}
	
	private void PersistPhones(UserDto userDto, User user) {
		
		for (PhoneDto phoneAux: userDto.getPhones()) {
			Phone phone = new Phone();
			phone.setNumber(phoneAux.getNumber());
			phone.setCitycode(phoneAux.getCitycode());
			phone.setContrycode(phoneAux.getContrycode());
			phone.setUser(user);
			
			phoneRepository.save(phone);
		}
	}
	
	private UserResponseDto MapperUserResponse(User user) {
		UserResponseDto userResponse = new UserResponseDto();

		userResponse.setName(user.getName());
		userResponse.setId(user.getId());
		userResponse.setCreated(format.format(user.getCreatedDate()));
		userResponse.setModified(format.format(user.getModifiedDate()));
		userResponse.setLastLogin(format.format(user.getLastLogin()));
		userResponse.setIsactive(user.getIsactive());
		userResponse.setToken(user.getToken());

		return userResponse;
	}
}
