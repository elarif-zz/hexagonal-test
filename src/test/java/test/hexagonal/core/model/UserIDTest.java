package test.hexagonal.core.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.Test;

import test.hexagonal.core.model.UserID;

public class UserIDTest {
	@Test
	public void testImmutableUserIDBuilder() {
		final Long value = Long.valueOf(20);
		final UserID userId = ImmutableUserID.builder().value(value).build();
		assertThat(userId, hasProperty("value", equalTo(value)));
		assertThat(userId.toString(), equalTo("UserID{value=20}"));
	}
}
