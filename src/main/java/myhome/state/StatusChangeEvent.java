package myhome.state;

import myhome.domain.AnuncioStatus;

import java.time.Instant;

public record StatusChangeEvent(
        String anuncioId,
        String titulo,
        String anuncianteNome,
        String contatoDestino,     
        String preferenciaCanal,
        AnuncioStatus de,
        AnuncioStatus para,
        Instant em
) {}
