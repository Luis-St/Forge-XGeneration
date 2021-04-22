package net.luis.industry.api.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.google.common.collect.Lists;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemStackList extends NonNullList<ItemStack> {
	
	private final List<ItemStack> itemStacks;
	private final ItemStack defaultItemStack;

	@SuppressWarnings("unchecked")
	public static ItemStackList create() {
		return new ItemStackList();
	}
	
	public static ItemStackList withSize(int size, ItemStack defaultItemStack) {
		Objects.requireNonNull(defaultItemStack);
		ItemStack[] itemStackArray = new ItemStack[size];
		Arrays.fill(itemStackArray, defaultItemStack);
		return new ItemStackList(Arrays.asList(itemStackArray), defaultItemStack);
	}
	
	public static ItemStackList of(ItemStack defaultItemStack, List<ItemStack> itemStacks) {
		return new ItemStackList(itemStacks, defaultItemStack);
	}

	@SafeVarargs
	public static ItemStackList of(ItemStack defaultItemStack, ItemStack... itemStacks) {
		return new ItemStackList(Arrays.asList(itemStacks), defaultItemStack);
	}
	
	protected ItemStackList() {
		this(Lists.newArrayList(), ItemStack.EMPTY);
	}
	
	protected ItemStackList(List<ItemStack> itemStacks, ItemStack defaultItemStack) {
		this.itemStacks = itemStacks;
		this.defaultItemStack = defaultItemStack;
	}
	
	public ItemStack getDefault() {
		return this.defaultItemStack;
	}
	
	@Override
	public ItemStack get(int index) {
		return this.itemStacks.get(index);
	}
	
	public List<ItemStack> getAll() {
		return this.itemStacks;
	}
	
	public List<ItemStack> getAndClear() {
		List<ItemStack> itemStacks = this.getAll();
		this.clear();
		return itemStacks;
	}
	
	public ItemStack setDefault(int index) {
		return this.set(index, this.getDefault());
	}
	
	@Override
	public ItemStack set(int index, ItemStack itemStack) {
		Objects.requireNonNull(itemStack);
		return this.itemStacks.set(index, itemStack);
	}
	
	@Override
	public boolean add(ItemStack itemStack) {
		Objects.requireNonNull(itemStack);
		return this.itemStacks.add(itemStack);
	}
	
	@Override
	public void add(int index, ItemStack itemStack) {
		Objects.requireNonNull(itemStack);
		this.itemStacks.add(index, itemStack);
	}
	
	@Override
	public boolean remove(Object object) {
		
		Iterator<ItemStack> iterator = this.iterator();
		
		if (object instanceof ItemStack) {
			
			while (iterator.hasNext()) {
				
				ItemStack itemStack = (ItemStack) object;
				ItemStack nextItemStack = iterator.next();
				
				if (this.equalItemStack(itemStack, nextItemStack)) {
					iterator.remove();
					return true;
				}
				
			}
			
		}
		
		return false;
		
	}
	
	@Override
	public ItemStack remove(int index) {
		return this.itemStacks.remove(index);
	}
	
	@Override
	public int size() {
		return this.itemStacks.size();
	}
	
	@Override
	public boolean contains(Object object) {
		if (!(object instanceof ItemStack)) {
			return false;
		}
		ItemStack itemStack = (ItemStack) object;
		return this.containsItemStack(itemStack);
	}
	
	public boolean containsAll(List<ItemStack> itemStacks) {
		
		if (!itemStacks.isEmpty()) {
			
			int contains = 0;
			
			for (ItemStack itemStack : itemStacks) {
				
				if (this.containsItemStack(itemStack)) {
					
					contains++;
					
				}
				
			}
			
			return contains >= itemStacks.size();
			
		}
		
		return false;
		
	}
	
	public boolean containsItemStack(ItemStack itemStack) {
		
		boolean contains = false;
		
		for (ItemStack stack : this.itemStacks) {
			
			if (this.equalItemStack(stack, itemStack)) {
				
				contains = true;
				break;
				
			}
			
		}
		
		return contains;
		
	}
	
	@Override
	public void clear() {
		
		if (this.defaultItemStack == null) {
			
			throw new NullPointerException();
			
		} else {
			
			for (int i = 0; i < this.size(); i++) {
				
				this.itemStacks.set(i, this.getDefault());
				
			}
			
		}
		
	}
	
	private boolean equalItemStack(ItemStack itemStack, ItemStack toCheck) {
		
		if (itemStack.getItem() == toCheck.getItem()) {
			
			return toCheck.getCount() >= itemStack.getCount();
			
		}
		
		return false;
		
	}
	
}
