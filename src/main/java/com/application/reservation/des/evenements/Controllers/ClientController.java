package com.application.reservation.des.evenements.Controllers;

import com.application.reservation.des.evenements.DTO.ClientDto;
import com.application.reservation.des.evenements.Services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    public ClientService clientService;

    public ClientController(ClientService clientService) {

        this.clientService = clientService;
    }
    @GetMapping
    public List<ClientDto> getallClients(){
        return  clientService.getallClients();
    }
    @PostMapping("/addClient")
    public ClientDto addClient(@RequestBody ClientDto clientDto){
        return clientService.SaveClient(clientDto);
    }
    @GetMapping("/client/{id}")
    public ClientDto getClientById(@PathVariable Long id){
        return clientService.getClientByid(id);
    }
    @PutMapping("/client/{id}")
    public ClientDto updateClient(@PathVariable Long id , @RequestBody ClientDto clientDto){
        return clientService.modifierClient(id,clientDto);
    }
    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }



}
