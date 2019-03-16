package microservices.book.multiplication.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomGeneratorServiceImpl implements RandomGeneratorService {


	@Override
	public int generateRandomFactor() {
	return new Random().nextInt(100);
	}
}
