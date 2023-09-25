package xtech.qrvenus.business.abstracts;

import xtech.qrvenus.business.requests.*;
import xtech.qrvenus.business.responses.LoginResponse;
import xtech.qrvenus.business.responses.GetAllUsersResponse;
import xtech.qrvenus.business.responses.GetByIdUserResponse;

import java.util.List;

public interface UserService {
    List<GetAllUsersResponse> getAll();

    GetByIdUserResponse getById(Integer id);

    void add(CreateUserRequest createUserRequest);

    void update(UpdateUserRequest updateUserRequest);

    void delete(Integer id);

    void register(RegisterRequest signUpRequest);
    LoginResponse login(LoginRequest loginRequest);
}
