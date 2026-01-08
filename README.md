```markdown
# 🍔 Phoodelivery - Food Delivery Application

A sophisticated JavaFX-based food delivery desktop application with UI, multi-cuisine support, shopping cart functionality, and complete order management system.

## ✨ Features

### 🍽️ Multi-Cuisine Restaurant
**8 International Cuisines:**
- 🍔 American (Burgers, Hot Dogs, Apple Pie)
- 🍕 Italian (Pizza, Pasta, Lasagna)
- 🌮 Mexican (Tacos, Burritos, Enchiladas)
- 🥢 Chinese (Dumplings, Chow Mein, Tofu)
- 🍣 Japanese (Sushi, Sashimi, Ramen)
- 🍛 Indian (Tikka Masala, Butter Chicken, Biryani)
- 🥘 Korean (Kimchi, Bibimbap, Rice Cakes)
- 🥟 Polish (Pierogi, Cabbage Rolls, Gulasz)

### 🛒 Complete Shopping Experience
- Browse food items with images and descriptions
- Add/remove items from cart with quantity controls
- Real-time price calculation with tax
- Cart persistence during session
- Multi-step checkout process

### 👤 User Management
- Secure login/signup system
- User session management
- Order history tracking

## 🚀 Quick Start

### Prerequisites
- **Java JDK 21+** [Download](https://adoptium.net/)
- **JavaFX 21 SDK** [Download](https://gluonhq.com/products/javafx/)

### Installation & Running

```bash
# 1. Clone the repository
git clone https://github.com/ChadurCheese/Phoodelivery-App.git
cd Phoodelivery-App

# 2. Compile and run using module-info.java
# The application uses Java Platform Module System (JPMS)
# Run from your IDE or use the following commands:

# Using Maven (if pom.xml is present):
mvn clean javafx:run

# Or manually with javac/java:
javac --module-path "path/to/javafx-sdk/lib" \
      --add-modules javafx.controls,javafx.fxml,javafx.graphics \
      -d out/production \
      src/module-info.java src/**/*.java

java --module-path "path/to/javafx-sdk/lib:out/production" \
     --add-modules phoodelivery.app \
     com.phoodelivery.Main
```

### IDE Setup

**IntelliJ IDEA:**
1. Import as Java project
2. Configure SDK: Java 21+
3. Add JavaFX SDK to module path
4. Run configurations will be auto-detected from `module-info.java`

**VS Code:**
1. Open project folder
2. Install "Extension Pack for Java"
3. JavaFX support will be auto-configured from `module-info.java`

**Eclipse:**
1. Import as Java project
2. Configure build path to include JavaFX libraries
3. Set run configurations from module descriptor

## 🏗️ Project Structure

```
Phoodelivery-App/
├── src/
│   ├── module-info.java          # Java module descriptor
│   ├── App.java                  # Main application class
│   ├── Food.java                 # Food item data model
│   ├── sOneController.java       # Login controller
│   ├── sTwoController.java       # Signup controller
│   ├── sThreeController.java     # Main menu controller
│   ├── sFourController.java      # Cart controller
│   ├── sFiveController.java      # Checkout controller
│   └── resources/
│       ├── com/example/phoodelivery/
│       │   ├── cart.fxml         # Cart screen layout
│       │   ├── checkout.fxml     # Checkout screen layout
│       │   ├── loginPage.fxml    # Login screen layout
│       │   ├── mainMenu.fxml     # Main menu layout
│       │   ├── primary.fxml      # Primary layout
│       │   ├── secondary.fxml    # Secondary layout
│       │   └── signUp.fxml       # Signup screen layout
│       ├── images/               # Food images (30+ files)
│       ├── foods.txt            # Food database
│       └── users.txt            # User database
├── target/                      # Compiled classes (generated)
├── pom.xml                     # Maven configuration
└── README.md                   # This file
```

### Module Configuration
The application uses Java's Module System for better encapsulation and dependency management:

```java
// module-info.java example:
module phoodelivery.app {
    requires javafx.controls;
    requires javafx.fxml;
    
    opens com.phoodelivery.controllers to javafx.fxml;
    exports com.phoodelivery;
}
```

## 🐛 Troubleshooting

### Common Issues
1. **"Module not found" errors**
   - Ensure JavaFX modules are on module path
   - Verify `module-info.java` is properly configured

2. **"JavaFX runtime components are missing"**
   - Add JavaFX SDK to module path: `--module-path "path/to/javafx-sdk/lib"`
   - Include required modules: `--add-modules javafx.controls,javafx.fxml,javafx.graphics`

3. **Reflection access errors**
   - Ensure controller packages are opened to javafx.fxml in `module-info.java`

4. **IDE-specific issues**
   - **IntelliJ**: Enable "JavaFX" plugin and configure run configurations
   - **VS Code**: Install "Java Extension Pack" and reload window
   - **Eclipse**: Install e(fx)clipse plugin for JavaFX support

### System Requirements
- **Java**: JDK 21 or later (with module support)
- **JavaFX**: 21.0.9 or compatible
- **OS**: Windows 10+, macOS 11+, Linux with JavaFX support

## 📚 Development

### Building from Source
```bash
# Clone and setup
git clone https://github.com/ChadurCheese/Phoodelivery-App.git
cd Phoodelivery-App

# Set JAVA_HOME to JDK 21+
export JAVA_HOME=/path/to/jdk-21

# Compile
javac --module-path "/path/to/javafx-sdk/lib" \
      --add-modules javafx.controls,javafx.fxml,javafx.graphics \
      -d out \
      src/module-info.java \
      src/com/phoodelivery/**/*.java \
      src/com/phoodelivery/*.java

# Run
java --module-path "/path/to/javafx-sdk/lib:out" \
     --add-modules phoodelivery.app \
     com.phoodelivery.Main
```

### Module Dependencies
- `javafx.controls` - UI controls (buttons, tables, etc.)
- `javafx.fxml` - FXML layout support
- `javafx.graphics` - Core JavaFX graphics


<div align="center">
  
**Made with ❤️ by [ChadurCheese](https://github.com/ChadurCheese)**

*Computer Science culminating project showcasing Java Module System development*
</div>
```