package springBootInitialDemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springBootInitialDemo.dto.ResponseDto;
import springBootInitialDemo.dto.UserResponseDto;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserRepository implements IRepository, JpaRepository {

    @Autowired
    private UserResponseDto userResponseDto;

    public UserResponseDto getUser (String uuid){
        userResponseDto.setName("Jonatan");
        userResponseDto.setSurname("Vicente");
        userResponseDto.setGender("Male");
        return userResponseDto;
    }


    @Override
    public List<ResponseDto> findAll(){
        return null;
    }

    @Override
    public List findAll(Sort sort) {
        return null;
    }

    @Override
    public List findAllById(Iterable iterable) {
        return null;
    }

    @Override
    public List saveAll(Iterable entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public Object saveAndFlush(Object entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Object getOne(Object o) {
        return null;
    }

    @Override
    public List findAll(Example example) {
        return null;
    }

    @Override
    public List findAll(Example example, Sort sort) {
        return null;
    }

    @Override
    public Page findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public Optional findById(Object o) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Object o) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Object o) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public void deleteAll(Iterable entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional findOne(Example example) {
        return Optional.empty();
    }

    @Override
    public Page findAll(Example example, Pageable pageable) {
        return null;
    }

    @Override
    public long count(Example example) {
        return 0;
    }

    @Override
    public boolean exists(Example example) {
        return false;
    }
}
