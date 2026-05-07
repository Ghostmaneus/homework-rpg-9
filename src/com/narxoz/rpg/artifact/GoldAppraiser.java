package com.narxoz.rpg.artifact;

public class GoldAppraiser implements ArtifactVisitor {
    private int totalValue = 0;

    @Override
    public void visit(Weapon weapon) {
        totalValue += weapon.getValue();
        System.out.println("Appraising Weapon '" + weapon.getName() + "': " + weapon.getValue() + " gold.");
    }

    @Override
    public void visit(Potion potion) {
        totalValue += potion.getValue();
        System.out.println("Appraising Potion '" + potion.getName() + "': " + potion.getValue() + " gold.");
    }

    @Override
    public void visit(Scroll scroll) {
        totalValue += scroll.getValue();
        System.out.println("Appraising Scroll '" + scroll.getName() + "': " + scroll.getValue() + " gold.");
    }

    @Override
    public void visit(Ring ring) {
        totalValue += ring.getValue();
        System.out.println("Appraising Ring '" + ring.getName() + "': " + ring.getValue() + " gold.");
    }

    @Override
    public void visit(Armor armor) {
        totalValue += armor.getValue();
        System.out.println("Appraising Armor '" + armor.getName() + "': " + armor.getValue() + " gold.");
    }

    public int getTotalValue() {
        return totalValue;
    }
}
