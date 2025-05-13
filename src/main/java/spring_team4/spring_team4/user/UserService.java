package spring_team4.spring_team4.user;


import spring_team4.spring_team4.user.dto.UserRequest;
import spring_team4.spring_team4.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserResponse getUserById(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("user not found"));

    UserResponse userResponse = new UserResponse();
    userResponse.setUserId(user.getUserId());
    userResponse.setUsername(user.getUsername());
    userResponse.setEmail(user.getEmail());

    return userResponse;
  }

  public UserResponse createUser(UserRequest dto) {
    User user1 = new User();
    user1.setUsername(dto.getUsername());
    user1.setEmail(dto.getEmail());
    userRepository.save(user1);
    UserResponse createResponse = new UserResponse();
    createResponse.setUserId(user1.getUserId());
    createResponse.setUsername(user1.getUsername());
    createResponse.setEmail(user1.getEmail());
    return createResponse;
  }
}
