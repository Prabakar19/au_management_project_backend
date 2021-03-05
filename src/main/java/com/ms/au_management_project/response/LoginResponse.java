package com.ms.au_management_project.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LoginResponse {
    private boolean isValid;
    private String message;
    private Integer managerId;

    private String managerName;

    private String emailId;

    private String password;


    public LoginResponse(boolean isValid, String message, Integer managerId, String managerName, String emailId, String password) {
        this.isValid = isValid;
        this.message = message;
        this.managerId = managerId;
        this.managerName = managerName;
        this.emailId = emailId;
        this.password = password;
    }
}
