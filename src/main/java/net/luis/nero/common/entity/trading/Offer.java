package net.luis.nero.common.entity.trading;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.trading.MerchantOffer;

public class Offer extends MerchantOffer {

	public Offer(CompoundTag nbt) {
		super(nbt);
	}
	
	public Offer(ItemStack firstPrice, ItemStack forSale, int maxUses, int xp) {
		this(firstPrice, ItemStack.EMPTY, forSale, 0, maxUses, xp, forSale.getItem() instanceof TieredItem ? 0.2f : 0.05f, 0);
	}
	
	public Offer(ItemStack firstPrice, ItemStack secondPrice, ItemStack forSale, int maxUses, int xp) {
		this(firstPrice, secondPrice, forSale, 0, maxUses, xp, forSale.getItem() instanceof TieredItem ? 0.2f : 0.05f, 0);
	}
	
	public Offer(ItemStack firstPrice, ItemStack forSale, int maxUses, int xp, float priceMultiplier) {
		this(firstPrice, ItemStack.EMPTY, forSale, 0, maxUses, xp, priceMultiplier, 0);
	}
	
	public Offer(ItemStack firstPrice, ItemStack secondPrice, ItemStack forSale, int maxUses, int xp, float priceMultiplier) {
		this(firstPrice, secondPrice, forSale, 0, maxUses, xp, priceMultiplier, 0);
	}
	
	protected Offer(ItemStack firstPrice, ItemStack secondPrice, ItemStack forSale, int uses, int maxUses, int xp, float priceMultiplier, int demand) {
		super(firstPrice, secondPrice, forSale, uses, maxUses, xp, priceMultiplier, demand);
	}
	
	private Offer(ItemStack baseCostA, ItemStack costB, ItemStack result, int uses, int maxUses, boolean rewardExp, int specialPriceDiff, int demand, float priceMultiplier, int xp) {
		super(baseCostA, costB, result, uses, maxUses, xp, priceMultiplier, demand);
		this.uses = uses;
		this.rewardExp = rewardExp;
		this.specialPriceDiff = specialPriceDiff;
		this.demand = demand;
		this.priceMultiplier = priceMultiplier;
		this.xp = xp;
	}
	
	public ItemStack getBaseCostB() {
		return this.costB;
	}
	
	@Override
	public ItemStack getCostB() {
		if (this.getCostA().getCount() == 1) {
			int i = this.costB.getCount();
			int j = this.demand / 2;
			int k = Math.max(0, Mth.floor((i * j) * this.priceMultiplier));
			ItemStack itemStack = this.costB.copy();
			itemStack.setCount(Mth.clamp(i + k + (this.specialPriceDiff / 2), 1, this.baseCostA.getMaxStackSize()));
			return itemStack;
		}
		return super.getCostB();
	}
	
	public ItemStack getBaseResult() {
		return this.result;
	}
	
	@Override
	public ItemStack getResult() {
		if (this.getCostA().getCount() == 1 && this.getCostB().getCount() == 1) {
			int i = this.result.getCount();
			int j = this.demand / 3;
			int k = Math.max(0, Mth.floor((i * j) * this.priceMultiplier));
			ItemStack itemStack = this.result.copy();
			itemStack.setCount(Mth.clamp(i + k + (this.specialPriceDiff / 3), 1, this.result.getMaxStackSize()));
			return itemStack;
		}
		return super.getResult();
	}
	
	@Override
	public ItemStack assemble() {
		return this.getResult().copy();
	}
	
	public static Offer fromVanilla(MerchantOffer merchantOffer) {
		return new Offer(merchantOffer.getBaseCostA(), merchantOffer.getCostB(), merchantOffer.getResult(), merchantOffer.getUses(), merchantOffer.getMaxUses(), merchantOffer.shouldRewardExp(),
				merchantOffer.getSpecialPriceDiff(), merchantOffer.getDemand(), merchantOffer.getPriceMultiplier(), merchantOffer.getXp());
	}
	
	public static ItemStack getBaseResult(MerchantOffer merchantOffer) {
		if (merchantOffer instanceof Offer) {
			return ((Offer) merchantOffer).getBaseResult();
		}
		return ItemStack.EMPTY;
	}
	
}
