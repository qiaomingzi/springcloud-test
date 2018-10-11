package com.example.anotaionvalid;
import static com.google.common.collect.Iterables.getFirst;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

public class BeanValidatorTest {
    public static void main(String[] args) {
        try {
            BeanValidatorTest.validate(new Car());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        //验证Bean参数，并返回验证结果信息
        Car car = new Car();
        Set<ConstraintViolation<Car>> validators = validator.validate(car);
        for (ConstraintViolation<Car> constraintViolation : validators) {
            System.out.println(constraintViolation.getMessage());
        }

        // 验证方法参数
        Method method = null;
        try {
            method = Car.class.getMethod("drive", int.class);
        } catch (SecurityException e) {
        } catch (NoSuchMethodException e) {
        }
        Object[] parameterValues = { 80 };
        ExecutableValidator executableValidator = validator.forExecutables();
        Set<ConstraintViolation<Car>> methodValidators = executableValidator.validateParameters(car,
                method, parameterValues);
        for (ConstraintViolation<Car> constraintViolation : methodValidators) {
            System.out.println(constraintViolation.getMessage());
        }
    }
    /**
     * 验证某个bean的参数
     *
     * @param object 被校验的参数
     */
    public static <T> void validate(T object) throws Exception {
        //获得验证器
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        //执行验证
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        //如果有验证信息，则将第一个取出来包装成异常返回
        ConstraintViolation<T> constraintViolation = getFirst(constraintViolations, null);
        if (constraintViolation != null) { throw new Exception(constraintViolation.getMessage());}
    }

    public static class Car {

        private String name;
        private int speedInMph;

        @NotNull(message = "车主不能为空")
        public String getRentalStation() {
            return name;
        }

        public void drive(@Max(75) int speedInMph) {
            this.speedInMph=speedInMph;
        }
    }
}
