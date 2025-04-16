package com.example.demo.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VIP")
public class QuartoVip extends Quarto {

    private boolean arCondicionado;

    private boolean hidromassagem;

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean isHidromassagem() {
        return hidromassagem;
    }

    public void setHidromassagem(boolean hidromassagem) {
        this.hidromassagem = hidromassagem;
    }

    
}
