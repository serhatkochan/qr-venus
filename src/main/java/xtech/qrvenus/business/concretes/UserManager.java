package xtech.qrvenus.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xtech.qrvenus.business.abstracts.UserService;
import xtech.qrvenus.business.enums.Role;
import xtech.qrvenus.business.requests.*;
import xtech.qrvenus.business.responses.LoginResponse;
import xtech.qrvenus.business.responses.GetAllUsersResponse;
import xtech.qrvenus.business.responses.GetByIdUserResponse;
import xtech.qrvenus.business.rules.UserBusinessRules;
import xtech.qrvenus.core.utilities.mappers.ModelMapperService;
import xtech.qrvenus.core.utilities.security.JwtService;
import xtech.qrvenus.dataAccess.abstracts.UserRepository;
import xtech.qrvenus.entities.concretes.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private ModelMapperService modelMapperService;
    private UserRepository userRepository;
    private UserBusinessRules userBusinessRules;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = userRepository.findAllByOrderByIdAsc();
        List<GetAllUsersResponse> getAllUsersResponse = users.stream()
                .map(user -> modelMapperService.forResponse()
                        .map(user, GetAllUsersResponse.class))
                .collect(Collectors.toList());
        return getAllUsersResponse;
    }

    @Override
    public GetByIdUserResponse getById(Integer id) {
        Optional<User> user = userRepository.findById(id); // bulamazsa orElseThrow veya Optional yapacaz

        GetByIdUserResponse getByIdUserResponse = modelMapperService.forResponse()
                .map(user, GetByIdUserResponse.class);
        return getByIdUserResponse;
    }

    @Override
    public void add(CreateUserRequest createUserRequest) {
        // businessRule
        userBusinessRules.checkIfUserPhoneNumberExists(createUserRequest.getPhoneNumber());

        User user = modelMapperService.forRequest().map(createUserRequest, User.class);
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        // businessRule
        userBusinessRules.checkIfUserIdAndUserPhoneNumberExists(updateUserRequest.getId(), updateUserRequest.getPhoneNumber());

        User user = modelMapperService.forRequest().map(updateUserRequest, User.class);
        user.setPassword(passwordEncoder.encode(updateUserRequest.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void register(RegisterRequest signUpRequest) {
        userBusinessRules.checkIfUserPhoneNumberExists(signUpRequest.getPhoneNumber());

        User user = modelMapperService.forRequest().map(signUpRequest, User.class);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getPhoneNumber(),
                        loginRequest.getPassword()
                )
        );
        var user  = userRepository.findByPhoneNumber(loginRequest.getPhoneNumber()); // orElseThrow var
        var jwtToken = jwtService.generateToken(user);

        LoginResponse loginResponse = modelMapperService.forResponse()
                .map(user, LoginResponse.class);
        loginResponse.setToken(jwtToken);
        return loginResponse;
    }
}
