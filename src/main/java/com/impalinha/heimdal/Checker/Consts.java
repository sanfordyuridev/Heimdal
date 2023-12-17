package com.impalinha.heimdal.Checker;

import com.impalinha.heimdal.Pref.ModEntity;

public abstract class Consts {
    public static String MODS_DIR = "mods";
    public static String CLIENT_NOT_OK  = "O seu cliente encontra-se em desacordo com o servidor";
    public static String TITLE = "Detectamos algo anormal";
    public static String TITLE_EXIT_BTN = "Confirmar e Sair";
    public static String TITLE_FIX_BTN = "Corrigir os meus arquivos";
    public static long CLOSE_DELAY = 1 * 60 * 1000;
    public static ModEntity DAMAGE_INDICATOR = new ModEntity("[1.12.2]DamageIndicatorsMod-3.5.1.jar", "285416");
    public static ModEntity ARMOURERS_WORKSHOP = new ModEntity("Armourers-Workshop-1.12.2-0.50.5.jar", "2625996");
    public static ModEntity CUSTOM_NPC = new ModEntity("CustomNPCs_1.12.2-(05Jul20).jar", "9911871");
    public static ModEntity SUPER_IC = new ModEntity("superic-1.0.jar", "369117");
    public static String HEIMDAL = "heimdal-1.0.jar";
    public static String LINK = "https://www.dropbox.com/scl/fi/o7jmer2zo1jfwvjfuc405/MODPACKSUPER.zip?rlkey=ls7saov6x8pyebekp68c7g2vx&dl=1";
    public static String LINK_BAT = "https://www.dropbox.com/scl/fi/527bhm2bnqkgzafjswv6x/UpdateMods.bat?rlkey=l9szdfin8tpl324c08lhja1wv&dl=1";
    public static ModEntity[] CURRENT_MODS = {DAMAGE_INDICATOR, ARMOURERS_WORKSHOP, CUSTOM_NPC, SUPER_IC};
    public static String[] VERIFY_CLIENT_TXT = {
            "Sugerimos que verifique a integridade dos seus arquivos",
            "Caso tenha algum arquivo suspeito, remova-o e tente novamente",
            " ",
            "Para corrigir de forma automatica clique em " + TITLE_FIX_BTN +
                    "Apos corrigir, o seu Minecraft ira fechar, basta inicia-lo novamente..."
    };
}
