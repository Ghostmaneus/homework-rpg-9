package com.narxoz.rpg.vault;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.artifact.*;
import java.util.List;

/**
 * Orchestrates the Chronomancer's Vault demo run.
 */
public class ChronomancerEngine {

    /**
     * Runs the vault sequence for the supplied party.
     *
     * @param party the heroes entering the vault
     * @return a placeholder result in the scaffold
     */
    public VaultRunResult runVault(List<Hero> party) {
        int artifactsAppraised = 0;
        int mementosCreated = 0;
        int restoredCount = 0;

        Caretaker caretaker = new Caretaker();
        GoldAppraiser goldAppraiser = new GoldAppraiser();
        EnchantmentScanner enchantmentScanner = new EnchantmentScanner();
        CurseDetector curseDetector = new CurseDetector();

        System.out.println("--- Entering Chronomancer's Vault ---");

        for (Hero hero : party) {
            System.out.println("\nHero " + hero.getName() + " enters the appraisal chamber.");

            // 1. Appraisal
            System.out.println("[Appraisal Phase]");
            hero.getInventory().accept(goldAppraiser);
            hero.getInventory().accept(enchantmentScanner);
            hero.getInventory().accept(curseDetector);
            artifactsAppraised += hero.getInventory().size();

            // 2. Snapshot
            System.out.println("\n[Snapshot Phase]");
            System.out.println("Saving state for " + hero.getName() + " before the trials...");
            System.out.println("State before: " + hero);
            caretaker.save(hero.createMemento());
            mementosCreated++;

            // 3. Trap
            System.out.println("\n[Trap Phase]");
            System.out.println("A vault trap is triggered!");
            hero.takeDamage(50);
            hero.spendGold(hero.getGold()); // lose all gold
            System.out.println("State after trap: " + hero);

            // 4. Rewind
            System.out.println("\n[Rewind Phase]");
            System.out.println("Rewinding time crystals...");
            hero.restoreFromMemento(caretaker.undo());
            restoredCount++;
            System.out.println("State after rewind: " + hero);
        }

        System.out.println("\n--- Vault Run Complete ---");
        return new VaultRunResult(artifactsAppraised, mementosCreated, restoredCount);
    }
}
