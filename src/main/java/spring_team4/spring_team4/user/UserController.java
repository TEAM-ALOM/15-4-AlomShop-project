package spring_team4.spring_team4.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_team4.spring_team4.user.dto.UserRequest;
import spring_team4.spring_team4.user.dto.UserResponse;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController{

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //URI 경로
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest dto) {
        System.out.println("여기 들어옴");
        return ResponseEntity.ok(userService.createUser(dto));
    }
}
