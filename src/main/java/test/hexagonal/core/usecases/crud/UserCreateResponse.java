package test.hexagonal.core.usecases.crud;

import org.immutables.value.Value.Immutable;

import test.hexagonal.core.model.User;

@Immutable
public abstract class UserCreateResponse {
	public abstract User getUser();
}
