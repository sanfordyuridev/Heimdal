package com.impalinha.heimdal.Events;

import com.impalinha.heimdal.Checker.Consts;
import com.impalinha.heimdal.Pref.Pref;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientConnectedToServerEvent {
    public Boolean isNotIntegrity;
    public ClientConnectedToServerEvent(Boolean isNotIntegrity) {
        this.isNotIntegrity = isNotIntegrity;
    }
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onClientConnectedToServerEvent(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        if(isNotIntegrity) {
            Pref.screenConnection = true;
            System.out.println(Consts.CLIENT_NOT_OK);
        }
    }
}
