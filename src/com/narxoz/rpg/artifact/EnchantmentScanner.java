package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor {
    @Override
    public void visit(Weapon weapon) {
        System.out.println("Scanning Weapon '" + weapon.getName() + "': Attack Bonus +" + weapon.getAttackBonus());
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("Scanning Potion '" + potion.getName() + "': Heals " + potion.getHealing() + " HP");
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("Scanning Scroll '" + scroll.getName() + "': Contains spell [" + scroll.getSpellName() + "]");
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("Scanning Ring '" + ring.getName() + "': Magic Bonus +" + ring.getMagicBonus());
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("Scanning Armor '" + armor.getName() + "': Defense Bonus +" + armor.getDefenseBonus());
    }
}
