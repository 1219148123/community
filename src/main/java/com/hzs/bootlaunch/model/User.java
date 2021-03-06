package com.hzs.bootlaunch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private String bio;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
