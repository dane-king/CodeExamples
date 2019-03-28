### How to Write Threadable code
+ Be Stateless
	+ Thread issues come into play when modifying state of an object after creatiion
+ Be Immutable
	+ Another reason to favor immutablilty
	+ Also functional lends itself to immutable
+ Use Atomic primitives
	+ AtomInteger, AtomicLong, AtomicReference, etc
+ With variable
	+ volatile keyword assumes value is dirty and reads from main memory
	+ avoid static variables
	+ final variables and local variables are thread safe
+ Use concurrent collections
	+ can be misused, for instance put-if-absent
	```java
	if(!names.contains(name)){
		names.add(name);
	}
	```
+ Synchronize
	+ newer ways with count down latch, and old ways with syncronized

##### Patterns that could be not thread safe	
- check-then-act
- put-if-absent
- read-modify-write
