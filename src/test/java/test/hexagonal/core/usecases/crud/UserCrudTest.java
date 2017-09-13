package test.hexagonal.core.usecases.crud;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.Test;
import org.mockito.Mockito;

import test.hexagonal.core.model.ImmutableUser;
import test.hexagonal.core.model.ImmutableUserID;
import test.hexagonal.core.model.User;
import test.hexagonal.core.model.UserID;
import test.hexagonal.core.model.UserRepository;
import usecases.crud.requests.ImmutableUserCreateRequest;

public class UserCrudTest {
	@Test
	public void testCreate() throws Exception {
		final UserRepository userRepository = Mockito.mock(UserRepository.class);
		Mockito.when(userRepository.save(userWithoutUserId())).thenReturn(defaultUser());
		final UserCreateRequest userCreateRequest = userCreateRequestWithoutUserId();
		final UserCrud userCrud = new UserCrud(userRepository);
		
		final UserCreateResponse userCreateResponse = userCrud.create(userCreateRequest);
		assertThat(userCreateResponse, hasProperty("user", equalTo(defaultUser())));
	}
	private User defaultUser() {
		final UserID userID = ImmutableUserID.builder()
				.value(Long.valueOf(1))
				.build();
		final String username = "username";
		final String password = "password";
		final String email = "email";
		final User result = ImmutableUser.builder()
				.userID(userID)
				.username(username)
				.password(password)
				.email(email)
				.build();
		return result;
	}
	private UserCreateRequest userCreateRequestWithoutUserId() {
		final User userWithoutUserId = userWithoutUserId();
		final UserCreateRequest result = ImmutableUserCreateRequest.builder()
				.user(userWithoutUserId)
				.build();
		return result;
	}
	private User userWithoutUserId() {
		final String username = "username";
		final String password = "password";
		final String email = "email";
		final User result = ImmutableUser.builder()
				.username(username)
				.password(password)
				.email(email)
				.build();
		return result;
	}

}
