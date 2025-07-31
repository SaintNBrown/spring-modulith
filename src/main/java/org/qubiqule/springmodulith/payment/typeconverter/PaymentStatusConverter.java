package org.qubiqule.springmodulith.payment.typeconverter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.qubiqule.springmodulith.payment.PaymentStatus;

import java.util.Arrays;

@Converter(autoApply = true)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, String> {
    @Override
    public String convertToDatabaseColumn(PaymentStatus paymentStatus) {
      return Arrays.stream(PaymentStatus.values())
              .filter(s -> s == paymentStatus)
              .map(PaymentStatus::getCode)
              .findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid PaymentStatus"));
    }

    @Override
    public PaymentStatus convertToEntityAttribute(String code) {
        return Arrays.stream(PaymentStatus.values())
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("Status %s not found", code)));
    }

}
