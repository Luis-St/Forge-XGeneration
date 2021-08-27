package net.luis.nero.common.entity;

import java.util.Set;

import com.google.common.collect.Sets;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.luis.nero.common.entity.trading.Offer;
import net.luis.nero.init.entity.ModEntityTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class ModVillagerEntity extends Villager {
	
	public ModVillagerEntity(Level level, double x, double y, double z) {
		this(ModEntityTypes.VILLAGER.get(), level);
		this.setPos(x, y, z);
	}
	
	public ModVillagerEntity(EntityType<? extends Villager> entityType, Level level) {
		super(entityType, level);
	}
	
	@Override
	protected void addOffersFromItemListings(MerchantOffers merchantOffers, ItemListing[] itemListings, int count) {
		Set<Integer> offerPositions = Sets.newHashSet();
		if (itemListings.length > count) {
			while (offerPositions.size() < count) {
				offerPositions.add(this.random.nextInt(itemListings.length));
			}
		} else {
			for (int i = 0; i < itemListings.length; ++i) {
				offerPositions.add(i);
			}
		}
		for (Integer offerPosition : offerPositions) {
			VillagerTrades.ItemListing itemListing = itemListings[offerPosition];
			MerchantOffer merchantOffer = itemListing.getOffer(this, this.random);
			if (merchantOffer != null) {
				merchantOffers.add(Offer.fromVanilla(merchantOffer));
			}
		}
	}
	
	@Override
	public boolean canBeLeashed(Player player) {
		return player.isShiftKeyDown();
	}
	
	@Override
	protected void registerBrainGoals(Brain<Villager> brain) {
		super.registerBrainGoals(brain); // if custom AIGoals
	}
	
	@Override
	protected void resetSpecialPrices() {
		for (MerchantOffer merchantOffer : this.getOffers()) {
			this.wrongMerchantOffer(merchantOffer);
			merchantOffer.resetSpecialPriceDiff();
		}
	}
	
	@Override
	protected boolean needsToRestock() {
		for (MerchantOffer merchantOffer : this.getOffers()) {
			this.wrongMerchantOffer(merchantOffer);
			if (merchantOffer.needsRestock()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected boolean allowedToRestock() {
		return 64 > this.numberOfRestocksToday;
	}
	
	@Override
	public boolean shouldRestock() {
		return this.allowedToRestock() && this.needsToRestock();
	}
	
	@Override
	protected void catchUpDemand() {
		int i = 64 - this.numberOfRestocksToday;
		if (i > 2) {
			i = 2;
		}
		if (i > 0) {
			for (MerchantOffer merchantOffer : this.getOffers()) {
				this.wrongMerchantOffer(merchantOffer);
				merchantOffer.resetUses();
			}
		}
		for (int j = 0; j < i; ++j) {
			this.updateDemand();
		}
	}
	
	@Override
	protected void updateDemand() {
		for (MerchantOffer merchantOffer : this.getOffers()) {
			this.wrongMerchantOffer(merchantOffer);
			merchantOffer.updateDemand();
		}
	}
	
	@Override
	protected void updateSpecialPrices(Player player) {
		int i = this.getPlayerReputation(player);
		if (i != 0) {
			for (MerchantOffer merchantOffer : this.getOffers()) {
				this.wrongMerchantOffer(merchantOffer);
				merchantOffer.addToSpecialPriceDiff(-Mth.floor((float) i * merchantOffer.getPriceMultiplier()));
			}
		}
		if (player.hasEffect(MobEffects.HERO_OF_THE_VILLAGE)) {
			MobEffectInstance effectInstance = player.getEffect(MobEffects.HERO_OF_THE_VILLAGE);
			int amplifier = effectInstance.getAmplifier();
			for (MerchantOffer merchantOffer : this.getOffers()) {
				this.wrongMerchantOffer(merchantOffer);
				double d = 0.3 + 0.1* amplifier;
				int j = (int) Math.floor(d * merchantOffer.getBaseCostA().getCount());
				merchantOffer.addToSpecialPriceDiff(-Math.max(j, 1));
			}
		}
	}
	
	@Override
	protected void tellWitnessesThatIWasMurdered(Entity entity) {
		
	}
	
	@Override
	protected void pickUpItem(ItemEntity itemEntity) {
		ItemStack itemStack = itemEntity.getItem();
		super.pickUpItem(itemEntity);
		if (this.isEmerald(itemStack)) {
			LOGGER.info("Merchant {}, picked up {} emeralds.", this, itemStack.getCount());
		}
	}
	
	@Override
	public boolean wantsToPickUp(ItemStack itemStack) {
		return super.wantsToPickUp(itemStack) || this.isEmerald(itemStack);
	}
	
	protected boolean isEmerald(ItemStack itemStack) {
		return itemStack.getItem() == Items.EMERALD;
	}
	
	@Override
	protected void updateTrades() {
		VillagerData villagerData = this.getVillagerData();
		Int2ObjectMap<VillagerTrades.ItemListing[]> villagerTrades = VillagerTrades.TRADES.get(villagerData.getProfession());
		if (villagerTrades != null && !villagerTrades.isEmpty()) {
			VillagerTrades.ItemListing[] levelTrades = villagerTrades.get(villagerData.getLevel());
			if (levelTrades != null) {
				MerchantOffers merchantOffers = this.getOffers();
				this.addOffersFromItemListings(merchantOffers, levelTrades, Math.min(4, levelTrades.length - 1));
			}
		}
	}
	
	@Override
	public boolean wantsToSpawnGolem(long time) {
		return !this.brain.hasMemoryValue(MemoryModuleType.GOLEM_DETECTED_RECENTLY);
	}
	
	protected void wrongMerchantOffer(MerchantOffer merchantOffer) {
		if (!(merchantOffer instanceof Offer)) {
			LOGGER.info("The MerchantOffer {}, which is used by Merchant {} is not an instance of the Mod Offer", merchantOfferToString(merchantOffer), this);
		}
	}
	
	public static AttributeSupplier registerAttributes() {
	      return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.5)
	    		  .add(Attributes.FOLLOW_RANGE, 64.0).add(Attributes.MAX_HEALTH, 20.0).build();
	}
	
	protected static String merchantOfferToString(MerchantOffer merchantOffer) {
		StringBuilder builder = new StringBuilder("MerchantOffer:{");
		builder.append("costA=\"").append(merchantOffer.getCostA()).append("\",");
		builder.append("costB=\"").append(merchantOffer.getCostB()).append("\",");
		builder.append("result=\"").append(merchantOffer.getResult()).append("\",");
		builder.append("maxUses=\"").append(merchantOffer.getMaxUses()).append("\",");
		builder.append("priceMultiplier=\"").append(merchantOffer.getPriceMultiplier()).append("\",");
		builder.append("demand=\"").append(merchantOffer.getDemand()).append("\"}");
		return builder.toString();
	}

}
