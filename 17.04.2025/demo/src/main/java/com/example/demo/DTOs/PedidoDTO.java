package com.example.demo.DTOs;

public class PedidoDTO {
    private Long clienteId;

    private Long saborId;
    
    private String status;

    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    public Long getSaborId() {
        return saborId;
    }
    public void setSaborId(Long saborId) {
        this.saborId = saborId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    
}
