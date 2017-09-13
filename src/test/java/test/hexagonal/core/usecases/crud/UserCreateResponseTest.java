package test.hexagonal.core.usecases.crud;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.Test;

import test.hexagonal.core.model.ImmutableUser;
import test.hexagonal.core.model.ImmutableUserID;
import test.hexagonal.core.model.User;
import test.hexagonal.core.model.UserID;
import usecases.crud.responses.ImmutableUserCreateResponse;

public class UserCreateResponseTest {

	@Test
	public void testUserCreateResponse() {
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
		final UserCreateResponse userCreateResponse = ImmutableUserCreateResponse.builder()
				.user(user)
				.build();
		assertThat(userCreateResponse, hasProperty("user", equalTo(user)));
		assertThat(userCreateResponse.toString(), equalTo("UserCreateResponse{user=User{userID=UserID{value=1}, username=username, password=password, email=email}}"));
	}

}
