package net.mythic.sotv.procedures;

import net.neoforged.bus.api.Event;

public class CheckLowHPProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 10) {
			return true;
		}
		return false;
	}
}
