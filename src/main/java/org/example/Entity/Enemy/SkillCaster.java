package org.example.Entity.Enemy;

import java.util.List;

public interface SkillCaster {
    boolean shouldUseSkill(List<Enemy> allyTeam);

    void executeSkill(List<Enemy> allyTeam);

    void decrementSkillCooldown();

    int getSkillCooldown();

    String getSkillName();
}
