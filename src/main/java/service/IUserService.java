package service;

import model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IUserService {

    Page<User> findAll(Pageable pageable);

    User saveOrUpdate(User user);

    void delete(User user);

    void delete(Long userId);

    User findById(Long userId);
}
