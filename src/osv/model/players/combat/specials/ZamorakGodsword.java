package osv.model.players.combat.specials;

import osv.model.entity.Entity;
import osv.model.npcs.NPC;
import osv.model.players.Player;
import osv.model.players.combat.Damage;
import osv.model.players.combat.Special;

/**
 * @author Jason MacKeigan
 * @date Apr 8, 2015, 2015, 10:45:54 AM
 */
public class ZamorakGodsword extends Special {

	public ZamorakGodsword() {
		super(6.0, 1.75, 1.10, new int[] { 11808 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.startAnimation(7057);
		player.gfx0(1210);
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {
		if (damage.getAmount() > 0) {
			if (target instanceof Player) {
				Player p = (Player) target;
				p.freezeTimer = 25;
				p.gfx0(369);
			} else if (target instanceof NPC) {
				NPC npc = (NPC) target;
				npc.freezeTimer = 25;
				npc.gfx0(369);
			}
		}
	}

}
