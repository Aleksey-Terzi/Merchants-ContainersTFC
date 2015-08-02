package com.aleksey.MerchantsContainers.WarehouseContainers;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import noppes.npcs.blocks.tiles.TileCrate;

import com.aleksey.merchants.WarehouseContainers.ChestContainer;

public class CustomNpcsCrateContainer extends ChestContainer
{
    @Override
    public boolean isValid(TileEntity tileEntity)
    {
        return tileEntity.getClass() == TileCrate.class;
    }
    
    @Override
    protected boolean isItemValid(TileEntity tileEntity, ItemStack itemStack)
    {
        IInventory inventory = (IInventory)tileEntity;
        Class<?> cls = tileEntity.getClass();
        
        if(cls == TileCrate.class)
            return new Slot(inventory, 0, 0, 0).isItemValid(itemStack);

        return false;
    }
}
