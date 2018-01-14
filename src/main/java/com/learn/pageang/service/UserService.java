package com.learn.pageang.service;

import com.learn.pageang.model.Address;
import com.learn.pageang.model.User;
import com.learn.pageang.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.learn.pageang.repository.UserRepository;

import javax.transaction.Transactional;


@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    private AddressRepository addressRepository;


    @Autowired
    private void setUserRepository(UserRepository userRepository){
        Assert.notNull(userRepository);
        this.userRepository=userRepository;
    }

    @Autowired
    private void setAddressRepository(AddressRepository addressRepository){
        Assert.notNull(addressRepository);
        this.addressRepository=addressRepository;
    }

    @Override
    public Page<User> findAll(PageRequest pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public User saveOrUpdate(User user) {
        User saveUser=userRepository.save(user);
        Address homeAddress = addressRepository.save(saveUser.getHomeAddress());
        Address permanentAddress= addressRepository.save(saveUser.getPermanentAddress());
        Address officialAddress=addressRepository.save(saveUser.getOfficialAddress());
        saveUser.setHomeAddress(homeAddress);
        saveUser.setPermanentAddress(permanentAddress);
        saveUser.setOfficialAddress(officialAddress);
        return saveUser;
    }

    @Override
    public void delete(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public void delete(Long userId) {
        this.userRepository.delete(userId);
    }

    @Override
    public User findById(Long userId) {
        return this.userRepository.findOne(userId);
    }
}
