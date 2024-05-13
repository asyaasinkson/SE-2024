package put.io.testing.junit;

import put.io.testing.audiobooks.Audiobook;
import put.io.testing.audiobooks.AudiobookPriceCalculator;
import put.io.testing.audiobooks.Customer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AudiobookPriceCalculatorTest {

    @Test
    public void testSubscriberGetsFree() {
        Customer subscriber = new Customer("Alice", Customer.LoyaltyLevel.STANDARD, true);
        Audiobook audiobook = new Audiobook("1984", 20.0);
        AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();

        assertEquals(0.0, calculator.calculate(subscriber, audiobook), "Subscribers should get the audiobook for free.");
    }

    @Test
    public void testSilverLoyaltyDiscount() {
        Customer silverCustomer = new Customer("Bob", Customer.LoyaltyLevel.SILVER, false);
        Audiobook audiobook = new Audiobook("Animal Farm", 15.0);
        AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();

        assertEquals(13.5, calculator.calculate(silverCustomer, audiobook), "Silver loyalty level should get 10% off.");
    }

    @Test
    public void testGoldLoyaltyDiscount() {
        Customer goldCustomer = new Customer("Carol", Customer.LoyaltyLevel.GOLD, false);
        Audiobook audiobook = new Audiobook("The Catcher in the Rye", 25.0);
        AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();

        assertEquals(20.0, calculator.calculate(goldCustomer, audiobook), "Gold loyalty level should get 20% off.");
    }

    @Test
    public void testStandardPricing() {
        Customer standardCustomer = new Customer("Dave", Customer.LoyaltyLevel.STANDARD, false);
        Audiobook audiobook = new Audiobook("To Kill a Mockingbird", 30.0);
        AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();

        assertEquals(30.0, calculator.calculate(standardCustomer, audiobook), "Customers with standard loyalty level pay full price.");
    }
}
