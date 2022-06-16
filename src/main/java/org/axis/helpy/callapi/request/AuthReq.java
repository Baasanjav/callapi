package org.axis.helpy.callapi.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AuthReq {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
