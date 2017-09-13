package test.hexagonal.core.model;

import org.immutables.value.Value.Immutable;

@Immutable
public abstract class UserID {
	public abstract Long getValue();
}
