package com.ksnovaes.bora_jogar.domain.address;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "endereco-partida")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue
    private UUID id;

    private String cep;

    private String enderecoPartida;

    public AddressDTO toDTO() {
        return new AddressDTO(
                this.id,
                this.cep,
                this.enderecoPartida
        );
    }

    public static AddressDTO fromEntity(Address entity) {
        if (entity == null) return new AddressDTO(null, null, null);

        return new AddressDTO(
                entity.getId(),
                entity.getCep(),
                entity.getEnderecoPartida()
        );
    }
}
