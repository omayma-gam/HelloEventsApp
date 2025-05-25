package com.application.reservation.des.evenements.Services;

import com.application.reservation.des.evenements.DTO.ClientDto;
import com.application.reservation.des.evenements.Entity.Client;
import com.application.reservation.des.evenements.Mapper.ClientMapper;
import com.application.reservation.des.evenements.Repositorie.ClientRepositorie;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepositorie clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepositorie clientRepository , ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ClientDto SaveClient(ClientDto clientDto){
        return clientMapper.toClientDto(clientRepository.save(clientMapper.toCliententity(clientDto)));
    }

    public List<ClientDto> getallClients(){
        return clientRepository.findAll().stream()
                .map(client ->clientMapper.toClientDto(client)).toList();
    }

    public ClientDto getClientByid(Long id){
        return clientRepository.findById(id)
                .map(client -> clientMapper.toClientDto(client))
                .orElseThrow(()-> new RuntimeException("Client not found"));
    }

    public ClientDto modifierClient(Long id ,ClientDto clientDto){
        Client client= clientRepository.findById(id).get();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPassword(clientDto.getPassword());

        return clientMapper.toClientDto(clientRepository.save(client));



    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }
}
