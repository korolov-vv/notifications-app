package ua.goit.goitnotes.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userServiceDetails")
public class GoITNotesUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public GoITNotesUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final User user = userRepository.findByName(userName).orElseThrow(() ->
                new UsernameNotFoundException(String.format("user with username %s not exists", username)));
        return new UserPrincipal(user);
    }
}
