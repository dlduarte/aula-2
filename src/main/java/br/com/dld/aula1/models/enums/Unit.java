package br.com.dld.aula1.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author David Duarte
 * @created 23/08/2022
 * @project aula-2
 */
@Getter
@AllArgsConstructor
public enum Unit {

    MT("Metros"),
    KT("Kit"),
    JG("Jogo"),
    UN("Unidade");

    private final String value;
}
