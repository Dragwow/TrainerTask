package com.yumimi.service;

import com.yumimi.entity.Users;

import java.util.List;

public interface UserService extends CrudService<Users>{

    List<Users> listByCompanyId(Long companyId);
}
