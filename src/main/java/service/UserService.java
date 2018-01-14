package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.UserRepository;


@Service
public class UserService implements IUserService {

    UserRepository userRepository;

    @Autowired
    private void setUserRepository(UserRepository userRepository){
        Assert.notNull(userRepository);
        this.userRepository=userRepository;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
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
