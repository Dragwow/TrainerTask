package com.yumimi.db.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
}
