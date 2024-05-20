2.1:


Well, I think you need to check if these methods are called in the right order. Like, you first call connect(), then queryAll(), and finally close(). You can use Mockito to check this. You need to verify the calls in order. So, you use InOrder from Mockito to check this.


5.1:


Um, I'm not sure, but I think it does matter. Like, if you expect the method to be called with "Home" and then with "Car", and you reverse the order, it might not work as expected. So, the order of these expectations probably matters.
