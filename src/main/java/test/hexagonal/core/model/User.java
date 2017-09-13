package test.hexagonal.core.model;

import org.immutables.value.Value.Immutable;
import java.util.Optional;

@Immutable
public abstract class User {
	public abstract Optional<UserID> getUserID();

	public abstract String getUsername();

	public abstract String getPassword();

	public abstract String getEmail();
}
