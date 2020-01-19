package question3_triConsumer;

import java.util.Objects;

@FunctionalInterface
public interface TriConsumer<A, B, C> {
	void Myaccept(final A a, final B b, final C c);
	
	default  TriConsumer<A,B,C> andThen(final TriConsumer<? super A, ? super B, ? super C> after){
		Objects.requireNonNull(after);
		
		return (a, b, c) -> {
			Myaccept(a,b,c);
			after.Myaccept(a,b,c);
		};
	}
	
}