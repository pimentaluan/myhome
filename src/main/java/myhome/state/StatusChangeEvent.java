package myhome.state;

import myhome.domain.AnuncioStatus;

import java.time.Instant;

public record StatusChangeEvent(
        String anuncioId,
        String titulo,
        String anuncianteNome,
        AnuncioStatus de,
        AnuncioStatus para,
        Instant em
) {}
