package by.potapenko.creditservice.util.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ErrorValidationMessage {

    public static final String FIELD_IS_REQUIRED = "Поле обязательно для заполнения";
    public static final String NUMBER_MUST_BE_MORE = "Значение поля должно быть больше или равно 1";
    public static final String NUMBER_MUST_BE_LESS = "Значение поля должно быть меньше или равно 12";
    public static final String INCORRECT_FORMAT_FIELD_CAN_ONLY_BE_N_OR_Y = "Неверный формат. Поле может быть только N или Y";
    public static final String VALUE_CANNOT_BE_NEGATIVE_OR_ZERO = "Значение не может быть отрицательным или нулем";
}