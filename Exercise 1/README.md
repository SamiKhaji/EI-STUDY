### 1. Behavioral Design Patterns
## Use Case 1 - Strategy Pattern:
## Scenario: 
A payment system that supports different payment methods (credit card, PayPal, bank transfer).
Implementation: Define a common PaymentStrategy interface and implement concrete strategies like CreditCardPayment, PayPalPayment, etc. The PaymentProcessor class will dynamically choose the strategy based on user input.
## Use Case 2 - Observer Pattern:
## Scenario:
A social media platform uses a Content Moderation System where different moderation services subscribe to updates on posts made by users. These services might include:

Profanity Detection: Detects and flags inappropriate language.
Image Moderation: Checks for sensitive or inappropriate images.
Spam Detection: Identifies potential spam content.
User Reporting: Allows users to report posts, triggering additional scrutiny.
Whenever a new post is created or updated, all the subscribed moderation services are notified and take their respective actions to either approve, flag, or reject the content.
### 2.Creational Design Patterns

## Use Case 1 - Factory Method Pattern:
## Scenario: 
A vehicle manufacturing system needs to produce different types of vehicles, such as cars and bikes. The type of vehicle to be produced depends on the client's needs.
## Use Case 2 - Builder Pattern:
## Scenario:
A fast-food restaurant allows customers to create custom meal orders. Each meal consists of a burger, drink, and dessert, but the customer can choose different combinations.
### 3.Structural Design Patterns

## Use Case 1 - Adapter Pattern:
## Scenario: 
You have an advanced media player that supports MP4 and VLC formats, but your application only supports MP3. The adapter will allow the MP3 player to play these advanced formats.
## Use Case 2 - Decorator Pattern:
## Scenario:
A coffee shop sells different types of coffee. Customers can add extra ingredients like milk, sugar, or whipped cream. The Decorator Pattern will allow adding these extras dynamically.

