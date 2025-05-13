package spring_team4.spring_team4.user.dto;

import lombok.*;
import spring_team4.spring_team4.user.User;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class UserResponse {

  private Long userId;
  private String email;
  private String username;



}