package com.impalinha.heimdal;

import com.impalinha.heimdal.Checker.CheckerMod;
import com.impalinha.heimdal.Events.ClientConnectedToServerEvent;
import com.impalinha.heimdal.Events.RenderTickEvent;
import com.impalinha.heimdal.Pref.Pref;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
    public static final String MODID = "heimdal";
    public static final String NAME = "Heimdal";
    public static final String VERSION = "1.0";
    private static CheckerMod checker;

    @EventHandler
    @SideOnly(Side.CLIENT)
    public void preInit(FMLPreInitializationEvent event) {
        Pref.log = event.getModLog();

        Pref.screenConnection = false;
        Pref.shouldTryReplace = false;
        File modsDir = Pref.getModsDir(event.getModConfigurationDirectory());
        Pref.modsDir = modsDir;

        checker = new CheckerMod(modsDir);

        Pref.log.info("Starting Heimdal checker of mods's intengrity");
        checker.CheckModsIntegrity();
    }

    @EventHandler
    @SideOnly(Side.CLIENT)
    public void init(FMLInitializationEvent event) {
        Pref.log.info("Starting Heimdal modding, the guardian of our server...");
        MinecraftForge.EVENT_BUS.register(new RenderTickEvent(checker.isModsWrong()));
        MinecraftForge.EVENT_BUS.register(new ClientConnectedToServerEvent(checker.isModsWrong()));
    }
}
