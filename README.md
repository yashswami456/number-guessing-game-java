# 🎮 Number Guessing Game

A console-based Java game where the player guesses a randomly generated number across multiple rounds, earning points based on how few attempts they take.

---

# 👨‍💻 Author

**Yash Malbhage**

---

# 🎥 Demo Video

https://drive.google.com/file/d/1i_69tUmHPq3d8lfso8MAmUH0vv4-URBJ/view?usp=drive_link

# 📁 Project Structure

```text
NumberGuessingGame/
├── .idea/
│   ├── misc.xml                        # Java SDK settings
│   ├── modules.xml                     # Module registration
│   └── runConfigurations/
│       └── NumberGuessingGame.xml      # Pre-configured Run config
├── src/
│   └── com/numbergame/
│       ├── NumberGuessingGame.java     # Entry point (main method)
│       ├── GameEngine.java             # Manages rounds & total score
│       ├── Round.java                  # Single-round logic & input
│       ├── NumberGenerator.java        # Random number generation
│       ├── ScoreCalculator.java        # Scoring formula & ratings
│       └── DisplayHelper.java          # Console UI / banners
├── NumberGuessingGame.iml              # IntelliJ module file
└── README.md
```

---

# 🕹️ How to Play

- The game generates a secret number between **1 and 100**
- You have **7 attempts per round** to guess it
- After each wrong guess you receive a hint:

```text
📉 Too Low — guess higher
📈 Too High — guess lower
```

- Play through **3 rounds**
- Collect as many points as possible
- Final score and performance rating are shown at the end

---

# 🏆 Scoring System

| Attempts Used | Score Earned |
|---|---|
| 1 | 100 pts |
| 2 | 85 pts |
| 3 | 70 pts |
| 4 | 55 pts |
| 5 | 40 pts |
| 6 | 25 pts |
| 7 | 10 pts |
| Did not guess | 0 pts |

### Formula

```text
score = 100 − (attempts − 1) × 15
```

Minimum score: **10**

---

# ⭐ Performance Ratings

| Average Score / Round | Rating |
|---|---|
| ≥ 90 | ⭐⭐⭐⭐⭐ Legendary |
| ≥ 70 | ⭐⭐⭐⭐ Excellent |
| ≥ 50 | ⭐⭐⭐ Good |
| ≥ 25 | ⭐⭐ Fair |
| < 25 | ⭐ Beginner |

---

# 🚀 Getting Started in IntelliJ IDEA

## ✅ Prerequisites

- IntelliJ IDEA (Community or Ultimate)
- Java JDK 17+

---

## ▶️ Steps to Run

### 1. Open the Project

```text
File → Open → Select NumberGuessingGame folder
```

---

### 2. Set Up Java SDK

```text
File → Project Structure → Project
```

Set:

```text
Project SDK → JDK 17
Language Level → 17
```

---

### 3. Run the Game

Use the pre-configured run configuration:

```text
NumberGuessingGame
```

OR

Right-click:

```text
NumberGuessingGame.java
```

Then click:

```text
Run 'NumberGuessingGame.main()'
```

---

# 🛠️ Customisation

| Constant | Location | Default | Description |
|---|---|---|---|
| DEFAULT_ROUNDS | GameEngine | 3 | Number of rounds |
| MAX_ATTEMPTS | Round | 7 | Allowed guesses |
| MIN_NUMBER | Round | 1 | Minimum random number |
| MAX_NUMBER | Round | 100 | Maximum random number |
| BASE_SCORE | ScoreCalculator | 100 | Maximum score |
| PENALTY_PER_ATTEMPT | ScoreCalculator | 15 | Deduction per attempt |

---

# 📦 Class Responsibilities

| Class | Responsibility |
|---|---|
| NumberGuessingGame | Entry point |
| GameEngine | Handles game flow |
| Round | Round logic & hints |
| NumberGenerator | Generates random numbers |
| ScoreCalculator | Calculates score |
| DisplayHelper | Console UI and banners |

---

# ✨ Features

- 🎲 Random number generation
- 🔁 Multiple rounds
- 🧠 Hint system
- ⏳ Attempt limitation
- 🏆 Score calculation
- ⭐ Performance rating
- 📊 Final result summary

---

# 🧰 Technologies Used

- Java
- OOP Concepts
- IntelliJ IDEA
- Java Random Class
- Scanner Class

---

# 📄 License

MIT License — free to use, modify, and distribute.

---

# 🙌 Thank You

If you like this project, consider giving it a ⭐ on GitHub.
