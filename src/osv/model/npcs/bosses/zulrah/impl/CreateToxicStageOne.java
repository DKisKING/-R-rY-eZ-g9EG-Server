package osv.model.npcs.bosses.zulrah.impl;

import java.util.Arrays;

import osv.event.CycleEventContainer;
import osv.event.CycleEventHandler;
import osv.model.npcs.bosses.zulrah.DangerousEntity;
import osv.model.npcs.bosses.zulrah.DangerousLocation;
import osv.model.npcs.bosses.zulrah.SpawnDangerousEntity;
import osv.model.npcs.bosses.zulrah.Zulrah;
import osv.model.npcs.bosses.zulrah.ZulrahLocation;
import osv.model.npcs.bosses.zulrah.ZulrahStage;
import osv.model.players.Player;
import osv.model.players.combat.CombatType;

public class CreateToxicStageOne extends ZulrahStage {

	public CreateToxicStageOne(Zulrah zulrah, Player player) {
		super(zulrah, player);
	}

	@Override
	public void execute(CycleEventContainer container) {
		if (container.getOwner() == null || zulrah == null || zulrah.getNpc() == null || zulrah.getNpc().isDead || player == null || player.isDead
				|| zulrah.getInstancedZulrah() == null) {
			container.stop();
			return;
		}
		if (container.getTotalTicks() == 1) {
			zulrah.getNpc().setFacePlayer(false);
			CycleEventHandler.getSingleton().addEvent(player, new SpawnDangerousEntity(zulrah, player, Arrays.asList(DangerousLocation.values()), DangerousEntity.TOXIC_SMOKE, 40),
					1);
		} else if (container.getTotalTicks() >= 19) {
			zulrah.getNpc().totalAttacks = 0;
			zulrah.changeStage(2, CombatType.MELEE, ZulrahLocation.NORTH);
			container.stop();
		}
	}

}
