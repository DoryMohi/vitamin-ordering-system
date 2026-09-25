**Vitamin Ordering System**

This project was created for the Object-Oriented Programming coursework. It demonstrates the use of design patterns and good coding practices through a simple console-based Vitamin Ordering System.

**How it works**
1.	The system asks for the user’s age.
2.	If the user is older than 12, it also asks for their gender.
3.	Recommendations differ based on gender (male/female).
4.	Using this information, the system suggests suitable vitamins.
5.	The user selects one of the recommended options.
6.	They choose a form (tablets, capsules, gummies, liquid).
7.	They choose a brand (generic, premium, organic, pharma).
8.	They choose a packaging type (glass bottle, plastic bottle, eco-pack, container).
9.	They choose a flavour (orange, strawberry, mint, unflavoured) only if they selected gummies or liquid.
10.	They choose a size (30, 60, 120). Liquid vitamins cannot be ordered in 120-count. The system blocks this and asks again.
11.	The user can undo the last customisation step.
12.	They can place the order or cancel it.
13.	The system displays notifications after every action.
14.	After a successful order, the system offers an optional weekly or monthly subscription. Users may also choose “no subscription”.

**Main features**

1.	Vitamin recommendations based on age and gender
2.	Brand customisation (generic, premium, organic, pharma)
3.	Form customisation (tablets, capsules, gummies, liquid)
4.	Packaging customisation (glass bottle, plastic bottle, eco-pack, container)
5.	Flavour customisation for gummies and liquid only
6.	Size customisation (30, 60, 120) with validation
7.	Mutually exclusive rule: liquid vitamins cannot be ordered in 120-count
8.	Undo functionality using a history stack
9.	Notifications for every user action (Observer pattern)
10.	Strong input validation to prevent invalid choices or crashes
11.	Singleton order management — only one active order at a time
12.	Optional subscription offer (weekly or monthly) after order placement

Design patterns used

**Factory Method**

Turns the user’s text input into the correct vitamin object.

**Decorator**

Adds customisations (form + size) to a vitamin without changing the base class.

**BrandDecorator**

Adds the brand level to the vitamin and adjusts price.

**Singleton**

Makes sure there is only one order active throughout the program.

**Observer**

Sends notifications every time the order changes.

These patterns keep the code clean, flexible, and easy to extend.

**System Structure**

1.	**Vitamin (abstract)** is base class for all vitamins. Defines shared attributes and abstract methods.
2.	**Omega3, Omega6, Calcium, Iron, Magnesium, VitaminB12** are concrete vitamin types, each with its own name and base price.
3.	**VitaminDecorator (abstract)** is base decorator class. Wraps a Vitamin object and allows additional features to be added dynamically.
4.	**FormDecorator, BrandDecorator, PackagingDecorator, FlavorDecorator, SizeDecorator** are concrete decorators that add customisation layers such as form, brand, packaging type, flavour, and size.
5.	**Customer** stores user information such as age and gender.
6.	**VitaminRecommender** suggests suitable vitamins based on the customer’s profile.
7.	**VitaminFactory** creates concrete Vitamin objects from user input using the Factory Method pattern.
8.	**Order (Singleton)** manages the active vitamin order. Applies decorators, handles undo functionality, sends notifications, and processes order placement or cancellation.
9.	**Notifier** + **NotificationListener** (Observer Pattern) **Notifier** manages listeners and broadcasts updates. **ConsoleNotification** receives messages and displays them to the user.
10.	**Main** controls the application flow, handles all user input, and coordinates the system components.

**How to run**
1.	Open the project in IntelliJ IDEA or any Java IDE.
2.	Make sure all .java files are in the same package or folder.
3.	Run Main.java.
4.	Follow the instructions shown in the console.


Some parts of this coursework were supported using AI tools.
AI assistance was used only for:

•	generating early ideas and planning the system structure

•	suggesting class names, method names, and overall architecture

•	reviewing code when errors occurred, and helping identify bugs

All final code, logic, implementation decisions, and testing were completed by me.
