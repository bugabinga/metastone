package net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.shaman;

import net.pferdimanzug.hearthstone.analyzer.game.GameContext;
import net.pferdimanzug.hearthstone.analyzer.game.Player;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Rarity;
import net.pferdimanzug.hearthstone.analyzer.game.cards.SpellCard;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.HeroClass;
import net.pferdimanzug.hearthstone.analyzer.game.spells.BuffSpell;
import net.pferdimanzug.hearthstone.analyzer.game.targeting.EntityReference;
import net.pferdimanzug.hearthstone.analyzer.game.targeting.TargetSelection;

public class Bloodlust extends SpellCard {

	private static final int ATTACK_BONUS = 3;
	
	public Bloodlust() {
		super("Bloodlust", Rarity.FREE, HeroClass.SHAMAN, 5);
		BuffSpell buff = new BuffSpell(+ATTACK_BONUS);
		buff.setTemporary(true);
		buff.setTarget(EntityReference.FRIENDLY_MINIONS);
		setSpell(buff);
		setTargetRequirement(TargetSelection.NONE);
	}
	
	@Override
	public boolean canBeCast(GameContext context, Player player) {
		return player.getMinions().size() > 0;
	}

}
