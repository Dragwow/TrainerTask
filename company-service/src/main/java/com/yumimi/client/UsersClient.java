package com.yumimi.client;

import com.yumimi.db.response.UsersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "user-service")
public interface UsersClient {

    @PostMapping("/api/users/batch")
    List<UsersResponse> getAllUsersById(@RequestBody List<Long> id);
}
