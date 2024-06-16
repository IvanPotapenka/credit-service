package by.potapenko.creditservice.model.enam;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
public enum OfferType {
    STANDART("STANDART"),
    GOLD("GOLD"),
    PREMIUM("PREMIUM");
    private String value;

    @JsonCreator
    public static OfferType fromString(String value) {
        return Arrays.stream(OfferType.values())
                .filter(type -> type.value.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}
