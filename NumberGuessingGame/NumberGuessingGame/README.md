# 🎮 Number Guessing Game

A console-based Java game where the player guesses a randomly generated number across multiple rounds, earning points based on how few attempts they take.

---

## 📁 Project Structure

```
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

## 🕹️ How to Play

1. The game generates a **secret number between 1 and 100**.
2. You have **7 attempts** per round to guess it.
3. After each wrong guess you receive a hint:
   - 📉 **Too Low** — guess higher
   - 📈 **Too High** — guess lower
4. Play through **3 rounds** and collect as many points as possible.
5. Your final score and performance rating are shown at the end.

---

## 🏆 Scoring

| Attempts Used | Score Earned |
|:---:|:---:|
| 1 | 100 pts |
| 2 | 85 pts |
| 3 | 70 pts |
| 4 | 55 pts |
| 5 | 40 pts |
| 6 | 25 pts |
| 7 | 10 pts |
| Did not guess | 0 pts |

**Formula:** `score = 100 − (attempts − 1) × 15`  (minimum 10)

### Performance Ratings

| Average Score / Round | Rating |
|:---:|---|
| ≥ 90 | ⭐⭐⭐⭐⭐ Legendary! |
| ≥ 70 | ⭐⭐⭐⭐ Excellent! |
| ≥ 50 | ⭐⭐⭐ Good |
| ≥ 25 | ⭐⭐ Fair |
| < 25 | ⭐ Beginner |

---

## 🚀 Getting Started in IntelliJ IDEA

### Prerequisites
- **IntelliJ IDEA** (Community or Ultimate)
- **Java JDK 17+**

### Steps

1. **Open the project**
   - Launch IntelliJ IDEA → `File → Open` → select the `NumberGuessingGame` folder.

2. **Set up the SDK** *(if prompted)*
   - Go to `File → Project Structure → Project`.
   - Set **Project SDK** to JDK 17 (or whichever version you have).
   - Set **Language Level** to `17`.

3. **Run the game**
   - A pre-configured run config **NumberGuessingGame** is included.
   - Select it from the top toolbar and click ▶️ **Run**, or press `Shift + F10`.

4. **Alternatively — run from source**
   - Right-click `NumberGuessingGame.java` → `Run 'NumberGuessingGame.main()'`.

---

## 🛠️ Customisation

| Constant | Location | Default | Description |
|---|---|:---:|---|
| `DEFAULT_ROUNDS` | `GameEngine` | `3` | Number of rounds per session |
| `MAX_ATTEMPTS` | `Round` | `7` | Guesses allowed per round |
| `MIN_NUMBER` | `Round` | `1` | Lower bound of secret number |
| `MAX_NUMBER` | `Round` | `100` | Upper bound of secret number |
| `BASE_SCORE` | `ScoreCalculator` | `100` | Score for a first-attempt correct guess |
| `PENALTY_PER_ATTEMPT` | `ScoreCalculator` | `15` | Points deducted per extra attempt |

---

## 📦 Class Responsibilities

| Class | Responsibility |
|---|---|
| `NumberGuessingGame` | Entry point; wires up components |
| `GameEngine` | Session loop, running score, final summary |
| `Round` | Single-round flow, hint logic, input validation |
| `NumberGenerator` | Stateless utility: random int in [min, max] |
| `ScoreCalculator` | Stateless utility: score formula & ratings |
| `DisplayHelper` | Stateless utility: banners, dividers |

---

## 📄 License

MIT — free to use, modify, and distribute.
