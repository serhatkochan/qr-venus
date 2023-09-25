package xtech.qrvenus.webApi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xtech.qrvenus.business.abstracts.UserService;
import xtech.qrvenus.business.requests.CreateUserRequest;
import xtech.qrvenus.business.requests.UpdateUserRequest;
import xtech.qrvenus.business.responses.GetAllUsersResponse;
import xtech.qrvenus.business.responses.GetByIdUserResponse;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
@CrossOrigin
public class UsersController {
    private UserService userService;

    @GetMapping("")
    public List<GetAllUsersResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdUserResponse getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateUserRequest createUserRequest) {
        userService.add(createUserRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateUserRequest updateUserRequest) {
        userService.update(updateUserRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
