package com.impalinha.heimdal.Events;

import com.impalinha.heimdal.Checker.Consts;
import com.impalinha.heimdal.Middleware.GuiErrorConnection;
import com.impalinha.heimdal.Pref.Pref;
import net.minecraft.client.gui.*;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderTickEvent {
    public Boolean isNotIntegrity;
    private GuiScreen errorGui;
    public RenderTickEvent(Boolean isNotIntegrity) {
        this.errorGui = new GuiErrorConnection();
        this.isNotIntegrity = isNotIntegrity;
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onRenderTick(TickEvent.RenderTickEvent event) {
        if(isNotIntegrity) {
            FontRenderer fRenderer = Minecraft.getMinecraft().fontRenderer;
            if(Pref.screenConnection) {
               Minecraft.getMinecraft().displayGuiScreen(errorGui);
            } else {
                fRenderer.drawStringWithShadow(Consts.CLIENT_NOT_OK,
                        (Minecraft.getMinecraft().currentScreen.width / 2)-138, 10, 0xFF0000);
            }
        }
    }
}