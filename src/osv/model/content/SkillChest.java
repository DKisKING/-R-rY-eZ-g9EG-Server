package osv.model.content;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import osv.Server;
import osv.model.content.achievement.AchievementType;
import osv.model.content.achievement.Achievements;
import osv.model.items.GameItem;
import osv.model.players.Boundary;
import osv.model.players.Player;
import osv.model.players.Right;
import osv.util.Misc;

public class SkillChest {

	public static int KEY = 989;
	public static int DRAGONSTONE = 1631;
	public static int KEY_HALVE1 = 985;
	public static int KEY_HALVE2 = 987;
	public static final int ANIMATION = 881;

	private static Map<Rarity, List<GameItem>> items = new HashMap<>();

	static {
		items.put(Rarity.COMMON, Arrays.asList(
				new GameItem(441, 50),
				new GameItem(454, 100),
				new GameItem(1522, 100),
				new GameItem(1518, 75),
				new GameItem(1520, 100),
				new GameItem(5291, 10),
				new GameItem(5292, 10),
                new GameItem(5293, 10),
                new GameItem(5294, 10),
                new GameItem(5295, 5),
				new GameItem(360, 50),
                new GameItem(378, 50),
				new GameItem(372, 50)));
		
		items.put(Rarity.UNCOMMON, Arrays.asList(
				new GameItem(1516, 100),
                new GameItem(1514, 35),
				new GameItem(5295, 25),
				new GameItem(5300, 5),
				new GameItem(5303, 5),
				new GameItem(5304, 5),
				new GameItem(454, 100),
				new GameItem(452, 35),
				new GameItem(448, 100),
				new GameItem(378, 400),
				new GameItem(384, 100),
                new GameItem(1275, 1),
                new GameItem(1359, 1),
				new GameItem(390, 250)));

        items.put(Rarity.RARE, Arrays.asList(
                new GameItem(6739, 1),
                new GameItem(6571, 1),
                new GameItem(11920, 1)));

	}

	public static GameItem randomChestRewards(int chance) {
		int random = Misc.random(200);
        List<GameItem> itemList = random < 101 ? items.get(Rarity.COMMON) : random > 100 && random < 199 ? items.get(Rarity.UNCOMMON) : items.get(Rarity.RARE);
		return Misc.getRandomItem(itemList);
	}

	public static void makeKey(Player c) {
		if (c.getItems().playerHasItem(KEY_HALVE1, 1) && c.getItems().playerHasItem(KEY_HALVE2, 1)) {
			c.getItems().deleteItem(KEY_HALVE1, 1);
			c.getItems().deleteItem(KEY_HALVE2, 1);
			c.getItems().addItem(KEY, 1);
		}
	}

	public static void searchChest(Player c) {
		if (c.getItems().playerHasItem(KEY)) {
			c.getItems().deleteItem(KEY, 1);
			c.startAnimation(ANIMATION);
			c.getItems().addItem(DRAGONSTONE, 1);
			GameItem reward = Boundary.isIn(c, Boundary.DONATOR_ZONE) && c.getRights().isOrInherits(Right.VIP) ? randomChestRewards(2) : randomChestRewards(9);
			if (!c.getItems().addItem(reward.getId(), reward.getAmount())) {
				Server.itemHandler.createGroundItem(c, reward.getId(), c.getX(), c.getY(), c.heightLevel, reward.getAmount());
			}
			Achievements.increase(c, AchievementType.LOOT_CRYSTAL_CHEST, 1);
            c.sendMessage("@blu@You stick your hand in the chest and pull an item out of the chest.");
		} else {
			c.sendMessage("@blu@The chest is locked, it won't budge!");
			return;
		}
	}

	enum Rarity {
		UNCOMMON, COMMON, RARE
	}

}