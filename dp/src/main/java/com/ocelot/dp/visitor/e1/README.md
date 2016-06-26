We would like to declare a function like:
`void process( virtual Base object1, virtual Base object2 )`
that does the right thing based on the type of 2 objects that come from a single
inheritance hierarchy. The only problem is that the keyword "virtual" may not be
used to request dynamic binding for an object being passed as an argument. Java
will only "discriminate" the type of an object being messaged, not the type of an
object being passed.

So in order for the type of 2 objects to be discriminated, each object must be the
receiver of a virtual function call. Here, when `process1()` is called on the first
object, its type becomes "known" at runtime, but the type of the second is still
UNknown.  `process2()` is then called on the second object, and the identity (and type)
of the first object is passed as an argument. Flow of control has now been vectored to
the spot where the type (and identity) of both objects are known.