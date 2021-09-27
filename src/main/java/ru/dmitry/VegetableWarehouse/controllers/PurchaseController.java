package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.PurchaseDto;
import ru.dmitry.VegetableWarehouse.services.PurchaseService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/"}, produces = "application/json")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping(path = "/purchase")
    public Iterable<PurchaseDto> getAllPurchase() {
        return purchaseService.findAll();
    }

    @GetMapping(path = "/purchase/{id}")
    public ResponseEntity<PurchaseDto> getUnitsById(@PathVariable("id") Long id) {
        Optional<PurchaseDto> purchaseDto = Optional.ofNullable(purchaseService.findById(id));
        return purchaseDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/purchase", consumes = "application/json")
    public PurchaseDto createPurchase(@RequestBody PurchaseDto purchaseDto) {
        return purchaseService.save(purchaseDto);
    }

    @PutMapping(path = "/purchase/{id}")
    public PurchaseDto updatePurchase(@RequestBody PurchaseDto purchaseDto) {
        return purchaseService.save(purchaseDto);
    }

    @DeleteMapping(path = "/purchase/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePurchase(@PathVariable("id") Long id) {
        purchaseService.deleteById(id);
    }
}
