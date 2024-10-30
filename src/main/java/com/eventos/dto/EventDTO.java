package com.eventos.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Future;
import java.time.LocalDateTime;

@Data
public class EventDTO {
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    private String description;

    @NotNull(message = "Data é obrigatória")
    @Future(message = "A data deve ser futura")
    private LocalDateTime dateTime;

    @NotBlank(message = "Local é obrigatório")
    private String location;

    @NotNull(message = "Capacidade é obrigatória")
    private Integer capacity;

    @NotNull(message = "Organizador é obrigatório")
    private Long organizerId;
}
