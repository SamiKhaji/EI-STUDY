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
