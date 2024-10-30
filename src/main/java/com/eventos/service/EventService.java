package com.eventos.service;

import com.eventos.dto.EventDTO;
import com.eventos.model.Event;
import com.eventos.model.User;
import com.eventos.model.UserRole;
import com.eventos.repository.EventRepository;
import com.eventos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventDTO createEvent(EventDTO eventDTO) {
        try {
            // Primeiro, insere um usuário organizador se não existir
            User organizer;
            if (!userRepository.existsById(1L)) {
                organizer = new User();
                organizer.setName("Organizador Padrão");
                organizer.setEmail("organizador@email.com");
                organizer.setPassword("senha123");
                organizer.setRole(UserRole.ORGANIZER);
                organizer = userRepository.save(organizer);
            } else {
                organizer = userRepository.findById(1L)
                    .orElseThrow(() -> new RuntimeException("Organizador não encontrado"));
            }

            Event event = new Event();
            event.setName(eventDTO.getName());
            event.setDescription(eventDTO.getDescription());
            event.setDateTime(eventDTO.getDateTime());
            event.setLocation(eventDTO.getLocation());
            event.setCapacity(eventDTO.getCapacity());
            event.setOrganizer(organizer);
            event.setParticipants(new HashSet<>());

            Event savedEvent = eventRepository.save(event);
            return convertToDTO(savedEvent);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar evento: " + e.getMessage());
        }
    }

    public Page<EventDTO> listEvents(String search, Pageable pageable) {
        Page<Event> events = search != null ? 
            eventRepository.findByNameContainingIgnoreCase(search, pageable) :
            eventRepository.findAll(pageable);
        return events.map(this::convertToDTO);
    }

    public EventDTO getEvent(Long id) {
        Event event = eventRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        return convertToDTO(event);
    }

    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        Event event = eventRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        
        // Atualizar campos
        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setDateTime(eventDTO.getDateTime());
        event.setLocation(eventDTO.getLocation());
        event.setCapacity(eventDTO.getCapacity());
        
        return convertToDTO(eventRepository.save(event));
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        eventRepository.delete(event);
    }


    private EventDTO convertToDTO(Event event) {
        // Convert Event to EventDTO
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setDateTime(event.getDateTime());
        eventDTO.setLocation(event.getLocation());
        eventDTO.setCapacity(event.getCapacity());
        eventDTO.setOrganizerId(event.getOrganizer().getId());
        return eventDTO;
    }
}
