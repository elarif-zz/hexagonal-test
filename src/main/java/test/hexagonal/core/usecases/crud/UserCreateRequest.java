package test.hexagonal.core.usecases.crud;

import org.immutables.value.Value;

import test.hexagonal.core.model.User;
@Value.Immutable
public abstract class UserCreateRequest {
	public abstract User getUser();
}
