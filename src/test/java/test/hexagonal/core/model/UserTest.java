package test.hexagonal.core.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.Test;

import test.hexagonal.core.model.User;
import test.hexagonal.core.model.UserID;

public class UserTest {
	@Test
	public void testImmutableUserBuilder() {
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
		assertThat(user, hasProperty("userID", equalTo(userID)));
		assertThat(user, hasProperty("username", equalTo(username)));
		assertThat(user, hasProperty("password", equalTo(password)));
		assertThat(user, hasProperty("email", equalTo(email)));
		assertThat(user.toString(), equalTo("User{userID=UserID{value=1}, username=username, password=password, email=email}"));
	}
}
