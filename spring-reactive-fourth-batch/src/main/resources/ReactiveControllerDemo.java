import java.util.concurrent.Flow.Publisher;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@CrossOrigin
@RequestMapping("api/reactive")
public class ReactiveControllerDemo {
	@GetMapping("range")
    public Flux<Integer> getRange() {
		Publisher<Integer> rangeOfIntegers = Flux.range(0, 10);
		
		rangeOfIntegers.subscribe((num)->{
			System.out.println("Num "+num);
		});
        return rangeOfIntegers;
    }
}
