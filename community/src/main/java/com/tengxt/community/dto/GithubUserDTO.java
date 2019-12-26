package com.tengxt.community.dto;

import lombok.Data;

@Data
public class GithubUserDTO {
    private Long id;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String bio;
    private String avatarUrl;
}
