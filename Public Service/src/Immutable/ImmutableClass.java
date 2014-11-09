package Immutable;

/*
 * Immutable means that the instantiation of the 
 * variable can only be done once and during the first time
 */
class ImmutableField {

}

public class ImmutableClass {
	static final ImmutableField immutableVariable = new ImmutableField();

	ImmutableField ImmutableClass() {
		return immutableVariable;
	}
}
