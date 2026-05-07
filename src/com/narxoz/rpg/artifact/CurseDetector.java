package com.narxoz.rpg.artifact;

public class CurseDetector implements ArtifactVisitor {
    private boolean foundCurse = false;

    private void checkCurse(Artifact artifact) {
        if (artifact.getName().toLowerCase().contains("cursed") || artifact.getName().toLowerCase().contains("doom")) {
            System.out.println("WARNING: '" + artifact.getName() + "' emanates a dark, cursed energy!");
            foundCurse = true;
        } else {
            System.out.println("'" + artifact.getName() + "' appears safe.");
        }
    }

    @Override
    public void visit(Weapon weapon) {
        checkCurse(weapon);
        if (weapon.getAttackBonus() < 0) {
            System.out.println("  -> It has a negative attack bonus!");
            foundCurse = true;
        }
    }

    @Override
    public void visit(Potion potion) {
        checkCurse(potion);
        if (potion.getHealing() < 0) {
            System.out.println("  -> It is a poison!");
            foundCurse = true;
        }
    }

    @Override
    public void visit(Scroll scroll) {
        checkCurse(scroll);
    }

    @Override
    public void visit(Ring ring) {
        checkCurse(ring);
        if (ring.getMagicBonus() < 0) {
            System.out.println("  -> It drains magic!");
            foundCurse = true;
        }
    }

    @Override
    public void visit(Armor armor) {
        checkCurse(armor);
        if (armor.getDefenseBonus() < 0) {
            System.out.println("  -> It makes you vulnerable!");
            foundCurse = true;
        }
    }

    public boolean isFoundCurse() {
        return foundCurse;
    }
}
