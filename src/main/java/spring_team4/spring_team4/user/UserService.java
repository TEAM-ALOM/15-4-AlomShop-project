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

    return UserResponse.from(user);
  }

  public UserResponse createUser(UserRequest dto) {
    User user = User.builder()
            .userId(dto.getUserId())
            .email(dto.getEmail())
            .username(dto.getUsername())
            .build();

    return UserResponse.from(
            userRepository.save(user)
    );
  }

  public UserResponse updateUser(UserRequest dto){
    User user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new RuntimeException("user not found"));
    user.setEmail(dto.getEmail());
    user.setUsername(dto.getUsername());

    return UserResponse.from(
            userRepository.save(user)
    );
  }

  public void deleteUser(Long id) {
    User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("user not found"));
    userRepository.delete(user);
  }
}
