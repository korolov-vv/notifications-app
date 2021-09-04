package ua.goit.goitnotes.note.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public enum AccessType {
    PRIVATE,
    PUBLIC,
    UNKNOWN;

    public static AccessType byName(@NonNull String accessTypeName) {
        log.info("byName .");
        return Arrays.stream(AccessType.values())
                .filter(accessType -> accessType.name()
                        .equalsIgnoreCase(accessTypeName.strip()))
                .findFirst()
                .orElse(UNKNOWN);
    }
}