package com.bancolombia.aplicacionbanco.controller;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
public class TransaccionDTO {
    @NotNull(message = "el ID de la cuenta es obligatorio!")
    private String cuentaId;

    @NotNull(message = "el monto de la cuenta es obligatorio!")
    @Positive(message = "El monto debe ser mayor que cero")
    private BigDecimal monto;

    @NotEmpty(message = "la descripción de la cuenta es obligatorio!")
    private String descripcion;

    public TransaccionDTO(String cuentaId, BigDecimal monto, String descripcion) {
        this.cuentaId=cuentaId;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public String getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(String cuentaId) {
        this.cuentaId = cuentaId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TransaccionDTO{" +
                "cuentaId='" + cuentaId + '\'' +
                ", monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
