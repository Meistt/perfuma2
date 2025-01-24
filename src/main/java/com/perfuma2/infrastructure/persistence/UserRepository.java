package com.perfuma2.infrastructure.persistence;

import com.perfuma2.domain.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findeByEmail(String email);
}
