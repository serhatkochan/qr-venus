package xtech.qrvenus.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xtech.qrvenus.core.utilities.exceptions.BusinessException;
import xtech.qrvenus.dataAccess.abstracts.UserRepository;

@Service
@AllArgsConstructor
public class UserBusinessRules {
    private UserRepository userRepository;

    public void checkIfUserPhoneNumberExists(String phoneNumber) {
        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new BusinessException("Phone Number Already Exists");
        }
    }

    public void checkIfUserPhoneNumberNotExists(String phoneNumber) {
        if (!userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new BusinessException("Phone Number Not Exists: " + phoneNumber + ", " + userRepository.findByPhoneNumber(phoneNumber).getId());
        }
    }

    public void checkIfUserIdAndUserPhoneNumberExists(Integer id, String phoneNumber) {
        if (!userRepository.existsByIdAndPhoneNumber(id, phoneNumber)) {
            checkIfUserPhoneNumberExists(phoneNumber);
        }
    }
}
