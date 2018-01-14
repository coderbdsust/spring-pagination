package com.learn.pageang.repository;

import com.learn.pageang.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User,Long> {

}
