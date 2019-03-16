package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

	
    private RandomGeneratorServiceImpl randomGeneratorServiceImpl;


    private MultiplicationServiceImpl multiplicationServiceImpl;

    @Before
    public void setUp() {
        // With this call to initMocks we tell Mockito to process the annotations
    	//  MockitoAnnotations.initMocks(this);  MockitoAnnotations.initMocks(this);
    	randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
    	  multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorServiceImpl);
    }

    @Test
    public void createRandomMultiplicationTest() {
        // given (our mocked Random Generator service will return first 50, then 30)
        //given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        // when
        Multiplication     	multiplication = 	multiplicationServiceImpl.createRandomMultiplication();

        // assert
       // multiplication
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
        assertThat(multiplication.getResult()).isEqualTo(1500);
    }
}