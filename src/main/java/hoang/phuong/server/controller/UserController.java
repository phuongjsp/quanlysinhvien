package hoang.phuong.server.controller;

import hoang.phuong.server.model.Activeuser;
import hoang.phuong.server.model.User;
import hoang.phuong.server.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getOne(@PathVariable Integer id) {
        return userService.getOne(id);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void ConfirmEmail(@RequestBody Activeuser activeuser) {
        userService.confirmUser(activeuser);
    }

    @PostMapping(value = "/{keyCode}")
    @ResponseStatus(HttpStatus.CREATED)
    public User CreateUser(@PathVariable(value = "keyCode") String keyCode
            , @RequestParam(value = "password") String password) {
        if (userService.isActiveUser(keyCode) == null) {
            return new User();
        }
        User user = userService.isActiveUser(keyCode);
        user.setPassword(password);
        return userService.save(user);
    }
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User update(@PathVariable Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void resetPassword(@RequestParam(value = "email") String email) {
        userService.resetPassword(email);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePassword(@PathVariable Integer id,
                               @RequestParam(value = "currentPassword") String currentPassword,
                               @RequestParam(value = "newPassword") String newPassword) {
        userService.updatePassword(id, currentPassword, newPassword);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id,
                       @RequestParam(value = "password") String password) {
        userService.delete(id, password);
    }

}