package class05.inheritance;

import java.util.Objects;

public final class TechnicalSkill {
    private final String skillName; // final attributes to make it immutable
    private final int proficiencyLevel; // For instance, 1 to 5.

    public TechnicalSkill(String skillName, int proficiencyLevel) {
        this.skillName = skillName;
        this.proficiencyLevel = proficiencyLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechnicalSkill that = (TechnicalSkill) o;
        return proficiencyLevel == that.proficiencyLevel && Objects.equals(skillName, that.skillName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillName, proficiencyLevel);
    }

    public String getSkillName() {
        return skillName;
    }

    public int getProficiencyLevel() {
        return proficiencyLevel;
    }

    // Métodos getters, equals, hashCode, etc.
}