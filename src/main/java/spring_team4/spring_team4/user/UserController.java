package spring_team4.spring_team4.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    // 유저 출력
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserResponse> getUsers(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    // 유저 생성
    @PostMapping("/user")
    public ResponseEntity<UserResponse> getUsers(@RequestBody UserRequest dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    // 유저 수정
    @PutMapping("/user/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long userId,
                                                   @RequestBody UserRequest dto) {
        dto.setUserId(userId);
        return ResponseEntity.ok(userService.updateUser(dto));
    }

    // 유저 삭제
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("삭제 완료");
    }
}
