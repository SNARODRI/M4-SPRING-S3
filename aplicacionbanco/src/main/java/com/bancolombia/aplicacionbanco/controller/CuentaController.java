package com.bancolombia.aplicacionbanco.controller;

import com.bancolombia.aplicacionbanco.repository.CuentaRepository;
import com.bancolombia.aplicacionbanco.service.CuentaService;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;
    private final CuentaRepository cuentaRepository;

    public CuentaController(CuentaService cuentaService, CuentaRepository cuentaRepository) {
        this.cuentaService = cuentaService;
        this.cuentaRepository=cuentaRepository;
    }

    @GetMapping("/saldo")
    public BigDecimal obtenerSaldo(){
        return cuentaService.obtenerSaldo();
    }

    @PostMapping("/deposito")
    public String deposito(@Valid @RequestBody TransaccionDTO transaccionDto){
        System.out.println(transaccionDto.toString());
        //BigDecimal nuevoSaldo = cuentaService.depositar(transaccionDto.getMonto());
        return "Deposito exitoso.\n saldo actual: "/*+nuevoSaldo*/;
    }

    @PostMapping("/retiro")
    public String retiro(@RequestParam BigDecimal retiro) {
        BigDecimal nuevoSaldo = cuentaService.retirar(retiro);
        return "Retiro exitoso.\nNuevo saldo: "+nuevoSaldo;
    }

    @PostMapping("/buscarCuenta")
    public String obtenerCuenta(@RequestParam String cuenta){
        boolean indCuenta = cuentaRepository.buscarCuenta(cuenta);
        if(indCuenta){
            return "número de cuenta existente! " +cuenta;
        }else{
            return "No existe número de cuenta ingresado: " +cuenta;
        }
    }
}
