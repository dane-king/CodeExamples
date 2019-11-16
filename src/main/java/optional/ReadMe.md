[Stack Overflow](https://stackoverflow.com/questions/26327957/should-java-8-getters-return-optional-type/26328555#26328555)

[Optional Dos and Don'ts](https://medium.com/@bgourlie/java-s-optional-the-do-s-and-don-ts-4323151bc073)

###How to use Optional the way it was intended
- Use Optional only as a return type for methods, and never, under any circumstances, return null.
- Where possible, use the `orElse()` method to access the wrapped value. This method takes a single argument, which will be returned if the wrapped value is not present. This saves a call to `isPresent()` and will not throw any unchecked exceptions.
- For returning primitive types, there are non-generic variants of Optional such as OptionalInt and OptionalDouble. You should favor these over using Optional<T> with boxed primitives, unless you have a specific need for boxed primitives.
- Do not use Optional to return collections or arrays. Favor returning an empty collection/array.

And one additional caveat:
- Do not use Optional or its variants if you’re trying to avoid heap allocations.