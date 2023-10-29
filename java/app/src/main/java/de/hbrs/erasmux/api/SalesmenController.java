package de.hbrs.erasmux.api;

import de.hbrs.erasmux.ManagePersonal;
import de.hbrs.erasmux.ManagePersonalImpl;
import de.hbrs.erasmux.model.SalesMan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * RestController for CRUD operations for salesmen
 */
@RestController
public class SalesmenController {

    private final ManagePersonal managePersonal = new ManagePersonalImpl();

    /**
     * POST-Method for creating a salesman
     * @param salesman JSON-object of a salesman
     * @return HTTP-Response including response string
     */
    @PostMapping("api/salesmen/create")
    public ResponseEntity<String> createSalesman(@RequestBody SalesMan salesman){
        managePersonal.createSalesMan(salesman);
        return ResponseEntity.ok("Salesman created");
    }

    /**
     * GET-Method for reading a salesman
     * @param sid id of requested salesman
     * @return JSON-object of requested salesman
     */
    @GetMapping("api/salesmen/read/{sid}")
    public ResponseEntity<SalesMan> readSalesman(@PathVariable int sid){
        SalesMan salesMan = managePersonal.readSalesMan(sid);
        return salesMan != null ? ResponseEntity.ok(salesMan) : ResponseEntity.notFound().build();
    }

    /**
     * PUT-Method for updating an existing salesman
     * @param sid id of salesman that should be updated
     * @param updatedSalesman JSON-Object that represents updated salesman
     * @return HTTP-Response including response string
     */
    @PutMapping("api/salesmen/update/{sid}")
    public ResponseEntity<String> updateSalesman(@PathVariable int sid, @RequestBody SalesMan updatedSalesman){
        managePersonal.updateSalesMan(sid, updatedSalesman);
        // Todo updatedSalesman needs to have some exception handling to provide appropriate response in api
        return ResponseEntity.ok("Salesman updated");
    }

    /**
     * DELETE-Method for deleting a salesman
     * @param sid id of salesman that should be deleted
     * @return HTTP-Response including response string
     */
    @DeleteMapping("api/salesmen/delete/{sid}")
    public ResponseEntity<String> deleteSalesman(@PathVariable int sid){
        managePersonal.deleteSalesMan(sid);
        // Todo deleteSalesman needs to have some exception handling to provide appropriate response in api
        return ResponseEntity.ok("Salesman deleted");
    }
}
