package ua.goit.goitnotes.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.goitnotes.note.model.Note;

import java.util.Optional;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
    Optional<Note> findByTitle(String title);
}
