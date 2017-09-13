package test.hexagonal.core.usecases.crud;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.Test;

import test.hexagonal.core.model.ImmutableUser;
import test.hexagonal.core.model.ImmutableUserID;
import test.hexagonal.core.model.User;
import test.hexagonal.core.model.UserID;
import usecases.crud.requests.ImmutableUserCreateRequest;

public class UserCreateRequestTest {

	@Test
	public void testUserCreateRequest() {
		final UserID userID = ImmutableUserID.builder()
				.value(Long.valueOf(1))
				.build();
		final String username = "username";
		final String password = "password";
		final String email = "email";
		final User user = ImmutableUser.builder()
				.userID(userID)
				.username(username)
				.password(password)
				.email(email)
				.build();
		final UserCreateRequest userCreateRequest = ImmutableUserCreateRequest.builder()
				.user(user)
				.build();
		assertThat(userCreateRequest, hasProperty("user", equalTo(user)));
		assertThat(userCreateRequest.toString(), equalTo("UserCreateRequest{user=User{userID=UserID{value=1}, username=username, password=password, email=email}}"));
	}

}
