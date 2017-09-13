package test.hexagonal.core.usecases.crud;

import javax.inject.Inject;

import test.hexagonal.core.model.User;
import test.hexagonal.core.model.UserRepository;
import usecases.crud.responses.ImmutableUserCreateResponse;

public class UserCrud implements UserCrudPort {
	private final UserRepository userRepository;
	@Inject public UserCrud(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserCreateResponse create(UserCreateRequest ucr) {
		final User user = userRepository.save(ucr.getUser());
		final UserCreateResponse result = ImmutableUserCreateResponse.builder()
				.user(user)
				.build();
		ImmutableUserCreateResponse.copyOf(result).withUser(null);
		return result;
	}

	
}
