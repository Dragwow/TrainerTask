package com.yumimi.repository;

import com.yumimi.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<Users>{

    List<Users> findByCompanyId( Long companyId);
}
