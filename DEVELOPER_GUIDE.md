# Developer Guide

## Project Overview

This project is a Java turn-based RPG built with Gradle. The main entry point is `src/main/java/org/example/Main.java`, which boots the `GameManager` and opens the main menu.

## Core Flow

1. `Main` starts the game.
2. `GameManager` handles menus, inventory, difficulty, shops, and mission start.
3. `Level` runs the battle loop.
4. `Entity` is the base combat model for player and enemies.
5. `Inventory` tracks money, level, XP, stat upgrades, and skill charges.

## Package Map

- `org.example.Entity`
  - `Entity`: abstract base class for all combat units.
  - `Player`: player-controlled entity.
- `org.example.Entity.Enemy`
  - `Enemy`: abstract parent for all enemies.
  - `SpecialEnemy`: abstract parent for skill-based enemy types.
  - `MedicEnemy`, `BulldozerEnemy`, `ShieldSpecialistEnemy`: special enemy variants.
  - `SkillCaster`: interface for enemies that can use a special skill.
- `org.example.GameManager`
  - `GameManager`: menu flow, shops, and game start.
  - `Level`: battle loop and turn resolution.
  - `EnemyManager`: enemy squad generation.
  - `Inventory`: progression and economy.
- `org.example.Skill`
  - `Skill`: immutable skill definition.
  - `SkillEffect`: temporary effect instance and timing.
- `org.example.GameManager.Range`
  - `Difficulty`, `Reward`: battle scaling and reward tables.

## Battle Rules

- Player acts first.
- Enemies act after the player.
- Damage is applied to armor first, then to health.
- If armor breaks, remaining damage goes directly to health.
- End-of-round effects are processed after all turns.
- Special enemies may use skill-based behavior when their awareness conditions are met.

## Special Enemy System

Special enemies are driven by two layers:

- `SpecialEnemy` provides the shared base behavior.
- `SkillCaster` defines the skill contract.

Current variants:

- `MedicEnemy`: heals the weakest ally.
- `BulldozerEnemy`: buffs team armor.
- `ShieldEnemy`: applies damage reduction shield.

Cooldown behavior:

- Each special skill uses a cooldown counter.
- A skill can only be used when cooldown is `0`.
- Cooldown is decremented at end of round.

## Skills And Effects

Skills are data-driven through `Skill` and `SkillEffect`.
Available skill types:

- `DAMAGE`
- `HEAL`
- `BUFF_ARMOR`
- `DEBUFF_ARMOR`

Effect timing options:

- `IMMEDIATE`
- `END_OF_TURN`
- `END_OF_ROUND`
- `NEXT_TURN_START`

## How To Add A New Skill

1. Add a new `Skill` definition in `GameManager.initializeSkills()`.
2. Add the skill to the inventory with an initial charge count.
3. Extend `Entity.applyEffect()` if the skill type needs new effect logic.
4. Update battle UI text in `Level` if the skill needs custom targeting or display.

## How To Add A New Special Enemy

1. Create a new class in `org.example.Entity.Enemy`.
2. Extend `SpecialEnemy`.
3. Implement `SkillCaster` methods.
4. Add awareness logic in `shouldUseSkill()`.
5. Register the new enemy type in `EnemyManager.generateEnemies()`.

## How To Run

- Build and test: `./gradlew test`
- Run the game: launch `org.example.Main`

## Notes For Maintenance

- Keep combat logic in `Level`, not in `GameManager`.
- Keep stat definitions in `Inventory` or `Skill` instead of hardcoding them in battle flow.
- Prefer adding new enemy behavior through subclassing rather than expanding one giant conditional block.
- If you change combat math, re-run the full test/build before touching menu logic.
