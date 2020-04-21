package com.lonxinwu.db.dao;

import com.lonxinwu.db.domain.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}