package com.gorajski.spring.basics.springinsteps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringInStepsApplication {

	//What are the beans?
	//  Do this by marking classes with @Component or constructors with @Beans
	//  FROM DEBUG LOGS:  "Creating shared instance of singleton bean 'binarySearchImpl'"
	//  FROM DEBUG LOGS:  "Creating shared instance of singleton bean 'bubbleSortAlgorithm'"

	//What are the dependencies of a bean?
	//  Do this by marking dependencies with @Autowired

	//Where to search for beans?
	//  Do this by tagging the package with @ComponentScan.  You can indicate the package
	//  by assigning it to @ComponentScan's "value" field.  If you leave this blank, then
	//  Spring will default to using the package of the class tagged with @ComponentScan.
	//  In this case, @SpringBootApplication includes @ComponentScan as a convenience method
	//  so @ComponentScan is unneeded.
	//  FROM DEBUG LOGS:  "Identified candidate component class:"


	public static void main(String[] args) {

		//Application Context will manage both of these **beans**
		//BinarySearchImpl **binarySearch** =
		//  new BinarySearchImpl( **new QuickSortAlgorithm()** );

		ConfigurableApplicationContext context =
				SpringApplication.run(SpringInStepsApplication.class, args);

		BinarySearchImpl binarySearch = context.getBean(BinarySearchImpl.class);

		int result = binarySearch.binarySearch(new int[] {12,4,6}, 3);
		System.out.println("*********");
		System.out.println("Success!");
		System.out.println("Result:" + result);
		System.out.println("*********");
	}

}