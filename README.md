# 💊 Object-Oriented Vitamin Ordering System

A Java-based, console application that provides personalized nutritional recommendations and customizable product orders, built to demonstrate core Object-Oriented Programming (OOP) principles and classic Design Patterns.

---

## 📌 Project Overview

Developed for Object-Oriented Programming coursework, this application simulates a complete e-commerce customization and ordering workflow. It captures user profile data (age and gender), recommends tailored supplements, applies customizable attributes through dynamic decorators, and processes orders through a controlled state pipeline.

---

## ✨ System Workflow & Features

1. **Smart Recommendations:** Suggests specific vitamins based on user age and gender rules.
2. **Multi-Stage Customization:**
   * **Form Selection:** Tablets, Capsules, Gummies, or Liquid.
   * **Brand Tiering:** Generic, Premium, Organic, or Pharma.
   * **Packaging:** Glass bottle, Plastic bottle, Eco-pack, or Container.
   * **Flavoring:** Conditionally enabled for Gummies and Liquid (Orange, Strawberry, Mint, Unflavored).
   * **Sizing & Validation:** Offers 30, 60, or 120-count options.
3. **Business Rule Enforcement:** Enforces mutually exclusive constraints (e.g., blocking 120-count orders for liquid vitamins).
4. **Undo Functionality:** Reverts the last customization step using a history stack.
5. **Real-time Notifications:** Dispatches state update events after every user action.
6. **Subscription Management:** Offers optional weekly or monthly recurring subscriptions post-checkout.

---

## 📐 Design Patterns Applied

| Design Pattern | Implementation Role in Architecture |
| :--- | :--- |
| **Factory Method** | Instantiates concrete vitamin objects (`Omega3`, `Calcium`, `VitaminB12`, etc.) from user inputs. |
| **Decorator** | Dynamically wraps base vitamin objects with customization layers (`FormDecorator`, `BrandDecorator`, `PackagingDecorator`, `FlavorDecorator`, `SizeDecorator`) and updates price calculation dynamically. |
| **Singleton** | Ensures a single active `Order` state manager exists across the application runtime. |
| **Observer** | Implements `Notifier` and `ConsoleNotification` listeners to broadcast real-time state updates upon order mutation. |

---

## 📁 Class Hierarchy & System Structure

* **`Vitamin` (Abstract Base Class):** Defines shared supplement attributes and contract methods.
* **Concrete Supplements:** `Omega3`, `Omega6`, `Calcium`, `Iron`, `Magnesium`, `VitaminB12`.
* **`VitaminDecorator` (Abstract Decorator):** Base wrapper extending `Vitamin` to allow dynamic feature attachment.
* **Concrete Decorators:** `FormDecorator`, `BrandDecorator`, `PackagingDecorator`, `FlavorDecorator`, `SizeDecorator`.
* **`Customer`:** Encapsulates demographic data (age, gender).
* **`VitaminRecommender`:** Implements rule-based filtering for supplement suggestions.
* **`VitaminFactory`:** Handles object instantiation via input mapping.
* **`Order` (Singleton):** Manages active order lifecycle, decorator stacks, history state tracking (undo logic), and notifications.
* **`Notifier` / `NotificationListener` (Observer):** Event-broadcasting engine for system event tracking.
* **`Main`:** Handles CLI input streams, application loop state, and output presentation.

---

## 🚀 Getting Started

### Prerequisites
* **Java Development Kit (JDK):** Version 8 or higher
* **IDE:** IntelliJ IDEA, Eclipse, NetBeans, or VS Code

### Execution Instructions

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/YOUR-USERNAME/vitamin-ordering-system.git](https://github.com/YOUR-USERNAME/vitamin-ordering-system.git)
   cd vitamin-ordering-system
