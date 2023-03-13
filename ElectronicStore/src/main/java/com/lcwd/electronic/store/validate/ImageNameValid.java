package com.lcwd.electronic.store.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ImageNameValidator.class)
public @interface ImageNameValid {
    //error message
    String message() default "Invalid Image Name !!";
    // represent group of constraint
    Class<?>[] groups() default { };
    // additional inormation about annnotation
    Class<? extends Payload>[] payload() default { };

}
