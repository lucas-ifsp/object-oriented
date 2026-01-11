package class07.collections;

import java.util.Objects;

public final class TechnicalSkill implements Comparable<TechnicalSkill> {
    private final String skillName; // final attributes to make it immutable
    private final int proficiencyLevel; // For instance, 1 to 5.

    public TechnicalSkill(String skillName) {
        this.skillName = skillName;
        this.proficiencyLevel = 5;
    }

    public TechnicalSkill(String skillName, int proficiencyLevel) {
        this.skillName = skillName;
        this.proficiencyLevel = proficiencyLevel;
    }

    @Override
    public int compareTo(TechnicalSkill out) {
        return skillName.compareTo(out.skillName) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechnicalSkill that = (TechnicalSkill) o;
        return Objects.equals(skillName, that.skillName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillName);
    }

    @Override
    public String toString() {
        return "TechnicalSkill{skillName='" + skillName + "', proficiencyLevel=" + proficiencyLevel + "}";
    }

    public String getSkillName() {
        return skillName;
    }

    public int getProficiencyLevel() {
        return proficiencyLevel;
    }

}