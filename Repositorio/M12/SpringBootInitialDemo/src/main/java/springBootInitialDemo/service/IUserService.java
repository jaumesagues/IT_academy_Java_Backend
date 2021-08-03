package springBootInitialDemo.service;

import springBootInitialDemo.dto.UserResponseDto;

public interface IUserService {

    UserResponseDto getUser(String uuid);
}
