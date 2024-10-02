package net.mythic.sotv.procedures;

import net.mythic.sotv.entity.IncendimiteEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import java.util.Comparator;

public class IncendimiteOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).isEmpty() && new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null)))) {
			if (entity instanceof IncendimiteEntity) {
				((IncendimiteEntity) entity).setAnimation("explode");
			}
			if (entity instanceof IncendimiteEntity _datEntSetI)
				_datEntSetI.getEntityData().set(IncendimiteEntity.DATA_explodetimer, (int) ((entity instanceof IncendimiteEntity _datEntI ? _datEntI.getEntityData().get(IncendimiteEntity.DATA_explodetimer) : 0) + 1));
			if ((entity instanceof IncendimiteEntity _datEntI ? _datEntI.getEntityData().get(IncendimiteEntity.DATA_explodetimer) : 0) >= 37) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/summon area_effect_cloud ~ ~ ~ {Particle:{type:item_slime},Radius:3,RadiusPerTick:-0.01,Duration:200,potion_contents:{potion:poison}}");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.generic.explode")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.generic.explode")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
			}
			if ((entity instanceof IncendimiteEntity _datEntI ? _datEntI.getEntityData().get(IncendimiteEntity.DATA_explodetimer) : 0) >= 40) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(0);
			}
		} else if (!((entity instanceof IncendimiteEntity _datEntI ? _datEntI.getEntityData().get(IncendimiteEntity.DATA_explodetimer) : 0) <= 0)) {
			if (entity instanceof IncendimiteEntity) {
				((IncendimiteEntity) entity).setAnimation("empty");
			}
			if (entity instanceof IncendimiteEntity _datEntSetI)
				_datEntSetI.getEntityData().set(IncendimiteEntity.DATA_explodetimer, (int) ((entity instanceof IncendimiteEntity _datEntI ? _datEntI.getEntityData().get(IncendimiteEntity.DATA_explodetimer) : 0) - 1));
		}
		if (((entity.getDisplayName().getString()).toLowerCase()).equals("habibi")) {
			if (entity instanceof IncendimiteEntity animatable)
				animatable.setTexture("habibimite");
		} else {
			if (entity instanceof IncendimiteEntity animatable)
				animatable.setTexture("incendimite");
		}
	}
}
