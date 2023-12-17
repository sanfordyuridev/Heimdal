package com.impalinha.heimdal.Middleware;

import com.impalinha.heimdal.Checker.Consts;
import com.impalinha.heimdal.RestoreMod.RestoreMod;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class GuiErrorConnection extends GuiScreen {
    private long startTime;

    public GuiErrorConnection() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height - 55, Consts.TITLE_FIX_BTN));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height - 30, Consts.TITLE_EXIT_BTN));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            mc.shutdown();
        }
        if (button.id == 1) {
            try {
                RestoreMod.getHealthyFiles();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();

        drawCenteredString(fontRenderer, Consts.TITLE, width / 2, height / 2 - 40, 0xFF0000);
        drawCenteredString(fontRenderer, Consts.CLIENT_NOT_OK, width / 2, height / 2 - 10, 0xFFFFFF);

        int yInit = (height / 2 + 5);

        for(String txt : Consts.VERIFY_CLIENT_TXT) {
            drawCenteredString(fontRenderer, txt, width / 2, yInit, 0xFFFFFF);
            yInit += 8;
        }

        if ((System.currentTimeMillis() - startTime) > Consts.CLOSE_DELAY) {
            mc.getMinecraft().shutdown();
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}