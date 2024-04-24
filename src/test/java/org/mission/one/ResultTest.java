package org.mission.one;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultTest {
	final static Logger log = (Logger) LoggerFactory.getLogger(ResultTest.class);

	@Test
	public void solve() {
		List<Integer> grades = new ArrayList<Integer>();
		grades.add(4);
		grades.add(73);
		grades.add(67);
		grades.add(38);
		grades.add(33);

		List<Integer> result = gradingStudents(grades);
		log.info("{}", result);
	}
	
    private List<Integer> gradingStudents(List<Integer> grades) {
    	List<Integer> result = new ArrayList<Integer>();
		
    	// 상수를 사용하면 안된다.
    	// grades.get(i) 는 빼야 한다.
    	// 상수는 되도록 위에서 변수선언을 해야한다.
    	// 역할마다 메소드로 분리해야 한다.
    	for ( int i = 0; i < grades.size(); i++ ) { // use forEach
			if ( grades.get(i) < 38 ) { // code smell
				result.add(grades.get(i));
			} else {
				int multipleOfFive = (grades.get(i) / 5 + 1) * 5;
    			int calculatedValue = multipleOfFive - grades.get(i);

    			if ( calculatedValue < 3 ) {
    				result.add(multipleOfFive);
    			} else { 
    				result.add(grades.get(i));
    			}
			}
    	}

    	List<Integer> matcher = new ArrayList<Integer>();
		matcher.add(75);
		matcher.add(67);
		matcher.add(40);
		matcher.add(33);
		
    	for ( int i = 0; i < matcher.size(); i++ ) {
    		assertThat(result.get(i+1), is(matcher.get(i)));
    	}
    	
		return result;
    }
}
