package org.edu.vsu.service;

import org.edu.vsu.entity.User;

public interface UserService extends GenericService<User, Long> {

    User findByName(String name);

}
