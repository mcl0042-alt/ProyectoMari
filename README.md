# The Clean Code & Automation Cycle

## 🎯 Project Objective
This project demonstrates a professional software development lifecycle focused on **Code Quality (Clean Code)** and **Automation (Selenium)**. The goal is to identify common "Code Smells", prove their impact through automated tests, and perform a structural refactoring using IntelliJ IDEA tools to achieve a scalable and maintainable architecture.

## 🛠️ Technical Stack
- **Language**: Java 17
- **Build Tool**: Maven
- **Testing**: Selenium WebDriver (4.16+), JUnit 5, AssertJ
- **IDE**: IntelliJ IDEA
- **Version Control**: Git & GitHub

## 📁 Project Structure
- `src/main/java/com/cleancode/legacy/`: Contains the original code with **10 implemented Code Smells**.
- `src/main/java/com/cleancode/refactored/`: Contains the clean, refactored version using design patterns.
- `src/test/java/com/cleancode/automation/`: Selenium scripts that validate functionality on both versions.
- `docs/`: Research notes and presentation slides.

## 👃 Implemented Code Smells
We have identified and refactored the following 10 smells:

1.  **Bloaters**:
    - **Long Method**: `OrderProcessor.process()` contained excessive logic.
    - **Large Class**: `OrderSystem` handled too many responsibilities (God Object).
2.  **Object-Orientation Abusers**:
    - **Switch Statements**: Replaced with **Polymorphism/Strategy Pattern** in payment processing.
    - **Temporary Fields**: Removed class-level variables used only for intermediate calculations.
3.  **Change Preventers**:
    - **Divergent Change**: Split classes that changed for multiple unrelated reasons.
    - **Shotgun Surgery**: Centralized logic that was scattered across multiple files.
4.  **Dispensables**:
    - **Duplicate Code**: Unified identical calculation logic.
    - **Dead Code**: Removed unused legacy methods.
5.  **Couplers**:
    - **Feature Envy**: Moved methods to classes that actually own the data.
    - **Inappropriate Intimacy**: Encapsulated fields that were being accessed directly.

## 🚀 How to Run
1.  **Clone the repository**: `git clone <repository-url>`
2.  **Install dependencies**: `mvn clean install`
3.  **Run Automation Tests**: `mvn test`

## 👨‍💻 Author
- **Name**: [Your Name/Mari]
- **Course**: Final Project - Clean Code & Automation
