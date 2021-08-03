package springBootInitialDemo.repository;

import springBootInitialDemo.dto.ResponseDto;

public interface IRepository {

    public ResponseDto getUser(String uuid);
}
