package spring_team4.spring_team4.user.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
  private Long userId;
  private String email;
  private String username;
}
