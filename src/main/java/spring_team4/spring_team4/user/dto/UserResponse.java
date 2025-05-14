package spring_team4.spring_team4.user.dto;

import lombok.*;
import spring_team4.spring_team4.user.User;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
public class UserResponse {

  private Long userId;
  private String email;
  private String username;

  public static UserResponse from(User user) {
    return UserResponse.builder()
            .userId(user.getUserId())
            .email(user.getEmail())
            .username(user.getUsername())
            .build();
  }
}