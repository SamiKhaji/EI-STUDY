// Main.java
public class App {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        
        paymentProcessor.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        paymentProcessor.processPayment(100.0);

        paymentProcessor.setPaymentStrategy(new PayPalPayment("user@example.com"));
        paymentProcessor.processPayment(200.0);
    }
}
