package com.aleksey.MerchantsContainers;

import com.aleksey.MerchantsContainers.WarehouseContainers.CellarShelfContainer;
import com.aleksey.MerchantsContainers.WarehouseContainers.CustomNpcsCrateContainer;
import com.aleksey.merchants.api.WarehouseContainerList;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="MerchantsContainersTFC", name="Merchants Containers", version="1.0.1", dependencies="required-after:MerchantsTFC")
public class MerchantsContainersMod
{
    @Instance("MerchantsContainersTFC")
    public static MerchantsContainersMod instance;

    @SidedProxy(clientSide = "com.aleksey.MerchantsContainers.ClientProxy", serverSide = "com.aleksey.MerchantsContainers.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    }
  
    @EventHandler
    public void initialize(FMLInitializationEvent event)
    {
        if (Loader.isModLoaded("tfccellars"))
            WarehouseContainerList.addContainer(new CellarShelfContainer());

        if (Loader.isModLoaded("customnpcs"))
            WarehouseContainerList.addContainer(new CustomNpcsCrateContainer());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}