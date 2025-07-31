package org.qubiqule.springmodulith.order.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    OPEN("O"),
    CLOSED("C");
    private final String code;
}
