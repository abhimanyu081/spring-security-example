package dev.abhi.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<TableUser> userOptional = userRepository.findByUsername(userName);
		userOptional.orElseThrow(() -> new UsernameNotFoundException(" User Not Found : " + userName));
		return userOptional.map(MyUserDetails::new).get();
	}

}
