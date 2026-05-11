#!/bin/bash
# ─────────────────────────────────────────────────────────────────────────────
# build-and-run.sh  –  Compile and launch the Number Guessing Game
# ─────────────────────────────────────────────────────────────────────────────

set -e   # Exit immediately on error

SRC_DIR="src"
OUT_DIR="out"
MAIN_CLASS="com.game.Main"

echo "==> Compiling sources..."
mkdir -p "$OUT_DIR"
javac -d "$OUT_DIR" $(find "$SRC_DIR" -name "*.java")
echo "==> Compilation successful."
echo ""
echo "==> Starting game..."
echo ""
java -cp "$OUT_DIR" "$MAIN_CLASS"
