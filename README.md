# Extensible Document Editor (LLD)

A Java-based Low Level Design project that models a document editor supporting
multiple content types (text, images) and pluggable storage mechanisms (File, DB).

The system is built using Object-Oriented Design, SOLID principles, and Strategy Pattern.

---

## Design Principles Used

- **Single Responsibility Principle**
- **Open–Closed Principle**
- **Dependency Inversion Principle**
- **Polymorphism**
- **Loose Coupling**

---

## Features
- Add text and image elements to a document
- Render a complete document
- Save using FileStorage or DBStorage
- Easily extensible for new element types or storage methods

---

## Design Highlights
- Interfaces for abstraction (DocumentElement, Persistence)
- Loose coupling using dependency injection
- Strategy Pattern for storage selection
- Composite structure for document elements

---

## UML Diagram

<img width="600" alt="UML Diagram" src="https://github.com/user-attachments/assets/26dbec35-01e2-4065-8543-26c4e5c14a18" />

