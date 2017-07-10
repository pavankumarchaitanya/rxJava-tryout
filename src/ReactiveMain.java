import java.util.Date;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ReactiveMain {

	public static void main(String[] args) throws Exception {

		long start = (new Date()).getTime();
		long sleepInterval1 = (long) (Math.random() * 10000);

		long sleepInterval2 = (long) (Math.random() * 10000);

		long sleepInterval3 = (long) (Math.random() * 10000);

		Processor processor1 = (interval) -> {
			Thread.sleep(interval);

			return sleepInterval1 + "ms completed";
		};

		Processor processor2 = (interval) -> {
			Thread.sleep(interval);

			return interval + "ms completed";
		};

		Processor processor3 = (interval) -> {
			Thread.sleep(interval);

			return interval + "ms completed";
		};

		Observable<Processor> observable = Observable.just(processor1);

		observable.map(v -> v.process(sleepInterval1));
		observable.subscribe();
		Observer<Processor> observer = new Observer<Processor>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				System.out.println();
			}

			@Override
			public void onNext(Processor t) {
				// TODO Auto-generated method stub
				System.out.println();

			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				System.out.println();

			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println();

			}
		};
		observable.subscribe();

		System.out.println(processor1.process(sleepInterval1));
		System.out.println(processor2.process(sleepInterval2));
		System.out.println(processor3.process(sleepInterval3));

		long end = (new Date()).getTime();

		System.out.println("Exiting main : " + (end - start));
		System.out.println(processor1.process(sleepInterval1));
		System.out.println(processor2.process(sleepInterval2));
		System.out.println(processor3.process(sleepInterval3));// This is to
																// make sure
																// each
																// processor
																// consumes same
																// time to
																// execute the
																// task

	}

}
