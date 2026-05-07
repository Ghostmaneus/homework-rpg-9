package com.narxoz.rpg;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import java.util.List;

/**
 * Entry point for Homework 9 — Chronomancer's Vault: Visitor + Memento.
 *
 * The scaffold prints the banner only; students fill in the vault demo.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        // 1. Create at least 2 heroes with different starting states.
        Hero warrior = new Hero("Tharion", 150, 0, 25, 10, 100, new Inventory());
        Hero mage = new Hero("Elora", 80, 200, 10, 5, 250, new Inventory());

        // 2. Build an artifact inventory and exercise the visitor interface.
        warrior.getInventory().addArtifact(new Weapon("Excalibur", 1000, 15, 50));
        warrior.getInventory().addArtifact(new Armor("Dragon Mail", 800, 40, 30));
        warrior.getInventory().addArtifact(new Ring("Cursed Ring of Doom", 50, 1, -5));

        mage.getInventory().addArtifact(new Potion("Elixir of Life", 150, 2, 100));
        mage.getInventory().addArtifact(new Scroll("Fireball", 300, 1, "Cast Fireball"));
        mage.getInventory().addArtifact(new Ring("Ring of Wisdom", 500, 1, 20));

        // 3. Capture a hero snapshot through the memento workflow.
        // 4. Rewind the hero after a vault trap changes state.
        // 5. Run the ChronomancerEngine demo sequence.
        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(List.of(warrior, mage));

        // 6. Print a final VaultRunResult summary.
        System.out.println(result);

        // Open/Closed Proof: 4th Visitor
        System.out.println("\n=== Open/Closed Proof: 4th Visitor (WeightCalculator) ===");
        WeightCalculator weightCalculator = new WeightCalculator();
        warrior.getInventory().accept(weightCalculator);
        System.out.println(warrior.getName() + " inventory weight: " + weightCalculator.getTotalWeight());
        
        mage.getInventory().accept(weightCalculator);
        System.out.println(mage.getName() + " inventory weight: " + weightCalculator.getTotalWeight());
    }
}
