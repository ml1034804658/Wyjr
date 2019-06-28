package com.jr.server.user.service;

import com.jr.common.exception.UserException;
import com.jr.common.vo.R;
import com.jr.entity.Tb_User;

public interface Tb_UserService {

    R save(Tb_User user) throws UserException;

    R all();
}
