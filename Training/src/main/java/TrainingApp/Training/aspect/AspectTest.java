package trainingapp.training.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {

	private static final String CALLING_S_WITH_S = "Calling %s with [ %s ]";

	@Pointcut("execution(* trainingapp.training.mapper.*.*(..))")
	public void dataAccessOperation() {
	}

	@Before("dataAccessOperation()")
	public void printTotoYolo(JoinPoint joinPoint) {
		System.out.println(String.format(CALLING_S_WITH_S, joinPoint.getSignature(), joinPoint.getArgs()));

	}
}