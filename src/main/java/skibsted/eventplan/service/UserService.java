package skibsted.eventplan.service;

import org.springframework.stereotype.Service;
import skibsted.eventplan.model.User;
import skibsted.eventplan.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUserService{

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public Set<User> findAll() {
        Set<User> set = new HashSet<>();
        userRepository.findAll().forEach(set::add);
        return null;
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }
}
