**3.1**

*Yep, switching from BeforeEach to BeforeAll could mess up the tests if your class uses state that changes during the tests. With BeforeEach, each test gets a fresh start with a new object, but with BeforeAll, all tests share the same object setup once for all tests. So, if tests are independent and don't mess with shared state, it might still work, but it's risky if the setup changes later to hold some kind of state.*

**4.1**

*In JUnit testing, a "Failure" happens when an assertion fails—like if you expect two numbers to be the same and they aren't. An "Error" pops up when something unexpected breaks, like an unplanned exception crashing the test. So, if a test checks something and the result isn't what was expected, that’s a Failure. But if the test throws some random error, like running out of memory, that's an Error.*

**4.2**
*JUnit flags a test as a failure using an AssertionError. This isn’t your usual exception; it’s a special kind of error specifically for when an assertion—like checking two values are equal—doesn’t go as planned. It's a direct subclass of Error and is used to clearly mark where a test's expected result wasn't met.*

**5.1**

*Path analysis in testing is definitely a form of white-box testing. That's because it involves peeking into the method’s structure to see all the potential paths it can take. You're basically using knowledge of the code's internals to make sure every possible route is covered, which is exactly what white-box testing is all about.*

**5.2**

*Looking at the calculate method, there are four distinct paths it can take based on the conditions within it. These are when a customer is a subscriber, has silver or gold loyalty levels, or falls under none of these categories and pays the full price. Each of these scenarios represents a separate path that needs testing to ensure the method handles every case correctly.* 

