package org.qubiqule.springmodulith.order.typeconverter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.qubiqule.springmodulith.order.types.Status;
import org.w3c.dom.Attr;

import java.util.Arrays;


@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return Arrays.stream(Status.values())
                .filter(s -> s == status)
                .map(Status::getCode)
                .findFirst().orElseThrow( () -> new IllegalArgumentException( String.format("Status %s not found", status ) ) );
    }

    @Override
    public Status convertToEntityAttribute(String code) {
        return Arrays.stream(Status.values())
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst().orElseThrow( () -> new IllegalArgumentException( String.format("Status %s not found", code ) ) );
    }
}
