/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uam.jokenpo_sd_aps;
import java.util.Random;

/**
 *
 * @author root
 */
public class Jokenpo {
    Player player = new Player();
    JokenpoUI manageJokenpo;
    
    public Jokenpo(JokenpoUI jokenpoUi) {
        this.manageJokenpo = jokenpoUi;
        manageJokenpo.getVitoriaNum().setText(Integer.toString(player.getVitorias()));
        manageJokenpo.getDerrotaNum().setText(Integer.toString(player.getDerrotas()));
        manageJokenpo.getEmpateNum().setText(Integer.toString(player.getEmpates()));
        manageJokenpo.getPapelBtn().setEnabled(false);
        manageJokenpo.getPedraBtn().setEnabled(false);
        manageJokenpo.getTesouraBtn().setEnabled(false);
    }
    
    public JokenpoUI getManageJokenpo() {
        return manageJokenpo;
    }

}
